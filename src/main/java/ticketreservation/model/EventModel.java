package ticketreservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {
	private int eid;
	private String ename;
	private String edate;
	private int tseats;
	private int aseats;
	private int price;
	private String time;

	private String desc;

//	public EventModel() {
//
//	}

//	public EventModel(int eid, String ename, String edate, int tseats, int aseats, int price,String time, String desc) {
//		this.eid = eid;
//		this.ename = ename;
//		this.edate = edate;
//		this.tseats = tseats;
//		this.aseats = aseats;
//		this.price = price;
//		this.time=time;
//		this.desc = desc;
//	}

//	public int getEid() {
//		return eid;
//	}
//
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
//
//	public String getEname() {
//		return ename;
//	}
//
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//
//	public String getEdate() {
//		return edate;
//	}
//
//	public void setEdate(String edate) {
//		this.edate = edate;
//	}
//
//	public int getTseats() {
//		return tseats;
//	}
//
//	public void setTseats(int tseats) {
//		this.tseats = tseats;
//	}
//
//	public int getAseats() {
//		return aseats;
//	}
//
//	public void setAseats(int aseats) {
//		this.aseats = aseats;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public String getTime() {
//		return time;
//	}
//
//	public void setTime(String time) {
//		this.time = time;
//	}
//
//	public String getDesc() {
//		return desc;
//	}
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
}
