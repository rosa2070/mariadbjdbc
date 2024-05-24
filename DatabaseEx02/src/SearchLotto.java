//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//
//public class SearchLotto {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		String url = "jdbc:mariadb://localhost:3306/project";
//		String user = "project";
//		String password = "123456";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		Class.forName("org.mariadb.jdbc.Driver");
//		conn = DriverManager.getConnection(url, user, password);
//		
//		String sql = "insert into lottotbl values (" 
//		Workbook workBook = null;
//		
//		workBook = workBook.getWorkbook(new FileInputStream("./lotto(1119).xls"));
//		
//		Sheet sheet = workBook.getSheet(0);
//		
//		for(int row=4; row<=sheet.getRows(); row++) {
//            // 각 셀의 데이터를 가져옴
//			Cell seq = sheet.getCell(2-1, row-1); // 회차
//			Cell n1 = sheet.getCell(14-1, row-1);
//			Cell n2 = sheet.getCell(15-1, row-1);
//			Cell n3 = sheet.getCell(16-1, row-1);
//			Cell n4 = sheet.getCell(17-1, row-1);
//			Cell n5 = sheet.getCell(18-1, row-1);
//			Cell n6 = sheet.getCell(19-1, row-1);
//			Cell wdate = sheet.getCell(3-1, row-1); // 추첨일
//
//		
//		}
//
//	}
//
//}
