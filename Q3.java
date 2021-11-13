package jdbc_2021_team_project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q3 {
	public void DeleteEmployee(String ssn) {
		try {
			DeleteWorksOn(ssn);
			DeleteDependent(ssn);
			
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "DELETE FROM EMPLOYEE WHERE Ssn=?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
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
	
	public void DeleteWorksOn(String ssn) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "DELETE FROM WORKS_ON WHERE Essn=?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
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
	
	public void DeleteDependent (String ssn) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "DELETE FROM DEPENDENT WHERE Essn=?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
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
	
	public int isManager (String ssn) {
		int m = -1;
		
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "SELECT COUNT(*) AS C FROM DEPARTMENT WHERE Mgr_ssn = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
			ResultSet rs = pstm.executeQuery();
			rs.next();
			m = rs.getInt("C");
			
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

		return m;
	}
	
	public int isSuper (String ssn) {
		int s = -1;
		
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = "SELECT COUNT(*) AS C FROM EMPLOYEE WHERE Super_ssn = ?";
			
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, ssn);
			
			ResultSet rs = pstm.executeQuery();
			rs.next();
			s = rs.getInt("C");
			
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

		return s;
	}
}
