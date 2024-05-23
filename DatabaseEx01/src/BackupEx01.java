import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BackupEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt1 = null;     // select
		Statement stmt2 = null;     // insert
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt1 = conn.createStatement();
			stmt2 = conn.createStatement();
			
			String selectSQL = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where deptno=10";
			rs = stmt1.executeQuery(selectSQL);
			
			while(rs.next()) {
//				System.out.println(rs.getString("empno"));
				
				// 데이터의 조작
				String empno = rs.getString("empno");
				String ename = rs.getString("ename"); 
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				String insertSQL = String.format("insert into emp_10 values (%s, '%s', '%s', %s, '%s', %s, %s, %s)", 
						empno, ename, job, mgr, hiredate, sal, comm, deptno);
//				System.out.println(insertSQL);
				
				stmt2.executeUpdate(insertSQL);
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
			if (stmt2 != null) try { stmt2.close(); } catch (SQLException e) {}
			if (stmt1 != null) try { stmt1.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		
		
		

	}

}
