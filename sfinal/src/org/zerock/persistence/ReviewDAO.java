package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.zerock.domain.ReviewVO;

public class ReviewDAO {

	// 데이터 소스
	private static BasicDataSource dataSource;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dataSource = new BasicDataSource();
			dataSource.setUrl("jdbc:oracle:thin:@192.168.0.8:1521:XE");
			dataSource.setUsername("leo");
			dataSource.setPassword("leo");
			dataSource.setInitialSize(10); // 사실 10을 주면 안됨. why?? WAS쪽에 150개 사용하면
			dataSource.setMinIdle(5);
			dataSource.setMaxIdle(10);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public int getListCount()throws Exception{
		
		String sql = "select count(rno) from tbl_menu_review ";
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total = -1;
		
		try {
		
			pstmt = dataSource.getConnection().prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				total = rs.getInt(1);
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			}
		return total;		
	}
	
	
	
	public void register(){
	
		
		// ======= !!!
		
	}
	

	public List<ReviewVO> readList(int page){
		
		String sql ="SELECT  rno, member_id, menu_no, score, review, reviewdate "
				+ "FROM(select rownum rn, rno, member_id, menu_no, score, review, reviewdate from TBL_MENU_REVIEW "
				+ "where rownum<= (?)*10 order by rn desc ) menu where rn>(?-1)*10 ";
		
		ResultSet rs = null;
		List<ReviewVO> list= new ArrayList<>();
		
		try {
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, page);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ReviewVO vo = new ReviewVO();
				
				vo.setRno(rs.getInt(1));
				vo.setMemberId(rs.getString(2));
				vo.setMenuNo(rs.getInt(3));
				vo.setScore(rs.getInt(4));
				vo.setReview(rs.getString(5));
				vo.setReviewDate(rs.getDate(6));
				
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	public int CountTotal()throws Exception{
		String sql = "select count(rno) from tbl_menu_review";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total = -1;
		
		try {
			
			pstmt = dataSource.getConnection().prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				total = rs.getInt(1);
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		
		}
		
		return total;
		
	}
}

	
