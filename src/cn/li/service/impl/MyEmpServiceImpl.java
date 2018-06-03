package cn.li.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.li.Factory.DaoFactory;
import cn.li.dbc.DatabaseConnection;
import cn.li.service.IMyEmpService;
import cn.li.vo.MyEmp;   

public class MyEmpServiceImpl implements IMyEmpService {
	DatabaseConnection dbc=new DatabaseConnection();
	
 	@Override
	public boolean insert(MyEmp vo) throws Exception {
 		try {
 			if(DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).findById(vo.getEmpno())==null) {
 				return DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).doCreate(vo);
 			}
 			return false;
 		}catch(Exception e) {
 			throw e;
 		}finally {
 			this.dbc.close();
 		}
 		
	}

	@Override
	public boolean update(MyEmp vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).doRemoveBatch(ids);
		}catch(Exception e) {
			throw  e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public MyEmp get(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).findById(id);
		}catch(Exception e) {
			throw  e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<MyEmp> list() throws Exception {
		// TODO Auto-generated method stub
		try {
		 return DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e) {
			throw  e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(int current, int pageSize, String column, String keyword) throws Exception {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("allMyEmps", DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).findBySplit(current, pageSize, column, keyword));
			map.put("myEmpsCount", DaoFactory.getIMyEmpDaoInstance(this.dbc.getConnection()).getCount(column, keyword));
			return map;
		}catch(Exception e) {
			throw  e;
		}finally {
			this.dbc.close();
		}
	}

}
