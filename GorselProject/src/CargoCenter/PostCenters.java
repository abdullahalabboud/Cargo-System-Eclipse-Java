package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PostCenters {

	public JFrame frame;
	private JTextField centerNameInput;
	private JTable addressTable;
	private JTable postCenterTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostCenters window = new PostCenters();
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
	public PostCenters() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 1072, 895);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1058, 139);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cargo Center And Work Centers Page");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 867, 119);
		panel.add(lblNewLabel);
		
		JLabel centernamelbl = new JLabel("Center Name");
		centernamelbl.setBounds(31, 149, 151, 63);
		centernamelbl.setHorizontalAlignment(SwingConstants.LEFT);
		centernamelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(centernamelbl);
		
		centerNameInput = new JTextField();
		centerNameInput.setBounds(31, 207, 459, 63);
		frame.getContentPane().add(centerNameInput);
		centerNameInput.setColumns(10);
		
		JButton createCenterbtn = new JButton("Create Center");
		createCenterbtn.setBounds(31, 710, 457, 63);
		
		
	
		
		
		
		
		createCenterbtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		createCenterbtn.setBackground(Color.DARK_GRAY);
		createCenterbtn.setForeground(Color.YELLOW);
		frame.getContentPane().add(createCenterbtn);
		
		JLabel allPostCenterlbl = new JLabel("All Post Center");
		allPostCenterlbl.setBounds(535, 149, 151, 63);
		allPostCenterlbl.setHorizontalAlignment(SwingConstants.LEFT);
		allPostCenterlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(allPostCenterlbl);
		
		JComboBox cityinput = new JComboBox();
		cityinput.setBounds(31, 289, 459, 65);
		
		cityinput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityinput.setBackground(Color.WHITE);
		frame.getContentPane().add(cityinput);
		
		JScrollPane addressScrollPane = new JScrollPane();
		
		addressScrollPane.setBounds(31, 364, 459, 252);
		frame.getContentPane().add(addressScrollPane);
		
		addressTable = new JTable();
		addressTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressTable.setRowHeight(30);
		addressTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Address Id", "Street", "Building", "Home Number", "Other"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		addressTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		addressTable.getColumnModel().getColumn(1).setPreferredWidth(105);
		addressTable.getColumnModel().getColumn(2).setPreferredWidth(111);
		addressTable.getColumnModel().getColumn(3).setPreferredWidth(135);
		addressTable.getColumnModel().getColumn(4).setPreferredWidth(233);
		addressScrollPane.setViewportView(addressTable);
		
		JButton btnCreateNewAddress = new JButton("Create New Address");
		btnCreateNewAddress.setBounds(31, 626, 457, 63);
		btnCreateNewAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addresses address = new Addresses();
				address.frame.show();
				
			}
		});
		btnCreateNewAddress.setForeground(Color.DARK_GRAY);
		btnCreateNewAddress.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCreateNewAddress.setBackground(Color.YELLOW);
		frame.getContentPane().add(btnCreateNewAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(535, 221, 487, 552);
		frame.getContentPane().add(scrollPane);
		
		postCenterTable = new JTable();
		postCenterTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		postCenterTable.setRowHeight(30);
		postCenterTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"adfadfasdf", null},
			},
			new String[] {
				"Post Center", "City Of Center"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(postCenterTable);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Go Back To Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCargoCenter mn = new MainCargoCenter();
				mn.frmCargosystem.show();
				frame.dispose();
				
				
			}
			
		});
		menuBar.add(mntmNewMenuItem);
		
		
		// put address to compbox 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
			
			//query of city
			String cityQuery = "select city from address";
			Statement citySt = con.createStatement();
			ResultSet cityRs = citySt.executeQuery(cityQuery);
			while(cityRs.next()) {
				String city = cityRs.getString("city");
				cityinput.addItem(city);
				
			}
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("Error Is : " + e);
		}
		
		
		
		cityinput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String selectedCity = cityinput.getSelectedItem().toString();
					//query of city
					String cityQuery = "select * from address where city= '"+selectedCity+"';";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(cityQuery);
					DefaultTableModel addressModel = (DefaultTableModel) addressTable.getModel();
					addressModel.setRowCount(0);
					while(rs.next()) {
						String addressId = rs.getString("address_id");
						String street = rs.getString("street");
						String building = rs.getString("building");
						String home_number = rs.getString("home_number");
						String other = rs.getString("other");
						
						String[] addressList = {addressId,street , building , home_number , other};
						addressModel.addRow(addressList);
					}
					
					con.close();
					} catch (Exception ecreatecenter) {
					System.out.println("Error Is : " + ecreatecenter);
				}
				
			}
		});

		//default address table and post centers
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
			String selectedCity = cityinput.getSelectedItem().toString();
			//Addresses
			String cityQuery = "select * from address where city= '"+selectedCity+"';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(cityQuery);
			DefaultTableModel addressModel = (DefaultTableModel) addressTable.getModel();
			addressModel.setRowCount(0);
			while(rs.next()) {
				String addressId = rs.getString("address_id");
				String street = rs.getString("street");
				String building = rs.getString("building");
				String home_number = rs.getString("home_number");
				String other = rs.getString("other");
				
				String[] addressList = {addressId,street , building , home_number , other};
				addressModel.addRow(addressList);
			}
			
			
			
			//PostCetners
			String centersQuery = "select center_name , work_center_id from work_center;";
			Statement centerSt = con.createStatement();
			ResultSet centerRs = centerSt.executeQuery(centersQuery);
			DefaultTableModel centersModel = (DefaultTableModel) postCenterTable.getModel();
			centersModel.setRowCount(0);
			while(centerRs.next()) {
				String centerName =centerRs.getString("center_name");
				
				int centerId = centerRs.getInt("work_center_id");
				String getAddCity = "select city from address where address_id = '" + centerId +"';";
				PreparedStatement citySt = con.prepareStatement(getAddCity);
				ResultSet rrr = citySt.executeQuery();
				rrr.next();
				String centerCity = rrr.getString("city");
				String[] centersList = {centerName , centerCity};
				centersModel.addRow(centersList);

				}
			
			con.close();
			} catch (Exception ecreatecenter) {
			System.out.println("Error Is : " + ecreatecenter);
		}
		
		
		// Create New Post Center
		createCenterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel addmodel = (DefaultTableModel) addressTable.getModel();
					String centerName = centerNameInput.getText();
					String addId = addmodel.getValueAt(addressTable.getSelectedRow(), 0).toString();
					int addressId = Integer.valueOf(addId);
					//connection....
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					String sql = "insert into work_center (center_name ,address) values (? , ?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, centerName);
					pst.setInt(2, addressId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(frame, "Created New Post Center Successfully");
					
					con.close();
					
					
				}
				catch(Exception ecreatecetner) {
					System.out.println("Have a Error : "+ ecreatecetner.getMessage());
				}
			}
		});
		
	}
}
