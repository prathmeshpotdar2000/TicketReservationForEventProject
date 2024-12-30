package ticketreservation.repository;

import java.util.*;

import ticketreservation.model.BookingModel;
import ticketreservation.model.UserEventBookingModel;

public interface BookingRepository {
	public boolean isAddBookingDeatails(BookingModel bmodel);
	public List<UserEventBookingModel> getAllBookingDetails();
	public List<UserEventBookingModel> getBookingDetailsByUserName(String uname);
	public boolean isCancelBookingByBkid(int bkid);
//	public int getEventIdFromBooking(String uname);
	public int getNumOfTicketsByBkid(int bkid);
	public String getEventNameByBkid(int bkid);
	public List<UserEventBookingModel> getBookingReceiptByBkid(int bkid);
}
