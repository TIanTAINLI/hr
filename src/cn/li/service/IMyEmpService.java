package cn.li.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.li.vo.MyEmp;

public interface IMyEmpService {
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(MyEmp vo) throws Exception;
	public boolean update(MyEmp vo) throws Exception;
	public boolean delete(Set<Integer> ids) throws Exception;
	public MyEmp get(int id) throws Exception;
	public List<MyEmp> list() throws Exception;
	/**
	 * 
	 * @param current
	 * @param pageSize
	 * @param column
	 * @param keyword
	 * @return ��key=allMyEmps������findBySplit()���<br>
	 * <li>��key=myEmpsCount,����getCount()���
	 * @throws Exception
	 */
	public Map<String,Object> list(int current,int pageSize,String column,String keyword) throws Exception;
}
