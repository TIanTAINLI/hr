package cn.li.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ฺ�����ݿ�����Ӻ͹ر�
 * @author litia
 *
 */
public class DatabaseConnection {
	public static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String DBURL="jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String USER="scott";
	public static final String PSAAWORD="tiger";
	private Connection conn=null;
	public DatabaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL, USER, PSAAWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ȡ��ͬһ������
	public Connection getConnection() {
		return this.conn;
	}
	//�ر�����
	public void  close() {
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
