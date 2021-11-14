package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private Connection con = null;
	
	public void Connect() {
		// SQL 연결 시작
		try {
			String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
			String user = "root";
			String pwd = "0000";
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("연결 성공");
			
		} catch (SQLException e) {
			System.err.println("연결 실패");
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			System.err.println("드라이브 로드 실패");
			e.printStackTrace();
		}*/
	}
	
	public void DisConnect() {
		// 연결 해제
		try {
			if (con != null) {
				con.close();
				System.out.println("연결 해제");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// SQL 연결 끝
	}
	
	public Connection getConnection() {
		return con;
	}
}