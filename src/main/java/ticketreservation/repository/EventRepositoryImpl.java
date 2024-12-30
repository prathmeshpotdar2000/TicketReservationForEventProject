package ticketreservation.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import ticketreservation.clientapp.TicketReservationApp;
import ticketreservation.model.CategoryModel;
import ticketreservation.model.EventModel;

public class EventRepositoryImpl extends DBUSER implements EventRepository{
	static Logger logger = Logger.getLogger(EventRepositoryImpl.class);
public List<EventModel> elist;
public LinkedHashMap<String,ArrayList<EventModel>> ecatlist;
	@Override
	public boolean isAddNewEvent(EventModel model) {
		try {
			stmt = conn.prepareStatement("insert into eventmaster values('0',?,?,?,?,?,?,?)");
			stmt.setString(1, model.getEname());
			stmt.setString(2, model.getEdate());
			stmt.setInt(3,model.getTseats());
			stmt.setInt(4, model.getAseats());
			stmt.setInt(5, model.getPrice());
			stmt.setString(6, model.getTime());
			stmt.setString(7, model.getDesc());
			
			int val = stmt.executeUpdate();
			return val>0?true:false;
					
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::isAddNewEvent::Error in insert new event deatails:"+e.getMessage());
			return false;
		}
	}

	@Override
	public List<EventModel> getAllEvent(EventModel model) {
		elist = new ArrayList<EventModel>();
		try {
			
			stmt=conn.prepareStatement("select *from eventmaster where edate>timestamp(now())");
			rs=stmt.executeQuery();
			while(rs.next()) {
				elist.add(new EventModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
			return elist.size()>0?elist:null;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("EventRepositoryImpl::getAllEvent::Error in getting all event deatails:"+e.getMessage());
			return null;
		}
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		try {
			stmt = conn.prepareStatement("delete from eventmaster where eid = ?");
			stmt.setInt(1, eid);
			int val = stmt.executeUpdate();
			return val>0?true:false;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("EventRepositoryImpl::isDeleteEvent::Error in delete  event deatails:"+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateDateById(int eid,String date) {
		try {
			stmt = conn.prepareStatement("update eventmaster set edate=? where eid=?");
			stmt.setString(1, date);
			stmt.setInt(2, eid);
			int val = stmt.executeUpdate();
			return val>0?true:false;
		} catch (Exception e) {
			System.out.println("Error is"+e);
			logger.fatal("EventRepositoryImpl::updateDateById::Error in update  event deatails:"+e.getMessage());
			return false;
		}
	}

	@Override
	public int getIdByEventName(String ename) {
		try {
			stmt= conn.prepareStatement("select eid from eventmaster where ename =?");
			stmt.setString(1, ename);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::getIdByEventName::Error in getting event id from eventmaster:"+e.getMessage());
			return -1;
		}
	}

	@Override
	public LinkedHashMap<String,ArrayList<EventModel>> getAllEventByCategory() {
		ecatlist = new LinkedHashMap<String, ArrayList<EventModel>>();
		try {
			stmt=conn.prepareStatement("select c.ecategory,e.ename,e.edate,e.totalseats,e.availabeseates,e.price,e.etime,e.description from category c inner join cateventjoin cej on c.categoryid = cej.categoryid inner join eventmaster e on e.eid=cej.eid;");
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				String category = rs.getString(1);
//				ecatlist.put(category,new EventModel(0,rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
				EventModel event = new EventModel(
		                0, // Assuming ID is not needed here
		                rs.getString(2), // ename
		                rs.getString(3), // edate
		                rs.getInt(4), // totalseats
		                rs.getInt(5), // availabeseates
		                rs.getInt(6), // price
		                rs.getString(7), // etime
		                rs.getString(8)  // description
		            );
				// Check if the category already exists
	            ArrayList<EventModel> eventList = ecatlist.getOrDefault(category, new ArrayList<>());
	            eventList.add(event); // Add the event to the list
	            ecatlist.put(category, eventList); // Update the map

			}
			return ecatlist;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::getAllEventByCategory::Error in getting event details by category from eventmaster:"+e.getMessage());
			return null;
		}
	}

	@Override
	public int getPriceByEventId(int eid) {
		try {
			stmt = conn.prepareStatement("select price from eventmaster where eid=?");
			stmt.setInt(1, eid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		} catch (Exception e) {
		System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::getPriceByEventId::Error in getting event details by category from eventmaster:"+e.getMessage());
		return -1;
		}
	}

	@Override
	public boolean getAvailableSeates(int eid,int numtickets) {
		try {
			stmt = conn.prepareStatement("update eventmaster set availabeseates = (availabeseates-?) where eid=?");
			stmt.setInt(1, numtickets);
			stmt.setInt(2, eid);
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::getAvailableSeates::Error in update availabeseates in eventmaster:"+e.getMessage());
			return false;
		}
	}

	@Override
	public int checkAvailableSeates(int eid) {
		try {
			stmt = conn.prepareStatement("select availabeseates from eventmaster where eid=?");
			stmt.setInt(1, eid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		} catch (Exception e) {
		System.out.println("Error is:"+e);
		logger.fatal("EventRepositoryImpl::checkAvailableSeates::Error in getting availabeseates from eventmaster:"+e.getMessage());
		return -1;
		}
		
	}

	@Override
	public boolean isAvalaibleSeatsAfterCancelBooking(String ename,int numtickets) {
		try {
			stmt = conn.prepareStatement("update eventmaster set availabeseates = (availabeseates+?) where ename=?");
			stmt.setInt(1, numtickets);
			stmt.setString(2, ename);
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			logger.fatal("EventRepositoryImpl::isAvalaibleSeatsAfterCancelBooking::Error in update availabeseates from eventmaster:"+e.getMessage());
			return false;
		}
	}

}
