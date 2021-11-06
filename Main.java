package jdbc_2021_team_project;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JPanel npanel;
	private Box nverticalBox;
	private JPanel npanel_1;
	private String[] rangeComboName = {"전체", "부서", "성별", "연봉", "생일", "부하직원"};
	private JComboBox rangeCombo;
	private String[] departmentComboName = {"Headquarters", "Administration", "Research"};
	private JComboBox departmentCombo;
	private String[] sexComboName = {"M", "F"};
	private JComboBox sexCombo;
	private JTextField salaryTextField;
	private String[] bdateComboName = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private JComboBox bdateCombo;
	private JTextField juniorTextField;
	private JPanel npanel_2;
	private JLabel rangeLabel;
	private JLabel attLabel;
	private JCheckBox nameCheckBox;
	private JCheckBox ssnCheckBox;
	private JCheckBox bdateCheckBox;
	private JCheckBox addressCheckBox;
	private JCheckBox sexCheckBox;
	private JCheckBox salaryCheckBox;
	private JCheckBox supervisorCheckBox;
	private JCheckBox departmentCheckBox;
	private String[] columnNames = new String[] { "선택", "NAME", "SSN", "BDATE", "ADDRESS", "SEX", "SALARY", "SUPERVISOR", "DEPARTMENT" };
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer dcr;
	private JCheckBox cellBox;
	private Box sverticalBox;
	private JPanel spanel_1;
	private JPanel spanel_2;
	private JLabel selectedLabel;
	private JLabel countLabel;
	private JButton searchButton;
	private Vector<String> selectedColumn = new Vector<String>();
	private JLabel tempLabel;
	private JLabel updateLabel;
	private String[] updateComboName = {"Address", "Sex", "Salary"};
	private JComboBox updateCombo;
	private JTextField textField;
	private JButton updateButton;
	private JButton addButton;
	private JButton deleteButton;

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
		
		rangeCombo.setSelectedIndex(0);
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
		
		npanel_1 = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		nverticalBox.add(npanel_1);
		
		rangeLabel = new JLabel("검색 범위");
		npanel_1.add(rangeLabel);
		
		rangeCombo = new JComboBox(rangeComboName);
		rangeCombo.addActionListener(new ActionListener() {
			@Override // 검색 범위 필터
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				
				// 전체 VIsible
				departmentCombo.setVisible(true);
				sexCombo.setVisible(true);
				salaryTextField.setVisible(true);
				bdateCombo.setVisible(true);
				juniorTextField.setVisible(true);
				
				switch (index) {
				case 0:	// 전체 선택
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					break;
					
				case 1: // 부서 선택
					departmentCombo.setVisible(true);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					departmentCombo.setSelectedIndex(0);
					break;
					
				case 2: // 성별 선택
					departmentCombo.setVisible(false);
					sexCombo.setVisible(true);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					sexCombo.setSelectedIndex(0);
					break;
					
				case 3: // 연봉 선택
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(true);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					salaryTextField.setText("0");
					break;
					
				case 4: // 생일 선택
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(true);
					juniorTextField.setVisible(false);
					
					bdateCombo.setSelectedIndex(0);
					break;
					
				case 5: // 부하직원 선택
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(true);
					
					juniorTextField.setText("0");
					break;
					
				default:
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					break;
				}
			}
		});
		npanel_1.add(rangeCombo);
		
		departmentCombo = new JComboBox(departmentComboName);
		npanel_1.add(departmentCombo);
		
		sexCombo = new JComboBox(sexComboName);
		npanel_1.add(sexCombo);
		
		salaryTextField = new JTextField();
		npanel_1.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		bdateCombo = new JComboBox(bdateComboName);
		npanel_1.add(bdateCombo);
		
		juniorTextField = new JTextField();
		npanel_1.add(juniorTextField);
		juniorTextField.setColumns(10);
		
		npanel_2 = new JPanel();
		nverticalBox.add(npanel_2);
		
		attLabel = new JLabel("검색 항목");
		npanel_2.add(attLabel);
		
		nameCheckBox = new JCheckBox("Name");
		nameCheckBox.setSelected(true);
		npanel_2.add(nameCheckBox);
		
		ssnCheckBox = new JCheckBox("Ssn");
		ssnCheckBox.setSelected(true);
		npanel_2.add(ssnCheckBox);
		
		bdateCheckBox = new JCheckBox("Bdate");
		bdateCheckBox.setSelected(true);
		npanel_2.add(bdateCheckBox);
		
		addressCheckBox = new JCheckBox("Address");
		addressCheckBox.setSelected(true);
		npanel_2.add(addressCheckBox);
		
		sexCheckBox = new JCheckBox("Sex");
		sexCheckBox.setSelected(true);
		npanel_2.add(sexCheckBox);
		
		salaryCheckBox = new JCheckBox("Salary");
		salaryCheckBox.setSelected(true);
		npanel_2.add(salaryCheckBox);
		
		supervisorCheckBox = new JCheckBox("Supervisor");
		supervisorCheckBox.setSelected(true);
		npanel_2.add(supervisorCheckBox);
		
		departmentCheckBox = new JCheckBox("Department");
		departmentCheckBox.setSelected(true);
		npanel_2.add(departmentCheckBox);
		
		searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedColumn.clear(); // 열 이름 벡터 초기화
				// 열 체크 확인
				boolean[] isSelected = new boolean[]{
						true,	// 체크박스 공간은 기본 추가
						nameCheckBox.isSelected(),
						ssnCheckBox.isSelected(),
						bdateCheckBox.isSelected(),
						addressCheckBox.isSelected(),
						sexCheckBox.isSelected(),
						salaryCheckBox.isSelected(),
						supervisorCheckBox.isSelected(),
						departmentCheckBox.isSelected()};
				
				for (int i = 0; i < 9; i++) {
					if (isSelected[i]) {
						selectedColumn.add(columnNames[i]); // 선택한 열만 벡터에 추가
					}
				}
				
				model.setColumnIdentifiers(selectedColumn); // 선택한 열만 테이블에 설정
				
				int index = rangeCombo.getSelectedIndex();	// 검색 범위에 따른 API 호출
				switch(index) {
				case 0:	// 전체 검색
					Q1 q1 = new Q1();
					q1.ShowEmployee(model);
					break;
					
				case 1:	// 부서 검색
					Q2 q2d = new Q2();
					q2d.ShowEmployeeDpart(model, (String) departmentCombo.getSelectedItem(), isSelected);
					break;
					
				case 2:	// 성별 검색
					Q2 q2sex = new Q2();
					q2sex.ShowEmployeeSex(model, (String) sexCombo.getSelectedItem(), isSelected);
					break;
					
				case 3:	// 연봉 검색
					Q2 q2sal = new Q2();
					q2sal.ShowEmployeeSal(model, (String) salaryTextField.getText(), isSelected);
					break;
					
				case 4: // 생월 검색
					Q2 q2b = new Q2();
					q2b.ShowEmployeeBirth(model, (String) bdateCombo.getSelectedItem(), isSelected);
					break;
					
				case 5:	// 부하직원 검색
					Q2 q2sup = new Q2();
					q2sup.ShowEmployeeSuper(model, (String) juniorTextField.getText(), isSelected);
					break;
					
				default:
					// model.fireTableDataChanged();
					break;
				}
			}
		});
		npanel_2.add(searchButton);
		
		model = new DefaultTableModel(null, columnNames) {
			private static final long serialVersionUID = 1L;
			// 테이블 원소 더블클릭 후 수정 금지
			public boolean isCellEditable(int i, int c){
				return false;
			}};
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
		
		tempLabel = new JLabel("0");
		spanel_2.add(tempLabel);
		
		updateLabel = new JLabel("선택한 데이터 수정 : ");
		spanel_2.add(updateLabel);
		
		updateCombo = new JComboBox(updateComboName);
		spanel_2.add(updateCombo);
		
		textField = new JTextField();
		spanel_2.add(textField);
		textField.setColumns(10);
		
		updateButton = new JButton("UPDATE");
		spanel_2.add(updateButton);
		
		addButton = new JButton("새로운 데이터 추가");
		spanel_2.add(addButton);
		
		deleteButton = new JButton("선택한 데이터 삭제");
		spanel_2.add(deleteButton);
	}
	
	/*
	private class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		private static final long serialVersionUID = 1L;

		public TableCell() {
			cellBox = new JCheckBox();
			
			cellBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(table.getValueAt(table.getSelectedRow(), 1));
				}
			});
		}
		
		@Override
		public Object getCellEditorValue() {
			return cellBox;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			cellBox.setSelected(((Boolean)value).booleanValue());
			cellBox.setHorizontalAlignment(JLabel.CENTER);
			return cellBox;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			return cellBox;
		}
	}
	*/
}
