package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q4 {
	public static void UpdateEmployee(Connection con, String A, String Sex, String Sal, String Ssn) {
		try {
			String query = "UPDATE EMPLOYEE SET Address = ?, Sex = ?, Salary = ? WHERE Ssn = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, A);
			pstm.setString(2, Sex);
			pstm.setString(3, Sal);
			pstm.setString(4, Ssn);
			
			pstm.executeUpdate();
			
			// 수행 후 해제
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
}
