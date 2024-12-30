package ticketreservation.repository;

import ticketreservation.model.EventModel;
import java.util.*;

public interface EventRepository {
	
	public boolean isAddNewEvent(EventModel model);
	public List<EventModel> getAllEvent(EventModel model);
	public boolean isDeleteEvent(int eid);
	public boolean updateDateById(int eid,String date);
	public int getIdByEventName(String ename);
	public LinkedHashMap<String,ArrayList<EventModel>> getAllEventByCategory();
	public int getPriceByEventId(int eid);
	public boolean getAvailableSeates(int eid , int numtickets);
	public int checkAvailableSeates(int eid);
	public boolean isAvalaibleSeatsAfterCancelBooking(String ename,int numtickets);
}
