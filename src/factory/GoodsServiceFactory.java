package factory;

import service.IGoodsService;
import service.impl.GoodsServiceImpl;

public class GoodsServiceFactory {
	public static IGoodsService getIGoodsServiceInstance() {
		return new GoodsServiceImpl();
	}
}
