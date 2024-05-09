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
	JTextField txt1 = new JTextField(); // Ô văn bản cho Người chơi 1
	JTextField txt2 = new JTextField(); // Ô văn bản cho Người chơi 2

	public start() {
		super(); // Gọi constructor của lớp cha (JFrame)
		this.setSize(600, 1050); // Đặt kích thước cửa sổ
		this.setLocationRelativeTo(null); // Đặt vị trí của cửa sổ ở giữa màn hình
		this.setTitle("Game Caro 2024"); // Đặt tiêu đề của cửa sổ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Thiết lập hoạt động mặc định khi đóng cửa sổ
		this.setResizable(false); // Không cho phép thay đổi kích thước cửa sổ
		this.init1(); // Khởi tạo giao diện
	}

	public void init1() {
		JPanel panel = new JPanel(); // Panel chính
		JPanel panel1 = new JPanel(); // Panel cho nhãn "Người chơi 1" và "Người chơi 2"
		JPanel panel2 = new JPanel(); // Panel cho hai ô văn bản
		JPanel panel3 = new JPanel(); // Panel cho các nút

		panel.setSize(390, 600); // Đặt kích thước của panel chính
		panel1.setBounds(10, 550, 80, 80); // Đặt vị trí của panel1
		panel2.setBounds(150, 550, 300, 80); // Đặt vị trí của panel2
		panel3.setBounds(165, 650, 250, 210); // Đặt vị trí của panel3

		panel.setLayout(null); // Thiết lập layout của panel thành null
		panel1.setLayout(new GridLayout(2, 1, 10, 10)); // Thiết lập layout của panel1 thành grid 2x1
		panel2.setLayout(new GridLayout(2, 1, 10, 10)); // Thiết lập layout của panel2 thành grid 2x1
		panel3.setLayout(new GridLayout(3, 1, 10, 10)); // Thiết lập layout của panel3 thành grid 3x1
		panel.setBackground(Color.yellow); // Đặt màu nền của panel thành màu vàng
		panel1.setBackground(Color.yellow); // Đặt màu nền của panel1 thành màu vàng
		panel2.setBackground(Color.yellow); // Đặt màu nền của panel2 thành màu vàng
		panel3.setBackground(Color.yellow); // Đặt màu nền của panel3 thành màu vàng

		JLabel l1 = new JLabel("Người chơi 1:"); // Nhãn "Người chơi 1"
		l1.setForeground(Color.RED); // Thiết lập màu chữ của nhãn thành màu đỏ
		JLabel l2 = new JLabel("Người chơi 2:"); // Nhãn "Người chơi 2"
		l2.setForeground(Color.RED); // Thiết lập màu chữ của nhãn thành màu đỏ
		ImageIcon icon = new ImageIcon("images/caro.png"); // Biểu tượng hình ảnh của trò chơi
		JLabel l3 = new JLabel(icon); // Nhãn chứa biểu tượng hình ảnh
		l3.setBounds(0, 5, 600, 520); // Đặt vị trí và kích thước của nhãn
		txt2.addKeyListener(new KeyAdapter() { // Bắt sự kiện phím từ ô văn bản của Người chơi 2
			public void keyPressed(KeyEvent evt) {
				txt2KeyPressed(evt); // Xử lý khi nhấn phím
			}
		});

		panel.add(l3); // Thêm nhãn chứa biểu tượng hình ảnh vào panel
		panel1.add(l1); // Thêm nhãn "Người chơi 1" vào panel1
		panel1.add(l2); // Thêm nhãn "Người chơi 2" vào panel1
		panel2.add(txt1); // Thêm ô văn bản cho Người chơi 1 vào panel2
		panel2.add(txt2); // Thêm ô văn bản cho Người chơi 2 vào panel2
		panel.add(panel1); // Thêm panel1 vào panel
		panel.add(panel2); // Thêm panel2 vào panel

		JButton bchoi = new JButton("Bắt đầu"); // Nút "Bắt đầu"
		bchoi.setBackground(Color.GREEN); // Thiết lập màu nền của nút thành màu xanh lá cây
		bchoi.setActionCommand("Bat dau"); // Đặt lệnh hành động của nút thành "Bat dau"
		bchoi.addActionListener(this); // Bắt sự kiện nhấn nút

		JButton bthoat = new JButton("Thoát"); // Nút "Thoát"
		bthoat.setBackground(Color.GREEN); // Thiết lập màu nền của nút thành màu xanh lá cây
		bthoat.setActionCommand("Thoat"); // Đặt lệnh hành động của nút thành "Thoat"
		bthoat.addActionListener(this); // Bắt sự kiện nhấn nút

		panel3.add(bchoi); // Thêm nút "Bắt đầu" vào panel3
		panel3.add(bthoat); // Thêm nút "Thoát" vào panel3
		panel.add(panel3); // Thêm panel3 vào panel

		this.setContentPane(panel); // Đặt panel làm nội dung của cửa sổ
	}

	public void actionPerformed(ActionEvent e) {
		if ("Thoat".equalsIgnoreCase(e.getActionCommand())) {
			System.exit(0); // Thoát chương trình khi nhấn nút "Thoát"
			}
		
		String a, b;
		a = txt1.getText(); // Lấy nội dung từ ô văn bản cho Người chơi 1
		b = txt2.getText(); // Lấy nội dung từ ô văn bản cho Người chơi 2
		if (!a.equals("") && !b.equals("") && !a.equals(b) && a.length() < 15 && b.length() < 15) {
			if ("Bat dau".equalsIgnoreCase(e.getActionCommand())) {
				new play(a, b).setVisible(true); // Khởi tạo trò chơi mới và hiển thị nó
				this.dispose(); // Đóng cửa sổ hiện tại
			}
		}
	}

	// Phương thức xử lý khi nhấn phím ENTER trong ô văn bản cho Người chơi 2
	private void txt2KeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			String a, b;
			a = txt1.getText(); // Lấy nội dung từ ô văn bản cho Người chơi 1
			b = txt2.getText(); // Lấy nội dung từ ô văn bản cho Người chơi 2
			if (!a.equals("") && !b.equals("") && !a.equals(b) && a.length() < 15 && b.length() < 15) {
				new play(a, b).setVisible(true); // Khởi tạo trò chơi mới và hiển thị nó
				this.dispose(); // Đóng cửa sổ hiện tại
			}
		}
	}
}
