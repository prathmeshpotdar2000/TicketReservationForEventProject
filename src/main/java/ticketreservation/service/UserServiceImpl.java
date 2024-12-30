package ticketreservation.service;

import java.util.List;

import ticketreservation.model.UserModel;
import ticketreservation.repository.UserRepository;
import ticketreservation.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService
{
	List<UserModel> custList;
	UserService userService;
	UserRepository usrepo=new UserRepositoryImpl();

	public boolean isAddNewUser(UserModel model) 
	{
		return usrepo.isAddNewUser(model);
	}

	public boolean isExistngUser(String euname, String eupassword) 
	{
		
		return usrepo.isExistingUser(euname,eupassword);
	}

	public boolean isExistingAdmin(String euname, String eupassword) {
		
		return usrepo.isExistingAdmin(euname,eupassword);
	}

	public boolean isAddNewAdmin(UserModel model) {
		
		return usrepo.isAddNewAdmin(model);
	}

	
	public boolean isExistingKey(String Akey) {
		
		return usrepo.isExistingKey(Akey);
	}

	@Override
	public List<UserModel> getAllCustomer() {
		
		return usrepo.getAllCustomer();
	}

	@Override
	public boolean isDeleteCust(int cid) {
		
		return usrepo.isDeleteCust(cid);
	}

	@Override
	public int getUidByUserName(String uname) {
		
		return usrepo.getUidByUserName(uname);
	}

	@Override
	public void getCustomerList() {
		
//		System.out.println("==================Customer List====================");
//
//		custList = userService.getAllCustomer();
//		if (custList.isEmpty()) {
////			 custList = userService.getAllCustomer();
//			System.out.println("There are no data present...");
//		} else {
//			custList.forEach(
//					(cl) -> System.out.println(cl.getUid() + "\t" + cl.getUname()
//							+ "\t" + cl.getUemail() + "\t" + cl.getUpassword()));
//		}

		
	}
	

}