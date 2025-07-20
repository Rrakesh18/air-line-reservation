package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener
{
	JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone;
	JRadioButton  rbmale, rbfemale;
	
	public AddCustomer()
	{
	
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(250, 20, 500, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 36));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(50, 100, 150, 25);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setForeground(Color.BLACK);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(250, 100, 200, 25);
		add(tfname);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(50, 150, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnationality.setForeground(Color.BLACK);
		add(lblnationality);
		
		tfnationality = new JTextField();
		tfnationality.setBounds(250, 150, 200, 25);
		add(tfnationality);
		
		JLabel lblaadhar = new JLabel("Aadhar Number");
		lblaadhar.setBounds(50, 200, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaadhar.setForeground(Color.BLACK);
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(250, 200, 200, 25);
		add(tfaadhar);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(50, 250, 150, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbladdress.setForeground(Color.BLACK);
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(250, 250, 200, 25);
		add(tfaddress);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(50, 300, 150, 25);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblgender.setForeground(Color.BLACK);
		add(lblgender);
		
		ButtonGroup gendergroup = new ButtonGroup();
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(250, 300, 70, 25);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(400, 300, 70, 25);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);
		
		JLabel lblphone = new JLabel("Phone Number");
		lblphone.setBounds(50, 350, 150, 25);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblphone.setForeground(Color.BLACK);
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(250, 350, 200, 25);
		add(tfphone);
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/emp.png"));
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(500, 80, 280, 400);
		add(lblimage);
		
		JButton save = new JButton("SAVE");
		save.setBackground(Color.black);
		save.setForeground(Color.WHITE);
		save.setBounds(100, 400, 200, 35);
		save.addActionListener(this);
		add(save);
		
		setSize(900, 600);
		setLocation(200, 50);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = tfname.getText();
		String nationality = tfnationality.getText();
		String aadhar = tfaadhar.getText();
		String address = tfaddress.getText();
		String gender = null;
		if(rbmale.isSelected()) {
			gender = "Male";
		}
		else
			gender = "Female";
		String phone = tfphone.getText();
		
		
		try {
			
			Conn conn = new Conn();
			
			String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+aadhar+"', '"+address+"', '"+gender+"', '"+phone+"')";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
			setVisible(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new AddCustomer();
	}
}
