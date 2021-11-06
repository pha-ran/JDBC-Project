package jdbc_2021_team_project;

import java.awt.EventQueue;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private JPanel npanel;
	private Box nverticalBox;
	private JPanel npanel_1;
	String[] comboName = {"전체", "부서", "성별", "연봉", "생일", "부하직원"};
	JComboBox combo;
	private JPanel npanel_2;
	private JLabel rangeLabel;
	private JLabel attLabel;
	private JCheckBox NameCheckBox;
	private JCheckBox SsnCheckBox;
	private JCheckBox BdateCheckBox;
	private JCheckBox AddressCheckBox;
	private JCheckBox SexCheckBox;
	private JCheckBox SalaryCheckBox;
	private JCheckBox SupervisorCheckBox;
	private JCheckBox DepartmentCheckBox;
	Object[][] data = new Object[][] {{false, null, null, null, null, null, null, null, null}};
	String[] columnNames = new String[] { "선택", "NAME", "SSN", "BDATE", "ADDRESS", "SEX", "SALARY", "SUPERVISOR", "DEPARTMENT" };
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	DefaultTableCellRenderer dcr;
	JCheckBox cellBox;
	private Box sverticalBox;
	private JPanel spanel_1;
	private JPanel spanel_2;
	private JLabel selectedLabel;
	private JLabel countLabel;
	private JButton SearchButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 생성자, 이벤트 설정
	public Main() {
		initialize();
	}

	// 화면 구성
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		npanel = new JPanel();
		frame.getContentPane().add(npanel, BorderLayout.NORTH);
		
		nverticalBox = Box.createVerticalBox();
		npanel.add(nverticalBox);
		
		npanel_1 = new JPanel();
		nverticalBox.add(npanel_1);
		
		rangeLabel = new JLabel("검색 범위");
		npanel_1.add(rangeLabel);
		
		combo = new JComboBox(comboName);
		npanel_1.add(combo);
		
		npanel_2 = new JPanel();
		nverticalBox.add(npanel_2);
		
		attLabel = new JLabel("검색 항목");
		npanel_2.add(attLabel);
		
		NameCheckBox = new JCheckBox("Name");
		NameCheckBox.setSelected(true);
		npanel_2.add(NameCheckBox);
		
		SsnCheckBox = new JCheckBox("Ssn");
		SsnCheckBox.setSelected(true);
		npanel_2.add(SsnCheckBox);
		
		BdateCheckBox = new JCheckBox("Bdate");
		BdateCheckBox.setSelected(true);
		npanel_2.add(BdateCheckBox);
		
		AddressCheckBox = new JCheckBox("Address");
		AddressCheckBox.setSelected(true);
		npanel_2.add(AddressCheckBox);
		
		SexCheckBox = new JCheckBox("Sex");
		SexCheckBox.setSelected(true);
		npanel_2.add(SexCheckBox);
		
		SalaryCheckBox = new JCheckBox("Salary");
		SalaryCheckBox.setSelected(true);
		npanel_2.add(SalaryCheckBox);
		
		SupervisorCheckBox = new JCheckBox("Supervisor");
		SupervisorCheckBox.setSelected(true);
		npanel_2.add(SupervisorCheckBox);
		
		DepartmentCheckBox = new JCheckBox("Department");
		DepartmentCheckBox.setSelected(true);
		npanel_2.add(DepartmentCheckBox);
		
		SearchButton = new JButton("검색");
		npanel_2.add(SearchButton);
		
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		dcr = new DefaultTableCellRenderer(){
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				JCheckBox box= new JCheckBox();
				box.setSelected(((Boolean)value).booleanValue());  
				box.setHorizontalAlignment(JLabel.CENTER);
				return box;
			}};
		table.getColumn("선택").setCellRenderer(dcr);
		cellBox = new JCheckBox();
		table.getColumn("선택").setCellEditor(new DefaultCellEditor(cellBox));
		scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		Q1 q1 = new Q1();
		q1.ShowEmployee(model);
		
		JPanel spanel = new JPanel();
		frame.getContentPane().add(spanel, BorderLayout.SOUTH);
		
		sverticalBox = Box.createVerticalBox();
		spanel.add(sverticalBox);
		
		spanel_1 = new JPanel();
		sverticalBox.add(spanel_1);
		
		selectedLabel = new JLabel("선택한 직원 : ");
		spanel_1.add(selectedLabel);
		
		spanel_2 = new JPanel();
		sverticalBox.add(spanel_2);
		
		countLabel = new JLabel("인원수 : ");
		spanel_2.add(countLabel);
	}
}
