package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DButil {
	
	static DataSource ds;
	
	
	
	//1단계 : Driver 로딩
	static {
		Context initialContext = null;
		
		try {
			initialContext = new InitialContext();
			
			// 초기 설정 파일 envContext에 저장
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			
			// 우리가 필요한 초기설정 context.xml 을 불러 위해 아래 와같이 "jdbc/mysql" 별칭으로 찾는다
			ds = (DataSource)envContext.lookup("jdbc/mysql");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// 2단계 : DB 연결 가능 메소드
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	// 6단계 : 자원반환 메소드
	public static void close(ResultSet rset, Statement stmt, Connection con) throws SQLException {
		if(rset != null) {
			rset.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(Statement stmt, Connection con) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
}
