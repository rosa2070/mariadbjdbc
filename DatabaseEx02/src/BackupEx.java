import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackupEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt1 = null; // select
		PreparedStatement pstmt2 = null; // insert
		ResultSet rs = null;
		 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String selectSQL = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where deptno=?";
			pstmt1 = conn.prepareStatement(selectSQL);
			pstmt1.setString(1, args[0]);
			rs = pstmt1.executeQuery();
			
			while(rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename"); 
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				String insertSQL = "insert into emp2 values (?, ?, ?, ?, ?, ?, ?, ?) ";
				pstmt2 = conn.prepareStatement(insertSQL);
				
				pstmt2.setString(1, empno);
				pstmt2.setString(2, ename);
				pstmt2.setString(3, job);
				pstmt2.setString(4, mgr);
				pstmt2.setString(5, hiredate);
				pstmt2.setString(6, sal);
				pstmt2.setString(7, comm);
				pstmt2.setString(8, deptno);
				
				pstmt2.executeUpdate();
				
			}
			System.out.println("백업 완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (pstmt2 != null) try { pstmt2.close(); } catch (SQLException e) {}
			if (pstmt1 != null) try { pstmt1.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}

	}

}
