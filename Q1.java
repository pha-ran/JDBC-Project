package jdbc_2021_team_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Q1 {
	public Vector<String> ShowEmployee(DefaultTableModel model, boolean[] isSelected) {
		try {
			DBConnector db = new DBConnector();
			db.Connect(); // 연결 시도
			
			Statement stm = db.getConnection().createStatement();
			String query = "SELECT * "
						+ "FROM (EMPLOYEE AS E LEFT OUTER JOIN EMPLOYEE AS S ON E.Super_ssn = S.Ssn) JOIN DEPARTMENT ON E.Dno = Dnumber";
			ResultSet rs = stm.executeQuery(query);
			
			// 테이블의 기존 데이터 삭제
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			
			Vector<String> ssnVec = new Vector<String>();
			
			// 결과를 변수와 매칭 (ToDo F L 이름이랑 주민번호, Dno는 Not Null)
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
		        
		        Object[] dataList = {name, Ssn, Bdate, Address, Sex, Salary, supervisor, department}; // 전체 데이터의 배열
		        Vector<Object> data = new Vector<Object>();
		        for (int i = 0; i < 8; i++) {
		        	if (isSelected[i]) {
		        		data.add(dataList[i]); // 선택된 열의 값만 최종 데이터 벡터에 추가
		        	}
		        }
		        
		        model.addRow(data); // 테이블에 행 추가
		        ssnVec.add(Ssn); // 리턴할 Ssn 벡터에 검색된 행의 Ssn 추가
			}
			
			// 수행 후 해제
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			db.DisConnect(); // 연결 해제
			
			return ssnVec; // 쿼리 종료 후 Ssn 벡터 리턴
			
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		
		return null;
	}
}
