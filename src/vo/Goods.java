package vo;

import java.io.Serializable;

public class Goods implements Serializable{
	private String gname;
	private String kind;
	private String details;
	public Goods() {
		super();
	}
	public Goods(String gname,String kind,String details) {
		super();
		this.gname = gname;
		this.kind=kind;
		this.details=details;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
