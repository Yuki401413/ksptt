package vo;

public class Goods1 {
	private int price;
	private String gname;
	private String kind;
	public Goods1() {
		super();
	}
	public Goods1(int price, String gname,String kind) {
		super();
		this.price = price;
		this.gname = gname;
		this.kind=kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	
	
}
