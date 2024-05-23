import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeSearchEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select * from zipcode";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if (rs.getString("dong").startsWith(args[0])) {
					System.out.printf("[%s] %s %s %s %s %s%n", 
							rs.getString("zipcode"), 
							rs.getString("sido"),
							rs.getString("gugun"),
							rs.getString("dong"),
							rs.getString("ri"),
							rs.getString("bunji"));
				}
			

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
