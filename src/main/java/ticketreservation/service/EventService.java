package ticketreservation.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ticketreservation.model.EventModel;

public interface EventService {
	public boolean isAddNewEvent(EventModel model);
	public List<EventModel> getAllEvent(EventModel model);
	public boolean isDeleteEvent(int eid);
	public boolean updateDateById(int eid,String date);
	public int getIdByEventName(String ename);
//	public List<EventModel> getAllEventByCategory();
	public LinkedHashMap<String,ArrayList<EventModel>> getAllEventByCategory();
	public int getPriceByEventId(int eid);
	public boolean getAvailableSeates(int eid,int numtickets);
	public int checkAvailableSeates(int eid);
	public boolean isAvalaibleSeatsAfterCancelBooking(String ename,int numtickets);
}
