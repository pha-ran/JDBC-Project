package jdbc_2021_team_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q2 {
	static String baseQuery = "SELECT * "
			+ "FROM (EMPLOYEE AS E LEFT OUTER JOIN EMPLOYEE AS S ON E.Super_ssn = S.Ssn) JOIN DEPARTMENT ON E.Dno = Dnumber ";
	
	public static void ShowEmployeeAll(Connection con) {
		Q1.ShowEmployee(con);
	}
	
	public static void ShowEmployeeDpart(Connection con, String s) {
		try {
			String query = baseQuery + "WHERE Dname = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public static void ShowEmployeeSex(Connection con, String s) {
		try {
			String query = baseQuery + "WHERE E.Sex = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public static void ShowEmployeeSal(Connection con, int i) {
		try {
			String query = baseQuery + "WHERE E.Salary > ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, i);
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public static void ShowEmployeeBirth(Connection con, String i) {
		try {
			String query = baseQuery + "WHERE E.Bdate LIKE ?";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, "_____"+i+"___");
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public static void ShowEmployeeSuper(Connection con, String s) {
		try {
			String query = baseQuery + "WHERE E.Super_ssn = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			printResult(rs);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
	public static void printResult(ResultSet rs) {
		try {
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
		        
		        System.out.println(name + "  "
		        				+ Ssn + "  "
		        				+ Bdate + "  "
		        				+ Address + "  "
		        				+ Sex + "  "
		        				+ Salary + "  "
		        				+ supervisor + "  "
		        				+ department);
		    }
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
}
