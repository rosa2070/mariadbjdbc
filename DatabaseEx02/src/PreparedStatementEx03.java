import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select deptno, dname, loc from dept2 where dname=?";
//			String sql = "select deptno, dname, loc from dept2 where ?=?";
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setString(1, "dname");
//			pstmt.setString(2, "개발부");
			pstmt.setString(1, "개발부");
			
			rs = pstmt.executeQuery();
			while ( rs.next() ) {
				String result = String.format("%s %s %s", 
						rs.getString("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				System.out.println(result);
			}
			System.out.println("실행완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());		
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}

}
