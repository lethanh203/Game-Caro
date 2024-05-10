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

    // Constructor nhận vào tên của ba người chơi và khởi tạo giao diện kết thúc trò chơi
    public end(String a, String b, String c) {
        super();
        init1(); 
        n1 = a;
        n2 = b;
        n3 = c;
        this.setTitle(" TRÒ CHƠI KẾT THÚC "); 
        this.setSize(490, 550); 
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setResizable(false); 
        this.init1(); 
    }

    // Phương thức khởi tạo giao diện kết thúc trò chơi
    private void init1() {
        JPanel panel = new JPanel(); 
        JPanel panel1 = new JPanel(); 
        panel.setSize(250, 300); 
        panel1.setBounds(90, 50, 290, 360); 
        panel.setLayout(null); 
        panel1.setLayout(new GridLayout(4, 1, 0, 10));
        panel.setBackground(Color.YELLOW); 
        panel1.setBackground(Color.YELLOW); 
        JLabel l1 = new JLabel(n3 + " THẮNG !");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.RED); 
        l1.setOpaque(true); // Cho phép label sử dụng màu nền
        l1.setBackground(Color.GREEN); // Đặt màu nền cho label
       

        // Tạo và thiết lập các JButton cho panel chứa nút điều khiển
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

        // Thêm các thành phần vào panel chứa nút điều khiển
        panel1.add(l1);
        panel1.add(blai);
        panel1.add(bmoi);
        panel1.add(bthoat);
        panel.add(panel1); // Thêm panel chứa nút điều khiển vào panel chính
        this.setContentPane(panel); // Đặt panel chính là nội dung của cửa sổ
    }

    // Xử lý sự kiện khi người dùng tương tác với các nút điều khiển
    public void actionPerformed(ActionEvent e) {
        // Xử lý khi người chơi nhấn nút "Chơi lại"
        if ("Choi lai".equalsIgnoreCase(e.getActionCommand())) {
            // Khởi tạo một trò chơi mới với các người chơi hiện tại và đóng cửa sổ kết thúc trò chơi
            new play(n1, n2).setVisible(true);
            this.dispose();
        }
        // Xử lý khi người chơi nhấn nút "Chơi mới"
        if ("Choi moi".equalsIgnoreCase(e.getActionCommand())) {
            // Hiển thị cửa sổ bắt đầu trò chơi mới và đóng cửa sổ kết thúc trò chơi
            new start().setVisible(true);
            this.dispose();
        }
        // Xử lý khi người chơi nhấn nút "Thoát"
        if ("Thoat".equalsIgnoreCase(e.getActionCommand())) {
            // Thoát khỏi ứng dụng
            System.exit(0);
        }
    }
}
