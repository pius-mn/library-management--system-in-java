

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
/*
 * Created by JFormDesigner on Fri Mar 12 16:28:12 EAT 2021
 */



/**
 * @author pius
 */
public class addbook extends JPanel {
	public addbook() {
		initComponents();
	}
	public void collectedData(){
		String isbn=textField1.getText();
		String title=textField2.getText();
		String author= textField3.getText();
		String publisher= textField4.getText();
	
		if(controller.isbnValidate(isbn)){
			JOptionPane.showMessageDialog(null, isbn+ " Already exists!\n Try again!");
		}else{
		if(controller.booksave(isbn, title, author, publisher)){
			JOptionPane.showMessageDialog(null, " BOOK ADDED SUCCESSFULLY!!");
		}
	}
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Pius
		label1 = new JLabel();
		ISBN = new JLabel();
		TITLE = new JLabel();
		ISBN3 = new JLabel();
		ISBN2 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		label2 = new JLabel();

		//======== this ========
		setBackground(new Color(102, 102, 102));
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
		( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
		. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
		. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
		propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
		; }} );

		//---- label1 ----
		label1.setText("ADD BOOK");
		label1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label1.setForeground(Color.white);

		//---- ISBN ----
		ISBN.setText("ISBN");
		ISBN.setFont(new Font("Tahoma", Font.BOLD, 15));
		ISBN.setForeground(Color.white);

		//---- TITLE ----
		TITLE.setText("TITLE");
		TITLE.setFont(new Font("Tahoma", Font.BOLD, 15));
		TITLE.setForeground(Color.white);

		//---- ISBN3 ----
		ISBN3.setText("AUTHOR");
		ISBN3.setFont(new Font("Tahoma", Font.BOLD, 15));
		ISBN3.setForeground(Color.white);

		//---- ISBN2 ----
		ISBN2.setText("PUBLISHER");
		ISBN2.setFont(new Font("Tahoma", Font.BOLD, 15));
		ISBN2.setForeground(Color.white);

		//---- label2 ----
		label2.setBackground(new Color(102, 102, 102));
		label2.setForeground(Color.red);
		label2.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(ISBN3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ISBN2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(TITLE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ISBN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup()
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addComponent(textField4, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addComponent(textField3, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addGap(173, 173, 173)
					.addComponent(label2, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addGap(26, 26, 26)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label2)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(TITLE)
						.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGap(9, 9, 9)
							.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(18, 18, 18)
							.addComponent(ISBN3)))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup()
						.addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN2))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Pius
	private JLabel label1;
	private JLabel ISBN;
	private JLabel TITLE;
	private JLabel ISBN3;
	private JLabel ISBN2;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
