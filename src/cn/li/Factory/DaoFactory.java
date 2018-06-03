package cn.li.Factory;

import java.sql.Connection;

import cn.li.dao.IMyEmpDao;
import cn.li.dao.impl.MyEmpDaoImpl;

public class DaoFactory {
public static IMyEmpDao getIMyEmpDaoInstance(Connection conn) {
	return new MyEmpDaoImpl(conn); 
}
}
