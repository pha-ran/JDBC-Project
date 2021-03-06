package jdbc_2021_team_project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q5 {
	public void InsertEmployee(String F, String M, String L, String Ssn, String B,
										String A, String Sex, String Sal, String Sup_ssn, String Dno) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
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
			
			db.DisConnect(); // 연결 해제
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public int isExistSsn(String ssn) {
		int exist = -1;
		
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "SELECT COUNT(*) AS C FROM EMPLOYEE WHERE Ssn = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
			ResultSet rs = pstm.executeQuery();
			rs.next();
			exist = rs.getInt("C");
			
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

		return exist;
	}
	
	public int isExistDnumber(String dnumber) {
		int exist = -1;
		
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "SELECT COUNT(*) AS C FROM DEPARTMENT WHERE Dnumber = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, dnumber);
			
			ResultSet rs = pstm.executeQuery();
			rs.next();
			exist = rs.getInt("C");
			
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

		return exist;
	}
}
