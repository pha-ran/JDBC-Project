package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private Connection con = null;
	
	public void Connect() {
		// SQL ���� ����
		try {
			String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
			String user = "root";
			String pwd = "0000";
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("���� ����");
			
		} catch (SQLException e) {
			System.err.println("���� ����");
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			System.err.println("����̺� �ε� ����");
			e.printStackTrace();
		}*/
	}
	
	public void DisConnect() {
		// ���� ����
		try {
			if (con != null) {
				con.close();
				System.out.println("���� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// SQL ���� ��
	}
	
	public Connection getConnection() {
		return con;
	}
}