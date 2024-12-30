package ticketreservation.repository;

import java.sql.*;
import java.util.Properties;

import org.apache.log4j.*;

import java.io.*;

public class DBconfig {

	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	private static DBconfig db = null;
	
	private static Logger logger = Logger.getLogger(DBconfig.class);
//	static {
//		SimpleLayout layout = new SimpleLayout();
//		ConsoleAppender appender = new ConsoleAppender(layout);
//		logger.addAppender(appender);
//		logger.setLevel(Level.DEBUG);            
//	}
	protected  DBconfig() {
		try {
//			logger=Logger.getLogger(DBconfig.class);
			File f = new File("");
			String path = f.getAbsolutePath();
			FileInputStream inputStream = new FileInputStream(path + "\\src\\main\\resources\\dbconfig.properties");
//			System.out.println(path+"\\src\\main\\resources\\dbconfig.properties");
			Properties p = new Properties();
			p.load(inputStream);
			String driverClassName = p.getProperty("driver");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String url = p.getProperty("url");
			Class.forName(driverClassName);
			 conn = DriverManager.getConnection(url, username, password);
			 if (conn!=null) {
				logger.info("Database is Connected");
			}
			 else {
				 logger.info("Database Connection fail");
			 }
		} catch (SQLException | ClassNotFoundException | IOException ex) {
			logger.error("Error is:" + ex);
		}

	}

	public static DBconfig getInstance() {
		if (db == null) {
			db = new DBconfig();
		}
		return db;
	}
	public static Connection getConn(){
		return conn;
	}
	public static PreparedStatement getStatement() {
		return stmt;
	}
	public static ResultSet getResult() {
		return rs;
	}
	public static CallableStatement getCallStatement() {
		return cstmt;
	}
}
