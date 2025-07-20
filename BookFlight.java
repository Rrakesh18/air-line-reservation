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

public class BookFlight extends JFrame implements ActionListener
{
	JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
	JTextField  tfaadhar;
	JButton bookflight, fetchButton, flight;
	Choice source, destination;
	JDateChooser dcdate;

	public BookFlight()
	{ 

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("Book Flight");
		heading.setBounds(420, 20, 500, 45);
		heading.setFont(new Font("Tahoma", Font.BOLD, 32));
		heading.setForeground(Color.BLUE);
		add(heading);

		JLabel lblaadhar = new JLabel("Aadhar");
		lblaadhar.setBounds(50, 100, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaadhar.setForeground(Color.BLACK);
		add(lblaadhar);

		tfaadhar = new JTextField();
		tfaadhar.setBounds(250, 100, 150, 25);
		add(tfaadhar);

		fetchButton = new JButton("Fetch User");
		fetchButton.setBackground(Color.BLACK);
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setBounds(410, 100, 120, 25);
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

		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(50, 150, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnationality.setForeground(Color.BLACK);
		add(lblnationality);

		tfnationality = new JLabel();
		tfnationality.setBounds(250, 150, 200, 25);
		add(tfnationality);


		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(50, 250, 150, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbladdress.setForeground(Color.BLACK);
		add(lbladdress);

		tfaddress = new JLabel();
		tfaddress.setBounds(250, 250, 200, 25);
		add(tfaddress);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(50, 300, 150, 25);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblgender);

		labelgender = new JLabel("Gender");
		labelgender.setBounds(250, 300, 200, 25);
		add(labelgender);

		JLabel lblsource = new JLabel("Source");
		lblsource.setBounds(50, 350, 150, 25);
		lblsource.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblsource);

		source = new Choice();
		source.setBounds(250, 350, 150, 25);
		add(source);

		JLabel lbldest = new JLabel("Destination");
		lbldest.setBounds(50, 400, 150, 25);
		lbldest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldest);

		destination = new Choice();
		destination.setBounds(250, 400, 150, 25);
		add(destination);

		try {
			Conn c = new Conn();
			String query = "Select * from flight";
			ResultSet rs = c.s.executeQuery(query);

			while(rs.next()) {
				source.add(rs.getString("source"));
				destination.add(rs.getString("destination"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		flight = new JButton("Fetch Flights");
		flight.setBackground(Color.black);
		flight.setForeground(Color.WHITE);
		flight.setBounds(410, 400, 120, 20);
		flight.addActionListener(this);
		add(flight);

		JLabel lblfname = new JLabel("Flight Name");
		lblfname.setBounds(50, 450, 150, 25);
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfname);

		labelfname = new JLabel();
		labelfname.setBounds(250, 450, 200, 25);
		add(labelfname);

		JLabel lblfcode = new JLabel("Flight Code");
		lblfcode.setBounds(50, 500, 150, 25);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfcode);

		labelfcode = new JLabel();
		labelfcode.setBounds(250, 500, 200, 25);
		add(labelfcode);

		JLabel lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(500, 480, 150, 25);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);

		dcdate = new JDateChooser();
		dcdate.setBounds(650, 480, 200, 25);
		add(dcdate);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/details.jpg"));
		Image i2 = i1.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(550, 80, 450, 410);
		add(lblimage);

		bookflight = new JButton("Book Flight");
		bookflight.setBackground(Color.BLACK);
		bookflight.setForeground(Color.WHITE);
		bookflight.setBounds(350, 550, 100, 35);
		bookflight.addActionListener(this);
		add(bookflight);

		setSize(1000, 700);
		setLocation(100, 20);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == fetchButton)
		{
			String aadhar = tfaadhar.getText();
			try {

				Conn conn = new Conn();

				String query = "select * from passenger where aadhar = '"+aadhar+"'";

				ResultSet rs = conn.s.executeQuery(query);
				
				if(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfnationality.setText(rs.getString("nationality"));
					tfaddress.setText(rs.getString("address"));
					labelgender.setText(rs.getString("gender"));
				}else
					JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
					
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				//setVisible(true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(ae.getSource() == flight)
		{
			String src = source.getSelectedItem();
			String dest = destination.getSelectedItem();
			try {

				Conn conn = new Conn();

				String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

				ResultSet rs = conn.s.executeQuery(query);

				if(rs.next()) {
					labelfname.setText(rs.getString("f_name"));
					labelfcode.setText(rs.getString("f_code"));
					
				}else
					JOptionPane.showMessageDialog(null, "No Flights Found");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == bookflight){
			
			Random random = new Random();
			
			String aadhar = tfaadhar.getText();
			String name = tfname.getText();
			String nationality = tfnationality.getText();
			String flightname = labelfname.getText();
			String flightcode = labelfcode.getText();
			String src = source.getSelectedItem();
			String dest = destination.getSelectedItem();
			String ddate = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
			
			try {

				Conn conn = new Conn();

				String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"',  '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+dest+"', '"+ddate+"')";

				conn.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Ticket Booked Successflly");
				
				setVisible(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args)
	{
		new BookFlight();
	}
}
