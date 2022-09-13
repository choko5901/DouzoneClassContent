package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.Dept;
import util.DBUtil;

//DAO 란 Data Access Object


public class DeptDAO {
//		
//	// 1단계 : Driver 로딩 
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	// 2단계 : DB 연결
	// dept 테이블에서 모든 정보 검색
	// Query : SELECT * FROM DEPT;
	
	public static ArrayList<Dept> getAllDept() throws SQLException{
		ArrayList<Dept> allData = null;
		// 2단계 : DB 연결에는 필요한 객체들이 몇개 필요한데 그중 Connection 객체가 있고
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		
		
		try {
			con = DBUtil.getConnection();
			
			// 3단계 : SQL 문장객체(Statement) 도 있다
			stmt = con.createStatement();
			
			// 4단계 : SQL 실행( DB에서 SELECT * FROM DEPT;) -> 반환된 결과를 담을 수 있는 객체 (ResultStatement)
			
			rset = stmt.executeQuery("SELECT * FROM DEPT;");
			
			allData = new ArrayList<Dept>();
			
			
			
			
			while(rset.next()){
				// 5단계 : 데이터 활용(검색)
				allData.add(new Dept(rset.getInt("DEPTNO"), rset.getString("DNAME"), rset.getString("loc")));
			}
			
			// 6단계 : DB 종료(자원 반환하는 로직 사용)			
		} finally {
//			rset.close();
//			stmt.close();
//			con.close();
			DBUtil.close(rset, stmt, con);
		}
		
		
		return allData;
	}
	
	// step02 : 부서번호로 특정 부서만 검색
	
	// Query : select * from where deptno = ?;
	public static Dept getDept(int deptno) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		Dept data = null;
		
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();

			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select * from dept where deptno =" + deptno+ ";");
			while(rset.next()) {
				data = new Dept(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			}
		} finally {
//			rset.close();
//			stmt.close();
//			con.close();
			
			DBUtil.close(rset, stmt, con);
		}
		
		return data;
		
		
	}
	
	
	
	
	//step 02-2
	
	public static Dept getDeptByDname(String dname) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Dept data = null;
		
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("select * from dept where dname = ?");
			pstmt.setString(1, dname);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				data = new Dept(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			}
		} finally {
//			rset.close();
//			pstmt.close();
//			con.close();
			
			//파라미터 값으로 pstmt로 받아 지는 이유는 Statement 타입이 PreparedStatement의 부모 요소 이기떄문에
			// 상속이 가능해 pstmt로 보내도 에러가 없다
			DBUtil.close(rset, pstmt, con);
		}
		
		return data;
		
		
	}
	
	//step 03 새로운 부서 생성
	// Query : insert into dept values(deptno, dname, loc)
	
	private static boolean insertDept(Dept dept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("insert into dept values(?, ?, ?)");
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			//DB 내용 업데이트(생성) : 몇 개의 행이 적용 되어쓴지 그 반환 값을 숫자로 나타냄
			
			int result = pstmt.executeUpdate();
			
			if(result != 0) {
				
				return true;
			}
			
			
		} finally {
			
//			pstmt.close();
//			con.close();
			DBUtil.close(pstmt, con);

		}
		
		
		
		
		return false;
	}
	
	
	public static  boolean setDeptLoc(String loc, int deptno) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		
		
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update dept set loc = ? where deptno = ?");
			pstmt.setString(1, loc);
			pstmt.setInt(2, deptno);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0) {
				
				return true;
			}
					
				
		} finally {
		
//			pstmt.close();
//			con.close();
			DBUtil.close(pstmt, con);

		}
		
		return false;
		
		
	}
	
	
	
	public static  boolean deleteDept(String dname) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul", "scott", "tiger");
			con = DBUtil.getConnection();

//			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("delete from dept where dname = ?");
			pstmt.setString(1, dname);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0) {
				
				return true;
			}
			
//			con.commit();			
		} finally {
		
//			pstmt.close();
//			con.close();
			DBUtil.close(pstmt, con);

		}
		return false;
	}
	

	
	
	
	
	//그냥 실행하면 타임존 에러 생기는데 위의 URL 에 파라미터로 serverTimezone=Asia/Seoul 을 전달
	public static void main(String[] args) {
		try {
			// step01 : 모든 부서 검색
			
			for(Dept dept :getAllDept()) {
				System.out.println(dept);
			};
			// step02-1 : 부서번호로 특정 부서만 검색
			
			
//			System.out.println(getDept(10));
			
			// step02-2 : 부서 이름으로 특정 부서 정보 검색
//			System.out.println(getDeptByDname("ACCOUNTING"));
			
			// step03 : 새로운 부서 생성(insert 성공 - true / false)
			
//			System.out.println(insertDept(new Dept(50,"IT", "DEV")));
			
			// step03-2 builder 패턴으로 해보기
			
			Dept newDept = new Dept.Builder()
									.deptno(60)
									.dname("IT")
									.loc("DEV")
									.build();
			
			
			// step04 : 부서 번호로 검색하여 해당 부서의 위치를 수정 50번 부서의 위치를 SEOUL로 변경하기;
			
//			System.out.println(setDeptLoc("SEOUL", 50));
			
			// step05 : 삭제
			
//			System.out.println(deleteDept("IT"));
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

}