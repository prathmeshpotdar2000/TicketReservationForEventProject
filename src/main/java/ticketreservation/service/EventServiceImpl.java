package ticketreservation.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ticketreservation.model.EventModel;
import ticketreservation.repository.EventRepository;
import ticketreservation.repository.EventRepositoryImpl;

public class EventServiceImpl implements EventService{
EventRepository erepo = new EventRepositoryImpl();
	@Override
	public boolean isAddNewEvent(EventModel model) {
		
		return erepo.isAddNewEvent(model);
	}
	@Override
	public List<EventModel> getAllEvent(EventModel model) {
		// TODO Auto-generated method stub
		return erepo.getAllEvent(model);
	}
	@Override
	public boolean isDeleteEvent(int eid) {
		return erepo.isDeleteEvent(eid);
	}
	@Override
	public boolean updateDateById(int eid, String date) {
		return erepo.updateDateById(eid, date);
	}
	@Override
	public int getIdByEventName(String ename) {
		return erepo.getIdByEventName(ename);
	}
	@Override
	public LinkedHashMap<String, ArrayList<EventModel>> getAllEventByCategory() {
		
		return erepo.getAllEventByCategory();
	}
	@Override
	public int getPriceByEventId(int eid) {
		
		return erepo.getPriceByEventId(eid);
	}
	@Override
	public boolean getAvailableSeates(int eid,int numtickets) {
		return erepo.getAvailableSeates(eid,numtickets);
	}
	@Override
	public int checkAvailableSeates(int eid) {
		return erepo.checkAvailableSeates(eid);
	}
	@Override
	public boolean isAvalaibleSeatsAfterCancelBooking(String ename, int numtickets) {
		// TODO Auto-generated method stub
		return erepo.isAvalaibleSeatsAfterCancelBooking(ename,numtickets);
	}
	
}
