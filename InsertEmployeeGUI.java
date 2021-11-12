package jdbc_2021_team_project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class InsertEmployeeGUI {

	public JFrame insertFrame;
	private JTextField fNameTextField;
	private JTextField mNameTextField;
	private JTextField lNameTextField;
	private JTextField ssnTextField;
	private JTextField bDateTextField;
	private JTextField addressTextField;
	private String[] sexComboName = {"M", "F"};
	private JComboBox sexCombo;
	private JTextField salaryTextField;
	private JTextField superSsnTextField;
	private JTextField dnoTextField;
	
	public InsertEmployeeGUI() {
		initialize();
		
		sexCombo.setSelectedIndex(0); // ����� ���� �⺻ M ����
	}

	private void initialize() {
		insertFrame = new JFrame("���ο� ���� ���� �߰� (*�ʼ�)");
		insertFrame.setBounds(100, 100, 360, 480);
		insertFrame.setLocationRelativeTo(null); // ȭ�� ����� ��ġ
		insertFrame.setResizable(false); // â ũ�� ����
		
		Box verticalBox = Box.createVerticalBox();
		insertFrame.getContentPane().add(verticalBox, BorderLayout.NORTH);
		
		//
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		
		JLabel fNameLabel = new JLabel("First Name (*) : ");
		panel.add(fNameLabel);
		
		fNameTextField = new JTextField();
		panel.add(fNameTextField);
		fNameTextField.setColumns(10);
		
		//
		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);
		
		JLabel mNameLabel = new JLabel("Middle Init. : ");
		panel_1.add(mNameLabel);
		
		mNameTextField = new JTextField();
		panel_1.add(mNameTextField);
		mNameTextField.setColumns(10);
		
		//
		JPanel panel_2 = new JPanel();
		verticalBox.add(panel_2);
		
		JLabel lNameLabel = new JLabel("Last Name (*) : ");
		panel_2.add(lNameLabel);
		
		lNameTextField = new JTextField();
		panel_2.add(lNameTextField);
		lNameTextField.setColumns(10);
		
		//
		JPanel panel_3 = new JPanel();
		verticalBox.add(panel_3);
		
		JLabel ssnLabel = new JLabel("Ssn (*) : ");
		panel_3.add(ssnLabel);
		
		ssnTextField = new JTextField();
		panel_3.add(ssnTextField);
		ssnTextField.setColumns(10);
		
		//
		JPanel panel_4 = new JPanel();
		verticalBox.add(panel_4);
		
		JLabel bDateLabel = new JLabel("Birthdate : ");
		panel_4.add(bDateLabel);
		
		bDateTextField = new JTextField();
		panel_4.add(bDateTextField);
		bDateTextField.setColumns(10);
		
		//
		JPanel panel_5 = new JPanel();
		verticalBox.add(panel_5);
		
		JLabel addressLabel = new JLabel("Address : ");
		panel_5.add(addressLabel);
		
		addressTextField = new JTextField();
		panel_5.add(addressTextField);
		addressTextField.setColumns(10);
		
		//
		JPanel panel_6 = new JPanel();
		verticalBox.add(panel_6);
		
		JLabel sexLabel = new JLabel("Sex : ");
		panel_6.add(sexLabel);
		
		sexCombo = new JComboBox(sexComboName);
		panel_6.add(sexCombo);
		
		//
		JPanel panel_7 = new JPanel();
		verticalBox.add(panel_7);
		
		JLabel salaryLabel = new JLabel("Salary : ");
		panel_7.add(salaryLabel);
		
		salaryTextField = new JTextField();
		panel_7.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		//
		JPanel panel_8 = new JPanel();
		verticalBox.add(panel_8);
		
		JLabel superSsnLabel = new JLabel("Super_ssn : ");
		panel_8.add(superSsnLabel);
		
		superSsnTextField = new JTextField();
		panel_8.add(superSsnTextField);
		superSsnTextField.setColumns(10);
		
		//
		JPanel panel_9 = new JPanel();
		verticalBox.add(panel_9);
		
		JLabel dnoLabel = new JLabel("Dno (*) : ");
		panel_9.add(dnoLabel);
		
		dnoTextField = new JTextField();
		panel_9.add(dnoTextField);
		dnoTextField.setColumns(10);
		
		//
		JPanel panel_10 = new JPanel();
		verticalBox.add(panel_10);
		
		JButton addButton = new JButton("�߰��ϱ�");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fName = fNameTextField.getText();	// Fname VARCHAR(15) NOT NULL
				if (Pattern.matches("^[a-zA-Z]{1,15}$", fName) != true) {
					JOptionPane.showMessageDialog(null, "First Name�� ������ 1~15���ڷ� �Է����ּ���.");
					return;
				}
				
				String mName = mNameTextField.getText();	// Minit CHAR
				if (Pattern.matches("^[a-zA-Z]{0,1}$", mName) != true) {
					JOptionPane.showMessageDialog(null, "Middle init�� ������ 0~1���ڷ� �Է����ּ���.");
					return;
				}
				if (mName.equals("")) {
					mName = null;
				}
				
				String lName = lNameTextField.getText();	// Lname VARCHAR(15) NOT NULL
				if (Pattern.matches("^[a-zA-Z]{1,15}$", lName) != true) {
					JOptionPane.showMessageDialog(null, "Last Name�� ������ 1~15���ڷ� �Է����ּ���.");
					return;
				}
				
				Q5 q5 = new Q5();
				
				String ssn = ssnTextField.getText();	// Ssn CHAR(9) NOT NULL PRIMARY KEY (Ssn)
				if (Pattern.matches("^[0-9]{9}$", ssn) != true) {
					JOptionPane.showMessageDialog(null, "Ssn�� ���� 9�ڸ��� �Է����ּ���.");
					return;
				}
				if (q5.isExistSsn(ssn) > 0) {
					JOptionPane.showMessageDialog(null, "Ssn�� �ߺ��˴ϴ�.");
					return;
				}
				
				String bDate = bDateTextField.getText();	// Bdate DATE nls_date_format='YYYY-MM-DD'
				if (Pattern.matches("^((19[0-9]{2})|(20([01][0-9]|20)))\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", bDate) != true) {
					if (bDate.equals("")) {
						bDate = null;
					}
					else {
						JOptionPane.showMessageDialog(null, "Birthdate�� yyyy-mm-dd ���� 1900~2020�� ���̷� �Է����ּ���.");
						return;
					}
				}
				
				String address = addressTextField.getText();	// Address VARCHAR(30)
				if (Pattern.matches("^.{0,30}$", address) != true) {
					JOptionPane.showMessageDialog(null, "Address�� 0~30���ڷ� �Է����ּ���.");
					return;
				}
				if (address.equals("")) {
					address = null;
				}
				
				String sex = (String) sexCombo.getSelectedItem(); 	// Sex CHAR
				
				String salary = salaryTextField.getText();	// Salary DECIMAL(10,2)
				if (Pattern.matches("^[0-9]{1,10}(\\.[0-9]{1,2})?$", salary) != true) {
					if (salary.equals("")) {
						salary = null;
					}
					else {
						JOptionPane.showMessageDialog(null, "Salary�� ���� 10�ڸ� ����, �Ҽ����� 0~2�ڸ��� �Է����ּ���.");
						return;
					}
				}
				
				String superSsn = superSsnTextField.getText();	// Super_ssn CHAR(9) FOREIGN KEY (Super_ssn) REFERENCES EMPLOYEE (Ssn)
				if (Pattern.matches("^[0-9]{9}$", superSsn) != true) {
					if (superSsn.equals("")) {
						superSsn = null;
					}
					else {
						JOptionPane.showMessageDialog(null, "Super_ssn�� ���� 9�ڸ��� �Է����ּ���.");
						return;
					}
				}
				if (superSsn != null) {
					if (q5.isExistSsn(superSsn) < 1) {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� ������ ssn�Դϴ�.");
						return;
					}
				}
				
				String dno = dnoTextField.getText();	// Dno NUMBER DEFAULT 1 NOT NULL FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dnumber)
				if (Pattern.matches("^[0-9]{1}$", dno) != true) {
					JOptionPane.showMessageDialog(null, "Dno�� ���� 1�ڸ��� �Է����ּ���.");
					return;
				}
				if (q5.isExistDnumber(dno) < 1) {
					JOptionPane.showMessageDialog(null, "�������� �ʴ� Dno�Դϴ�.");
					return;
				}
				
				q5.InsertEmployee(fName, mName, lName, ssn, bDate, address, sex, salary, superSsn, dno);
				
				JOptionPane.showMessageDialog(null, "�߰� �Ϸ�. �˻� ��ư�� �ٽ� �����ּž� �ݿ��˴ϴ�.");
				insertFrame.dispose();
			}
		});
		panel_10.add(addButton);
	}
}
