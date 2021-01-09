package factory;
//由于不同层间依靠接口取得对象，所以定义工厂操作类
import java.sql.Connection;
import dao.ICustDAO;
import dao.impl.CustDAOImpl;
public class DAOFactory {
	public static ICustDAO getICustDAOInstance(Connection conn) {
		return new CustDAOImpl(conn);
		
	}
//	public static void main(String[] args) {
//		System.out.println("success!");
//	}
	
}
