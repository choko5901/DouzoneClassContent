package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import model.domain.Dept;
import util.DBUtil;

public class DeptDAO {
// 1단계 : Driver 로딩
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// dept 테이블에서 모든 정보 검색
	// Query : SELECT * FROM DEPT;
	
	public static ArrayList<Dept> getAllDept() throws SQLException{ // 2개 이상일수도 있어서 ArrayList + throws SQLException(컨트롤 에서 잡아주게 던지기)
		ArrayList<Dept> alldata = null;
		// 2단계 : DB 연결 
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();
			// 3 단계 : SQL 문장 객체(Statement)
			stmt = con.createStatement();
			
			// 4 단계 : SQL 실행 (DB에서 -> SELECT * FROM DEPT; 반환된 결과를 담을수 있는 객체 (ResultSet)
			
			rset = stmt.executeQuery("SELECT * FROM DEPT;");
			
			alldata = new ArrayList<Dept>();
			while(rset.next()) {
				// 5단계 : 데이터의 활용(검색)
				alldata.add(new Dept(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc")));
			}
			
			 // 6단계 : DB 종료(자원 반환)
		} finally { //주의
//			rset.close();
//			stmt.close();
//			con.close();
			DBUtil.close(rset, stmt, con);
		}
		
		return alldata;
	}
	
	
	// 부서 번호로 특정 부서 검색
	// Query : SELECT * FROM DEPT WHERE DEPTNO = ?
	public static Dept getDept(int deptno) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		Dept data = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("SELECT * FROM DEPT WHERE DEPTNO = " + deptno + ";"); //자바에서 쿼리 ; 생략가능
			while(rset.next()) {
				data = new Dept(rset.getInt("deptno"),rset.getString("dname"), rset.getString("loc"));
			} 
		} finally { // close 순서 있음 *(생성 1 -> 생성2 -> 생성3 인 순서에서 생성 1을 먼저 닫아버리면 문제가 발생한다. 항상 시작점은 제일 마지막에 닫이야 한다.)
//			rset.close();
//			stmt.close();
//			con.close();
			DBUtil.close(rset, stmt, con);
		}

		return data;
	}
	
	public static Dept getDeptByDname(String dname) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null; //
		ResultSet rset = null;
		Dept data = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			pstmt = con.prepareStatement("SELECT * FROM DEPT WHERE DNAME = ?");
			
			pstmt.setString(1, dname);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				data = new Dept(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			} 
			
		}finally {
//			rset.close();
//			pstmt.close();
//			con.close();
			DBUtil.close(rset, pstmt, con);
		}
		return data;
	}
	
	// 새로운 부서 생성
	// Query : INSERT INTO DEPT VALUES(deptno, dname, loc)
	public static boolean insertDept(Dept dept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			
			pstmt = con.prepareStatement("INSERT INTO DEPT VALUES(?, ?, ?)");
			
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			// DB 내용 생성 : 몇개의 행이 적용 되었는지 그 반환값을 숫자로 나타냄
			int result = pstmt.executeUpdate();
			if(result !=0 ) {
				return true;
			}
		}finally {

			pstmt.close();
			con.close();
		}
		
		return false;
	}
	
	public static boolean updateDeptLoc(int deptno, String loc) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con =DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE DEPT SET LOC = ? WHERE DEPTNO = ?");
		
			pstmt.setString(1,loc );
			pstmt.setInt(2,deptno);
			
			// DB 내용 생성 : 몇개의 행이 적용 되었는지 그 반환값을 숫자로 나타냄
			int result = pstmt.executeUpdate();
			if(result !=0 ) {
				return true;
			}
		}finally {

//			pstmt.close();
//			con.close();
			DBUtil.close(pstmt, con);
		}
		return false;
	}
	
	public static void main(String[] args) { //ERORR 세부설정 db해야됨 url 뒤에 설정
		
		try {
			// step01 : 모든 부서 검색 
			for(Dept dept : getAllDept()) {
				System.out.println(dept);
			};
			
			// step02 - 1 : 부서번호로 특정 부서만 검색
//			System.out.println(getDept(10));
			
			// step02 - 2 : 부서이름으로 특정 부서 정보 검색
//			System.out.println(getDeptByDname("ACCOUNTING"));
			
			// step03 : 새로운 부서 생성 (insert 성공 - true / false)
//			System.out.println(insertDept(new Dept(50, "IT", "DEV")));
			
			

//			-- 빌더
//			Dept newDept = new Dept.Builder() // 필요없는것을 맘대로 추가 제거 할수 있다.
//						.deptno(60)
//						.dname("IT")
//						.loc("DEV")
//						.build();
			
			// step04 : 부서 번호로 검색하여 해당 부서의 위치를 수정 , 50 번 부서의 위치를 서울로 변경하기
//			System.out.println(updateDeptLoc(50, "SEOUL"));
			System.out.println(Delete(50));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static boolean Delete(int i) throws SQLException{
		
		
		return false;
	}


}


