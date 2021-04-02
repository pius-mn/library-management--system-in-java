import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sat Mar 27 13:33:08 EAT 2021
 */
import javax.swing.table.DefaultTableModel;



/**
 * @author Pius
 */
public class StudentPanel extends JFrame {
	static DefaultTableModel defaultTableModel=new DefaultTableModel();
	UpdateProfile updateProfile=new UpdateProfile();
	public StudentPanel() {
		initComponents();
	}

	
	/*/public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPanel frame = new StudentPanel();
					frame.showBooks(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void setData(String[] x){
		label7.setText(x[0]);
		label3.setText(x[1]);
		label6.setText(x[2]);
		showBooks(null);
		setVisible(true);

	}
	
	public  void showBooks(String search) {
		label8.setText("Books");
		table1.setModel(defaultTableModel);
		if(search==null  && defaultTableModel.getColumnCount()!=6){
			defaultTableModel.addColumn("id");
			defaultTableModel.addColumn("isbn");
			defaultTableModel.addColumn("title");
			defaultTableModel.addColumn("author");
			defaultTableModel.addColumn("publisher");
			defaultTableModel.addColumn("status");
		
		   }
		   try {
			int flag=0;
		Connection connection = db.getConnection();//Crating connection with database
			Statement statement = connection.createStatement();//crating statement object
				int i=0;
				while (i<defaultTableModel.getRowCount()){
				defaultTableModel.removeRow(defaultTableModel.getRowCount()-1);
				}
				
			
			String query = search!=null?"select * from books where title = '" + search + "'or isbn = '" + search + "' or author = '" + search + "' ":"select * from books";//Storing MySQL query in A string variable
			ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
			
			
			while (resultSet.next()) {
				
				//Retrivind details from the database and stroing it in the String variables
				String id = resultSet.getString("id");
				String title = resultSet.getString("title");
				String isbn = resultSet.getString("isbn");
				String author = resultSet.getString("author");
				String publisher = resultSet.getString("publisher");
				String status = resultSet.getString("status");
				flag = 1;
				defaultTableModel.addRow(new Object[]{id,isbn, title, author, publisher,status});//Adding row in Table
			}	
		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "No record Found");
			
			//When invalid username is entered
		}


	} 
	catch (SQLException throwables) {throwables.printStackTrace();}
			
		}
		public void showIssuedBooks(){
			DefaultTableModel issuedbooktable =new DefaultTableModel();
			table1.setModel(issuedbooktable);
			String userName=label7.getText().trim();
			label8.setText(" ISSUED BOOKS");
			if(issuedbooktable.getColumnCount()!=8){
				issuedbooktable.addColumn("issue id");
				issuedbooktable.addColumn("book id");
				issuedbooktable.addColumn("username");
				issuedbooktable.addColumn("isbn");
				issuedbooktable.addColumn("title");
				issuedbooktable.addColumn("Author");
				issuedbooktable.addColumn("Publisher");
				issuedbooktable.addColumn("issue date");
				
			
			   }
			   try {
				int flag=0;
			Connection connection = db.getConnection();//Crating connection with database
				Statement statement = connection.createStatement();//crating statement object
					int i=0;
					while (i<issuedbooktable.getRowCount()){
					issuedbooktable.removeRow(issuedbooktable.getRowCount()-1);
					}
				
				String query =" select*from issued_book inner join books on issued_book.isbn=books.isbn WHERE issued_book.username='" + userName + "';";//Storing MySQL query in A string variable
				ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
				
				
				while (resultSet.next()) {
					
					//Retrivind details from the database and stroing it in the String variables
					String id = resultSet.getString("id");
					String username = resultSet.getString("username");
					String issueId = resultSet.getString("issue_id");
					String title = resultSet.getString("title");
					String isbn = resultSet.getString("isbn");
					String author = resultSet.getString("author");
					String publisher = resultSet.getString("publisher");
					String issueDate=resultSet.getString("Date");
					
	
					flag = 1;
					issuedbooktable.addRow(new Object[]{issueId,id,username,isbn, title, author, publisher,issueDate});//Adding row in Table
				}	
				  if (flag == 0) {
					JOptionPane.showMessageDialog(null, "No record Found");
					
					//When invalid username is entered
				}
	
	
			} 
			catch (SQLException throwables) {throwables.printStackTrace();}
		}

	private void menu3ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menu5ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menuItem1ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "This application is developed by pius nderitu\n email: pnderitu07@gmail.com\n Thank You!");
		// TODO add your code here
	}

	private void menu6MenuSelected(MenuEvent e) {
		String search= textField1.getText().trim();
		showBooks(search);	
		// TODO add your code here
	}

	private void menu1MenuSelected(MenuEvent e) {
		showBooks(null);
		// TODO add your code here
	}

	private void menu2MenuSelected(MenuEvent e) {
		showIssuedBooks();
		// TODO add your code here
	}

	private void menuItem2ActionPerformed(ActionEvent e) {
		
		updateProfile.setData(label3.getText());
		int result=	JOptionPane.showConfirmDialog(null,updateProfile, "updata Profile", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	
		if(result == JOptionPane.OK_OPTION){	
			updateProfile.collectedData();
			
	
		}
		// TODO add your code here
	}

	private void menuItem3ActionPerformed(ActionEvent e) {
		login.main(new String[]{});
		this.dispose();
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Pius
		splitPane1 = new JSplitPane();
		panel2 = new JPanel();
		label10 = new JLabel();
		label11 = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		panel1 = new JPanel();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menu3 = new JMenu();
		menuItem2 = new JMenuItem();
		menu5 = new JMenu();
		menuItem3 = new JMenuItem();
		menu4 = new JMenu();
		menuItem1 = new JMenuItem();
		menuBar2 = new JMenuBar();
		textField1 = new JTextField();
		menu6 = new JMenu();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		label8 = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("STUDENT PAGE");
		Container contentPane = getContentPane();

		//======== splitPane1 ========
		{
			splitPane1.setDividerSize(1);
			splitPane1.setLastDividerLocation(1);
			splitPane1.setOneTouchExpandable(true);
			splitPane1.setDividerLocation(200);

			//======== panel2 ========
			{
				panel2.setForeground(Color.red);
				panel2.setBackground(Color.green);
				panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
				( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
				. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
				. Color. red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
				propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
				; }} );

				//---- label10 ----
				label10.setForeground(Color.red);

				//---- label11 ----
				label11.setForeground(Color.red);

				//---- label1 ----
				label1.setText("welcome,");
				label1.setFont(new Font("Tahoma", Font.BOLD, 12));
				label1.setForeground(Color.blue);

				//---- label2 ----
				label2.setText("Last Login ");
				label2.setFont(new Font("Tahoma", Font.BOLD, 12));
				label2.setForeground(Color.blue);

				//---- label3 ----
				label3.setFont(new Font("Tahoma", Font.BOLD, 12));
				label3.setForeground(Color.blue);

				//---- label4 ----
				label4.setText("User Id");
				label4.setFont(new Font("Tahoma", Font.BOLD, 12));
				label4.setForeground(Color.blue);

				//---- label5 ----
				label5.setText("Dashboard");
				label5.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label6 ----
				label6.setFont(new Font("Tahoma", Font.BOLD, 12));
				label6.setForeground(Color.blue);

				//---- label7 ----
				label7.setFont(new Font("Tahoma", Font.BOLD, 12));
				label7.setForeground(Color.blue);

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel2Layout.createSequentialGroup()
							.addGroup(panel2Layout.createParallelGroup()
								.addGroup(panel2Layout.createSequentialGroup()
									.addContainerGap()
									.addGroup(panel2Layout.createParallelGroup()
										.addComponent(label11, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
										.addComponent(label2)
										.addGroup(panel2Layout.createSequentialGroup()
											.addComponent(label4)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(label3))
										.addGroup(panel2Layout.createSequentialGroup()
											.addComponent(label1)
											.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
											.addComponent(label7))))
								.addGroup(panel2Layout.createSequentialGroup()
									.addGap(20, 20, 20)
									.addComponent(label5))
								.addGroup(panel2Layout.createSequentialGroup()
									.addContainerGap()
									.addComponent(label6)))
							.addContainerGap(28, Short.MAX_VALUE))
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(18, 18, 18)
							.addComponent(label5)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(label7))
							.addGap(18, 18, 18)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label4)
								.addComponent(label3))
							.addGap(20, 20, 20)
							.addComponent(label10)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label2)
							.addGap(18, 18, 18)
							.addComponent(label6)
							.addGap(128, 128, 128)
							.addComponent(label11)
							.addContainerGap(122, Short.MAX_VALUE))
				);
			}
			splitPane1.setLeftComponent(panel2);

			//======== panel1 ========
			{
				panel1.setBackground(new Color(51, 51, 51));
				panel1.setBorder(LineBorder.createBlackLineBorder());

				//======== menuBar1 ========
				{

					//======== menu1 ========
					{
						menu1.setText("books");
						menu1.addMenuListener(new MenuListener() {
							@Override
							public void menuCanceled(MenuEvent e) {}
							@Override
							public void menuDeselected(MenuEvent e) {}
							@Override
							public void menuSelected(MenuEvent e) {
								menu1MenuSelected(e);
							}
						});
					}
					menuBar1.add(menu1);

					//======== menu2 ========
					{
						menu2.setText("mybooks");
						menu2.addMenuListener(new MenuListener() {
							@Override
							public void menuCanceled(MenuEvent e) {}
							@Override
							public void menuDeselected(MenuEvent e) {}
							@Override
							public void menuSelected(MenuEvent e) {
								menu2MenuSelected(e);
							}
						});
					}
					menuBar1.add(menu2);

					//======== menu3 ========
					{
						menu3.setText("update Profile");

						//---- menuItem2 ----
						menuItem2.setText("update");
						menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
						menu3.add(menuItem2);
					}
					menuBar1.add(menu3);

					//======== menu5 ========
					{
						menu5.setText("home");
						menu5.addActionListener(e -> menu5ActionPerformed(e));

						//---- menuItem3 ----
						menuItem3.setText("login page");
						menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
						menu5.add(menuItem3);
					}
					menuBar1.add(menu5);

					//======== menu4 ========
					{
						menu4.setText("Help");

						//---- menuItem1 ----
						menuItem1.setText("about developer");
						menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
						menu4.add(menuItem1);
					}
					menuBar1.add(menu4);
				}

				//======== menuBar2 ========
				{
					menuBar2.add(textField1);

					//======== menu6 ========
					{
						menu6.setText("search");
						menu6.addMenuListener(new MenuListener() {
							@Override
							public void menuCanceled(MenuEvent e) {}
							@Override
							public void menuDeselected(MenuEvent e) {}
							@Override
							public void menuSelected(MenuEvent e) {
								menu6MenuSelected(e);
							}
						});
					}
					menuBar2.add(menu6);
				}

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setRowSelectionAllowed(false);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setAutoCreateRowSorter(true);
					scrollPane1.setViewportView(table1);
				}

				//---- label8 ----
				label8.setText("welcome,");
				label8.setFont(new Font("Tahoma", Font.BOLD, 16));
				label8.setForeground(Color.green);

				GroupLayout panel1Layout = new GroupLayout(panel1);
				panel1.setLayout(panel1Layout);
				panel1Layout.setHorizontalGroup(
					panel1Layout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
							.addGap(0, 229, Short.MAX_VALUE)
							.addComponent(label8, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(285, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
							.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(panel1Layout.createSequentialGroup()
									.addContainerGap()
									.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
								.addGroup(panel1Layout.createSequentialGroup()
									.addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
									.addComponent(menuBar2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
				);
				panel1Layout.setVerticalGroup(
					panel1Layout.createParallelGroup()
						.addGroup(panel1Layout.createSequentialGroup()
							.addGap(1, 1, 1)
							.addGroup(panel1Layout.createParallelGroup()
								.addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(menuBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14, 14, 14)
							.addComponent(label8)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
							.addContainerGap())
				);
			}
			splitPane1.setRightComponent(panel1);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(splitPane1)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(splitPane1)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Pius
	private JSplitPane splitPane1;
	private JPanel panel2;
	private JLabel label10;
	private JLabel label11;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JPanel panel1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	private JMenuItem menuItem2;
	private JMenu menu5;
	private JMenuItem menuItem3;
	private JMenu menu4;
	private JMenuItem menuItem1;
	private JMenuBar menuBar2;
	private JTextField textField1;
	private JMenu menu6;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JLabel label8;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
