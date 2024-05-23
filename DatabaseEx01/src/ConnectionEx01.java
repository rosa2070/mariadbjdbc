
public class ConnectionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( "시작" );
		
		try {
			// 데이터베이스 연결을 위한 데이터베이스 드라이버 로딩
			Class.forName( "org.mariadb.jdbc.Driver" );
			System.out.println( "드라이버 로딩 성공" );
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] 드라이버 로딩 실패" );
			e.printStackTrace();
		}
		
		System.out.println( "끝" );
	}

}
