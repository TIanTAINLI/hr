package cn.li.test;

import java.util.Date;

import cn.li.Factory.ServiceFactory;
import cn.li.vo.MyEmp;

public class TestInsert {

	public static void main(String[] args) {
		MyEmp vo=new MyEmp ();
		vo.setEmpno(8888);
		vo.setEname("’≈∫≤");
		vo.setJob("hello");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			ServiceFactory.getMyEmpServiceImplInstance().insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
