package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Works {

	public JFrame frame;
	private JTextField worknameinput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Works window = new Works();
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
	public Works() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 694, 522);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner pricespinner = new JSpinner();
		pricespinner.setModel(new SpinnerNumberModel(new Integer(3000), new Integer(3000), null, new Integer(100)));
		pricespinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pricespinner.setBounds(181, 259, 171, 36);
		frame.getContentPane().add(pricespinner);
		
		JLabel priceUnitlbl = new JLabel("TL");
		priceUnitlbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		priceUnitlbl.setBounds(378, 263, 111, 31);
		frame.getContentPane().add(priceUnitlbl);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 680, 102);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Work");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 26, 670, 46);
		panel.add(lblNewLabel);
		
		JLabel worknamelbl = new JLabel("Work Name");
		worknamelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		worknamelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		worknamelbl.setBounds(23, 151, 137, 47);
		frame.getContentPane().add(worknamelbl);
		
		JLabel workpricelbl = new JLabel("Price Of Work");
		workpricelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		workpricelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		workpricelbl.setBounds(23, 249, 137, 47);
		frame.getContentPane().add(workpricelbl);
		
		worknameinput = new JTextField();
		worknameinput.setForeground(Color.WHITE);
		worknameinput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		worknameinput.setBackground(Color.LIGHT_GRAY);
		worknameinput.setBounds(181, 151, 446, 47);
		frame.getContentPane().add(worknameinput);
		worknameinput.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Work\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create connection:
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sql = "insert into work_tb(work_name , work_price ) values (? , ? )";
					String workName = worknameinput.getText();
					int workPrice = (Integer)pricespinner.getValue();
					
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, workName);
					st.setInt(2, workPrice);
					
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame, "Added New Work To Data Base");
					con.close();
								
					
				}
				catch(Exception eworkcreation) {
					JOptionPane.showMessageDialog(frame, "Error Is : "+ eworkcreation);
				}
				
				
				
			}
		});
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(23, 341, 610, 47);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Back To Main Page");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				
				
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		
	}
}
