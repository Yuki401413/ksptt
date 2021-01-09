import vo.Cust;
import factory.ServiceFactory;
public class test {
	public static void main(String[] args) {
		Cust vo=new Cust();
		vo.setCoding("20201219");
		vo.setName("王大三");
		vo.setAge(21);
		vo.setTime("AM12");
		vo.setMoney(200);
		try {
			ServiceFactory.getCustServiceInstance().insert(vo);
			System.out.println("Oh!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
