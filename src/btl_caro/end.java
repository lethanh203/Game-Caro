package btl_caro;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class end extends JFrame implements ActionListener {
	private String n1, n2, n3;

	public end(String a, String b, String c) {
		super();
		init1();
		n1 = a;
		n2 = b;
		n3 = c;
		this.setTitle(" TRÒ CHƠI KẾT THÚC ");
		this.setSize(390, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.init1();
	}

	private void init1() {
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel.setSize(250, 300);
		panel1.setBounds(90, 30, 190, 260);
		panel.setLayout(null);
		panel1.setLayout(new GridLayout(4, 1, 0, 10));
		panel.setBackground(Color.YELLOW);
		panel1.setBackground(Color.YELLOW);
		JLabel l1 = new JLabel(n3 + " thắng !");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setForeground(Color.YELLOW);
		l1.setOpaque(true);
		l1.setBackground(Color.RED);

		JButton blai = new JButton("Chơi lại");
		blai.setBackground(Color.GREEN);
		blai.setActionCommand("Choi lai");
		blai.addActionListener(this);

		JButton bmoi = new JButton("Chơi mới");
		bmoi.setBackground(Color.GREEN);
		bmoi.setActionCommand("Choi moi");
		bmoi.addActionListener(this);

		JButton bthoat = new JButton("Thoát");
		bthoat.setBackground(Color.GREEN);
		bthoat.setActionCommand("Thoat");
		bthoat.addActionListener(this);

		panel1.add(l1);
		panel1.add(blai);
		panel1.add(bmoi);
		panel1.add(bthoat);
		panel.add(panel1);
		this.setContentPane(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if ("Choi lai".equalsIgnoreCase(e.getActionCommand())) {
			new play(n1, n2).setVisible(true);
			this.dispose();
		}
		if ("Choi moi".equalsIgnoreCase(e.getActionCommand())) {
			new start().setVisible(true);
			this.dispose();
		}
		if ("Thoat".equalsIgnoreCase(e.getActionCommand())) {
			System.exit(0);
		}
	}
}