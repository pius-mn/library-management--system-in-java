
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

/*
 * Created by JFormDesigner on Thu Mar 11 12:43:49 EAT 2021
 */



/**
 * @author pius
 */
public class home extends JFrame {
	DefaultTableModel defaultTableModel= new DefaultTableModel();
	DefaultTableModel studentlist =new DefaultTableModel();
	DefaultTableModel issuedbooktable=new DefaultTableModel();
	static String books =new String("books");
	delete_update_book delete_update_book= new delete_update_book();
	delete_update_student delete_update_student=new delete_update_student();
	static String user = new String("user");

	public home() {
		initComponents();
	}

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.showdata(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void setData(String[] x){
		
		label13.setText(x[0]);
		label15.setText(x[1]);
		label17.setText(x[2]);
		showdata(null,null);
		setVisible(true);

	}

	private void menuItem1ActionPerformed(ActionEvent e) {
		addbook b = new addbook();
		int result=	JOptionPane.showConfirmDialog(null,b, "ADD BOOK", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		// TODO add your code here
		if(result == JOptionPane.OK_OPTION){	
		b.collectedData();} 
		

	}

	private void menuItem2ActionPerformed(ActionEvent e) {
		
		int result=	JOptionPane.showConfirmDialog(null,delete_update_book, "ADD BOOK", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	
		if(result == JOptionPane.OK_OPTION){	
			delete_update_book.collectedData();
			
	
		}
	}

	private void menuItem13ActionPerformed(ActionEvent e) {
		showdata(null, books);
		
		// TODO add your code here
	}

	

	private void menuItem8ActionPerformed(ActionEvent e) {
		int result=	JOptionPane.showConfirmDialog(null,delete_update_student, "delete or update student", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	
		if(result == JOptionPane.OK_OPTION){	
			delete_update_student.collectedData();
			
	
		}
	
		// TODO add your code here
	}

	private void menuItem6ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menuItem7ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menuItem9ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "This application is developed by pius nderitu\n email: pnderitu07@gmail.com\n Thank You!");
		// TODO add your code here
	}

	private void menuItem10ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menuItem11ActionPerformed(ActionEvent e) {
		String search= textField2.getText();
		if(search.equalsIgnoreCase("")){
			//System.out.println("empty");
			
		}
		else{	
			
			showdata(search,books);
			
		}
		
		
		
		// TODO add your code here
	}


	private void menuItem12ActionPerformed(ActionEvent e) {
		String search= textField2.getText();
		if(search.equalsIgnoreCase("")){	
			//System.out.println("empty");
		}
		else{
		
			
			showdata(search,user);
		}
		
		// TODO add your code here
	}

	private void menuItem14ActionPerformed(ActionEvent e) {
		showIssuedBooks();
		
    }
		// TODO add your code here

	private void menuItem15ActionPerformed(ActionEvent e) {
		showdata(null, user);
		// TODO add your code here
	}

	private void table1MouseClicked(MouseEvent e) {
		int i=table1.getSelectedRow();
		String id= defaultTableModel.getValueAt(i, 0).toString();
		String isbn= defaultTableModel.getValueAt(i, 1).toString();
		String title= defaultTableModel.getValueAt(i, 2).toString();
		String author= defaultTableModel.getValueAt(i, 3).toString();
		String publisher= defaultTableModel.getValueAt(i, 4).toString();
		delete_update_book.setData(id, isbn, title, author, publisher);
		// TODO add your code here
		
	}

	private void table2MouseClicked(MouseEvent e) {
		int i =table2.getSelectedRow();
		String id =studentlist.getValueAt(i,0 ).toString();
		String username =studentlist.getValueAt(i,1 ).toString();
		String fname=studentlist.getValueAt( i,2).toString();
		String lname=studentlist.getValueAt(i, 3 ).toString();
		String email=studentlist.getValueAt(i,4 ).toString();
		delete_update_student.setData(id, username, fname, lname, email);
		
		
		// TODO add your code here
	}

	private void button1ActionPerformed(ActionEvent e) {
		// TODO add your code here
		String username=textField1.getText().trim();
		String isbn=textField3.getText().trim();
		if(username.equals("") || isbn.equals("")){
			label10.setText(" isbn or username is empty !");
		}
		else{
			if(controller.checkBookInIssued(isbn)){
				label10.setText("Book Not Available");
			}
			else{
				if (controller.usernameValidate(username) ){
					if(controller.isbnValidate(isbn)){
						if(controller.issue_book(username, isbn)){
							textField3.setText("");
							label10.setText(" operation successfull ");

						}
					}
					else{
						label10.setText(" isbn does not exist");
					}
				
				}else{
					label10.setText(" Username does not exist");
				}

			}
		}
	}

	private void button2ActionPerformed(ActionEvent e) {
		String isbn=textField4.getText().trim();
		if(isbn.equals("")){
			label11.setText(" isbn is empty !");
		}
		else{
			if(controller.checkBookInIssued(isbn) && controller.return_book(isbn)){
					textField4.setText("");
				label11.setText("operation successful !");
			}else{ label11.setText("Book Was Not Issued !");}
			
		}
		// TODO add your code here
	}
	
	public void showIssuedBooks(){
		table1.setModel(issuedbooktable);
		String userName=textField2.getText().trim();
		label2.setText(" ISSUED BOOKS");
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
			
			String query =" select*from issued_book inner join books on issued_book.isbn=books.isbn;";//Storing MySQL query in A string variable
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
	public void showdata(String search,String data){
		//setVisible(true);
		table1.setModel(defaultTableModel);
		table2.setModel(studentlist);
		label2.setText("BOOKS");

       if(search==null  && defaultTableModel.getColumnCount()!=6){
        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("isbn");
		defaultTableModel.addColumn("title");
		defaultTableModel.addColumn("author");
		defaultTableModel.addColumn("publisher");
		defaultTableModel.addColumn("status");
	
	   }
	   if(search==null  && studentlist.getColumnCount()!=6){
	   studentlist.addColumn("id");
	   studentlist.addColumn("username");
	   studentlist.addColumn("first name");
	   studentlist.addColumn("last name");
	   studentlist.addColumn("email");
	   studentlist.addColumn("Last login");
	   }
		
				try {
				int flag=0;
			Connection connection = db.getConnection();//Crating connection with database
				Statement statement = connection.createStatement();//crating statement object
				if(data==books || data==null){
					int i=0;
					while (i<defaultTableModel.getRowCount()){
					defaultTableModel.removeRow(defaultTableModel.getRowCount()-1);
					}
					
				
					//System.out.println("data at "+ data+"  search at  "+search);
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
			}
			 if(data==user || data==null) {
				int i=0;
				while (i<studentlist.getRowCount()){
				studentlist.removeRow(studentlist.getRowCount()-1);
				}
				String query = search!=null?"select * from user where username='" + search + "'":"select* from user";//Storing MySQL query in A string variable
			ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
			
			
			while (resultSet.next()) {
				
				//Retrivind details from the database and stroing it in the String variables
				String id = resultSet.getString("id");
				String username = resultSet.getString("username");
				String fname = resultSet.getString("fname");
				String lname = resultSet.getString("lname");
				String email = resultSet.getString("email");
				String date = resultSet.getString("date");
				
					flag = 1;
					studentlist.addRow(new Object[]{id, username, fname, lname,email,date});//Adding row in Table
			}


			}

            if (flag == 0) {
				JOptionPane.showMessageDialog(null, "No Such record Found");
				
				//When invalid username is entered
            }


		} 
		catch (SQLException throwables) {throwables.printStackTrace();}
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
		textField1 = new JTextField();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		textField3 = new JTextField();
		button1 = new JButton();
		textField4 = new JTextField();
		label8 = new JLabel();
		label9 = new JLabel();
		button2 = new JButton();
		hSpacer1 = new JPanel(null);
		label10 = new JLabel();
		label11 = new JLabel();
		panel1 = new JPanel();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menuItem13 = new JMenuItem();
		menu2 = new JMenu();
		menuItem14 = new JMenuItem();
		menu3 = new JMenu();
		menuItem8 = new JMenuItem();
		menuItem6 = new JMenuItem();
		menuItem15 = new JMenuItem();
		menu4 = new JMenu();
		menuItem9 = new JMenuItem();
		menuItem10 = new JMenuItem();
		menu6 = new JMenu();
		menuItem16 = new JMenuItem();
		menuBar2 = new JMenuBar();
		menu5 = new JMenu();
		menuItem11 = new JMenuItem();
		menuItem12 = new JMenuItem();
		textField2 = new JTextField();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		label2 = new JLabel();
		label3 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		scrollPane2 = new JScrollPane();
		table2 = new JTable();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ADMIN PAGE");
		Container contentPane = getContentPane();

		//======== splitPane1 ========
		{
			splitPane1.setDividerSize(1);
			splitPane1.setLastDividerLocation(1);
			splitPane1.setOneTouchExpandable(true);
			splitPane1.setDividerLocation(180);

			//======== panel2 ========
			{
				panel2.setForeground(Color.red);
				panel2.setBackground(new Color(0, 51, 51));
				panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
				EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing
				.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
				java.awt.Color.red),panel2. getBorder()));panel2. addPropertyChangeListener(new java.beans.PropertyChangeListener()
				{@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
				throw new RuntimeException();}});

				//---- label5 ----
				label5.setText("issue book");
				label5.setForeground(Color.green);
				label5.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label6 ----
				label6.setText("username");
				label6.setForeground(Color.green);
				label6.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label7 ----
				label7.setText("isbn");
				label7.setForeground(Color.green);
				label7.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- button1 ----
				button1.setText("issue");
				button1.setBackground(Color.green);
				button1.setFont(new Font("Tahoma", Font.BOLD, 12));
				button1.setForeground(Color.white);
				button1.addActionListener(e -> button1ActionPerformed(e));

				//---- label8 ----
				label8.setText("return book");
				label8.setForeground(Color.green);
				label8.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label9 ----
				label9.setText("isbn");
				label9.setForeground(Color.green);
				label9.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- button2 ----
				button2.setText("Return");
				button2.setBackground(Color.green);
				button2.setFont(new Font("Tahoma", Font.BOLD, 12));
				button2.setForeground(Color.white);
				button2.addActionListener(e -> button2ActionPerformed(e));

				//---- hSpacer1 ----
				hSpacer1.setBackground(new Color(0, 51, 51));

				//---- label10 ----
				label10.setForeground(Color.red);

				//---- label11 ----
				label11.setForeground(Color.red);

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addComponent(label6)
							.addGroup(panel2Layout.createParallelGroup()
								.addGroup(panel2Layout.createSequentialGroup()
									.addGap(18, 18, 18)
									.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(textField3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label5)
									.addGap(44, 44, 44))))
						.addGroup(panel2Layout.createSequentialGroup()
							.addComponent(label7)
							.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel2Layout.createSequentialGroup()
							.addGroup(panel2Layout.createParallelGroup()
								.addComponent(hSpacer1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(panel2Layout.createSequentialGroup()
									.addGroup(panel2Layout.createParallelGroup()
										.addGroup(panel2Layout.createSequentialGroup()
											.addGap(49, 49, 49)
											.addComponent(label8))
										.addGroup(panel2Layout.createSequentialGroup()
											.addContainerGap()
											.addComponent(label9, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addComponent(textField4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
										.addGroup(panel2Layout.createSequentialGroup()
											.addGap(37, 37, 37)
											.addComponent(button1))
										.addGroup(panel2Layout.createSequentialGroup()
											.addGap(39, 39, 39)
											.addComponent(button2)))
									.addGap(0, 16, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label11, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(16, Short.MAX_VALUE))
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(9, 9, 9)
							.addComponent(label5)
							.addGap(33, 33, 33)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label6)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label7)
								.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(label10)
							.addGap(13, 13, 13)
							.addComponent(button1)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(hSpacer1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(19, 19, 19)
							.addComponent(label8)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label9)
								.addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(label11)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button2)
							.addContainerGap(79, Short.MAX_VALUE))
				);
			}
			splitPane1.setLeftComponent(panel2);

			//======== panel1 ========
			{
				panel1.setBackground(new Color(51, 51, 51));

				//======== menuBar1 ========
				{
					menuBar1.setBackground(new Color(51, 51, 51));
					menuBar1.setForeground(Color.white);

					//======== menu1 ========
					{
						menu1.setText("BOOKS");
						menu1.setForeground(Color.white);

						//---- menuItem1 ----
						menuItem1.setText("add book");
						menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
						menu1.add(menuItem1);

						//---- menuItem2 ----
						menuItem2.setText("update/delete book");
						menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
						menu1.add(menuItem2);

						//---- menuItem13 ----
						menuItem13.setText("view books");
						menuItem13.addActionListener(e -> menuItem13ActionPerformed(e));
						menu1.add(menuItem13);
					}
					menuBar1.add(menu1);

					//======== menu2 ========
					{
						menu2.setText("ACTIONS");
						menu2.setForeground(Color.white);

						//---- menuItem14 ----
						menuItem14.setText("view issued books");
						menuItem14.addActionListener(e -> menuItem14ActionPerformed(e));
						menu2.add(menuItem14);
					}
					menuBar1.add(menu2);

					//======== menu3 ========
					{
						menu3.setText("USERS");
						menu3.setForeground(Color.white);

						//---- menuItem8 ----
						menuItem8.setText("update\\delete user");
						menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
						menu3.add(menuItem8);

						//---- menuItem6 ----
						menuItem6.setText("add user");
						menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
						menu3.add(menuItem6);

						//---- menuItem15 ----
						menuItem15.setText("view users");
						menuItem15.addActionListener(e -> menuItem15ActionPerformed(e));
						menu3.add(menuItem15);
					}
					menuBar1.add(menu3);

					//======== menu4 ========
					{
						menu4.setText("HELP");
						menu4.setForeground(Color.white);

						//---- menuItem9 ----
						menuItem9.setText(" about developer");
						menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
						menu4.add(menuItem9);

						//---- menuItem10 ----
						menuItem10.setText("help");
						menuItem10.addActionListener(e -> menuItem10ActionPerformed(e));
						menu4.add(menuItem10);
					}
					menuBar1.add(menu4);

					//======== menu6 ========
					{
						menu6.setText("home");
						menu6.setForeground(Color.white);

						//---- menuItem16 ----
						menuItem16.setText("login page");
						menuItem16.addActionListener(e -> menuItem3ActionPerformed(e));
						menu6.add(menuItem16);
					}
					menuBar1.add(menu6);
				}

				//======== menuBar2 ========
				{
					menuBar2.setBackground(new Color(51, 51, 51));

					//======== menu5 ========
					{
						menu5.setText("search");
						menu5.setForeground(Color.white);
						menu5.setBackground(new Color(51, 51, 51));

						//---- menuItem11 ----
						menuItem11.setText("book");
						menuItem11.addActionListener(e -> menuItem11ActionPerformed(e));
						menu5.add(menuItem11);

						//---- menuItem12 ----
						menuItem12.setText("student");
						menuItem12.addActionListener(e -> menuItem12ActionPerformed(e));
						menu5.add(menuItem12);
					}
					menuBar2.add(menu5);
				}

				//---- textField2 ----
				textField2.setToolTipText("search");

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setUpdateSelectionOnSort(false);
					table1.setVerifyInputWhenFocusTarget(false);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					table1.setFocusable(false);
					table1.setAutoCreateRowSorter(true);
					table1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							table1MouseClicked(e);
						}
					});
					scrollPane1.setViewportView(table1);
				}

				//---- label2 ----
				label2.setText("BOOKS");
				label2.setForeground(Color.green);
				label2.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label3 ----
				label3.setText("STUDENTS");
				label3.setForeground(Color.green);
				label3.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label12 ----
				label12.setText("welcome,");
				label12.setForeground(Color.green);
				label12.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label13 ----
				label13.setForeground(Color.green);
				label13.setFont(new Font("Tahoma", Font.BOLD, 12));
				label13.setText("usename");

				//---- label14 ----
				label14.setText("user Id:");
				label14.setForeground(Color.green);
				label14.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label15 ----
				label15.setText("id");
				label15.setForeground(Color.green);
				label15.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label16 ----
				label16.setText("Last Login:");
				label16.setForeground(Color.green);
				label16.setFont(new Font("Tahoma", Font.BOLD, 12));

				//---- label17 ----
				label17.setText("date");
				label17.setForeground(Color.green);
				label17.setFont(new Font("Tahoma", Font.BOLD, 12));

				//======== scrollPane2 ========
				{

					//---- table2 ----
					table2.setUpdateSelectionOnSort(false);
					table2.setVerifyInputWhenFocusTarget(false);
					table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					table2.setFocusable(false);
					table2.setAutoCreateRowSorter(true);
					table2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							table2MouseClicked(e);
						}
					});
					scrollPane2.setViewportView(table2);
				}

				GroupLayout panel1Layout = new GroupLayout(panel1);
				panel1.setLayout(panel1Layout);
				panel1Layout.setHorizontalGroup(
					panel1Layout.createParallelGroup()
						.addGroup(panel1Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel1Layout.createParallelGroup()
								.addGroup(panel1Layout.createSequentialGroup()
									.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
									.addComponent(label12)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(label13)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label16)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(menuBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(51, 51, 51))
								.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
									.addComponent(scrollPane1)
									.addGap(10, 10, 10))
								.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
									.addGroup(panel1Layout.createParallelGroup()
										.addGroup(panel1Layout.createSequentialGroup()
											.addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(panel1Layout.createSequentialGroup()
											.addComponent(label14)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(label15)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
											.addComponent(label2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
											.addGap(0, 163, Short.MAX_VALUE)))
									.addGroup(panel1Layout.createParallelGroup()
										.addGroup(panel1Layout.createSequentialGroup()
											.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addGap(108, 108, 108))
										.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
											.addComponent(label17, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())))
								.addGroup(panel1Layout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(369, Short.MAX_VALUE))))
				);
				panel1Layout.setVerticalGroup(
					panel1Layout.createParallelGroup()
						.addGroup(panel1Layout.createSequentialGroup()
							.addGroup(panel1Layout.createParallelGroup()
								.addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(menuBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18, 18, 18)
							.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label12)
								.addComponent(label13)
								.addComponent(label16))
							.addGroup(panel1Layout.createParallelGroup()
								.addGroup(panel1Layout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(panel1Layout.createParallelGroup()
										.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label14)
											.addComponent(label15))
										.addComponent(label17)))
								.addGroup(panel1Layout.createSequentialGroup()
									.addGap(15, 15, 15)
									.addComponent(label2)))
							.addGap(9, 9, 9)
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label3)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(19, 19, 19))
				);
			}
			splitPane1.setRightComponent(panel1);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
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
	private JTextField textField1;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField3;
	private JButton button1;
	private JTextField textField4;
	private JLabel label8;
	private JLabel label9;
	private JButton button2;
	private JPanel hSpacer1;
	private JLabel label10;
	private JLabel label11;
	private JPanel panel1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem13;
	private JMenu menu2;
	private JMenuItem menuItem14;
	private JMenu menu3;
	private JMenuItem menuItem8;
	private JMenuItem menuItem6;
	private JMenuItem menuItem15;
	private JMenu menu4;
	private JMenuItem menuItem9;
	private JMenuItem menuItem10;
	private JMenu menu6;
	private JMenuItem menuItem16;
	private JMenuBar menuBar2;
	private JMenu menu5;
	private JMenuItem menuItem11;
	private JMenuItem menuItem12;
	private JTextField textField2;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JScrollPane scrollPane2;
	private JTable table2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

