package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// 1단계 : Driver 로딩 

	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}
	// 2단계 : DB 연결 가능 메소드
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
	}
	
	// 6단계 : 자원 반환 메소드
	
	public static void close(ResultSet rset, Statement stmt, Connection con) throws SQLException{
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
	
	//공통 부분중 위의 메소드에서 파라미터 갯수만 불필요한게 있어 새로운 매소드 만들땐 동일한 이름의
	// 메소드로 만들 수 있습니다 이것을 오버라이딩 이라고 합니다 
	public static void close(Statement stmt, Connection con) throws SQLException{
		
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
		
	}	
	
	
}

