import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( "시작" );

		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			System.out.println( "드라이버 로딩 성공" );
				
			conn = DriverManager.getConnection(url, user, password);
			System.out.println( "데이터베이스 연결 성공" );
			
			stmt = conn.createStatement();
			
			// DDL
			String sql = String.format( "create table testtbl ( col1 varchar(10) )" );
			//System.out.println( sql );
			int result = stmt.executeUpdate( sql );
			
			System.out.println( "생성 완료 : " + result );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( stmt != null ) try { stmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
					
		System.out.println( "끝" );
	}

}




