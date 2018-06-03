package cn.li.dao;

import java.util.List;
import java.util.Set;

import cn.li.vo.MyEmp;

/**
 * 本接口实现数据类的dao操作
 * @author litia
 *
 */
public interface IMyEmpDao {
	/**
	 * 增加雇员
	 * @param vo 要增加的雇员
	 * @return 增加成功返回true，否则返回false
	 */
	public boolean doCreate(MyEmp vo) throws Exception;
	/**
	 * 更新雇员
	 * @param vo 要更新的雇员信息
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean doUpdate(MyEmp vo) throws Exception;
	/**
	 * 批量删除雇员
	 * @param ids 所有要删除的雇员的编号，set集合保存
	 * @return 删除成功返回true（删除的数量与set集合的长度相等）；
	 */
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
	/**
	 * 通过雇员编号查找雇员信息
	 * @param id
	 * @return
	 */
	public MyEmp findById( Integer id) throws Exception;
	/**
	 * 取得所有雇员信息
	 * @return 以list集合形式返回所有雇员的信息
	 */
	public List<MyEmp> findAll() throws Exception;
	/**
	 * 模糊的数据分页查询
	 * @param currentPage 当前页面
	 * @param pageSize 页面尺寸
	 * @param password 模糊查询的关键字
	 * @param column 要进行模糊查询的列
	 * @return
	 */
	public List<MyEmp> findBySplit(int currentPage,int pageSize,String column,String password) throws Exception;
	/**
	 * 模糊查询的数据量统计
	 * @param column 要进行模糊查询的列
	 * @param password 模糊查询的关键字
	 * @return
	 */
	public Integer getCount(String column,String password) throws Exception;
}
