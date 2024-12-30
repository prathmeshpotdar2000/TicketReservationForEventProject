package ticketreservation.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ticketreservation.model.*;

public class BookingRepositoryImpl extends DBUSER implements BookingRepository {
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	
	public List<UserEventBookingModel> bklist;
	public List<UserEventBookingModel> ubklist;
	public List<UserEventBookingModel> receiptlist;
	@Override
	public boolean isAddBookingDeatails(BookingModel bmodel) {
		try {
			stmt = conn.prepareStatement("insert into bookingmaster(uid,eid,numtickets,status,finalprice)values(?,?,?,?,?)");
			stmt.setInt(1, bmodel.getUid());
			stmt.setInt(2, bmodel.getEid());
			stmt.setInt(3, bmodel.getNumtickets());
			stmt.setString(4, bmodel.getStatus());
			stmt.setFloat(5, bmodel.getFinalprice());
			
			int val = stmt.executeUpdate();
			return val>0?true:false;
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::isAddBookingDeatails::Error in insert new booking deatails:"+e.getMessage());
			return false;
		}
	}

	@Override
	public List<UserEventBookingModel> getAllBookingDetails() {
		bklist = new ArrayList<UserEventBookingModel>();
		try {
			stmt = conn.prepareStatement("select bk.bkid,u.uname,e.ename,bk.numtickets,bk.bkdate,bk.status,bk.finalprice from usermaster u inner join bookingmaster bk on u.uid=bk.uid inner join eventmaster e on e.eid=bk.eid");
			rs=stmt.executeQuery();
			while(rs.next()) {
				bklist.add(new UserEventBookingModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getFloat(7)));
			}
			return bklist.size()>0?bklist:null;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::getAllBookingDetails::Error in getting all booking deatails:"+e.getMessage());
			return null;
		}
	}

	@Override
	public List<UserEventBookingModel> getBookingDetailsByUserName(String uname) {
		ubklist = new ArrayList<UserEventBookingModel>();
		try {
			stmt = conn.prepareStatement("select bk.bkid,u.uname,e.ename,bk.numtickets,bk.bkdate,bk.status,bk.finalprice from usermaster u inner join bookingmaster bk on u.uid=bk.uid inner join eventmaster e on e.eid=bk.eid where uname=?");
			stmt.setString(1, uname);
			rs=stmt.executeQuery();
			while(rs.next()) {
				ubklist.add(new UserEventBookingModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getFloat(7)));
			}
			return ubklist.size()>0?ubklist:null;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::getBookingDetailsByUserName::Error in getting booking deatails:"+e.getMessage());
			return null;
		}
	}

	@Override
	public boolean isCancelBookingByBkid(int bkid) {
		try {
			stmt = conn.prepareStatement("delete from bookingmaster where bkid = ?");
			stmt.setInt(1, bkid);
			int val = stmt.executeUpdate();
			return val>0?true:false;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::isCancelBookingByBkid::Error in deleting booking deatails by booking Id:"+e.getMessage());
			return false;
		}
	}

	@Override
	public int getNumOfTicketsByBkid(int bkid) {
		try {
			stmt = conn.prepareStatement("select numtickets from bookingmaster where bkid = ?");
			stmt.setInt(1, bkid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::getNumOfTicketsByBkid::Error in getting numtickets deatails by booking Id:"+e.getMessage());
		}
		return -1;
	
	}

	@Override
	public String getEventNameByBkid(int bkid) {
		try {
			stmt = conn.prepareStatement("select e.ename from eventmaster e inner join bookingmaster bk on e.eid=bk.eid where bkid=?");
			stmt.setInt(1, bkid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("BookingRepositoryImpl::getEventNameByBkid::Error in getting ename deatails by booking Id:"+e.getMessage());
		}
		return null;
	}

	@Override
	public List<UserEventBookingModel> getBookingReceiptByBkid(int bkid) {
		receiptlist = new ArrayList<UserEventBookingModel>();
		try {
			stmt = conn.prepareStatement("select bk.bkid,u.uname,e.ename,bk.numtickets,bk.bkdate,bk.status,bk.finalprice from usermaster u inner join bookingmaster bk on u.uid=bk.uid inner join eventmaster e on e.eid=bk.eid where bkid=?");
			stmt.setInt(1, bkid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				receiptlist.add(new UserEventBookingModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getFloat(7)));
			}
			return receiptlist.size()>0?receiptlist:null;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("BookingRepositoryImpl::getBookingReceiptByBkid::Error in getting booking deatails by booking Id:"+e.getMessage());
			return null;
		}
	}

	
//	@Override
//	public int getEventIdFromBooking(String uname) {
//		try {
//			stmt = conn.prepareStatement("");
//		} catch (Exception e) {
//			System.out.println("Error is:"+e);
//		}
//		return 0;
//	}
	
}
