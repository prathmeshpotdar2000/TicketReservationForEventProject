package ticketreservation.clientapp;

import java.sql.*;
import java.sql.Date;
import java.time.Instant;
import java.util.*;
import ticketreservation.model.*;
import ticketreservation.service.*;
import org.apache.log4j.*;
//import org.techhub.clientapp.HousePricePredClientApplication;

public class TicketReservationApp {
	static Logger logger = Logger.getLogger(TicketReservationApp.class);
	static {
		PropertyConfigurator.configure(
				"C:\\Users\\admin\\eclipse-workspace\\TicketReservationSystemForEvent\\src\\main\\resources\\application.properties");
	}

	public static void main(String x[]) {
		UserService userService = new UserServiceImpl();
		UserModel model = new UserModel();
		List<UserModel> custList = new ArrayList<UserModel>();
		CategoryService categoryService = new CategoryServiceImpl();
		CategoryModel cmodel = new CategoryModel();

		EventService eventService = new EventServiceImpl();
		EventModel emodel = new EventModel();
		List<EventModel> elist = new ArrayList<EventModel>();

		BookingModel bmodel = new BookingModel();
		BookingService bookingService = new BookingServiceImpl();
		UserEventBookingModel uebmodel = new UserEventBookingModel();
		List<UserEventBookingModel> bklist = new ArrayList<UserEventBookingModel>();
		List<UserEventBookingModel> ubklist = new ArrayList<UserEventBookingModel>();
		List<UserEventBookingModel> receiptlist = new ArrayList<UserEventBookingModel>();

		logger.debug("Main method started Successfully...");

		int count = 0;

//		LinkedHashMap<String,ArrayList<EventModel>> ecatlist = new LinkedHashMap<String, ArrayList<EventModel>>();
		Scanner xyz = new Scanner(System.in);
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"==================================================================      WELCOME TO TICKET RESERVATION APP      ===================================================");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		try {
			do {
				System.out.println("==>If You Are Alredy Registerd Then You Can Login \n");
				System.out.println("1.Registration");
				System.out.println("2.Login");
				System.out.println("3.Exit");

				System.out.println("\nEnter Your Choice");
				int choice = xyz.nextInt();
				String limit = "";

				switch (choice) {
				case 1:
					System.out.println(
							"===========================================================     REGISTRATION FORM       =======================================================================");

					do {

						System.out.println("1.Register For Admin");
						System.out.println("2.Register For Customer");
						System.out.println("3.exit from Reisteration");

						System.out.println("Enter your Choice");
						int chss = xyz.nextInt();

						switch (chss)

						{

						case 1:
							try {
								System.out.println("Enter Key to Register for Admin");
								xyz.nextLine();
								String Akey = xyz.nextLine();
								model.setKey(Akey);
								// System.out.println((userService.isExistingKey(String Akey));
								boolean b = userService.isExistingKey(Akey);

								if (b) {
									System.out.println("Enter the Name");
									String uname = xyz.nextLine();
									System.out.println("Enter the Email");
									String uemail = xyz.nextLine();
									System.out.println("Enter the Password");
									String upassword = xyz.nextLine();
									model.setUname(uname);
									model.setUemail(uemail);
									model.setUpassword(upassword);
									boolean istrue;
									System.out
											.println((istrue=userService.isAddNewAdmin(model)) ? "Admin Added SuccessFully...!"
													: "Admin NOT Added SuccessFully...!");
									
								if (istrue) {
									logger.info("TicketReservationApp::New Admin Added in database");
								}
								else {
									logger.error("TicketReservationApp::Error in:Case 1.Register For Admin");
								}
								} else {
									System.out.println("Invalid Key...Plz Enter Valid Key...");
								}
							} catch (InputMismatchException e) {
								logger.error("TicketReservationApp::Register For Admin"+e.getMessage());
							}
							break;

						case 2:
							System.out.println("Enter the Name");
							xyz.nextLine();
							String uname = xyz.nextLine();
							System.out.println("Enter the Email");
							String uemail = xyz.nextLine();
							System.out.println("Enter the Password");
							String upassword = xyz.nextLine();

							model.setUname(uname);
							model.setUemail(uemail);
							model.setUpassword(upassword);

							System.out.println((userService.isAddNewUser(model)) ? "User Added SuccessFully...!"
									: "User NOT Added SuccessFully...!");

							break;
						case 3:
							limit = "y";
							break;
						}
						System.out.println("Do you want to Register For Another User(y/n)");
//					xyz.nextLine();
						limit = xyz.nextLine();

					} while (limit.equals("y"));

					break;

				case 2:
					System.out.println(
							"===============================================================    LOGIN   ====================================================================================");

					do {
						System.out.println("1:Admin Login");
						System.out.println("2:Customer Login");
						System.out.println("3.Exit from Login panel");
						System.out.println("Enter the Choice");
						
						int chs = xyz.nextInt();
						
						switch (chs) {

						// Admin Login
						case 1:
							System.out.println("Enter the AdminName");
							xyz.nextLine();
							String euname = xyz.nextLine();
							System.out.println("Enter the Password");
							String eupassword = xyz.nextLine();

							if (userService.isExistingAdmin(euname, eupassword)) {
								System.out.println(
										"\n You are successfully Logged In Ticket Reservation App of Admin Panel \n");
//=================================================================================================================================================================================================================
								do {
									System.out.println("1.Customer");// 137
									System.out.println("2.Category");// 203
									System.out.println("3.Event");// 254
									System.out.println("4.Booking");//
									System.out.println("5.Show Booking Deatails");
									System.out.println("6.Cancel Booking");//
									System.out.println("7.Exit to Login or Register");
									System.out.println("Enter choice:");//

									chs = xyz.nextInt();
									switch (chs) {
									case 1://////////////////////////////// customer ///////////////////////////////
										do {
											System.out.println("1.Add customer");
											System.out.println("2.Show customer");
											System.out.println("3.Delete custmer");
											System.out.println("4.Exit from Customer Curd");
											System.out.println("Enter your choice:");
											chs = xyz.nextInt();
											switch (chs) {
											case 1:
												System.out.println("Enter the Name");
												xyz.nextLine();
												String uname = xyz.nextLine();
												System.out.println("Enter the Email");
												String uemail = xyz.nextLine();
												System.out.println("Enter the Password");
												String upassword = xyz.nextLine();

												model.setUname(uname);
												model.setUemail(uemail);
												model.setUpassword(upassword);

												System.out.println((userService.isAddNewUser(model))
														? "User Added SuccessFully...!"
														: "User NOT Added SuccessFully...!");
												break;
											case 2:
//											userService.getCustomerList();
												System.out
														.println("==================Customer List====================");

												custList = userService.getAllCustomer();
												if (custList.isEmpty()) {
//												 custList = userService.getAllCustomer();
													System.out.println("There are no data present...");
												} else {
													custList.forEach((cl) -> System.out
															.println(cl.getUid() + "\t" + cl.getUname() + "\t"
																	+ cl.getUemail() + "\t" + cl.getUpassword()));
												}
												break;

											case 3:
												System.out
														.println("==================Customer List====================");

//											 custList = userService.getAllCustomer();
												custList.forEach(
														(cl) -> System.out.println(cl.getUid() + "\t" + cl.getUname()
																+ "\t" + cl.getUemail() + "\t" + cl.getUpassword()));
												System.out.println("Enter custmer id for delete customer:");
												int cid = xyz.nextInt();
												boolean b = userService.isDeleteCust(cid);
												if (b) {
													System.out.println("Custemer deleted successfully...");
												} else {
													System.out.println("Custmer not deleted...");
												}
												break;
											case 4:
												limit = "y";
												break;
											default:
												System.out.println("invalid choice");
												break;
											}
											if (limit.equals("y")) {
												break;
											} else {
												System.out.println("Do you want to Repeat CURD of Customer???(y/n)");
												xyz.nextLine();
												limit = xyz.nextLine();
											}
										} while (limit.equals("y"));

										break;
									case 2:////////////////////////// category//////////////////////////////////////////

										do {
											System.out.println("1.Add category");
											System.out.println("2.Show category");
											System.out.println("3.Delete category");
											System.out.println("4.Exit from Category Curd");
											System.out.println("Enter your choice:");
											chs = xyz.nextInt();
											switch (chs) {
											case 1:
												System.out.println("Enter The Category Name to Add");
												xyz.nextLine();
												String category = xyz.nextLine();
												cmodel.setEcategory(category);

												System.out.println((categoryService.isAddNewCategory(cmodel))
														? "Category Added Successfully.....!"
														: "Category NOT Added Successfully.....!");
												break;

											case 2:
												System.out.println("\n CATEGORY LIST \n");
												List<CategoryModel> catlist = categoryService.getAllCategoriesList();
												catlist.forEach((cl) -> System.out
														.println(cl.getCategoryid() + "\t" + cl.getEcategory()));
												break;
											case 3:
												System.out.println("\n CATEGORY LIST \n");
												catlist = categoryService.getAllCategoriesList();
												catlist.forEach((cl) -> System.out
														.println(cl.getCategoryid() + "\t" + cl.getEcategory()));

												System.out.println("Enter Category ID for delete");
												int cid = xyz.nextInt();
												boolean b = categoryService.isDeleteCategory(cid);
												if (b) {
													System.out.println("category deleted successfully...");
												} else {
													System.out.println("Category not deleted...");
												}
												break;
											case 4:
												limit = "category";
												break;
											default:
												System.out.println("Invalid choice for category...");
												break;
											}
											if (limit.equals("category")) {
												break;
											} else {
												System.out.println("Do you want to Repeat CURD of Customer???(y/n)");
												xyz.nextLine();
												limit = xyz.nextLine();
											}
										} while (limit.equals("y"));
										break;
									case 3://////////////////////////// EVENT ///////////////////////////////////
										do {
											System.out.println("1.Add Event");
											System.out.println("2.Show Event");
											System.out.println("3.Delete Envent");
											System.out.println("4.Update Event");
											System.out.println("5.Exit from Event Curd");
											System.out.println("Enter your choice:");

											chs = xyz.nextInt();
											switch (chs) {
											case 1:
												System.out.println("\n CATEGORY LIST \n");
												List<CategoryModel> catlist = categoryService.getAllCategoriesList();
												catlist.forEach((cl) -> System.out
														.println(cl.getCategoryid() + "\t" + cl.getEcategory()));
												System.out.println(
														"In Which category you want to add Event? Enter Category:");
												xyz.nextLine();
												String category = xyz.nextLine();
												System.out.println(
														"Enter name of Event,DATE(yyyy-mm-dd),Total seats,available seats,price,time and Discription of Event ");
												try {
													String name = xyz.nextLine();
													String date = xyz.nextLine();
													int tseats = xyz.nextInt();
													xyz.nextLine();
													int aseats = xyz.nextInt();
													xyz.nextLine();
													int price = xyz.nextInt();
													xyz.nextLine();
													String time = xyz.nextLine();
													String desc = xyz.nextLine();

													emodel.setEname(name);
													emodel.setEdate(date);
													emodel.setTseats(tseats);
													emodel.setAseats(aseats);
													emodel.setPrice(price);
													emodel.setTime(time);
													emodel.setDesc(desc);

													boolean b = eventService.isAddNewEvent(emodel);

													xyz.nextLine();
													int cid = categoryService.getIdByName(category);
													xyz.nextLine();
													int eid = eventService.getIdByEventName(name);
													System.out.println("eid=" + eid);
													boolean b1 = categoryService.isAssociatedCatEvent(cid, eid);

													if (b1 && b) {
														System.out.println("Event added successfully...");
													} else {
														System.out.println("Event not Added...");
													}
												} catch (InputMismatchException e) {
													System.out.println(
															"Invalid input! Please enter data in the correct format.");
													xyz.nextLine(); // Clear scanner buffer
												} catch (Exception e) {
													System.out.println("An error occurred: " + e.getMessage());
												}
												break;
											case 2:
												System.out.println(
														"===================Upcoming Events======================");
												elist = eventService.getAllEvent(emodel);
												elist.forEach((e) -> System.out.println(e.getEid() + "\t" + e.getEname()
														+ "\t" + e.getEdate() + "\t" + e.getTseats() + "\t"
														+ e.getAseats() + "\t" + e.getPrice() + "\t" + e.getTime()
														+ "\t" + e.getDesc()));
												break;
											case 3:
												System.out.println(
														"===================Upcoming Events======================");
												elist = eventService.getAllEvent(emodel);
												elist.forEach((e) -> System.out.println(e.getEid() + "\t" + e.getEname()
														+ "\t" + e.getEdate() + "\t" + e.getTseats() + "\t"
														+ e.getAseats() + "\t" + e.getPrice() + "\t" + e.getTime()
														+ "\t" + e.getDesc()));

												System.out.println("Enter Event ID for delete:");
												int eid = xyz.nextInt();
												boolean b = eventService.isDeleteEvent(eid);
												if (b) {
													System.out.println("Event deleted successfully...");
												} else {
													System.out.println("Event not deleted...");
												}
												break;
											case 4:
												System.out.println(
														"===================Upcoming Events======================");
												elist = eventService.getAllEvent(emodel);
												elist.forEach((e) -> System.out.println(e.getEid() + "\t" + e.getEname()
														+ "\t" + e.getEdate() + "\t" + e.getTseats() + "\t"
														+ e.getAseats() + "\t" + e.getPrice() + "\t" + e.getTime()
														+ "\t" + e.getDesc()));

												System.out.println("Enter id to update date of event");
												xyz.nextLine();
												eid = xyz.nextInt();
												System.out.println("Enter Date(yyyy-mm-dd) for update");
												xyz.nextLine();
												String date = xyz.nextLine();

												b = eventService.updateDateById(eid, date);
												if (b) {
													System.out.println("Date of Event Updated Successfully...");
												} else {
													System.out.println("Date not updated...");
												}
												break;
											case 5:
												limit = "event";
												break;
											default:
												System.out.println("Invalid choice for event...");
												break;
											}
											if (limit.equals("event")) {

												break;
											} else {
												System.out.println("Do you want to Repeat CURD of Customer???(y/n)");
												xyz.nextLine();
												limit = xyz.nextLine();
											}
										} while (limit.equals("y"));
										break;
									case 4:
//									bookingService.callBooking();

										////////////////////////////////// * BOOKING LOGIC
										////////////////////////////////// *//////////////////////////////////

										LinkedHashMap<String, ArrayList<EventModel>> ecatlist = eventService
												.getAllEventByCategory();
										for (Map.Entry<String, ArrayList<EventModel>> entry : ecatlist.entrySet()) {
											String category = entry.getKey();
											ArrayList<EventModel> events = entry.getValue();

											System.out.println("Category: " + category);
											System.out.println("Events:");

											if (events != null && !events.isEmpty()) {
												for (EventModel event : events) {
													// Assuming EventModel has a `toString` or display method
													System.out.println("  Event Name: " + event.getEname());
													System.out.println("  Event Date: " + event.getEdate());
													System.out.println("  Total Seats: " + event.getTseats());
													System.out.println("  Available Seats: " + event.getAseats());
													System.out.println("  Price: " + event.getPrice());
													System.out.println("  Time: " + event.getTime());
													System.out.println("  Description: " + event.getDesc());
													System.out.println();
												}
											} else {
												System.out.println("  No events in this category.");
											}
										}

										System.out.println("Enter Event Name Which you want to Book...");
										xyz.nextLine();
										String ename = xyz.nextLine().trim();
										int eid = eventService.getIdByEventName(ename);
										System.out.println("Eid=" + eid);
										int curseates = eventService.checkAvailableSeates(eid);
										System.out.println("Current Available seates are: " + curseates);
										if (curseates > 0) {
											System.out.println("Enter User name...");
											String uname = xyz.nextLine();
											int uid = userService.getUidByUserName(uname);

											System.out.println("eid=" + eid + "\t" + "uid=" + uid);

											System.out.println("Enter Number of tickets:");
											int numtickets = xyz.nextInt();
											xyz.nextLine();
											if (numtickets < curseates) {
												int price = eventService.getPriceByEventId(eid);

												float totalprice = bookingService.calBookingAmount(price, numtickets);

												String status = "";
												System.out.println("Your total amount of ticket is:" + totalprice);
												System.out.println("Are you sure to confirm your booking???(y/n)");

												String msg = xyz.nextLine();

												if (msg.equals("y")) {
													System.out.println(
															"Enter " + totalprice + " amount to complete transaction:");
													float uamt = xyz.nextFloat();
													xyz.nextLine();
													if (totalprice == uamt) {
														System.out.println("Your tickets is Successfully Booked...");
														status = "Confirm";

														boolean b = eventService.getAvailableSeates(eid, numtickets);

													} else if (uamt == 0) {
														System.out.println(
																"Transaction Failed...Plz Enter total price...");
														status = "Failed";
													} else {
														System.out.println("Your Booking status is pending...");
														status = "Not Confirm";
													}
													bmodel.setUid(uid);
													bmodel.setEid(eid);
													bmodel.setNumtickets(numtickets);
													bmodel.setStatus(status);
													bmodel.setFinalprice(totalprice);

													uebmodel.setEname(ename);
													uebmodel.setUname(uname);
													uebmodel.setNumtickets(numtickets);
													uebmodel.setStatus(status);
													uebmodel.setFinalprice(totalprice);

													boolean b = bookingService.isAddBookingDeatails(bmodel);
													if (b) {
														System.out.println("Booking done...");
													} else {
														System.out.println("Booking not done...");
													}
												} else {
													System.out.println("Thank for visiting us...");
//												System.out.println("Now Avalaible seates for your event is:" + curseates);
												}
											} else {
												System.out
														.println("Now Avalaible seates for your event is:" + curseates);
												System.out.println(
														"Plzz select less than or equal to " + curseates + " seats");
											}
										} else {
//										System.out.println("Thank for visiting us...");
											System.out.println("Now Avalaible seates for your event is:" + curseates);
										}
										break;
									case 5:
										System.out.println(
												"=========================All Booking details======================");
										bklist = bookingService.getAllBookingDetails();
										bklist.forEach((bk) -> System.out.println(
												"Booking ID: " + bk.getBkid() + "\n User Name: " + bk.getUname()
														+ "\n Event Name: " + bk.getEname() + "\n Number Of Tickets: "
														+ bk.getNumtickets() + "\n Status Of Booking: " + bk.getStatus()
														+ "\n Total Amout Of Tickets: " + bk.getFinalprice() + "\n"));
										break;

									case 6:
										try {
											System.out.println("Enter user name to fetch all data:");
											xyz.nextLine();
											String uname = xyz.nextLine();
											ubklist = bookingService.getBookingDetailsByUserName(uname);

											System.out.println(
													"=========================All Booking details======================");
											ubklist.forEach((ubk) -> System.out.println("Booking ID: " + ubk.getBkid()
													+ "\n User Name: " + ubk.getUname() + "\n Event Name: "
													+ ubk.getEname() + "\n Number Of Tickets: " + ubk.getNumtickets()
													+ "\n Status Of Booking: " + ubk.getStatus()
													+ "\n Total Amout Of Tickets: " + ubk.getFinalprice() + "\n"));

											System.out.println("Enter booking Id which Booking you want to cancel:");
											int bkid = xyz.nextInt();
											xyz.nextLine();

											int numtickets = bookingService.getNumOfTicketsByBkid(bkid);
											ename = bookingService.getEventNameByBkid(bkid);
											eventService.isAvalaibleSeatsAfterCancelBooking(ename, numtickets);
											System.out.println("ename=" + ename + "\t" + "numtickets=" + numtickets);
											System.out
													.println("Are you sure about the cancelletion of Booking???(y/n)");
											String msg = xyz.nextLine();
											if (msg.equals("y")) {
												boolean b = bookingService.isCancelBookingByBkid(bkid);
												if (b) {
													System.out.println("Booking cancel succefullyy....");
//										int eid = eventService.get
													// numtickets
													//

												} else {
													System.out.println("Still booking not cancled....");
												}
											} else {
												System.out.println("Thats great...Enjoy Your Event...");
											}

										} catch (Exception e) {
											System.out.println("Error is:" + e.getMessage());
										}

										break;
									case 7:
										limit = "operation";
										break;
									default:
										System.out.println("Invalid choice");
										break;
									}
									if (limit.equals("operation")) {
										break;
									} else {
										System.out.println("Do you want to Repeat Operations Again???(y/n)");
										xyz.nextLine();
										limit = xyz.nextLine();
									}
								} while (limit.equals("y"));
							} else {
								System.out.println("Invalid Username And Password");
							}

							break;

////////////////////////////////////////////////////////////// Customer Login/////////////////////////////////////////////////////////////////////////////////////////////////
						case 2:

							System.out.println("Enter the UserName");
							xyz.nextLine();
							euname = xyz.nextLine();

							System.out.println("Enter the Password");

							eupassword = xyz.nextLine();

							if (userService.isExistngUser(euname, eupassword)) {
								System.out.println(
										"\n You are successfully Logged In Ticket Reservation App of Customer Panel \n");

								do {

									System.out.println("1.Show Events");
									System.out.println("2.Book Ticket");
									System.out.println("3.Cancel Booking");
									System.out.println("4.Receipt");
									System.out.println("12.Exit");

									System.out.println("Enter the Choice");
									int ch = xyz.nextInt();

									switch (ch) {
									case 1:
										System.out.println("===================Upcoming Events======================");
										elist = eventService.getAllEvent(emodel);
										elist.forEach((e) -> System.out.println(e.getEid() + "\t" + e.getEname() + "\t"
												+ e.getEdate() + "\t" + e.getTseats() + "\t" + e.getAseats() + "\t"
												+ e.getPrice() + "\t" + e.getTime() + "\t" + e.getDesc()));
										break;

									case 2:
										try {
											LinkedHashMap<String, ArrayList<EventModel>> ecatlist = eventService
													.getAllEventByCategory();
											for (Map.Entry<String, ArrayList<EventModel>> entry : ecatlist.entrySet()) {
												String category = entry.getKey();
												ArrayList<EventModel> events = entry.getValue();

												System.out.println("Category: " + category);
												System.out.println("Events:");

												if (events != null && !events.isEmpty()) {
													for (EventModel event : events) {
														// Assuming EventModel has a `toString` or display method
														System.out.println("  Event Name: " + event.getEname());
														System.out.println("  Event Date: " + event.getEdate());
														System.out.println("  Total Seats: " + event.getTseats());
														System.out.println("  Available Seats: " + event.getAseats());
														System.out.println("  Price: " + event.getPrice());
														System.out.println("  Time: " + event.getTime());
														System.out.println("  Description: " + event.getDesc());
														System.out.println();
													}
												} else {
													System.out.println("  No events in this category.");
												}
											}

											System.out.println("Enter Event Name Which you want to Book...");
											xyz.nextLine();
											String ename = xyz.nextLine().trim();
											int eid = eventService.getIdByEventName(ename);
											System.out.println("Eid=" + eid);
											int curseates = eventService.checkAvailableSeates(eid);
											System.out.println("Current Available seates are: " + curseates);
											if (curseates > 0) {
												System.out.println("Enter User name...");
												String uname = xyz.nextLine();
												int uid = userService.getUidByUserName(uname);

												System.out.println("eid=" + eid + "\t" + "uid=" + uid);

												System.out.println("Enter Number of tickets:");
												int numtickets = xyz.nextInt();
												xyz.nextLine();
												if (numtickets < curseates) {
													int price = eventService.getPriceByEventId(eid);

													float totalprice = bookingService.calBookingAmount(price,
															numtickets);

													String status = "";
													System.out.println("Your total amount of ticket is:" + totalprice);
													System.out.println("Are you sure to confirm your booking???(y/n)");

													String msg = xyz.nextLine();

													if (msg.equals("y")) {
														System.out.println("Enter " + totalprice
																+ " amount to complete transaction:");
														float uamt = xyz.nextFloat();
														xyz.nextLine();
														if (totalprice == uamt) {
															System.out
																	.println("Your tickets is Successfully Booked...");
															status = "Confirm";

															boolean b = eventService.getAvailableSeates(eid,
																	numtickets);

														} else if (uamt == 0) {
															System.out.println(
																	"Transaction Failed...Plz Enter total price...");
															status = "Failed";
														} else {
															System.out.println("Your Booking status is pending...");
															status = "Not Confirm";
														}
														bmodel.setUid(uid);
														bmodel.setEid(eid);
														bmodel.setNumtickets(numtickets);
														bmodel.setStatus(status);
														bmodel.setFinalprice(totalprice);

														uebmodel.setEname(ename);
														uebmodel.setUname(uname);
														uebmodel.setNumtickets(numtickets);
														uebmodel.setStatus(status);
														uebmodel.setFinalprice(totalprice);

														boolean b = bookingService.isAddBookingDeatails(bmodel);
														if (b) {
															System.out.println("Booking done...");
														} else {
															System.out.println("Booking not done...");
														}
													} else {
														System.out.println("Thank for visiting us...");
//													System.out.println("Now Avalaible seates for your event is:" + curseates);
													}
												} else {
													System.out.println(
															"Now Avalaible seates for your event is:" + curseates);
													System.out.println("Plzz select less than or equal to " + curseates
															+ " seats");
												}
											} else {
//											System.out.println("Thank for visiting us...");
												System.out
														.println("Now Avalaible seates for your event is:" + curseates);
											}

										} catch (Exception e2) {
											System.out.println("Error is:" + e2);
										}
										break;
									case 3:
										try {
											System.out.println("Enter user name to fetch all data:");
											xyz.nextLine();
											String uname = xyz.nextLine();
											ubklist = bookingService.getBookingDetailsByUserName(uname);

											System.out.println(
													"=========================All Booking details======================");
											ubklist.forEach((ubk) -> System.out.println("Booking ID: " + ubk.getBkid()
													+ "\n User Name: " + ubk.getUname() + "\n Event Name: "
													+ ubk.getEname() + "\n Number Of Tickets: " + ubk.getNumtickets()
													+ "\n Status Of Booking: " + ubk.getStatus()
													+ "\n Total Amout Of Tickets: " + ubk.getFinalprice() + "\n"));

											System.out.println("Enter booking Id which Booking you want to cancel:");
											int bkid = xyz.nextInt();
											xyz.nextLine();

											int numtickets = bookingService.getNumOfTicketsByBkid(bkid);
											String ename = bookingService.getEventNameByBkid(bkid);
											eventService.isAvalaibleSeatsAfterCancelBooking(ename, numtickets);
											System.out.println("ename=" + ename + "\t" + "numtickets=" + numtickets);
											System.out
													.println("Are you sure about the cancelletion of Booking???(y/n)");
											String msg = xyz.nextLine();
											if (msg.equals("y")) {
												boolean b = bookingService.isCancelBookingByBkid(bkid);
												if (b) {
													System.out.println("Booking cancel succefullyy....");
//										int eid = eventService.get
													// numtickets
													//

												} else {
													System.out.println("Still booking not cancled....");
												}
											} else {
												System.out.println("Thats great...Enjoy Your Event...");
											}

										} catch (Exception e) {
											System.out.println("Error is:" + e.getMessage());
										}
										break;
									case 4:
										try {
											System.out.println("Enter user name to fetch all data:");
											xyz.nextLine();
											String uname = xyz.nextLine();
											ubklist = bookingService.getBookingDetailsByUserName(uname);

											System.out.println(
													"=========================All Booking details======================");
											ubklist.forEach((ubk) -> System.out
													.println("Booking ID: " + ubk.getBkid() + "\n User Name: "
															+ ubk.getUname() + "\n Event Name: " + ubk.getEname()));

											System.out
													.println("Enter booking Id of event for getting Booking Receipt:");
											int bkid = xyz.nextInt();
											xyz.nextLine();
											receiptlist = bookingService.getBookingReceiptByBkid(bkid);
											receiptlist.forEach((r) -> System.out.println(
													"Booking Id:" + r.getBkid() + "\n User Name:" + r.getUname()
															+ "\n Event Name:" + r.getEname() + "\n Number of Tickets:"
															+ r.getNumtickets() + "\n Booking Date & Time: "
															+ r.getBkdate() + "\n Status Of Booking:" + r.getStatus()
															+ "\n \n Total Price Of Tickets:" + r.getFinalprice()));

										} catch (Exception e) {
											System.out.println("Error is:" + e);
										}
										break;
									case 12:
										System.exit(0);

									default:
										System.out.println("Invalid Choice");

									}

									System.out.println("Do you want to Repeat(y/n)");
									xyz.nextLine();
									limit = xyz.nextLine();

								} while (limit.equals("y"));

							} else {
								System.out.println("Invalid User");
							}
							break;

						case 3:
							limit = "panel";
							break;
						default:
							System.out.println("Invalid choice");
						}

					} while (!limit.equals("panel"));
					break;
				case 4:

					System.exit(0);
					break;

				default: {
					System.out.println("Invalid Choice");
				}
				}

			} while (true);
		} catch (InputMismatchException e) {
			System.out.println("Error is:InputMismatchException for this plz input proper datatype:IN INTEGER");
			logger.error("TicketReservationApp InputMismatchException");

		}

	}

}