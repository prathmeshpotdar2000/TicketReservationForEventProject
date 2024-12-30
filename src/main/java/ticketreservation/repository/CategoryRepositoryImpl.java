package ticketreservation.repository;

import ticketreservation.model.CategoryModel;
import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

public class CategoryRepositoryImpl extends DBUSER implements CategoryRepository 
{
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	List<CategoryModel> catlist;
	public boolean isAddNewCategory(CategoryModel cmodel) 
	{
		try 
		{
			stmt = conn.prepareStatement("insert into category values('0',?)");
			stmt.setString(1,cmodel.getEcategory());
            int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} 
		catch (Exception ex) 
		{
			System.out.println("Error is:" + ex);
			logger.fatal("CategoryRepositoryImpl::isAddNewCategory::Error in inserting information in category master..."+ex.getMessage());
			return false;
		}

	}


	public List<CategoryModel> getAllCategoriesList() 
	{
		catlist = new ArrayList<CategoryModel>();
		try
		{
			stmt=conn.prepareStatement("select *from category");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				catlist.add(new CategoryModel(rs.getInt(1),rs.getString(2)));
			}
			return catlist.size()>0?catlist:null;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			logger.fatal("CategoryRepositoryImpl::getAllCategoriesList::Error in getting category details from category master..."+ex.getMessage());
			return null;
		}
		
	}


	@Override
	public boolean isDeleteCategory(int cid) {
		try {
			stmt = conn.prepareStatement("delete from category where categoryid=?");
			stmt.setInt(1, cid);
			int val = stmt.executeUpdate();
			return val>0?true:false;
		} catch (Exception e) {
		System.out.println("Error is:"+e);
		logger.fatal("CategoryRepositoryImpl::isDeleteCategory::Error in deleting category details from category master..."+e.getMessage());
		return false;
		}
	}


	@Override
	public int getIdByName(String cname) {
		try {
			stmt = conn.prepareStatement("select categoryid from category where ecategory= ?");
			stmt.setString(1, cname);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("CategoryRepositoryImpl::getIdByName::Error in getting  category Id from category master..."+e.getMessage());
			return -1;
		}
	}


	@Override
	public boolean isAssociatedCatEvent(int cid, int eid) {
		try {
			cstmt = conn.prepareCall("{call saveCatevent(?,?)}");
			cstmt.setInt(1, cid);
			cstmt.setInt(2, eid);
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("CategoryRepositoryImpl::isAssociatedCatEvent::Error in saveCatevent procedure category master..."+e.getMessage());
			return false;
		}
	}

}