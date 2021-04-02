

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Feb 24 18:50:29 EAT 2021
 */





/**
 * @author Pius
 */
public class register extends JFrame {
	public register() {
		initComponents();
	}

		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void registerActionPerformed(ActionEvent e) {
		String passcode= new String(password.getPassword());
		String confpasscode=new String(confirm_password.getPassword());
		String user=username.getText().trim();
		String mail =email.getText().trim();
		String fname = fnametxt.getText().trim();
		String lname=lnametxt.getText().trim();
		if(mail.equals("")|| user.equals("")||passcode.equals("") ||confpasscode.equals("")){
			label5.setText("Fill all the fields !");
		}
		else {	
			if(passcode.equals(confpasscode)){	
				if(controller.register_auth(user,fname,lname,mail ,passcode)){
					controller controller=new controller();
					String[] x=controller.login_auth(user, passcode);
					StudentPanel studentPanel=new StudentPanel();
					close_log();
					 studentPanel.setData(x);
					 
					
				}
				else{
					label5.setText("username taken!");
				}
			}
			else{
				label5.setText("Password mismatch !");
				
			}
		}
		// TODO add your code here
	}
	public void close_log() {
		this.dispose();
		this.setVisible(false);
		
		
	}

	private void loginbtnActionPerformed(ActionEvent e) {
		close_log();
		login.main(new String[]{});
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Pius
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		register = new JButton();
		username = new JTextField();
		password = new JPasswordField();
		confirm_password = new JPasswordField();
		label5 = new JLabel();
		label6 = new JLabel();
		loginbtn = new JButton();
		email = new JTextField();
		fnametxt = new JTextField();
		lnametxt = new JTextField();
		label7 = new JLabel();
		label8 = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("REGISTER");
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(102, 102, 102));
			panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
			. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
			. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
			awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) )
			; panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
			) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
			;

			//======== panel2 ========
			{
				panel2.setBackground(new Color(153, 153, 153));

				//---- label1 ----
				label1.setText("username");
				label1.setFont(new Font("Tahoma", Font.BOLD, 12));
				label1.setForeground(Color.white);

				//---- label2 ----
				label2.setText("email");
				label2.setForeground(Color.white);
				label2.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label3 ----
				label3.setText("password");
				label3.setFont(new Font("Tahoma", Font.BOLD, 12));
				label3.setBackground(Color.darkGray);
				label3.setForeground(Color.white);

				//---- label4 ----
				label4.setText("confirm password");
				label4.setFont(new Font("Tahoma", Font.BOLD, 11));
				label4.setForeground(Color.white);

				//---- register ----
				register.setText("register");
				register.setForeground(Color.white);
				register.setBackground(new Color(0, 204, 51));
				register.setFont(new Font("Tahoma", Font.BOLD, 14));
				register.addActionListener(e -> registerActionPerformed(e));

				//---- label5 ----
				label5.setForeground(Color.red);
				label5.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label6 ----
				label6.setText("OR");
				label6.setForeground(Color.blue);
				label6.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- loginbtn ----
				loginbtn.setText("LOGIN");
				loginbtn.setBackground(Color.blue);
				loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
				loginbtn.setForeground(Color.white);
				loginbtn.addActionListener(e -> loginbtnActionPerformed(e));

				//---- label7 ----
				label7.setText("first name");
				label7.setFont(new Font("Tahoma", Font.BOLD, 12));
				label7.setForeground(Color.white);

				//---- label8 ----
				label8.setText("last name");
				label8.setFont(new Font("Tahoma", Font.BOLD, 12));
				label8.setForeground(Color.white);

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(38, 38, 38)
							.addComponent(register)
							.addGap(18, 18, 18)
							.addComponent(label6)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(loginbtn)
							.addGap(0, 34, Short.MAX_VALUE))
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(111, 111, 111)
							.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel2Layout.createParallelGroup()
								.addGroup(panel2Layout.createSequentialGroup()
									.addComponent(label2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(email, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
								.addGroup(panel2Layout.createSequentialGroup()
									.addGroup(panel2Layout.createParallelGroup()
										.addComponent(label4)
										.addComponent(label3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(panel2Layout.createParallelGroup()
										.addComponent(confirm_password)
										.addComponent(password)))
								.addGroup(panel2Layout.createSequentialGroup()
									.addGroup(panel2Layout.createParallelGroup()
										.addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(label7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(label8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(panel2Layout.createParallelGroup()
										.addComponent(lnametxt)
										.addComponent(fnametxt)
										.addComponent(username, GroupLayout.Alignment.TRAILING))))
							.addContainerGap())
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(fnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label3))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup()
								.addComponent(confirm_password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label4))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label5)
							.addGap(18, 18, 18)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label6)
								.addComponent(register)
								.addComponent(loginbtn))
							.addContainerGap())
				);
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap(50, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap(56, Short.MAX_VALUE))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(135, 135, 135))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		setSize(400, 420);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}


	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Pius
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton register;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirm_password;
	private JLabel label5;
	private JLabel label6;
	private JButton loginbtn;
	private JTextField email;
	private JTextField fnametxt;
	private JTextField lnametxt;
	private JLabel label7;
	private JLabel label8;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

