import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( "시작" );

		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			System.out.println( "드라이버 로딩 성공" );
				
			conn = DriverManager.getConnection(url, user, password);
			System.out.println( "데이터베이스 연결 성공" );
			
			stmt = conn.createStatement();
			
			String sql = "select empno, ename, sal, date_format(hiredate, '%Y/%m/%d') hiredate from emp";
			rs = stmt.executeQuery( sql );
			
			// 1. java
			// 2. sql
			
			while( rs.next() ) {
				// rs.getString( "hiredate" ).replaceAll("-", "/")
				System.out.printf( "%s\t%s\t%s\t%s%n",
					rs.getString( "empno" ), rs.getString( "ename" ), rs.getString( "sal" ), rs.getString("hiredate"));
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( stmt != null ) try { stmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
					
		System.out.println( "끝" );
	}

}




