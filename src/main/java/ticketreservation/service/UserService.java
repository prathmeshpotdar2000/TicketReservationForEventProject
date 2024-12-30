package ticketreservation.service;

import ticketreservation.model.UserModel;
import java.util.*;
public interface UserService 
{
	public boolean isAddNewUser(UserModel model);
	public boolean isAddNewAdmin(UserModel model);
	
	public boolean isExistngUser(String euname,String eupassword);
	public boolean isExistingAdmin(String euname,String eupassword);
    public boolean isExistingKey(String Akey);
    public List<UserModel> getAllCustomer();
    public boolean isDeleteCust(int cid);
    public int getUidByUserName(String uname);
    public void getCustomerList();
}