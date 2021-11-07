package jdbc_2021_team_project;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JPanel npanel;
	private Box nverticalBox;
	private JPanel npanel_1;
	private String[] rangeComboName = {"��ü", "�μ�", "����", "����", "����", "��������"};
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
	private String[] columnNames = new String[] { "NAME", "SSN", "BDATE", "ADDRESS", "SEX", "SALARY", "SUPERVISOR", "DEPARTMENT" };
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private Vector<String> ssnVec;
	private Box sverticalBox;
	private JPanel spanel_1;
	private JPanel spanel_2;
	private JLabel selectedLabel;
	private JLabel countLabel;
	private JButton searchButton;
	private Vector<Object> selectedColumn = new Vector<Object>();
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

	// ������ - ȭ�� ���� �� �ʱ� ����
	public Main() {
		initialize();
		
		rangeCombo.setSelectedIndex(0); // ����� ��ü ���� (default)
	}

	// ȭ�� ����
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 672);
		frame.setLocationRelativeTo(null); // ȭ�� ����� ��ġ
		frame.setResizable(false); // â ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		npanel = new JPanel();
		frame.getContentPane().add(npanel, BorderLayout.NORTH);
		
		nverticalBox = Box.createVerticalBox();
		npanel.add(nverticalBox);
		
		npanel_1 = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		nverticalBox.add(npanel_1);
		
		rangeLabel = new JLabel("�˻� ����");
		npanel_1.add(rangeLabel);
		
		// �˻� ���� �޺��ڽ� ����
		rangeCombo = new JComboBox(rangeComboName);
		rangeCombo.addActionListener(new ActionListener() {
			@Override // �˻� ���� ����
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				
				// ��ü VIsible
				departmentCombo.setVisible(true);
				sexCombo.setVisible(true);
				salaryTextField.setVisible(true);
				bdateCombo.setVisible(true);
				juniorTextField.setVisible(true);
				
				switch (index) {
				case 0:	// ��ü ����
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					break;
					
				case 1: // �μ� ����
					departmentCombo.setVisible(true);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					departmentCombo.setSelectedIndex(0);
					break;
					
				case 2: // ���� ����
					departmentCombo.setVisible(false);
					sexCombo.setVisible(true);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					sexCombo.setSelectedIndex(0);
					break;
					
				case 3: // ���� ����
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(true);
					bdateCombo.setVisible(false);
					juniorTextField.setVisible(false);
					
					salaryTextField.setText("0");
					break;
					
				case 4: // ���� ����
					departmentCombo.setVisible(false);
					sexCombo.setVisible(false);
					salaryTextField.setVisible(false);
					bdateCombo.setVisible(true);
					juniorTextField.setVisible(false);
					
					bdateCombo.setSelectedIndex(0);
					break;
					
				case 5: // �������� ����
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
		
		attLabel = new JLabel("�˻� �׸�");
		npanel_2.add(attLabel);
		
		// üũ�ڽ� ���� (����� �⺻���� true)
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
		// üũ�ڽ� ���� �Ϸ�
		
		// �˻� ��ư ����
		searchButton = new JButton("�˻�");
		searchButton.addActionListener(new ActionListener() {
			@Override	// �˻� ��ư�� ���� ���
			public void actionPerformed(ActionEvent e) {
				selectedColumn.clear(); // �� �̸� ���� �ʱ�ȭ
				
				// �� üũ Ȯ�� (üũ�� �� �ε��� true)
				boolean[] isSelected = new boolean[]{
						nameCheckBox.isSelected(),
						ssnCheckBox.isSelected(),
						bdateCheckBox.isSelected(),
						addressCheckBox.isSelected(),
						sexCheckBox.isSelected(),
						salaryCheckBox.isSelected(),
						supervisorCheckBox.isSelected(),
						departmentCheckBox.isSelected()};
				
				for (int i = 0; i < 8; i++) {
					if (isSelected[i]) {	// �� �̸� �迭���� ������ ���� ���Ϳ� �߰�
						selectedColumn.add(columnNames[i]);
					}
				}
				
				model.setColumnIdentifiers(selectedColumn); // ������ ���� ���̺� ����
				
				int index = rangeCombo.getSelectedIndex(); // �˻� ���� ���� Ȯ��
				
				// �˻� ���� ���ÿ� ���� API ȣ��
				switch(index) {
				case 0:	// ��ü �˻�
					Q1 q1 = new Q1();
					ssnVec = q1.ShowEmployee(model, isSelected);
					break;
					
				case 1:	// �μ� �˻� (���ڷ� ������ �μ� ����)
					Q2 q2d = new Q2();
					ssnVec = q2d.ShowEmployeeDpart(model, (String) departmentCombo.getSelectedItem(), isSelected);
					break;
					
				case 2:	// ���� �˻� (���ڷ� ������ ���� ����)
					Q2 q2sex = new Q2();
					ssnVec = q2sex.ShowEmployeeSex(model, (String) sexCombo.getSelectedItem(), isSelected);
					break;
					
				case 3:	// �Է°����� ������ ���� ���� �˻� (���ڷ� �Է��� ���� ����)
					Q2 q2sal = new Q2();
					ssnVec = q2sal.ShowEmployeeSal(model, (String) salaryTextField.getText(), isSelected);
					break;
					
				case 4: // ���� �˻�
					Q2 q2b = new Q2();
					ssnVec = q2b.ShowEmployeeBirth(model, (String) bdateCombo.getSelectedItem(), isSelected);
					break;
					
				case 5:	// �Է��� �ֹι�ȣ�� ���� ������ �������� �˻� (���ڷ� �Է��� �ֹι�ȣ ����)
					Q2 q2sup = new Q2();
					ssnVec = q2sup.ShowEmployeeSuper(model, (String) juniorTextField.getText(), isSelected);
					break;
					
				default:
					break;
				}
			}
		});
		npanel_2.add(searchButton);
		
		// ���̺� ����
		model = new DefaultTableModel(null, columnNames) {
			private static final long serialVersionUID = 1L;
			// ���̺� ���� ����Ŭ�� �� ���� ����
			public boolean isCellEditable(int i, int c){
				return false;
			}};
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		// ����� ��ü ������ �˻�
		Q1 q1 = new Q1();
		boolean[] defaultColumn = new boolean[] {true, true, true, true, true, true, true, true};
		ssnVec = q1.ShowEmployee(model, defaultColumn);
		
		JPanel spanel = new JPanel();
		frame.getContentPane().add(spanel, BorderLayout.SOUTH);
		
		sverticalBox = Box.createVerticalBox();
		spanel.add(sverticalBox);
		
		// spanel_1 = new JPanel();
		// sverticalBox.add(spanel_1);
		
		// selectedLabel = new JLabel("������ ���� : ");
		// spanel_1.add(selectedLabel);
		
		spanel_2 = new JPanel();
		sverticalBox.add(spanel_2);
		
		// countLabel = new JLabel("�ο��� : ");
		// spanel_2.add(countLabel);
		
		// tempLabel = new JLabel("0");
		// spanel_2.add(tempLabel);
		
		updateLabel = new JLabel("������ ������ ���� : ");
		spanel_2.add(updateLabel);
		
		updateCombo = new JComboBox(updateComboName);
		spanel_2.add(updateCombo);
		
		textField = new JTextField();
		spanel_2.add(textField);
		textField.setColumns(10);
		
		updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			@Override	// ���õ� ������ �ε����� �ش��ϴ� ssnVec�� ���� �ֿܼ� ���
			public void actionPerformed(ActionEvent e) {
				int[] index = table.getSelectedRows();
				for (int i = 0; i < index.length; i++) {
					System.out.println(ssnVec.get(index[i]));
				}
			}
		});
		spanel_2.add(updateButton);
		
		// ������ �߰� ��ư
		addButton = new JButton("���ο� ������ �߰�");
		spanel_2.add(addButton);
		
		// ������ ���� ��ư
		deleteButton = new JButton("������ ������ ����");
		spanel_2.add(deleteButton);
	}
}
