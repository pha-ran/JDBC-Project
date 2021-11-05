package jdbc_2021_team_project;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					
					// SQL 연결 시작
					Connection con = null;
					try {
						String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
						String user = "root";
						String pwd = "0000";
						
						con = DriverManager.getConnection(url, user, pwd);
						System.out.println("연결 성공");
						
						// 1. 전체 직원을 출력
						 Q1.ShowEmployee(con);
						
						// 2. 검색 범위, 검색 항목 필터 적용 직원 검색
						// Q2.ShowEmployeeAll(con);
						// Q2.ShowEmployeeDpart(con, "Administration");
						// Q2.ShowEmployeeSex(con, "M");
						// Q2.ShowEmployeeSal(con, 39000);
						// Q2.ShowEmployeeBirth(con, "11");
						// Q2.ShowEmployeeSuper(con, "888665555");
						
						// 3. 선택한 직원 삭제
						// Q3.DeleteEmployee(con, "11111111");
						
						// 4. 선택한 직원 수정
						// Q4.UpdateEmployee(con, "978dhjbdfsj", "M", "99999", "11111111");
						
						// 5. 새로운 직원 추가
						// Q5.InsertEmployee(con, "aaa", "B", "ccc", "11111111", "1919-11-22", "456 sadf", "F", "45678", null, "1");
						
					} catch (SQLException e) {
						System.err.println("연결 실패");
						e.printStackTrace();
					} /*catch (ClassNotFoundException e) {
						System.err.println("드라이브 로드 실패");
						e.printStackTrace();
					}*/
					
					// 연결 해제
					try {
						if (con != null) {
							con.close();
							System.out.println("연결 해제");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}// SQL 연결 끝
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
