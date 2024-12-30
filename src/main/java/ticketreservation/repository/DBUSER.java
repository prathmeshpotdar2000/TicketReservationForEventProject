package ticketreservation.repository;
import java.sql.*;

import org.apache.log4j.PropertyConfigurator;

public class DBUSER{
	
	static {
		PropertyConfigurator.configure(
				"C:\\Users\\admin\\eclipse-workspace\\TicketReservationSystemForEvent\\src\\main\\resources\\application.properties");
	}
	DBconfig config=DBconfig.getInstance();
	protected Connection conn=config.getConn();
	protected PreparedStatement stmt=config.getStatement();
	protected ResultSet rs=config.getResult();
	protected CallableStatement cstmt = config.getCallStatement();
}
