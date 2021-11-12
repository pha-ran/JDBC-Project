package jdbc_2021_team_project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Q2 {
	static String baseQuery = "SELECT * "
			+ "FROM (EMPLOYEE AS E LEFT OUTER JOIN EMPLOYEE AS S ON E.Super_ssn = S.Ssn) JOIN DEPARTMENT ON E.Dno = Dnumber ";
	
	public Vector<String> ShowEmployeeDpart(DefaultTableModel model, String s, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = baseQuery + "WHERE Dname = ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			Vector<String> ssnVec = printResult(rs, model, isSelected);
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			db.DisConnect(); // ���� ����

			return ssnVec;
				
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<String> ShowEmployeeSex(DefaultTableModel model, String s, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = baseQuery + "WHERE E.Sex = ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			Vector<String> ssnVec = printResult(rs, model, isSelected);
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
						
			db.DisConnect(); // ���� ����

			return ssnVec;
				
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<String> ShowEmployeeSal(DefaultTableModel model, String s, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = baseQuery + "WHERE E.Salary > ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			Vector<String> ssnVec = printResult(rs, model, isSelected);
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
									
			db.DisConnect(); // ���� ����

			return ssnVec;
				
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<String> ShowEmployeeBirth(DefaultTableModel model, String s, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = baseQuery + "WHERE E.Bdate LIKE ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			
			pstm.setString(1, "_____"+s+"___");
			
			ResultSet rs = pstm.executeQuery();
			
			Vector<String> ssnVec = printResult(rs, model, isSelected);
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
									
			db.DisConnect(); // ���� ����
			
			return ssnVec;
			
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<String> ShowEmployeeSuper(DefaultTableModel model, String s, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // ���� �õ�
			
			String query = baseQuery + "WHERE E.Super_ssn = ?";
			PreparedStatement pstm = db.getConnection().prepareStatement(query);
			pstm.setString(1, s);
			
			ResultSet rs = pstm.executeQuery();
			
			Vector<String> ssnVec = printResult(rs, model, isSelected);
			
			// ���� �� ����
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
									
			db.DisConnect(); // ���� ����
			
			return ssnVec;
					
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<String> printResult(ResultSet rs, DefaultTableModel model, boolean[] isSelected) {
		try {
			// ���̺��� ���� ������ ����
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			
			Vector<String> ssnVec = new Vector<String>();
			
			// ����� ������ ��Ī
			while (rs.next()) {
				String name;
		        if (rs.getString("E.Minit") != null) {
		        	name = rs.getString("E.Fname") + " " + rs.getString("E.Minit") + " " + rs.getString("E.Lname");
		        }
		        else {
		        	name = rs.getString("E.Fname") + " " + rs.getString("E.Lname");
		        }
		        String Ssn = rs.getString("E.Ssn");
		        String Bdate = rs.getString("E.Bdate");
		        String Address = rs.getString("E.Address");
		        String Sex = rs.getString("E.Sex");
		        String Salary = rs.getString("E.Salary");
		        String supervisor = null;
		        if (rs.getString("E.Super_ssn") != null) {
		        	if (rs.getString("S.Minit") != null) {
		        		supervisor = rs.getString("S.Fname") + " " + rs.getString("S.Minit") + " " + rs.getString("S.Lname");
		        	}
		        	else {
		        		supervisor = rs.getString("S.Fname") + " " + rs.getString("S.Lname");
		        	}
		        }
		        String department = rs.getString("Dname");
		        
		        Object[] dataList = {name, Ssn, Bdate, Address, Sex, Salary, supervisor, department}; // ��ü �������� �迭
		        Vector<Object> data = new Vector<Object>();
		        for (int i = 0; i < 8; i++) {
		        	if (isSelected[i]) {
		        		data.add(dataList[i]); // ���õ� ���� ���� ���� ������ ���Ϳ� �߰�
		        	}
		        }
		        
		        model.addRow(data); // ���̺� �� �߰�
		        ssnVec.add(Ssn); // ������ Ssn ���Ϳ� �˻��� ���� Ssn �߰�
		    }
			
			return ssnVec; // ���� ���� �� Ssn ���� ����
			
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return null;
	}
}
