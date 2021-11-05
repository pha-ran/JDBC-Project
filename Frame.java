package jdbc_2021_team_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frame {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;

	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
					
					DBConnector db = new DBConnector();
					db.Connect();
					
					Q1 q1 = new Q1();
					q1.ShowEmployee(db.getConnection(), model);
					
					db.DisConnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel npanel = new JPanel();
		frame.getContentPane().add(npanel, BorderLayout.NORTH);
		
		Object[][] data = new Object[][] {
			{null, null, null, null, null, null, null, null}
		};
		String[] columnNames = new String[] { "NAME", "SSN", "BDATE", "ADDRESS", "SEX", "SALARY", "SUPERVISOR", "DEPARTMENT" };
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel spanel = new JPanel();
		frame.getContentPane().add(spanel, BorderLayout.SOUTH);
	}

}
