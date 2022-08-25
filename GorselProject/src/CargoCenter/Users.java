package CargoCenter;

import java.awt.EventQueue;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Users {

	public JFrame users;
	private JTextField intxtusrname;
	private JTextField intxtpassword;
	private JTable usersTable;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTable workTable;
	private JTable centerTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
					window.users.setVisible(true);
					window.users.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Users() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		users = new JFrame();
		users.getContentPane().setBackground(Color.WHITE);
		users.setBackground(Color.WHITE);
		users.setBounds(100, 100, 1325, 780);
		users.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		users.getContentPane().setLayout(null);
		
		JLabel lblusrname = new JLabel("Username");
		lblusrname.setHorizontalAlignment(SwingConstants.CENTER);
		lblusrname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblusrname.setBounds(35, 144, 115, 43);
		users.getContentPane().add(lblusrname);
		
		JLabel lblpassword = new JLabel("password");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpassword.setBounds(35, 213, 115, 43);
		users.getContentPane().add(lblpassword);
		
		intxtusrname = new JTextField();
		intxtusrname.setForeground(Color.WHITE);
		intxtusrname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		intxtusrname.setBackground(Color.LIGHT_GRAY);
		intxtusrname.setBounds(149, 144, 306, 47);
		users.getContentPane().add(intxtusrname);
		intxtusrname.setColumns(10);
		
		intxtpassword = new JTextField();
		intxtpassword.setForeground(Color.WHITE);
		intxtpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		intxtpassword.setColumns(10);
		intxtpassword.setBackground(Color.LIGHT_GRAY);
		intxtpassword.setBounds(149, 213, 306, 47);
		users.getContentPane().add(intxtpassword);
		
		JButton btnNewButton = new JButton("Create New User");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(318, 275, 137, 43);
		users.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.YELLOW);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1419, 126);
		users.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Users And Add New Emplyee Page");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 979, 94);
		panel.add(lblNewLabel);
		
		
		
		
		
