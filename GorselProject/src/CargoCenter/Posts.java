package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Posts {

	public JFrame frame;
	private JTextField senderName;
	private JTextField reciverName;
	private JTable addressTableSender;
	private JTable addressTableReciver;
	private JTextField aboutPost;
	private JTextField sendingDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Posts window = new Posts();
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
	public Posts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1515, 917);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1501, 127);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Create Post Page");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 20, 1007, 83);
		panel.add(lblNewLabel_1);
		
		senderName = new JTextField();
		senderName.setBounds(128, 148, 339, 50);
		frame.getContentPane().add(senderName);
		senderName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sender");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 154, 108, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblReciver = new JLabel("Reciver");
		lblReciver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReciver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReciver.setBounds(567, 154, 108, 31);
		frame.getContentPane().add(lblReciver);
		
		reciverName = new JTextField();
		reciverName.setColumns(10);
		reciverName.setBounds(685, 148, 339, 50);
		frame.getContentPane().add(reciverName);
		
		JLabel lblSenderAddress = new JLabel("Sender Address");
		lblSenderAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenderAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenderAddress.setBounds(59, 280, 144, 31);
		frame.getContentPane().add(lblSenderAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 316, 407, 300);
		frame.getContentPane().add(scrollPane);
		
		addressTableSender = new JTable();
		addressTableSender.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "City", "Street", "Building", "Home Number", "Other"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(addressTableSender);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addresses ad = new Addresses();
				ad.frame.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(502, 251, 58, 50);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(613, 316, 411, 300);
		frame.getContentPane().add(scrollPane_1);
		
		addressTableReciver = new JTable();
		addressTableReciver.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "City", "Street", "Building", "Home Number", "Other"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(addressTableReciver);
		
		JLabel lblReciverAddress = new JLabel("Reciver Address");
		lblReciverAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblReciverAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReciverAddress.setBounds(613, 280, 144, 31);
		frame.getContentPane().add(lblReciverAddress);
		
		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
