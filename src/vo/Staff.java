package vo;

public class Staff {
	private int scard;
	private String sname;
	public Staff() {
		super();
	}
	public Staff(int scard, String sname) {
		super();
		this.scard = scard;
		this.sname = sname;
	}
	public int getScard() {
		return scard;
	}
	public void setScard(int scard) {
		this.scard = scard;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
