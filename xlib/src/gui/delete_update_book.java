

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Mar 14 09:52:48 EAT 2021
 */



/**
 * @author pius
 */
public class delete_update_book extends JPanel {
	public delete_update_book() {
		initComponents();
	}
	public void clear(){
		textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			textField5.setText("");
	}
	public void setData(String id,String isbn,String title,String author,String publisher){
		textField1.setText(isbn);
		textField2.setText(title);
		textField3.setText(author);
		textField4.setText(publisher);
		textField5.setText(id);

}
	public void collectedData(){
		String operation= (String) comboBox1.getSelectedItem();
		String id =textField5.getText();
		String isbn=textField1.getText();
		String title=textField2.getText();
		String author=textField3.getText();
		String publisher=textField4.getText();
				if(operation=="delete" && controller.delete_book(id)){
			JOptionPane.showMessageDialog(null, "deleted");
			clear();
		}
		if(operation=="update" && controller.update_book(id, isbn, title, author, publisher)){
			JOptionPane.showMessageDialog(null, "updated");
			clear();
			
			
		}
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - pius
		label1 = new JLabel();
		ISBN = new JLabel();
		TITLE = new JLabel();
		ISBN3 = new JLabel();
		ISBN2 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		comboBox1 = new JComboBox<>();
		label2 = new JLabel();
		ISBN4 = new JLabel();
		textField5 = new JTextField();

		//======== this ========
		setBackground(new Color(102, 102, 102));
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
		. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
		. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
		12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
		. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
		getPropertyName () )) throw new RuntimeException( ); }} );

		//---- label1 ----
		label1.setText("update or delete book");
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

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"update",
			"delete"
		}));

		//---- label2 ----
		label2.setText("select action");
		label2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label2.setForeground(Color.white);

		//---- ISBN4 ----
		ISBN4.setText("id");
		ISBN4.setFont(new Font("Tahoma", Font.BOLD, 15));
		ISBN4.setForeground(Color.white);

		//---- textField5 ----
		textField5.setEditable(false);
		textField5.setEnabled(false);

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addComponent(ISBN3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(ISBN2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(TITLE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(ISBN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(ISBN4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup()
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addComponent(textField4, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addComponent(textField3, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addComponent(label2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(116, 116, 116))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(label1)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(ISBN4, GroupLayout.Alignment.TRAILING))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN))
					.addGap(18, 18, 18)
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
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2))
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - pius
	private JLabel label1;
	private JLabel ISBN;
	private JLabel TITLE;
	private JLabel ISBN3;
	private JLabel ISBN2;
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public JTextField textField4;
	private JComboBox<String> comboBox1;
	private JLabel label2;
	private JLabel ISBN4;
	public JTextField textField5;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
