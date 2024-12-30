package ticketreservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingModel {
	
	private int uid;
	private int eid;
	private int numtickets;
	private String status;
	private float finalprice;
	
//	public BookingModel() {
//		
//	}
//	public BookingModel(int uid,int eid,int numtickets,String status,float finalprice) {
//		this.uid=uid;
//		this.eid=eid;
//		this.numtickets=numtickets;
//		this.status=status;
//		this.finalprice=finalprice;
//	}
	
	
//	public float getFinalprice() {
//		return finalprice;
//	}
//	public void setFinalprice(float finalprice) {
//		this.finalprice = finalprice;
//	}
//	public int getUid() {
//		return uid;
//	}
//	public void setUid(int uid) {
//		this.uid = uid;
//	}
//	public int getEid() {
//		return eid;
//	}
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
//	public int getNumtickets() {
//		return numtickets;
//	}
//	public void setNumtickets(int numtickets) {
//		this.numtickets = numtickets;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	
}
