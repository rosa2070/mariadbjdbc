import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataEx02 {

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
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("+----------+-----------------+------+");
			System.out.println("| Field    | Type            | Null |");
			System.out.println("+----------+-----------------+------+");
			
			// 번호가 컬럼의 순서
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i);
				
				String columnType = "";
				if (rsmd.getColumnTypeName(i).equals("INTEGER")) {
					columnType = "int(" + rsmd.getPrecision(i) + ")";
				} else if (rsmd.getColumnTypeName(i).equals("DECIMAL")) {
					columnType = rsmd.getColumnTypeName(i) + "(" + rsmd.getPrecision(i) + ", "
							+ rsmd.getScale(i) + ")";
				} else if (rsmd.getColumnTypeName(i).equals("DATE")) {
					columnType = "date";
				} else {
					columnType = rsmd.getColumnTypeName(i) + "(" + rsmd.getPrecision(i) + ")";
				}
				
				String isNull = rsmd.isNullable(i) == 0 ? "NO" : "YES";
				
				System.out.printf("| %-8s | %-15s | %-4s |\n", columnName, columnType, isNull);
			}
			
			System.out.println("+----------+-----------------+------+");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		
		
	}

}
