package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Addresses {

	public JFrame frame;
	private JTextField cityinput;
	private JTextField streetinput;
	private JTextField buildinginput;
	private JTextField otheraddressinput;
	private JTable addressTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addresses window = new Addresses();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addresses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 156, 153, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStreet.setBounds(10, 214, 153, 44);
		frame.getContentPane().add(lblStreet);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuilding.setBounds(10, 268, 153, 44);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblHomeNumber = new JLabel("Home Number");
		lblHomeNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHomeNumber.setBounds(10, 320, 153, 44);
		frame.getContentPane().add(lblHomeNumber);
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOther.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOther.setBounds(11, 379, 153, 44);
		frame.getContentPane().add(lblOther);
		
		cityinput = new JTextField();
		cityinput.setBackground(Color.LIGHT_GRAY);
		cityinput.setForeground(Color.WHITE);
		cityinput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityinput.setBounds(173, 161, 392, 44);
		frame.getContentPane().add(cityinput);
		cityinput.setColumns(10);
		
		streetinput = new JTextField();
		streetinput.setBackground(Color.LIGHT_GRAY);
		streetinput.setForeground(Color.WHITE);
		streetinput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		streetinput.setColumns(10);
		streetinput.setBounds(173, 214, 392, 44);
		frame.getContentPane().add(streetinput);
		
		buildinginput = new JTextField();
		buildinginput.setBackground(Color.LIGHT_GRAY);
		buildinginput.setForeground(Color.WHITE);
		buildinginput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buildinginput.setColumns(10);
		buildinginput.setBounds(173, 268, 392, 44);
		frame.getContentPane().add(buildinginput);
		
		otheraddressinput = new JTextField();
		otheraddressinput.setHorizontalAlignment(SwingConstants.LEFT);
		otheraddressinput.setBackground(Color.LIGHT_GRAY);
		otheraddressinput.setForeground(Color.WHITE);
		otheraddressinput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		otheraddressinput.setColumns(10);
		otheraddressinput.setBounds(173, 379, 392, 149);
		frame.getContentPane().add(otheraddressinput);
		
		JSpinner homenumberinput = new JSpinner();
		homenumberinput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		homenumberinput.setBackground(Color.DARK_GRAY);
		homenumberinput.setBounds(173, 322, 391, 50);
		frame.getContentPane().add(homenumberinput);
		
		JButton createAddressbtn = new JButton("Create New Address");
		createAddressbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = cityinput.getText();
				String street = streetinput.getText();
				String building = buildinginput.getText();
				String homeNumber = String.valueOf(homenumberinput.getValue());
				String other = otheraddressinput.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sql ="insert into address(city , street , building , home_number , other) values(? ,? ,? ,? ,?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, city);
					st.setString(2, street);
					st.setString(3, building);
					st.setString(4, homeNumber);
					st.setString(5, other);
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame, "Created New Address");
					con.close();
					
				}
				catch(Exception ecreateaddress) {
					JOptionPane.showMessageDialog(frame, ecreateaddress);
				}
				
				

				
				
				
				
				
				
				
			}
		});
		createAddressbtn.setForeground(new Color(255, 255, 255));
		createAddressbtn.setBackground(new Color(50, 205, 50));
		createAddressbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createAddressbtn.setBounds(173, 543, 392, 44);
		frame.getContentPane().add(createAddressbtn);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1210, 149);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Addresses Page");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(10, 20, 973, 95);
		panel.add(lblNewLabel_2);
		
		JLabel findaddresslbl = new JLabel("Find Address");
		findaddresslbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		findaddresslbl.setBounds(597, 156, 547, 44);
		frame.getContentPane().add(findaddresslbl);
		
		JComboBox citycbox = new JComboBox();
		
		
		citycbox.setBounds(671, 214, 192, 50);
		frame.getContentPane().add(citycbox);
		
		JLabel lblNewLabel_1 = new JLabel("City");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(561, 214, 100, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Street");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(873, 214, 100, 44);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox streetcbox = new JComboBox();
		streetcbox.setBounds(983, 214, 192, 50);
		frame.getContentPane().add(streetcbox);
		
		
		
		
		
		
		
		
		JButton btnFindAAddress = new JButton("Find Address");
		btnFindAAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// find address
				try {
					
					String city = citycbox.getSelectedItem().toString();
					String street = streetcbox.getSelectedItem().toString();
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sql ="select * from address where city= '"+ city+"' and street = '"+street+"';";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					DefaultTableModel addressModel = (DefaultTableModel) addressTable.getModel();
					addressModel.setRowCount(0);
					while (rs.next()) {
						String tcity = city.toString();
						String tstreet = street.toString();
						String tbuilding = rs.getString("building");
						String thomenumber = rs.getString("home_number");
						String tother = rs.getString("other");
						
						String dataList[] = {tcity , tstreet , tbuilding , thomenumber , tother};
						
						addressModel.addRow(dataList);
						
					}
					
					con.close();
					
					
					
				}
				catch(Exception ecreateaddress) {
					JOptionPane.showMessageDialog(frame, "Error Is : " + ecreateaddress.getMessage());
					System.out.println(ecreateaddress);
				}
				
				
				
			}
		});
		btnFindAAddress.setForeground(Color.YELLOW);
		btnFindAAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFindAAddress.setBackground(Color.DARK_GRAY);
		btnFindAAddress.setBounds(783, 284, 392, 44);
		frame.getContentPane().add(btnFindAAddress);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(628, 335, 548, 252);
		frame.getContentPane().add(tablePanel);
		tablePanel.setLayout(null);
		
		addressTable = new JTable();
		addressTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		addressTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"City", "Street", "Building", "Home Number", "Other"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		addressTable.setBounds(10, 10, 528, 232);
		tablePanel.add(addressTable);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//put data to compobox 
				try {
					citycbox.removeAllItems();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sqlcity ="select city from address ";
					PreparedStatement stcity = con.prepareStatement(sqlcity);
					ResultSet rscity = stcity.executeQuery(sqlcity);
					while (rscity.next()) {
						String city = rscity.getString("city");
						citycbox.addItem(city);
					}
					
					/*
					 * if(citycbox.isValid()) { streetcbox.removeAllItems();
					 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
					 * DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" ,
					 * "root" , "mysql"); String sqlstreet
					 * ="select street from address where city = ?"; String selectedCity =
					 * citycbox.getSelectedItem().toString(); PreparedStatement ststreet =
					 * con.prepareStatement(sqlstreet); ststreet.setString(1, selectedCity);
					 * ResultSet rsstreet = ststreet.executeQuery(sqlstreet); while
					 * (rsstreet.next()) { String street = rsstreet.getString("street");
					 * streetcbox.addItem(street); }
					 * 
					 * 
					 * }
					 */
					
					con.close();
				}
				catch(Exception ecreateaddress) {
					JOptionPane.showMessageDialog(frame, "Error Is : " + ecreateaddress.getMessage());
				}
				
				
			}
		});
		
		
		//action in city compobox to select street
		
		citycbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
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
					 con.close();
					}
				catch(Exception ee) 
				{
					System.out.println(ee); 
				}
				
				
			}
		});
		
		
		
		
		
		

		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(629, 284, 144, 44);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 1224, 669);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Go Back To Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCargoCenter main = new MainCargoCenter();
				main.frmCargosystem.show();
				frame.dispose();
			}
		});
		menuBar.add(mntmNewMenuItem);
	}
}
