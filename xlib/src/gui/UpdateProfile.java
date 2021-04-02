import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
/*
 * Created by JFormDesigner on Sun Mar 28 10:09:55 EAT 2021
 */



/**
 * @author Pius
 */
public class UpdateProfile extends JPanel {
	public UpdateProfile() {
		initComponents();
	}
	public void collectedData(){
		String id =idtxt.getText();
		String user=username.getText();
		String fname=fnametxt.getText();
		String lname=lnametxt.getText();
		String mail=email.getText();
		String passcode=String.valueOf(password.getPassword());
		String passcode2=String.valueOf(confirm_password.getPassword());
		if(id.equals("") || user.equals("") || fname.equals("") || lname.equals("") || mail.equals("") || passcode.equals("") || passcode2.equals("")){
			JOptionPane.showMessageDialog(null, "please fill all fields!");
		}else{
			if(passcode.equals(passcode2)){

				if(controller.update_user(id, user, fname, lname, mail,passcode,"user")){
					JOptionPane.showMessageDialog(null, "updated");	
				}else{
					JOptionPane.showMessageDialog(null, "username taken! Try another username");

				}
			}else{JOptionPane.showMessageDialog(null, "password mismatch!");}
		}
	}
	public void setData(String userId){
		try{
			Connection conn=db.getConnection();
			Statement statement= conn.createStatement();
			String sql= "select*from user where id='"+userId+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				username.setText(resultSet.getString("username"));
				idtxt.setText(resultSet.getString("id"));
				fnametxt.setText(resultSet.getString("fname"));
				lnametxt.setText(resultSet.getString("lname"));
				email.setText(resultSet.getString("email"));

			}
		}catch(SQLException throwables) {throwables.printStackTrace();}
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

		//======== this ========
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
		. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
		. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
		Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
		) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
		public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
		) )) throw new RuntimeException( ); }} );

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

			GroupLayout panel2Layout = new GroupLayout(panel2);
			panel2.setLayout(panel2Layout);
			panel2Layout.setHorizontalGroup(
				panel2Layout.createParallelGroup()
					.addGroup(panel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel2Layout.createParallelGroup()
							.addGroup(panel2Layout.createSequentialGroup()
								.addComponent(label6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(1, 1, 1)
								.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
							.addGroup(panel2Layout.createSequentialGroup()
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(email, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
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
						.addContainerGap(19, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(fnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(lnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label3))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
						.addGroup(panel2Layout.createParallelGroup()
							.addComponent(confirm_password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label4))
						.addGroup(panel2Layout.createParallelGroup()
							.addGroup(panel2Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
								.addComponent(label5)
								.addGap(52, 52, 52))
							.addGroup(panel2Layout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(label6)
									.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(30, Short.MAX_VALUE))))
			);
		}

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(0, 400, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(0, 300, Short.MAX_VALUE)
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
