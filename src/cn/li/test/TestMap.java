package cn.li.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.li.Factory.ServiceFactory;
import cn.li.vo.MyEmp;

public class TestMap {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
