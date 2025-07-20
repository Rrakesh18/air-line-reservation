package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BoardingPass extends JFrame implements ActionListener
{
	JButton fetchdetails;
	JTextField tfpnr;
	JLabel labelname, labelnationality, labelsrc, labeldestination, labelfname, labelfcode, labelddate;

	public BoardingPass() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("AIR INDIA");
		heading.setBounds(300, 20, 500, 35);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(heading);
		
		JLabel subheading = new JLabel("Boarding Pass");
		subheading.setBounds(300, 65, 500, 25);
		subheading.setForeground(Color.BLACK);
		subheading.setFont(new Font("Tahoma", Font.PLAIN, 26));
		add(subheading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/airindia.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(440, 00, 300, 300);
		add(lblimage);
		
		
		JLabel lblpnr = new JLabel("PNR DETAILS");
		lblpnr.setBounds(50, 100, 200, 20);
		lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblpnr);
		
		tfpnr = new JTextField();
		tfpnr.setBounds(180, 100, 150, 20);
		add(tfpnr);
		
		fetchdetails = new JButton("Fetch");
		fetchdetails.setBounds(350, 100, 100, 20);
		fetchdetails.setBackground(Color.BLACK);
		fetchdetails.setForeground(Color.WHITE);
		fetchdetails.addActionListener(this);
		add(fetchdetails);
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(50, 130, 200, 20);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblname);
		
		labelname = new JLabel();
		labelname.setBounds(180, 130, 200, 20);
		add(labelname);
		
		JLabel lblnationality = new JLabel("NATIONALITY");
		lblnationality.setBounds(50, 160, 200, 20);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblnationality);
		
		labelnationality = new JLabel();
		labelnationality.setBounds(180, 160, 200, 20);
		add(labelnationality);
		
		JLabel lblsrc = new JLabel("SRC");
		lblsrc.setBounds(50, 250, 200, 20);
		lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblsrc);
		
		labelsrc = new JLabel();
		labelsrc.setBounds(180, 250, 200, 20);
		add(labelsrc);
		
		JLabel lbldest = new JLabel("DEST");
		lbldest.setBounds(350, 250, 200, 20);
		lbldest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lbldest);
		
		labeldestination = new JLabel();
		labeldestination.setBounds(500, 250, 200, 20);
		add(labeldestination);
		
		JLabel lblfname = new JLabel("FLIGHT NAME");
		lblfname.setBounds(50, 220, 100, 20);
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblfname);
		
		labelfname = new JLabel();
		labelfname.setBounds(180, 220, 100, 20);
		add(labelfname);
		
		JLabel lblfcode = new JLabel("FLIGHT CODE");
		lblfcode.setBounds(350, 220, 200, 20);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblfcode);
		
		labelfcode = new JLabel();
		labelfcode.setBounds(500, 220, 200, 20);
		add(labelfcode);
		
		JLabel lblddate = new JLabel("DATE");
		lblddate.setBounds(50, 190, 200, 20); //50, 250, 200, 20
		lblddate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblddate);
		
		labelddate = new JLabel();
		labelddate.setBounds(180, 190, 100, 20); //280, 250, 200, 20
		add(labelddate);
		
		
		setSize(800, 400);
		setLocation(300,150);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String pnr = tfpnr.getText();
		
		if(ae.getSource() == fetchdetails)
		{
			try {
				
				Conn conn = new Conn();
				String query = "select * from reservation where PNR = '"+pnr+"'";
				ResultSet rs = conn.s.executeQuery(query);
				
				if(rs.next()) {
					labelname.setText(rs.getString("name"));
					labelnationality.setText(rs.getString("nationality"));
					labelsrc.setText(rs.getString("src"));
					labeldestination.setText(rs.getString("dest"));
					labelfname.setText(rs.getString("flightname"));
					labelfcode.setText(rs.getString("flightcode"));
					labelddate.setText(rs.getString("ddate"));
				}else {
					JOptionPane.showMessageDialog(null, "Please enter correct PNR");
					setVisible(false);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new BoardingPass();
	}
	
}
