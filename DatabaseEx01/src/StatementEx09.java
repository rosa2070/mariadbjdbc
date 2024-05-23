import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx09 {

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
			
			String sql = "select * from emp";
			rs = stmt.executeQuery( sql );
			
			// 커서의 이동
			// rs.next()
			// rs.absolute(행번호)
			// rs.beforeFirst() - 커서 위치를 초기화
			// rs.first() / rs.last()
			// rs.previous()
			
			rs.absolute(1);
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));
			
			rs.absolute(10);
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));
			
			rs.previous();
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));
			
			rs.next();
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));
			
			rs.last();
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));
			
			// 데이터의 갯수
			// select count(*) from 테이블명
			System.out.println(rs.getRow());
			
			// 커서 초기화
			rs.beforeFirst();
			rs.next();
			System.out.printf("%s\t%s%n", rs.getString("empno"), rs.getString("ename"));

			
			
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




