package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q3 {
	public static void DeleteEmployee(Connection con, String ssn) {
		try {
			String query = "DELETE FROM EMPLOYEE WHERE Ssn=?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, ssn);
			
			pstm.executeUpdate();
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
}
