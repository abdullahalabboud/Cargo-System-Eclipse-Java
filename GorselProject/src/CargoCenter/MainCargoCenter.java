package CargoCenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainCargoCenter {

	public JFrame frmCargosystem;
	public Users frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCargoCenter window = new MainCargoCenter();
					window.frmCargosystem.setVisible(true);
					window.frmCargosystem.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCargoCenter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCargosystem = new JFrame();
		frmCargosystem.setTitle("CargoSystem");
		frmCargosystem.getContentPane().setBackground(Color.WHITE);
		frmCargosystem.getContentPane().setLayout(null);
	
		
		JButton btnusers = new JButton("Users");
		btnusers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Users us = new Users();
			us.users.show();
			frmCargosystem.dispose();
			
				
			}
		});
		btnusers.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnusers.setBackground(Color.YELLOW);
		btnusers.setBounds(17, 92, 300, 300);
		frmCargosystem.getContentPane().add(btnusers);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 953, 79);
		frmCargosystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel mainpagelbltxt = new JLabel("New label");
		mainpagelbltxt.setFont(new Font("Tahoma", Font.BOLD, 40));
		mainpagelbltxt.setForeground(Color.YELLOW);
		mainpagelbltxt.setVerticalAlignment(SwingConstants.TOP);
		mainpagelbltxt.setBounds(10, 10, 926, 59);
		panel.add(mainpagelbltxt);
		frmCargosystem.setBackground(Color.WHITE);
		frmCargosystem.setBounds(100, 100, 990, 786);
		frmCargosystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.WHITE);
		frmCargosystem.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("System");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCargosystem.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mainpagelbltxt.setText("Main Page");
		
		JButton btnCargoCenter = new JButton("Cargo Centers");
		btnCargoCenter.setForeground(Color.YELLOW);
		btnCargoCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostCenters pc = new PostCenters();
				pc.frame.show();
				
			}
		});
		btnCargoCenter.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnCargoCenter.setBackground(Color.DARK_GRAY);
		btnCargoCenter.setBounds(327, 92, 300, 300);
		frmCargosystem.getContentPane().add(btnCargoCenter);
		
		JButton btnNewButton_1_1 = new JButton("Posts");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Posts posts = new Posts();
				posts.frame.show();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1.setBounds(637, 92, 300, 300);
		frmCargosystem.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Addresses");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addresses addresses = new Addresses();
				addresses.frame.show();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_1_2.setBackground(Color.YELLOW);
		btnNewButton_1_2.setBounds(327, 402, 300, 300);
		frmCargosystem.getContentPane().add(btnNewButton_1_2);
		
		JButton btnworks = new JButton("Works");
		btnworks.setForeground(Color.YELLOW);
		btnworks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Works works = new Works();
				works.frame.show();
			}
		});
		btnworks.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnworks.setBackground(Color.DARK_GRAY);
		btnworks.setBounds(17, 402, 300, 300);
		frmCargosystem.getContentPane().add(btnworks);
	}
}
