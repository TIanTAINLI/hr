package cn.li.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

import cn.li.Factory.ServiceFactory;
import cn.li.vo.MyEmp;
import junit.framework.TestCase;

class MyEmpServiceImplTest {
	private static int empno;
	static {
		empno=new Random().nextInt(10000);
	}
	@Test
	void testInsert() {
		MyEmp vo=new MyEmp ();
		vo.setEmpno(999);
		vo.setEname("’≈∫≤");
		vo.setJob("hello");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			TestCase.assertTrue(ServiceFactory.getMyEmpServiceImplInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testUpdate() {
		MyEmp vo=new MyEmp ();
		vo.setEmpno(999);
		vo.setEname("’≈∫≤");
		vo.setJob("hello");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			TestCase.assertTrue(ServiceFactory.getMyEmpServiceImplInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testDelete() {
		try {
			Set<Integer> set=new HashSet<>();
			set.add(9999);
			TestCase.assertTrue(ServiceFactory.getMyEmpServiceImplInstance().delete(set));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getMyEmpServiceImplInstance().get(999));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getMyEmpServiceImplInstance().list().size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testListIntIntStringString() {
		int current=1;
		int pageSize=6;
		String column="ename";
		String keyword="S";
		try {
			Map<String,Object> map=ServiceFactory.getMyEmpServiceImplInstance().list(current, pageSize, column, keyword);
			int myEmpsCount=(Integer)map.get("myEmpsCount");
			System.out.println(myEmpsCount+"\n");
			List<MyEmp> list=(List<MyEmp>)map.get("allMyEmps");
			Iterator<MyEmp> it=list.iterator();
			while(it.hasNext()) {
				MyEmp myEmp=it.next();
				System.out.println(myEmp.getEname());
			}
			TestCase.assertTrue(myEmpsCount>0&&list.size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
