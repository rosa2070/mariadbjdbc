import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx05 {

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
			
			String sql = String.format( "select * from dept2" );
			rs = stmt.executeQuery( sql );
			
			rs.next();
			System.out.println( rs.getString( "deptno" ) );
			System.out.println( rs.getString( "dname" ) );
			System.out.println( rs.getString( "loc" ) );

			rs.next();
			System.out.println( rs.getString( "deptno" ) );
			System.out.println( rs.getString( "dname" ) );
			System.out.println( rs.getString( "loc" ) );

			rs.next();
			System.out.println( rs.getString( 1 ) );
			System.out.println( rs.getString( 2 ) );
			System.out.println( rs.getString( 3 ) );
			
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




