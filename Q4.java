package jdbc_2021_team_project;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q4 {
	public void UpdateEmployee(String set, String data, String ssn) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = "UPDATE EMPLOYEE SET " + set + " = ? WHERE Ssn = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, data);
			pstm.setString(2, ssn);
			
			pstm.executeUpdate();
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			db.DisConnect(); // ���� ����
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
}