//					usersTable.setEditingRow(0);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					Statement st = con.createStatement();
					String sql = "select * from address";
					ResultSet rs = st.executeQuery(sql);
					DefaultTableModel tablemodelSender = (DefaultTableModel) addressTableSender.getModel();
					DefaultTableModel tablemodelReciver = (DefaultTableModel) addressTableReciver.getModel();
					tablemodelSender.setRowCount(0);
					tablemodelReciver.setRowCount(0);
					
					
					while (rs.next()) {
						String id = String.valueOf(rs.getInt("address_id"));
						String city = rs.getString("city");
						String street = rs.getString("street");
						String building = rs.getString("building");
						String homeNumber = rs.getString("home_number");
						String other = rs.getString("other");
						
						String dataList[] = {id,city , street, building , homeNumber, other};
						
						
						tablemodelSender.addRow(dataList);
						tablemodelReciver.addRow(dataList);
//						
						
						
					}
					
					con.close();
					
					
					
				}
				catch(Exception erefreshaddress) {
					System.out.println("Have a Error : "+ erefreshaddress.getMessage());
				}
				
				
			}
		});
		btnR.setForeground(Color.BLACK);
		btnR.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnR.setBackground(Color.YELLOW);
		btnR.setBounds(502, 315, 58, 50);
		frame.getContentPane().add(btnR);
		
		JComboBox citycbox = new JComboBox();
		
		citycbox.setBounds(59, 208, 192, 50);
		frame.getContentPane().add(citycbox);
		
		JComboBox streetcbox = new JComboBox();
		streetcbox.setBounds(278, 208, 192, 50);
		frame.getContentPane().add(streetcbox);
		
		JComboBox streetcbox1 = new JComboBox();
		streetcbox1.setBounds(832, 208, 192, 50);
		frame.getContentPane().add(streetcbox1);
		
		JComboBox citycbox1 = new JComboBox();
		
		citycbox1.setBounds(613, 208, 192, 50);
		frame.getContentPane().add(citycbox1);
		
		JLabel lblAboutPost = new JLabel("About  Post");
		lblAboutPost.setHorizontalAlignment(SwingConstants.LEFT);
		lblAboutPost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAboutPost.setBounds(60, 626, 144, 31);
		frame.getContentPane().add(lblAboutPost);
		
		JSpinner price = new JSpinner();
		price.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		price.setFont(new Font("Tahoma", Font.PLAIN, 18));
		price.setBounds(727, 665, 293, 67);
		frame.getContentPane().add(price);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(613, 683, 98, 31);
		frame.getContentPane().add(lblPrice);
		
		JSpinner status = new JSpinner();
		status.setModel(new SpinnerListModel(new String[] {"Being Sent", "Sent Delivered Handed"}));
		status.setFont(new Font("Tahoma", Font.PLAIN, 18));
		status.setBounds(727, 748, 293, 67);
		frame.getContentPane().add(status);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(613, 766, 98, 31);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblSendedCenter = new JLabel("Sended Center");
		lblSendedCenter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSendedCenter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSendedCenter.setBounds(1091, 154, 159, 31);
		frame.getContentPane().add(lblSendedCenter);
		
		JComboBox sendedcenter = new JComboBox();
		sendedcenter.setBounds(1129, 191, 313, 50);
		frame.getContentPane().add(sendedcenter);
		
		JLabel lblRecivedCenter = new JLabel("Recived Center");
		lblRecivedCenter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecivedCenter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecivedCenter.setBounds(1091, 251, 159, 31);
		frame.getContentPane().add(lblRecivedCenter);
		
		JComboBox recivedcenter = new JComboBox();
		recivedcenter.setBounds(1129, 288, 313, 50);
		frame.getContentPane().add(recivedcenter);
		
		JLabel lblDateOfSending = new JLabel("Date Of Sending");
		lblDateOfSending.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfSending.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfSending.setBounds(1085, 357, 159, 31);
		frame.getContentPane().add(lblDateOfSending);
		
		JButton createNewPost = new JButton("Create Post");
		
		createNewPost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		createNewPost.setForeground(Color.WHITE);
		createNewPost.setBackground(new Color(50, 205, 50));
		createNewPost.setBounds(1129, 524, 322, 208);
		frame.getContentPane().add(createNewPost);
		
		aboutPost = new JTextField();
		aboutPost.setBounds(61, 677, 406, 120);
		frame.getContentPane().add(aboutPost);
		aboutPost.setColumns(10);
		
		sendingDate = new JTextField();
		sendingDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sendingDate.setBounds(1108, 398, 339, 67);
		frame.getContentPane().add(sendingDate);
		sendingDate.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Go Back To Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCargoCenter mc = new MainCargoCenter();
				mc.frmCargosystem.show();
				frame.dispose();
				
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
			
			String sqlcity ="select city from address ";
			PreparedStatement stcity = con.prepareStatement(sqlcity);
			ResultSet rscity = stcity.executeQuery(sqlcity);
			while (rscity.next()) {
				String city = rscity.getString("city");
				citycbox.addItem(city);
				citycbox1.addItem(city);
			}
			con.close();
			
		}
		catch(Exception emainaddredd) {
			JOptionPane.showMessageDialog(frame, emainaddredd.getMessage());
		}
		sendedcenter.removeAllItems();
		String selectedCity =citycbox1.getSelectedItem().toString();
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
			 String sqlcenter="select center_name from work_center;";
			 
			 PreparedStatement stcenter =con.prepareStatement(sqlcenter);
			 ResultSet rscenter = stcenter.executeQuery(sqlcenter);
			 while(rscenter.next()) { 
				 String center = rscenter.getString("center_name");
				 sendedcenter.addItem(center);
				 recivedcenter.addItem(center);
				 } 
			 
//			
				con.close();
			}
		catch(Exception ee) 
		{
			System.out.println(ee); 
		}
		
		
		
		
		citycbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				streetcbox.removeAllItems();
				String selectedCity =citycbox.getSelectedItem().toString();
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
					 String sqlstreet="select street from address where city ='"+ selectedCity+"';";
					 
					 PreparedStatement ststreet =con.prepareStatement(sqlstreet);
					 ResultSet rsstreet = ststreet.executeQuery(sqlstreet);
					 while(rsstreet.next()) { 
						 String street = rsstreet.getString("street");
						 streetcbox.addItem(street);
						 } 
					 
