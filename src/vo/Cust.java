package vo;

import java.io.Serializable;
public class Cust implements Serializable{
	private String coding;
	private String name;
	private int age;
	private String time;
	private int money;
	private int rnumber;
	public Cust() {
		
	}
	public Cust(String coding, String name, int age, String time, int money,int rnumber) {
		super();
		this.coding = coding;
		this.name = name;
		this.age = age;
		
		this.time = time;
		this.money = money;
		this.rnumber=rnumber;
	}
	public  String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getRnumber() {
		return rnumber;
	}
	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}
	public String toString() {
		return "编码="+this.coding+"，姓名="+this.name+"，年龄="+this.age
				+"，时间="+this.time+"，金额="+this.money+"，包间号"+this.rnumber;
	}

}
