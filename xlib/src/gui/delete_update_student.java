

/*
 * Created by JFormDesigner on Mon Mar 15 16:44:09 EAT 2021
 */



import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author pius
 */
public class delete_update_student extends JPanel {
	public delete_update_student() {
		initComponents();
	}
	public void clear(){
		idtxt.setText("");
			username.setText("");
			fnametxt.setText("");
			lnametxt.setText("");
			email.setText("");
			password.setText("");
			confirm_password.setText("");
	}
	public void setData(String id,String user,String fname,String lname,String mail){
			idtxt.setText(id);
			username.setText(user);
			fnametxt.setText(fname);
			lnametxt.setText(lname);
			email.setText(mail);

	}
	public void collectedData(){
		String passcode=String.valueOf(password.getPassword());
		String conpasscode=String.valueOf(confirm_password.getPassword());
		String operation= (String) comboBox1.getSelectedItem();
		String usertype=(String) comboBox2.getSelectedItem();
		String id =idtxt.getText();
		String user=username.getText();
		String fname=fnametxt.getText();
		String lname=lnametxt.getText();
		String mail=email.getText();
		if(mail.equals("")|| lname.equals("") || fname.equals("")|| user.equals("")|| passcode.equals("")|| conpasscode.equals("")){
			label11.setText("fill all fields!");
			JOptionPane.showMessageDialog(null, "something went wrong ! EMPTY fields! Try again!");
		}
		else{
		
				if(operation=="delete" && controller.delete_user(id)){
			JOptionPane.showMessageDialog(null, "deleted");
			clear();
		}
		if(passcode.equals(conpasscode)){
		if(operation=="update" && controller.update_user(id, user, fname, lname, mail,passcode,usertype)){
			JOptionPane.showMessageDialog(null, "updated");
			clear();
			
			
		}
	}else{label11.setText("PAssword mismatch!");
	JOptionPane.showMessageDialog(null, "something went wrong! password mismatch! Try again!");}
	}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Pius
		panel2 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		username = new JTextField();
		password = new JPasswordField();
		confirm_password = new JPasswordField();
		label5 = new JLabel();
		email = new JTextField();
		fnametxt = new JTextField();
		lnametxt = new JTextField();
		label7 = new JLabel();
		label8 = new JLabel();
		label6 = new JLabel();
		idtxt = new JTextField();
		label9 = new JLabel();
		comboBox1 = new JComboBox<>();
		label10 = new JLabel();
		comboBox2 = new JComboBox<>();
		label11 = new JLabel();

		//======== this ========
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
		.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
		.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
		Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
		), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
		public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
		)))throw new RuntimeException();}});

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

			//---- label5 ----
			label5.setForeground(Color.red);
			label5.setFont(new Font("Tahoma", Font.BOLD, 12));

			//---- label7 ----
			label7.setText("first name");
			label7.setFont(new Font("Tahoma", Font.BOLD, 12));
			label7.setForeground(Color.white);

			//---- label8 ----
			label8.setText("last name");
			label8.setFont(new Font("Tahoma", Font.BOLD, 12));
			label8.setForeground(Color.white);

			//---- label6 ----
			label6.setText("userId");
			label6.setFont(new Font("Tahoma", Font.BOLD, 12));
			label6.setBackground(Color.darkGray);
			label6.setForeground(Color.white);

			//---- idtxt ----
			idtxt.setEditable(false);

			//---- label9 ----
			label9.setText("select option");
			label9.setFont(new Font("Tahoma", Font.BOLD, 12));
			label9.setBackground(Color.darkGray);
			label9.setForeground(Color.white);

			//---- comboBox1 ----
			comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
				"update",
				"delete"
			}));

			//---- label10 ----
			label10.setText("select usertype");
			label10.setFont(new Font("Tahoma", Font.BOLD, 12));
			label10.setBackground(Color.darkGray);
			label10.setForeground(Color.white);

			//---- comboBox2 ----
			comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
				"user",
				"Admin"
			}));

			//---- label11 ----
			label11.setForeground(Color.red);
			label11.setFont(new Font("Tahoma", Font.BOLD, 12));

			GroupLayout panel2Layout = new GroupLayout(panel2);
			panel2.setLayout(panel2Layout);
			panel2Layout.setHorizontalGroup(
				panel2Layout.createParallelGroup()
					.addGroup(panel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel2Layout.createParallelGroup()
							.addGroup(panel2Layout.createSequentialGroup()
								.addGap(101, 101, 101)
								.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(274, 274, 274))
							.addGroup(panel2Layout.createSequentialGroup()
								.addGroup(panel2Layout.createParallelGroup()
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(label7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(label8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(panel2Layout.createParallelGroup()
									.addComponent(username, GroupLayout.Alignment.TRAILING)
									.addComponent(fnametxt)
									.addComponent(lnametxt)))
							.addGroup(panel2Layout.createSequentialGroup()
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(email))
							.addGroup(panel2Layout.createSequentialGroup()
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(password))
							.addGroup(panel2Layout.createSequentialGroup()
								.addGroup(panel2Layout.createParallelGroup()
									.addGroup(panel2Layout.createSequentialGroup()
										.addComponent(label10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addGap(42, 42, 42)
										.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(panel2Layout.createSequentialGroup()
										.addComponent(label9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(panel2Layout.createSequentialGroup()
										.addComponent(label6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE))
							.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addGroup(panel2Layout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
										.addComponent(label4)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(confirm_password, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
									.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
										.addComponent(label11, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
										.addGap(63, 63, 63)))))
						.addContainerGap())
			);
			panel2Layout.setVerticalGroup(
				panel2Layout.createParallelGroup()
					.addGroup(panel2Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addComponent(fnametxt)
							.addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(lnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label3)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label4)
							.addComponent(confirm_password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label6)
							.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(label11)
						.addGap(4, 4, 4)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label10)
							.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label9)
							.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label5)
						.addGap(54, 54, 54))
			);
		}

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createParallelGroup()
					.addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(0, 410, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)))
				.addGap(0, 311, Short.MAX_VALUE)
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Pius
	private JPanel panel2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirm_password;
	private JLabel label5;
	private JTextField email;
	private JTextField fnametxt;
	private JTextField lnametxt;
	private JLabel label7;
	private JLabel label8;
	private JLabel label6;
	private JTextField idtxt;
	private JLabel label9;
	private JComboBox<String> comboBox1;
	private JLabel label10;
	private JComboBox<String> comboBox2;
	private JLabel label11;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