//					
						con.close();
					}
				catch(Exception ee) 
				{
					System.out.println(ee); 
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
					 Statement st = con.createStatement();
						String sql = "select * from address where city = '"+selectedCity+"'";
						ResultSet rs = st.executeQuery(sql);
						DefaultTableModel tablemodelSender = (DefaultTableModel) addressTableSender.getModel();
						tablemodelSender.setRowCount(0);

						
						
						while (rs.next()) {
							String id = String.valueOf(rs.getInt("address_id"));
							String city = rs.getString("city");
							String street = rs.getString("street");
							String building = rs.getString("building");
							String homeNumber = rs.getString("home_number");
							String other = rs.getString("other");
							
							String dataList[] = {id ,city , street, building , homeNumber, other};
							
							
							tablemodelSender.addRow(dataList);
					 
				}
					
					
					
					
				}
				catch(Exception aaa) {
					JOptionPane.showMessageDialog(frame, aaa);
				}
			}
			
		});
		citycbox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				streetcbox1.removeAllItems();
				String selectedCity =citycbox1.getSelectedItem().toString();
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
					 String sqlstreet="select street from address where city ='"+ selectedCity+"';";
					 
					 PreparedStatement ststreet =con.prepareStatement(sqlstreet);
					 ResultSet rsstreet = ststreet.executeQuery(sqlstreet);
					 while(rsstreet.next()) { 
						 String street = rsstreet.getString("street");
						 streetcbox1.addItem(street);
						 } 
					 
//					
						con.close();
					}
				catch(Exception ee) 
				{
					System.out.println(ee); 
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,"root" , "mysql"); 
					 Statement st = con.createStatement();
						String sql = "select * from address where city = '"+selectedCity+"'";
						ResultSet rs = st.executeQuery(sql);
						DefaultTableModel tablemodelReciver = (DefaultTableModel) addressTableReciver.getModel();
						tablemodelReciver.setRowCount(0);

						
						
						while (rs.next()) {
							String id = String.valueOf(rs.getInt("address_id"));
							String city = rs.getString("city");
							String street = rs.getString("street");
							String building = rs.getString("building");
							String homeNumber = rs.getString("home_number");
							String other = rs.getString("other");
							
							String dataList[] = {id,city , street, building , homeNumber, other};
							
							
							tablemodelReciver.addRow(dataList);
					 
				}
					
					
					
					
				}
				catch(Exception aaa) {
					JOptionPane.showMessageDialog(frame, aaa);
				}
			}
			
		});
		
		
		createNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sql = "insert into post(sender , reciver , sender_address , reciver_address , about_of_post , price , post_status , sended_center , recived_center , sending_date ) values (?,?,?,?,?,?,?,?,?,? )";
					
					String sender = senderName.getText();
					String reciver = reciverName.getText();
					DefaultTableModel senderModel = (DefaultTableModel) addressTableSender.getModel();
					String senderAddress = (String) senderModel.getValueAt(addressTableSender.getSelectedRow(), 0);
					int senderAddressId = Integer.valueOf(senderAddress);
					DefaultTableModel reciverModel = (DefaultTableModel) addressTableReciver.getModel();
					String reciverAddress = (String) reciverModel.getValueAt(addressTableReciver.getSelectedRow(), 0);
					int reciverAddressId = Integer.valueOf(reciverAddress);
					String about = aboutPost.getText();
					int Price = (Integer) price.getValue();
					
					String Status = (String)status.getValue();
					String sendedCenterName = sendedcenter.getSelectedItem().toString();
					String recivedCenterName = recivedcenter.getSelectedItem().toString();
					String dateOfSending = sendingDate.getText();
					
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, sender);
					st.setString(2, reciver);
					st.setInt(3, senderAddressId);
					st.setInt(4, reciverAddressId);
					st.setString(5, about);
					st.setInt(6, Price);
					st.setString(7, Status);
					st.setString(8, sendedCenterName);
					st.setString(9, recivedCenterName);
					st.setString(10, dateOfSending);

					
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame, "Created New Post");
					con.close();
					
				}
				catch(Exception ecreatePost) {
					System.out.print(ecreatePost);
					JOptionPane.showMessageDialog(frame , ecreatePost.getMessage());
				}
				
				
				
				
			}
		});
		
		
	}
}
