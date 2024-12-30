package ticketreservation.service;

import java.util.List;

import ticketreservation.model.BookingModel;
import ticketreservation.model.UserEventBookingModel;

public interface BookingService {
	public boolean isAddBookingDeatails(BookingModel bmodel);
	public float calBookingAmount(int price,int numtickets);
	public List<UserEventBookingModel> getAllBookingDetails();
	public void callBooking();
//	public boolean isDelete();
	public List<UserEventBookingModel> getBookingDetailsByUserName(String uname);
	public boolean isCancelBookingByBkid(int bkid);
	public int getNumOfTicketsByBkid(int bkid);
	public String getEventNameByBkid(int bkid);
	public List<UserEventBookingModel> getBookingReceiptByBkid(int bkid);
}
