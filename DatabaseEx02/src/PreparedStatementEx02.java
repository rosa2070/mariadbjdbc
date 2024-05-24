import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
//			String sql = "update dept2 set dname=?, loc=? where deptno=?";
			String sql = "delete from dept2 where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setString(1, "연구부");
//			pstmt.setString(2, "대전");
//			pstmt.setString(3, "96");
			
			pstmt.setString(1, "96");
			
			int result = pstmt.executeUpdate();
			System.out.println("[쿼리 성공] " + result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());		
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}

}
