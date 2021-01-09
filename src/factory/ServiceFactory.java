package factory;

import service.ICustService;
import service.impl.CustServiceImpl;

public class ServiceFactory {
	public static ICustService getCustServiceInstance() {
		return new CustServiceImpl();
	}
}
