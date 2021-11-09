package jdbc_2021_team_project;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q4 {
	public void UpdateEmployee(String set, String data, String ssn) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "UPDATE EMPLOYEE SET " + set + " = ? WHERE Ssn = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, data);
			pstm.setString(2, ssn);
			
			pstm.executeUpdate();
			
			// 수행 후 해제
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			db.DisConnect(); // 연결 해제
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
}
