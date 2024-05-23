import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zipcodeproject2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			String zipcode = "135-806";
			String sido = "서울";
			String gugun = "강남구";
			String dong = "개포1동";
			String ri = "우성3차아파트";
			String bunji = "(1∼6동)";
			String seq = "2";
					
			
			String insertSQL = String.format("insert into zipcode values ('%s', '%s', '%s', '%s', '%s', '%s','%s')", 
					zipcode, sido, gugun, dong, ri, bunji, seq);
			
			System.out.println(insertSQL);
			
			stmt.executeUpdate(insertSQL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
				
		

	}

}
