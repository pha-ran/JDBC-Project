package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q5 {
	public static void InsertEmployee(Connection con, String F, String M, String L, String Ssn, String B,
														String A, String Sex, String Sal, String Sup_ssn, String Dno) {
		try {
			String query = "INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, F);
			pstm.setString(2, M);
			pstm.setString(3, L);
			pstm.setString(4, Ssn);
			pstm.setString(5, B);
			pstm.setString(6, A);
			pstm.setString(7, Sex);
			pstm.setString(8, Sal);
			pstm.setString(9, Sup_ssn);
			pstm.setString(10, Dno);
			
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
