package ticketreservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventBookingModel {
	private int bkid;
	private String uname;
	private String ename;
	private int numtickets;
	private String bkdate;
	private String status;
	private float finalprice;
	
	
	
//	public UserEventBookingModel() {
//		
//	}
//	public UserEventBookingModel(int bkid, String uname, String ename, int numtickets, String bkdate, String status,
//			float finalprice) {
//		this.bkid = bkid;
//		this.uname = uname;
//		this.ename = ename;
//		this.numtickets = numtickets;
//		this.bkdate = bkdate;
//		this.status = status;
//		this.finalprice = finalprice;
//	}
//	public int getBkid() {
//		return bkid;
//	}
//	public String getUname() {
//		return uname;
//	}
//	public void setUname(String uname) {
//		this.uname = uname;
//	}
//	public void setBkid(int bkid) {
//		this.bkid = bkid;
//	}
//	public String getEname() {
//		return ename;
//	}
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//	public int getNumtickets() {
//		return numtickets;
//	}
//	public void setNumtickets(int numtickets) {
//		this.numtickets = numtickets;
//	}
//	public String getBkdate() {
//		return bkdate;
//	}
//	public void setBkdate(String bkdate) {
//		this.bkdate = bkdate;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public float getFinalprice() {
//		return finalprice;
//	}
//	public void setFinalprice(float finalprice) {
//		this.finalprice = finalprice;
//	}
}
