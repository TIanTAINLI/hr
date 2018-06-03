package cn.li.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.li.dao.IMyEmpDao;
import cn.li.vo.MyEmp;

public class MyEmpDaoImpl implements IMyEmpDao {

	private Connection conn;
	PreparedStatement pstmt;
	public MyEmpDaoImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreate(MyEmp vo) throws Exception {
		// TODO Auto-generated method stub
		String sql="INSERT INTO myemp(empno,ename,job,hiredate,sal,comm) VALUES (?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getEmpno());
		pstmt.setString(2,vo.getEname());
		pstmt.setString(3,vo.getJob());
		pstmt.setDate(4,new java.sql.Date(vo.getHiredate().getTime()));
		pstmt.setDouble(5,vo.getSal());
		pstmt.setDouble(6,vo.getComm());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(MyEmp vo) throws Exception{
		// TODO Auto-generated method stub
		String sql="UPDATE myemp SET ename=?,job=?,hiredate=?,sal=?,comm=?  WHERE empno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setString(1,vo.getEname());
		pstmt.setString(2,vo.getJob());
		pstmt.setDate(3,new java.sql.Date(vo.getHiredate().getTime()));
		pstmt.setDouble(4,vo.getSal());
		pstmt.setDouble(5,vo.getComm());
		pstmt.setInt(6, vo.getEmpno());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception{
		// TODO Auto-generated method stub
		if(ids==null||ids.size()==0) {
			return false;
		}
		StringBuffer sql=new StringBuffer(" DELETE FROM myemp WHERE empno IN ( ");
		Iterator<Integer> iter=ids.iterator();
		while(iter.hasNext()) {
			int i=iter.next();
			sql.append(i).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(") ");
		this.pstmt=this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate()==ids.size();
	}

	@Override
	public MyEmp findById(Integer id) throws Exception{
		MyEmp vo=null;
		String sql=" SELECT empno,ename,job,hiredate,sal,comm FROM myemp WHERE empno=? ";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			vo=new MyEmp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
		}
		return vo;
	}

	@Override
	public List<MyEmp> findAll() throws Exception{
		// TODO Auto-generated method stub
		List<MyEmp> all=new ArrayList<MyEmp>();
		String sql=" SELECT empno,ename,job,hiredate,sal,comm FROM myemp ";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			MyEmp vo=new MyEmp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<MyEmp> findBySplit(int currentPage, int pageSize, String column, String password) throws Exception{
		// TODO Auto-generated method stub
		List<MyEmp> all=new ArrayList<MyEmp>();
		String sql=" SELECT *  FROM "
				+ " (SELECT  empno,ename,job,hiredate,sal,comm,ROWNUM rn FROM myemp WHERE ROWNUM<=? AND  "+column+" LIKE ? ) "
				+ " temp WHERE rn> ? ";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setInt(1, currentPage*pageSize);
		pstmt.setString(2, "%"+password+"%");
		pstmt.setInt(3, (currentPage-1)*pageSize);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			MyEmp vo=new MyEmp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getCount(String column, String password) throws Exception{
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(empno) FROM myemp WHERE "+column+" like ? ";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setString(1,"%"+password+"%");
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}

}
