package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends JFrame implements ActionListener
{
	
	public Home()
	{
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/front.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1400, 650);
		add(image);
		
		JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
		heading.setBounds(400, 40, 1000, 40);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
		image.add(heading);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu details = new JMenu("Details");
		menubar.add(details);
		
		JMenuItem flightDetails = new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		
		JMenuItem customerDetails = new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		
		JMenuItem reservationDetails = new JMenuItem("Book Flight");
		reservationDetails.addActionListener(this);
		details.add(reservationDetails);
		
		JMenuItem journeyDetails = new JMenuItem("Journey Details");
		journeyDetails.addActionListener(this);
		details.add(journeyDetails);
		
		JMenuItem ticketCancellation = new JMenuItem("Ticket Cancellation");
		ticketCancellation.addActionListener(this);
		details.add(ticketCancellation);
		
		JMenu ticket = new JMenu("Ticket");
		menubar.add(ticket);
		
		JMenuItem boardingPass = new JMenuItem("Boarding Pass");
		boardingPass.addActionListener(this);
		ticket.add(boardingPass);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocation(400, 250);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		if(text.equals("Add Customer Details")) {
			new AddCustomer();
		}
		else if(text.equals("Flight Details")) {
			new Flight_info();
		}else if(text.equals("Book Flight")) {
			new BookFlight();
		}else if(text.equals("Journey Details")) {
			new JourneyDetails();
		}else if(text.equals("Ticket Cancellation")){
			new Cancel();
		}else if(text.equals("Boarding Pass")) {
			new BoardingPass();
		}
	}
	public static void main(String[] args)
	{
		new Home();
	}
}
