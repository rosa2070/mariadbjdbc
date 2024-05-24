import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadLottomy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Workbook workBook = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into lottotbl values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			workBook = Workbook.getWorkbook( new FileInputStream( "./lotto(1119).xls" ) );
			
			Sheet sheet = workBook.getSheet( 0 );
			
			for( int row=sheet.getRows() ; row>=4 ; row-- ) {
				Cell turn = sheet.getCell( 2-1, row-1 );
				Cell num1 = sheet.getCell( 14-1, row-1 );
				Cell num2 = sheet.getCell( 15-1, row-1 );
				Cell num3 = sheet.getCell( 16-1, row-1 );
				Cell num4 = sheet.getCell( 17-1, row-1 );
				Cell num5 = sheet.getCell( 18-1, row-1 );
				Cell num6 = sheet.getCell( 19-1, row-1 );
				Cell num7 = sheet.getCell( 20-1, row-1 );
				Cell wdate = sheet.getCell( 3-1, row-1 );
				
				System.out.printf( "%2s회 %2s %2s %2s %2s %2s %2s %2s %s\n",
					turn.getContents(), num1.getContents(), num2.getContents(), num3.getContents(),
					num4.getContents(), num5.getContents(), num6.getContents(), num6.getContents(), wdate.getContents() );
				
				pstmt.setLong(1, turn);
				pstmt.setString(2, num1);
				pstmt.setString(3, num2);
				pstmt.setString(4, num3);
				pstmt.setString(5, num4);
				pstmt.setString(6, num5);
				pstmt.setString(7, num6);
				pstmt.setString(8, num7);
				pstmt.setString(9, wdate);
				
				pstmt.executeUpdate();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
