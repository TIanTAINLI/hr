package cn.li.dao;

import java.util.List;
import java.util.Set;

import cn.li.vo.MyEmp;

/**
 * ���ӿ�ʵ���������dao����
 * @author litia
 *
 */
public interface IMyEmpDao {
	/**
	 * ���ӹ�Ա
	 * @param vo Ҫ���ӵĹ�Ա
	 * @return ���ӳɹ�����true�����򷵻�false
	 */
	public boolean doCreate(MyEmp vo) throws Exception;
	/**
	 * ���¹�Ա
	 * @param vo Ҫ���µĹ�Ա��Ϣ
	 * @return ���³ɹ�����true�����򷵻�false
	 */
	public boolean doUpdate(MyEmp vo) throws Exception;
	/**
	 * ����ɾ����Ա
	 * @param ids ����Ҫɾ���Ĺ�Ա�ı�ţ�set���ϱ���
	 * @return ɾ���ɹ�����true��ɾ����������set���ϵĳ�����ȣ���
	 */
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
	/**
	 * ͨ����Ա��Ų��ҹ�Ա��Ϣ
	 * @param id
	 * @return
	 */
	public MyEmp findById( Integer id) throws Exception;
	/**
	 * ȡ�����й�Ա��Ϣ
	 * @return ��list������ʽ�������й�Ա����Ϣ
	 */
	public List<MyEmp> findAll() throws Exception;
	/**
	 * ģ�������ݷ�ҳ��ѯ
	 * @param currentPage ��ǰҳ��
	 * @param pageSize ҳ��ߴ�
	 * @param password ģ����ѯ�Ĺؼ���
	 * @param column Ҫ����ģ����ѯ����
	 * @return
	 */
	public List<MyEmp> findBySplit(int currentPage,int pageSize,String column,String password) throws Exception;
	/**
	 * ģ����ѯ��������ͳ��
	 * @param column Ҫ����ģ����ѯ����
	 * @param password ģ����ѯ�Ĺؼ���
	 * @return
	 */
	public Integer getCount(String column,String password) throws Exception;
}
