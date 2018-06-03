package cn.li.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 本类负责数据库的连接和关闭
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
	//取得同一个连接
	public Connection getConnection() {
		return this.conn;
	}
	//关闭连接
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
