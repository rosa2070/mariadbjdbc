import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		
		HikariDataSource dataSource = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dataSource = new HikariDataSource();
			
			dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/sample");
			dataSource.setUsername("root");
			dataSource.setPassword("123456");
//		dataSource.addDataSourceProperty("user", "root");
//		dataSource.addDataSourceProperty("password", "123456");
			
			conn = dataSource.getConnection();
			
			String sql = "select version()";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
			
			if (dataSource != null) dataSource.close();
		}
		
		System.out.println("끝");


	}

}
