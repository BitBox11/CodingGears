package org.zerock.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class AbstractDAO {

	// 데이터 소스
	private BasicDataSource dataSource;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AbstractDAO() throws Exception {

		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@192.168.0.8:1521:XE");
		dataSource.setUsername("rurusyu");
		dataSource.setPassword("rurusyu");
		dataSource.setInitialSize(10); // 사실 10을 주면 안됨. why?? WAS쪽에 150개 사용하면
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(10);
		// dataSource.setMaxOpenPreparedStatements(100);
		// DB에서도 사용해야함. 이런 작업이 많기 때문에..
		// 10이면 MAX사이즈를 커넥션 10개로 사용하겠다는 것임. 병목현상 생김. !!실제 운영할때 WAS의 스레드 갯수와 DB의
		// 커넥션 개수를 맞춰야함. !!기억!!

	}

	public void test() {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select sysdate from dual");
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (Exception e) {

		}

	}

//	public static void main(String[] args) throws Exception {
//
//		AbstractDAO dao = new AbstractDAO();
//
//		long start = System.currentTimeMillis();
//
//		for (int i = 0; i < 100; i++) {
//			dao.test();
//
//		}
//
//		long end = System.currentTimeMillis();
//
//		System.out.println("total :" + (end - start));
//
//	}
}
