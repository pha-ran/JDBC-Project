package jdbc_2021_team_project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		sexCombo.setSelectedIndex(0); // 실헹시 성별 기본 M 선택
	}

	private void initialize() {
		insertFrame = new JFrame("새로운 직원 정보 추가 (*필수)");
		insertFrame.setBounds(100, 100, 360, 480);
		insertFrame.setLocationRelativeTo(null); // 화면 가운데에 배치
		insertFrame.setResizable(false); // 창 크기 고정
		//insertFrame.setAlwaysOnTop(true); // 항상 위
		
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
		
		JButton addButton = new JButton("추가하기");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fName = fNameTextField.getText();
				String mName = mNameTextField.getText();
				String lName = lNameTextField.getText();
				String ssn = ssnTextField.getText();
				String bDate = bDateTextField.getText();
				String address = addressTextField.getText();
				String sex = (String) sexCombo.getSelectedItem();
				String salary = salaryTextField.getText();
				String superSsn = superSsnTextField.getText();
				String dno = dnoTextField.getText();
				
				Q5 q5 = new Q5();
				q5.InsertEmployee(fName, mName, lName, ssn, bDate, address, sex, salary, superSsn, dno);
				
				JOptionPane.showMessageDialog(null, "추가 완료. 검색 버튼을 눌러주세요.");
				insertFrame.dispose();
			}
		});
		panel_10.add(addButton);
	}
}
