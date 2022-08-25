package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Start {

	public JFrame frame;
	private JTextField logusername;
	private JPasswordField logpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 970, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Posts System Of G\u00F6rsel Pro Dersi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(62, 40, 801, 102);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login To System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(341, 141, 251, 75);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsername.setBounds(59, 220, 239, 75);
		frame.getContentPane().add(lblUsername);
		
		logusername = new JTextField();
		logusername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		logusername.setBounds(272, 220, 392, 75);
		frame.getContentPane().add(logusername);
		logusername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(37, 315, 239, 75);
		frame.getContentPane().add(lblPassword);
		
		logpassword = new JPasswordField();
		logpassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		logpassword.setBounds(272, 315, 392, 75);
		frame.getContentPane().add(logpassword);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usrname = logusername.getText();
				String pass = String.valueOf(logpassword.getPassword());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String centerQuery = "select * from users where user_name = '"+ usrname+"';";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(centerQuery);
					if (rs.first()) {
						MainCargoCenter mcc = new MainCargoCenter();
						mcc.frmCargosystem.show();
						frame.dispose();
					}
					else {
						System.out.print("You Have Error IN UserName Or Password");
					}
					
					con.close();
					
					
				}
				catch(Exception elogin) {
					JOptionPane.showMessageDialog(frame, "Error In Login");
				}
				
				
				
				
				
			}
		});
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loginbtn.setBackground(Color.YELLOW);
		loginbtn.setBounds(272, 416, 392, 80);
		frame.getContentPane().add(loginbtn);
	}
}
