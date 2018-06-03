package cn.li.Factory;

import cn.li.service.IMyEmpService;
import cn.li.service.impl.MyEmpServiceImpl;

public class ServiceFactory {
	public static IMyEmpService getMyEmpServiceImplInstance() {
		return new MyEmpServiceImpl();
	}
}
