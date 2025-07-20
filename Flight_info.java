package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Flight_info extends JFrame
{

	public Flight_info()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Flight Details");
		heading.setBounds(280, 20, 300,45);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Tahoma", Font.BOLD, 36));
		add(heading);
		
		JTable table = new JTable();
		
		try {
			
			Conn conn = new Conn();
			
			ResultSet rs = conn.s.executeQuery("select * from flight");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 80, 800, 500);
		add(jsp);
		
		setSize(800, 500);
		setLocation(200, 100);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Flight_info();
	}
}
