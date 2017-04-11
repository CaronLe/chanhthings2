package omr.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	// TODO:  make login panel
	JTextField usernameTf, passwordTf;
	JButton loginBtn;
	
	public LoginPanel() {
		this.setLayout(new GridLayout(1, 3));
		this.setSize(400, 30);
		usernameTf = new JTextField("admin");
		passwordTf = new JTextField("123");
//		passwordTf.
		loginBtn = new JButton("Login");
		this.add(usernameTf);
		this.add(passwordTf);
		this.add(loginBtn);
	}
}