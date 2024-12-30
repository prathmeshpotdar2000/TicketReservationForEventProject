package ticketreservation.service;

import java.util.*;

import ticketreservation.model.*;
import ticketreservation.service.*;
import ticketreservation.repository.*;

public class BookingServiceImpl implements BookingService {
	
	BookingRepository bkrepo = new BookingRepositoryImpl();

	@Override
	public boolean isAddBookingDeatails(BookingModel bmodel) {
		return bkrepo.isAddBookingDeatails(bmodel);
	}

	public float calBookingAmount(int price, int numtickets) {
		float ticketprice = price * numtickets;
		System.out.println("There is 9% CGST And 9% SGST");

		ticketprice = (float) (ticketprice + ticketprice * 0.18);

		return ticketprice;
	}

	@Override
	public List<UserEventBookingModel> getAllBookingDetails() {
		return bkrepo.getAllBookingDetails();
	}

	@Override
	public List<UserEventBookingModel> getBookingDetailsByUserName(String uname) {
		return bkrepo.getBookingDetailsByUserName(uname);
	}

	@Override
	public void callBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCancelBookingByBkid(int bkid) {
		return bkrepo.isCancelBookingByBkid(bkid);
	}

	@Override
	public int getNumOfTicketsByBkid(int bkid) {
		return bkrepo.getNumOfTicketsByBkid(bkid);
	}

	@Override
	public String getEventNameByBkid(int bkid) {
		return bkrepo.getEventNameByBkid(bkid);
	}

	@Override
	public List<UserEventBookingModel> getBookingReceiptByBkid(int bkid) {
		return bkrepo.getBookingReceiptByBkid(bkid);
	}

}
