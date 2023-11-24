package cat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
public class Badday {

	private JFrame frame;
	private JTextField name;
	private JTextField user;
	private JTextField email;
	private JPasswordField pass;
	private JPasswordField pass2;
	private JTextField phone;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Badday window = new Badday();
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
	public Badday() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 26, 155, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(59, 77, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(43, 102, 62, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(49, 136, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
		lblNewLabel_4.setBounds(10, 161, 123, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(70, 199, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setBounds(70, 224, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(59, 260, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(33, 329, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name.getText();
				String username = user.getText();
				String password = String.valueOf(pass.getPassword());
				String confirm = String.valueOf(pass2.getPassword());
				String email = email.getText();
				String phone = phone.getText();
				String address = address.getText();

				if (password.equals(confirm)) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form", "festus004",
								"nixcraft@mysql");
						String sql = "INSERT INTO Registration (Name, Username, Password, Email, Phone, Address) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement preparedStatement = con.prepareStatement(sql);
						preparedStatement.setString(1, name);
						preparedStatement.setString(2, username);
						preparedStatement.setString(3, password);
						preparedStatement.setString(4, email);
						preparedStatement.setString(5, phone);
						preparedStatement.setString(6, address);
						preparedStatement.executeUpdate();
						preparedStatement.close();
						con.close();
						name.setText("");
						user.setText("");
						pass.setText("");
						pass2.setText("");
						email.setText("");
						phone.setText("");
						address.setText("");
						JOptionPane.showMessageDialog(null, "User added!");

					} catch (Exception err) {
						err.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Password and confirmation do not match!");
				}
			}

		});
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(151, 329, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		name.setText("");
		user.setText("");
		pass.setText("");
		pass2.setText("");
		email.setText("");
	    phone.setText("");
		address.setText("");
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBounds(282, 329, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		name = new JTextField();
		name.setBounds(112, 74, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		user = new JTextField();
		user.setBounds(112, 99, 86, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		email = new JTextField();
		email.setBounds(112, 196, 86, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(112, 133, 86, 20);
		frame.getContentPane().add(pass);
		
		pass2 = new JPasswordField();
		pass2.setBounds(112, 161, 86, 20);
		frame.getContentPane().add(pass2);
		
		phone = new JTextField();
		phone.setBounds(112, 221, 86, 20);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(112, 257, 86, 20);
		frame.getContentPane().add(address);
		address.setColumns(10);
	}
}
