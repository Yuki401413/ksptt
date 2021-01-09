package vo;

public class History {
	private int coding;
	private String name;
	private int age;
	private String time;
	private int money;
	public History() {
		
	}
	public History(int coding, String name, int age, String time, int money) {
		super();
		this.coding = coding;
		this.name = name;
		this.age = age;
		this.time = time;
		this.money = money;
	}
	public int getCoding() {
		return coding;
	}
	public void setCoding(int coding) {
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
	public String toString() {
		return "编码="+this.coding+"，姓名="+this.name+"，年龄="+this.age
				+"，入住时间="+this.time+"，金额="+this.money;
	}
}
