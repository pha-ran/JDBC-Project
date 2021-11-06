package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Q2 {
	static String baseQuery = "SELECT * "
			+ "FROM (EMPLOYEE AS E LEFT OUTER JOIN EMPLOYEE AS S ON E.Super_ssn = S.Ssn) JOIN DEPARTMENT ON E.Dno = Dnumber ";
	
	public void ShowEmployeeDpart(DefaultTableModel model, String s) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			String query = baseQuery + "WHERE Dname = ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs, model);
			
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
	
	public void ShowEmployeeSex(Connection con, String s) {
		try {
			String query = baseQuery + "WHERE E.Sex = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			//printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public void ShowEmployeeSal(Connection con, int i) {
		try {
			String query = baseQuery + "WHERE E.Salary > ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, i);
			
			ResultSet rs = pstm.executeQuery();
			
			//printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public void ShowEmployeeBirth(Connection con, String i) {
		try {
			String query = baseQuery + "WHERE E.Bdate LIKE ?";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, "_____"+i+"___");
			
			ResultSet rs = pstm.executeQuery();
			
			//printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public void ShowEmployeeSuper(Connection con, String s) {
		try {
			String query = baseQuery + "WHERE E.Super_ssn = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			//printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public void printResult(ResultSet rs, DefaultTableModel model) {
		try {
			// 테이블의 기존 데이터 삭제
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			
			while (rs.next()) {
				String name = rs.getString("E.Fname") + " " + rs.getString("E.Minit") + " " + rs.getString("E.Lname");
		        String Ssn = rs.getString("E.Ssn");
		        String Bdate = rs.getString("E.Bdate");
		        String Address = rs.getString("E.Address");
		        String Sex = rs.getString("E.Sex");
		        Double Salary = rs.getDouble("E.Salary");
		        String supervisor = null;
		        if (rs.getString("S.Fname") != null && rs.getString("S.Minit") != null && rs.getString("S.Lname") != null) {
		        	supervisor = rs.getString("S.Fname") + " " + rs.getString("S.Minit") + " " + rs.getString("S.Lname");
		        }
		        String department = rs.getString("Dname");
		        
		        /*
		        System.out.println(name + "  "
		        				+ Ssn + "  "
		        				+ Bdate + "  "
		        				+ Address + "  "
		        				+ Sex + "  "
		        				+ Salary + "  "
		        				+ supervisor + "  "
		        				+ department);
		        				*/
		        
		        Object[] data = {false, name, Ssn, Bdate, Address, Sex, Salary, supervisor, department};
		        model.addRow(data);
		    }
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
}
