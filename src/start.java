package btl_caro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class start extends JFrame implements ActionListener {
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();

	public start() {
		super();
		this.setSize(600, 1050);
		this.setLocationRelativeTo(null);
		this.setTitle("Game Caro 2024");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.init1();
	}

	public void init1() {
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel.setSize(390, 600);
		panel1.setBounds(10, 550, 80, 80);
		panel2.setBounds(150, 550, 300, 80);
		panel3.setBounds(165, 650, 250, 210);

		panel.setLayout(null);
		panel1.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel3.setLayout(new GridLayout(3, 1, 10, 10));
		panel.setBackground(Color.yellow);
		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.yellow);
		panel3.setBackground(Color.yellow);

		JLabel l1 = new JLabel("Người chơi 1:"); 
		l1.setForeground(Color.RED);
		JLabel l2 = new JLabel("Người chơi 2:");
		l2.setForeground(Color.RED);
		ImageIcon icon = new ImageIcon("images/caro.png");
		JLabel l3 = new JLabel(icon);
		l3.setBounds(0, 5, 600, 520);
		txt2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				txt2KeyPressed(evt);
			}
		});

		panel.add(l3);
		panel1.add(l1);
		panel1.add(l2);
		panel2.add(txt1);
		panel2.add(txt2);
		panel.add(panel1);
		panel.add(panel2);

		JButton bchoi = new JButton("Bắt đầu");
		bchoi.setBackground(Color.GREEN);
		bchoi.setActionCommand("Bat dau");
		bchoi.addActionListener(this);
	
		JButton bthoat = new JButton("Thoát");
		bthoat.setBackground(Color.GREEN);
		bthoat.setActionCommand("Thoat");
		bthoat.addActionListener(this);

		panel3.add(bchoi);
		
		panel3.add(bthoat);
		panel.add(panel3);

		this.setContentPane(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if ("Thoat".equalsIgnoreCase(e.getActionCommand())) {
			System.exit(0);
		}
		
		String a, b;
		a = txt1.getText();
		b = txt2.getText();
		if (!a.equals("") && !b.equals("") && !a.equals(b) && a.length() < 15 && b.length() < 15) {
			if ("Bat dau".equalsIgnoreCase(e.getActionCommand())) {
				new play(a, b).setVisible(true);
				this.dispose();
			}
		}
	}
//bam ENTER de bat dau
	private void txt2KeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			String a, b;
			a = txt1.getText();
			b = txt2.getText();
			if (!a.equals("") && !b.equals("") && !a.equals(b) && a.length() < 15 && b.length() < 15) {
				new play(a, b).setVisible(true);
				this.dispose();
			}
		}
	}
}
