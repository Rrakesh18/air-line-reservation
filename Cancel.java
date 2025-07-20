package airlinemanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Cancel extends JFrame implements ActionListener
{
	JLabel tfname, cancellation_no, tfcode, lbldate_of_travel, labelfname, labelfcode;
	JTextField  tfpnr;
	JButton bookflight, fetchButton, cancel;
	

	public Cancel()
	{ 

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		Random random = new Random();
		
		JLabel heading = new JLabel("CANCELLATION");
		heading.setBounds(200, 20, 300, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 32));
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("airlinemanagementsystem/Icons/cancel.jpg")));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(450, 140, 250, 250);
		add(image);

		JLabel lblpnr = new JLabel("PNR");
		lblpnr.setBounds(50, 100, 150, 25);
		lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpnr.setForeground(Color.BLACK);
		add(lblpnr);

		tfpnr = new JTextField();
		tfpnr.setBounds(250, 100, 150, 25);
		add(tfpnr);

		fetchButton = new JButton("Show Details");
		fetchButton.setBackground(Color.BLACK);
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setBounds(430, 100, 120, 25);
		fetchButton.addActionListener(this);
		add(fetchButton);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(50, 200, 150, 25);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setForeground(Color.BLACK);
		add(lblname);

		tfname = new JLabel();
		tfname.setBounds(250, 200, 200, 25);
		add(tfname);

		JLabel lblcancellation_no = new JLabel("Cancellation No");
		lblcancellation_no.setBounds(50, 150, 150, 25);
		lblcancellation_no.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblcancellation_no.setForeground(Color.BLACK);
		add(lblcancellation_no);

		cancellation_no = new JLabel(""+random.nextInt(1000000));
		cancellation_no.setBounds(250, 150, 200, 25);
		add(cancellation_no);


		JLabel lblfcode = new JLabel("Flight Code");
		lblfcode.setBounds(50, 250, 150, 25);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblfcode.setForeground(Color.BLACK);
		add(lblfcode);

		tfcode = new JLabel();
		tfcode.setBounds(250, 250, 200, 25);
		add(tfcode);

		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(50, 300, 150, 25);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);

		lbldate_of_travel = new JLabel();
		lbldate_of_travel.setBounds(250, 300, 200, 25);
		add(lbldate_of_travel);

		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(300, 400, 100, 25);
		cancel.addActionListener(this);
		add(cancel);


		setSize(800, 500);
		setLocation(250, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == fetchButton)
		{
			String pnr = tfpnr.getText();
			try {

				Conn conn = new Conn();

				String query = "select * from reservation where PNR = '"+pnr+"'";

				ResultSet rs = conn.s.executeQuery(query);
				
				if(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfcode.setText(rs.getString("flightcode"));
					lbldate_of_travel.setText(rs.getString("ddate"));
					JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				}else
					JOptionPane.showMessageDialog(null, "Please enter correct PNR");
					
				
				//JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}else if(ae.getSource() == cancel) {
			String name = tfname.getText();
			String pnr = tfpnr.getText();
			String cancel_no = cancellation_no.getText();
			String fcode = tfcode.getText();
			String ddate = lbldate_of_travel.getText();
			
			try {
				Conn conn = new Conn();
				
				String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancel_no+"', '"+fcode+"', '"+ddate+"')";
				
				conn.s.executeUpdate(query);
				
				conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
				
				JOptionPane.showMessageDialog(null, "Ticket cancelled");
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

	public static void main(String[] args)
	{
		new Cancel();
	}
}
