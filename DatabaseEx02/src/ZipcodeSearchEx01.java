import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeSearchEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 입력값 검사
		if (args.length != 1) {
			// 비정상 입력
			System.out.println("[실행방법] java ZipcodeSearchEx 동이름");
			System.exit(0);
		}
		// 정상 입력
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
//			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like '" + args[0] + "%'";
			String sql = String.format("select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like '%s%%'", args[0]);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				String result = String.format("[%s] %s %s %s %s %s", 
						zipcode, sido, gugun, dong, ri, bunji);
				System.out.println(result);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}

	}

}
