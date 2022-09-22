package guestbook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class GuestBookDAO {
	
	// 게시물 등록
	// 쿼리 작성
	// VO Value Object 이것도 bean이나 DTO 나 형태는 같으나 의미적인 측면에서 다름
	// 값을 DB에서 들고 왔을때 절대 변경되선 안되는 값들을 VO라 한다
	
	public static boolean writeContent(GuestBookBean vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into guestbook(title, author, email, content, pw) value( ?, ?, ?, ?, ?)");

	        pstmt.setString(1, vo.getTitle());
	        pstmt.setString(2, vo.getAuthor());
	        pstmt.setString(3, vo.getEmail());
	        pstmt.setString(4, vo.getContent());
	        pstmt.setString(5, vo.getPassword());
	        
			int count = pstmt.executeUpdate();			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;		
	}
	
	// 게시물 조회 - boolean flag 값 = read인 경우 true, update인 경우  false
	public static GuestBookBean getContent(int  num, boolean flag) throws SQLException{		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GuestBookBean vo  = null;
		String query1="update guestbook set readnum = readnum+1 where num = ?";
		String query2="select * from guestbook where num = ?";
		try {
			con = DBUtil.getConnection();
			if(flag){
				pstmt = con.prepareStatement(query1);
				pstmt.setInt(1, num);
				int count = pstmt.executeUpdate();
				if(count == 0){
					return vo;
				}
			}
			
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1, num);	
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				vo = new GuestBookBean(num, rset.getString(2),
									rset.getString(3),rset.getString(4),rset.getString(5).replaceAll("</n>","<br>"),
									rset.getString(6),rset.getString(7),rset.getInt(8));
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return vo;
	}
	
	//게시물 삭제
	public  static boolean deleteContent(int num, String password) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String query = "delete from guestbook where num = ? and pw = ? ";		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1,num);
	        pstmt.setString(2,password);

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// 게시물 수정
	public  static boolean updateContent(GuestBookBean vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		String query = "update guestbook set title = ?, author = ?, email = ?, content = ?"
				+ "where num = ? and pw = ? ";
		try {
			con = DBUtil.getConnection();
		
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,vo.getTitle());
		    pstmt.setString(2,vo.getAuthor());
		    pstmt.setString(3, vo.getEmail());
		    pstmt.setString(4, vo.getContent());
		    pstmt.setInt(5, vo.getNum());
		    pstmt.setString(6, vo.getPassword());

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// 모든 게시물 조회
	public  static ArrayList<GuestBookBean> getAllContents() throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GuestBookBean> alist = null;
		String sql="select * from guestbook";	
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			alist = new ArrayList<GuestBookBean>();
			while(rset.next()){
				alist.add(new GuestBookBean(rset.getInt(1),rset.getString(2),
						rset.getString(3),rset.getString(4),rset.getString(5)
		 				,rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
	}
}
