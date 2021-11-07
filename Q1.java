package jdbc_2021_team_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Q1 {
	public void ShowEmployee(DefaultTableModel model) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			Statement stm = db.getConnection().createStatement();
			String query = "SELECT * "
						+ "FROM (EMPLOYEE AS E LEFT OUTER JOIN EMPLOYEE AS S ON E.Super_ssn = S.Ssn) JOIN DEPARTMENT ON E.Dno = Dnumber";
			ResultSet rs = stm.executeQuery(query);
			
			// ���̺��� ���� ������ ����
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
		        
		        Object[] data = {name, Ssn, Bdate, Address, Sex, Salary, supervisor, department};
		        model.addRow(data);
			}
			
			// ���� �� ����
			if (stm != null) {
				try {
					stm.close();
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