//		JScrollPane pane = new JScrollPane(usersTable);
//		usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		
		JButton btnNewButton_1 = new JButton("Refresh Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					
//					usersTable.setEditingRow(0);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					Statement st = con.createStatement();
					String sql = "select * from users";
					ResultSet rs = st.executeQuery(sql);
					DefaultTableModel tablemodel = (DefaultTableModel) usersTable.getModel();
					tablemodel.setRowCount(0);
					
					while (rs.next()) {
						String userId = String.valueOf(rs.getInt("user_id"));
						String username = rs.getString("user_name");
						String password = rs.getString("user_password");
						
						String dataList[] = {userId , username , password};
						
						tablemodel.addRow(dataList);
						
						
						
					}
					
					
//					JOptionPane.showMessageDialog(users,"You refreshed Users Data .....");
					
					con.close();
					
					
					
				}
				catch(Exception erefreshdata) {
					System.out.println("Have a Error : "+ erefreshdata.getMessage());
				}
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(244, 275, 64, 43);
		users.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("username its unique value ... please becarefull when created it\r\n");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(23, 197, 433, 19);
		users.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("password its soo important .... put a password and remembar it ");
		lblNewLabel_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(23, 255, 433, 19);
		users.getContentPane().add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 324, 436, 322);
		users.getContentPane().add(scrollPane);
		
		usersTable = new JTable();
		scrollPane.setViewportView(usersTable);
		usersTable.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		usersTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usersTable.setForeground(Color.WHITE);
		usersTable.setBackground(Color.DARK_GRAY);
		usersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UserId", "UserName", "Password"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		usersTable.setRowHeight(30);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(558, 136, 713, 510);
		users.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JSpinner ageInput = new JSpinner();
		ageInput.setBounds(464, 335, 212, 47);
		panel_1.add(ageInput);
		ageInput.setModel(new SpinnerNumberModel(new Integer(20), new Integer(18), null, new Integer(1)));
		ageInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblfirstname = new JLabel("First Name");
		lblfirstname.setBounds(23, 337, 115, 43);
		panel_1.add(lblfirstname);
		lblfirstname.setForeground(Color.WHITE);
		lblfirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblfirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbllastname = new JLabel("Last Name");
		lbllastname.setBounds(23, 406, 115, 43);
		panel_1.add(lbllastname);
		lbllastname.setForeground(Color.WHITE);
		lbllastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllastname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		firstNameInput = new JTextField();
		firstNameInput.setBounds(148, 337, 212, 47);
		panel_1.add(firstNameInput);
		firstNameInput.setForeground(Color.WHITE);
		firstNameInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameInput.setColumns(10);
		firstNameInput.setBackground(Color.LIGHT_GRAY);
		
		lastNameInput = new JTextField();
		lastNameInput.setBounds(148, 402, 212, 47);
		panel_1.add(lastNameInput);
		lastNameInput.setForeground(Color.WHITE);
		lastNameInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameInput.setColumns(10);
		lastNameInput.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		
		JButton createEmployee = new JButton("Create New Employee");
		createEmployee.setBounds(412, 399, 264, 50);
		panel_1.add(createEmployee);
		
		
		createEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createEmployee.setForeground(Color.WHITE);
		createEmployee.setBackground(new Color(50, 205, 50));
		
		JLabel lblage = new JLabel("Age");
		lblage.setBounds(366, 337, 88, 43);
		panel_1.add(lblage);
		lblage.setForeground(Color.WHITE);
		lblage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane workScrollPane = new JScrollPane();
		workScrollPane.setBounds(366, 112, 306, 192);
		panel_1.add(workScrollPane);
		
		workTable = new JTable();
		workTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Work Id", "Work Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		workTable.getColumnModel().getColumn(0).setPreferredWidth(56);
		workTable.getColumnModel().getColumn(1).setPreferredWidth(247);
		workScrollPane.setViewportView(workTable);
		
		JScrollPane centerScrollPane = new JScrollPane();
		centerScrollPane.setBounds(49, 112, 306, 192);
		panel_1.add(centerScrollPane);
		
		centerTable = new JTable();
		centerTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Center Id", "Center Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		centerTable.getColumnModel().getColumn(0).setPreferredWidth(61);
		centerTable.getColumnModel().getColumn(1).setPreferredWidth(164);
		centerScrollPane.setViewportView(centerTable);
		
		
		
		JLabel lblpostcenter = new JLabel("Post Center");
		lblpostcenter.setBounds(49, 67, 115, 43);
		panel_1.add(lblpostcenter);
		lblpostcenter.setForeground(Color.WHITE);
		lblpostcenter.setHorizontalAlignment(SwingConstants.LEFT);
		lblpostcenter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblwork = new JLabel("Work");
		lblwork.setBounds(365, 67, 115, 43);
		panel_1.add(lblwork);
		lblwork.setForeground(Color.WHITE);
		lblwork.setHorizontalAlignment(SwingConstants.LEFT);
		lblwork.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Add Employee");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(68, 10, 578, 59);
		panel_1.add(lblNewLabel_1);
		DefaultTableModel centerModel = (DefaultTableModel)centerTable.getModel();
		DefaultTableModel workModel = (DefaultTableModel)workTable.getModel();
		createEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText();
				String lastName = lastNameInput.getText();
				int age = (Integer)ageInput.getValue();
				//create models of work and center to get selected work and center to take id's from them 
				DefaultTableModel workModel = (DefaultTableModel) workTable.getModel();
				DefaultTableModel centerModel = (DefaultTableModel) centerTable.getModel();
				DefaultTableModel usersModel = (DefaultTableModel) usersTable.getModel();
				String sworkId = (String) workModel.getValueAt(workTable.getSelectedRow(), 0);
				String scenterId = (String) centerModel.getValueAt(centerTable.getSelectedRow(), 0);
				String suserId = (String) usersModel.getValueAt(usersTable.getSelectedRow(), 0);
				
				int workId = Integer.valueOf(sworkId);
				int centerId = Integer.valueOf(scenterId);
				int userId = Integer.valueOf(suserId);
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					
					String query = "insert into employee (user_id ,employee_name , employee_lastname , age , work_id , work_center) values (? ,? ,? ,? ,? ,?)";
					PreparedStatement st = con.prepareStatement(query);
					st.setInt(1, userId);
					st.setString(2, firstName);
					st.setString(3, lastName);
					st.setInt(4, age);
					st.setInt(5,workId);
					st.setInt(6 , centerId);
					
					st.executeUpdate();
					JOptionPane.showMessageDialog(users, "Created New Employee Successfully");
					
					
					
					
				}
				catch(Exception ecreateemployee) {
					JOptionPane.showMessageDialog(users, ecreateemployee.getMessage());
					
				}
				
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Delete User");
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(new Color(255, 69, 0));
		btnNewButton_2.setBounds(23, 656, 137, 36);
		users.getContentPane().add(btnNewButton_2);
		
		JTextPane txtpnSelectUserTo = new JTextPane();
		txtpnSelectUserTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSelectUserTo.setForeground(new Color(192, 192, 192));
		txtpnSelectUserTo.setText("Select user to delete it\r\n");
		txtpnSelectUserTo.setBounds(177, 656, 278, 36);
		users.getContentPane().add(txtpnSelectUserTo);
		
		JMenuBar menuBar = new JMenuBar();
		users.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Go Back To Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCargoCenter main = new MainCargoCenter();
				main.frmCargosystem.show();
				users.dispose();
				
			
			}
		});
		mntmNewMenuItem.setBackground(new Color(255, 255, 0));
		menuBar.add(mntmNewMenuItem);
		
		
		try {
			// get connection to load works and centers
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
			String centerQuery = "select work_center_id , center_name from work_center;";
			Statement centerSt = con.createStatement();
			ResultSet centerRt = centerSt.executeQuery(centerQuery);
			centerModel.setRowCount(0);
			while(centerRt.next()) {
				String centerId =String.valueOf(centerRt.getInt("work_center_id"));
				String centerName = centerRt.getString("center_name");
				String centerList[] = {centerId , centerName};
				centerModel.addRow(centerList);
			}
			
			String workQuery = "select work_id , work_name from work_tb";
			Statement workSt = con.createStatement();
			ResultSet workRt = workSt.executeQuery(workQuery);
			workModel.setRowCount(0);
			while(workRt.next()) {
				String workId = String.valueOf(workRt.getInt("work_id"));
				String workName = workRt.getString("work_name");
				String workList[] = {workId , workName};
				workModel.addRow(workList);
			}
			
			
			String usersQuery = "select * from users;";
			Statement usersSt = con.createStatement();
			ResultSet usersRt = usersSt.executeQuery(usersQuery);
			DefaultTableModel usersModel = (DefaultTableModel)usersTable.getModel();
			usersModel.setRowCount(0);
			while(usersRt.next()) {
				String userId = String.valueOf(usersRt.getInt("user_id"));
				String userName = usersRt.getString("user_name");
				String userPassword= usersRt.getString("user_password");
				String usersList[] = {userId, userName , userPassword};
				usersModel.addRow(usersList);
			}
			
			
			
			
			con.close();
			
			
			
		}
		catch(Exception egeneralusers) {
			JOptionPane.showMessageDialog(users, egeneralusers.getMessage());
			
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					
					String username = intxtusrname.getText().toString();
					String password = intxtpassword.getText().toString();
					if(username.isEmpty() || password.isEmpty()) {						
						JOptionPane.showMessageDialog(users, "The Username or Password is Empty...!!!");
					}
					else {
						//control if user in users
						DefaultTableModel usersModel= (DefaultTableModel)usersTable.getModel();
						boolean usable = true;
						for(int a=0 ; a < usersModel.getRowCount();a++) {
							if(username.equals(usersModel.getValueAt(a, 1)) ) {
								usable = false;
								JOptionPane.showMessageDialog(users, "Can't use the username, Sorry..!!");
								break;
							}
						}
						//End control.....
						if(usable == true) {
							PreparedStatement ps = con.prepareStatement("insert into users(user_name , user_password) values(? , ?)");
							ps.setString(1, username);
							ps.setString(2, password);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(users, "Added To Data Base");
							usersModel.setRowCount(0);
							String usersQuery = "select * from users;";
							Statement usersSt = con.createStatement();
							ResultSet usersRt = usersSt.executeQuery(usersQuery);
							usersModel.setRowCount(0);
							while(usersRt.next()) {
								String suserId = String.valueOf(usersRt.getInt("user_id"));
								String userName = usersRt.getString("user_name");
								String userPassword= usersRt.getString("user_password");
								String usersList[] = {suserId, userName , userPassword};
								usersModel.addRow(usersList);
							}
						}
					}
					
					
					
					intxtusrname.setText(null);
					intxtpassword.setText(null);
					con.close();	
				}
				catch(Exception ecreateuser) {
					System.out.println("Have a Error : "+ ecreateuser.getMessage());
				}
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gorselprodb" , "root" , "mysql");
					
					DefaultTableModel usersModel= (DefaultTableModel)usersTable.getModel();
					int userId = Integer.valueOf((String)usersModel.getValueAt(usersTable.getSelectedRow(), 0).toString());
					String query = "delete from users where user_id = '"+userId+"'";
					Statement st = con.createStatement();
					st.execute(query);
					
					//refreshing data in the table after the deleting.....
					usersModel.setRowCount(0);
					String usersQuery = "select * from users;";
					Statement usersSt = con.createStatement();
					ResultSet usersRt = usersSt.executeQuery(usersQuery);
					usersModel.setRowCount(0);
					while(usersRt.next()) {
						String suserId = String.valueOf(usersRt.getInt("user_id"));
						String userName = usersRt.getString("user_name");
						String userPassword= usersRt.getString("user_password");
						String usersList[] = {suserId, userName , userPassword};
						usersModel.addRow(usersList);
					}
					
					
					con.close();
					
					
				}
				catch(Exception edeleteusr) {
					JOptionPane.showMessageDialog(users, edeleteusr.getMessage());
					
				}
				
			}
		});
		
	}
}
