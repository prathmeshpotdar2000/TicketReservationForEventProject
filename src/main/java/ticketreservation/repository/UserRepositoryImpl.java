package ticketreservation.repository;

import ticketreservation.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class UserRepositoryImpl extends DBUSER implements UserRepository
{
	List<UserModel> custList ;
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	public boolean isAddNewUser(UserModel model) 
	{
		try 
		{
			stmt=conn.prepareStatement("insert into usermaster (uid,uname,uemail,upassword) values('0',?,?,?)");
			stmt.setString(1,model.getUname());
			stmt.setString(2,model.getUemail());
			stmt.setString(3,model.getUpassword());
		
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
				
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			logger.fatal("UserRepositoryImpl::isAddNewUser::Error in Adding new User deatails:"+ex.getMessage());
			return false;
		}
		
	}

	public boolean isExistingUser(String euname,String eupassword) {
		try {
			
			stmt=conn.prepareStatement("select *from usermaster where uname=? and upassword=? and role='custmer'");
			stmt.setString(1, euname);
			stmt.setString(2, eupassword);
			rs = stmt.executeQuery();
			int value=0;
			if (rs.next()) 
			{
				value=1;
			}
		
			return value > 0 ? true : false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			logger.fatal("UserRepositoryImpl::isExistingUser::Error in getting User deatails:"+ex.getMessage());
			return false;
		}
		
	}


	public boolean isExistingAdmin(String euname, String eupassword) {
		
         try {
			
			stmt=conn.prepareStatement("select *from usermaster where uname=? and upassword=? and role='admin'");
			stmt.setString(1, euname);
			stmt.setString(2, eupassword);
			rs = stmt.executeQuery();
			int value=0;
			if (rs.next()) 
			{
				value=1;
			}
		
			return value > 0 ? true : false;
			
		}
		catch(Exception ex)
		{
			logger.fatal("UserRepositoryImpl::isExistingAdmin::Error in getting user info..."+ex.getMessage());
			System.out.println("Error is:"+ex);
			return false;
		}
	}

	public boolean isAddNewAdmin(UserModel model) {
		try 
		{
			System.out.println("UserModel"+model);
			stmt=conn.prepareStatement("insert into usermaster (uid,uname,uemail,upassword,role) values('0',?,?,?,?)");
			stmt.setString(1,model.getUname());
			stmt.setString(2,model.getUemail());
			stmt.setString(3,model.getUpassword());
			stmt.setString(4,"Admin");
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
				
		}
		catch(Exception ex)
		{
			logger.fatal("UserRepositoryImpl::isAddNewAdmin::Error in insert user info..."+ex.getMessage());
			System.out.println("Error is:"+ex);
			
			return false;
		}
	}

	@Override
	public boolean isExistingKey(String Akey) {
        try {
			
			stmt=conn.prepareStatement("select *from keymaster where Akey=?");
			stmt.setString(1, Akey);
			
			rs = stmt.executeQuery();
			int value=0;
			if (rs.next()) 
			{
				value=1;
			}
		
			return value > 0 ? true : false;
			
		}
		catch(Exception ex)
		{
			
			System.out.println("Error is:"+ex);
			logger.fatal("UserRepositoryImpl::isExistingKey::Error in getting Admin key info..."+ex.getMessage());
			return false;
		}
	}

	@Override
	public List<UserModel> getAllCustomer() {
		try {
			custList  = new ArrayList<UserModel>();
			stmt = conn.prepareStatement("select *from usermaster where role='custmer'");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				custList.add(new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			return custList.size()>0?custList:null;
		}
		catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("UserRepositoryImpl::getAllCustomer::Error in getting info of user..."+e.getMessage());
			return null;
		}
	}

	@Override
	public boolean isDeleteCust(int cid) {
		try {
			stmt = conn.prepareStatement("delete from usermaster where uid=?");
			stmt.setInt(1, cid);
			int val = stmt.executeUpdate();
			if(val>0) {
				return true;
			}
			else {
				return false;		
			}
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("UserRepositoryImpl::getAllCustomer::Error in getting info of user..."+e.getMessage());
			return false;
		}
	}

	@Override
	public int getUidByUserName(String uname) {
	try {
		stmt = conn.prepareStatement("select uid from usermaster where uname=?");
		stmt.setString(1, uname);
		rs=stmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		else {
			return -1;
		}
	} catch (Exception e) {
		System.out.println("Error is:"+e);
		logger.fatal("UserRepositoryImpl::getUidByUserName::Error in getting user id of usermaster..."+e.getMessage());
		return -1;
	}
	}



}