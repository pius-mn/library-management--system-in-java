
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
/*
 * Created by JFormDesigner on Fri Mar 05 17:27:42 EAT 2021
 */



/**
 * @author pius
 */
public class login extends JFrame {
	public login() {
		initComponents();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loginActionPerformed(ActionEvent e) {
		String passcode=String.valueOf(password.getPassword());
		String user=username.getText();
		controller controller=new controller();
		String[] x=controller.login_auth(user, passcode);
		System.out.println(x[0]+"\t"+x[1]+"\t"+x[2]+"\t"+x[3]);
		if(x[3].equalsIgnoreCase("user")){
			StudentPanel studentPanel=new StudentPanel();
			studentPanel.setData(x);
			this.dispose();
			this.setVisible(false);
		}else if(x[3].equalsIgnoreCase("Admin")){
			home home =new home();
			home.setData(x);
			this.dispose();
			this.setVisible(false);
		}

		else{
		
		incorrect.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
		incorrect.setText("invalid login credentials");}

		// TODO add your code here
	}

	private void registerbtnActionPerformed(ActionEvent e) {
		register.main(new String[]{});
		this.dispose();
		this.setVisible(false);
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Pius
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		username = new JTextField();
		login = new JButton();
		icon = new JLabel();
		incorrect = new JLabel();
		label4 = new JLabel();
		registerbtn = new JButton();
		password = new JPasswordField();

		//======== this ========
		setBackground(new Color(102, 102, 102));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setForeground(SystemColor.textHighlight);
		setTitle("LOGIN PAGE");
		setResizable(false);
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(51, 51, 51));
			panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
			javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax
			. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
			. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
			. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .
			PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .
			equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

			//======== panel2 ========
			{
				panel2.setBackground(new Color(153, 153, 153));

				//---- label1 ----
				label1.setText("USERNAME");
				label1.setForeground(Color.white);
				label1.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label2 ----
				label2.setText("PASSWORD");
				label2.setFont(new Font("Tahoma", Font.BOLD, 12));
				label2.setForeground(Color.white);

				//---- login ----
				login.setText("LOGIN");
				login.setBackground(new Color(0, 204, 51));
				login.setForeground(Color.white);
				login.setFont(new Font("Tahoma", Font.BOLD, 12));
				login.addActionListener(e -> loginActionPerformed(e));

				//---- icon ----
				icon.setIcon(new ImageIcon(getClass().getResource("/lock.png")));

				//---- incorrect ----
				incorrect.setFont(new Font("Tahoma", Font.BOLD, 12));
				incorrect.setForeground(Color.red);
				//incorrect.setIcon(UIManager.getIcon("OptionPane.warningIcon"));

				//---- label4 ----
				label4.setText("OR");
				label4.setForeground(Color.green);
				label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 3f));

				//---- registerbtn ----
				registerbtn.setText("CREATE ACCOUNT");
				registerbtn.setBackground(new Color(0, 255, 51));
				registerbtn.setForeground(Color.white);
				registerbtn.addActionListener(e -> registerbtnActionPerformed(e));

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(27, 27, 27)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(label2, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel2Layout.createParallelGroup()
								.addComponent(username)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addContainerGap(56, Short.MAX_VALUE))
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap(74, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup()
								.addComponent(registerbtn)
								.addGroup(panel2Layout.createSequentialGroup()
									.addGap(18, 18, 18)
									.addComponent(label4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addComponent(login, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(icon))
							.addContainerGap(62, Short.MAX_VALUE))
						.addComponent(incorrect, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap(19, Short.MAX_VALUE)
							.addComponent(icon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(password))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(incorrect, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(login, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label4)
							.addGap(18, 18, 18)
							.addComponent(registerbtn)
							.addGap(26, 26, 26))
				);
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap(97, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap(107, Short.MAX_VALUE))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap(42, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap(83, Short.MAX_VALUE))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Pius
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JLabel label2;
	private JTextField username;
	private JButton login;
	private JLabel icon;
	private JLabel incorrect;
	private JLabel label4;
	private JButton registerbtn;
	private JPasswordField password;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
