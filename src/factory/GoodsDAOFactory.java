package factory;

import java.sql.Connection;

import dao.IGoodsDAO;
import dao.impl.GoodsDAOImpl;

public class GoodsDAOFactory {
	public static IGoodsDAO getGoodsDAOInstance(Connection conn) {
		return new GoodsDAOImpl(conn);
	}
}
