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
					
					// SQL ���� ����
					Connection con = null;
					try {
						String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
						String user = "root";
						String pwd = "0000";
						
						con = DriverManager.getConnection(url, user, pwd);
						System.out.println("���� ����");
						
						// 1. ��ü ������ ���
						 Q1.ShowEmployee(con);
						
						// 2. �˻� ����, �˻� �׸� ���� ���� ���� �˻�
						// Q2.ShowEmployeeAll(con);
						// Q2.ShowEmployeeDpart(con, "Administration");
						// Q2.ShowEmployeeSex(con, "M");
						// Q2.ShowEmployeeSal(con, 39000);
						// Q2.ShowEmployeeBirth(con, "11");
						// Q2.ShowEmployeeSuper(con, "888665555");
						
						// 3. ������ ���� ����
						// Q3.DeleteEmployee(con, "11111111");
						
						// 4. ������ ���� ����
						// Q4.UpdateEmployee(con, "978dhjbdfsj", "M", "99999", "11111111");
						
						// 5. ���ο� ���� �߰�
						// Q5.InsertEmployee(con, "aaa", "B", "ccc", "11111111", "1919-11-22", "456 sadf", "F", "45678", null, "1");
						
					} catch (SQLException e) {
						System.err.println("���� ����");
						e.printStackTrace();
					} /*catch (ClassNotFoundException e) {
						System.err.println("����̺� �ε� ����");
						e.printStackTrace();
					}*/
					
					// ���� ����
					try {
						if (con != null) {
							con.close();
							System.out.println("���� ����");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}// SQL ���� ��
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
