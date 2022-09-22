package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DButil;

public class DeptDAO {
	// deptno dname 검색
	
	public static String getDNameByDeptno(int deptno) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT dname FROM DEPT WHERE deptno = ?";
		
		String dname = null;
		
		try {
			con = DButil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dname = rset.getString("dname");
			}
			
		} finally {
			DButil.close(rset, pstmt, con);
		}
		
		return dname;
		
	}
	
	
	
	
	
	
}
