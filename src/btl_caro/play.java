package btl_caro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class play extends JFrame implements ActionListener {
    
    private int n = 26, m = 26, ng = 1;
    private int tb[][] = new int[n][m];
    private JButton btn[][] = new JButton[n][m];
    private String n1, n2;
    JLabel l1 = new JLabel();
    JPanel pan2 = new JPanel();
    
   
    ImageIcon icon2 = new ImageIcon("images/iconx.png");
    ImageIcon icon3 = new ImageIcon("images/icono.png");

    // Constructor nhận vào tên của hai người chơi và khởi tạo giao diện trò chơi
    public play(String a, String b) {
        super();
        init1(); 
        n1 = a; 
        n2 = b;
        this.setTitle("Play Caro"); 
        this.setSize(1000, 715); 
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.init1(); 
    }

  
    private void init1() {
        JPanel pan = new JPanel(); // Tạo panel chính
        JPanel pan1 = new JPanel(); // Tạo panel cho bảng chơi
        JPanel pan3 = new JPanel(); // Tạo panel cho các nút điều khiển
        
        pan.setLayout(null); 
        pan.setSize(750, 690);
        pan1.setBounds(0, 0, 690, 690); 
        pan2.setBounds(692, 0, 155, 265); 
        pan3.setBounds(692, 265, 250, 250); 
        
        pan1.setLayout(new GridLayout(n, m));
        pan2.setLayout(null); 
        pan3.setLayout(new GridLayout(4, 1, 0, 5)); 
        pan.setBackground(Color.YELLOW); 
        pan1.setBackground(Color.YELLOW); 
        pan2.setBackground(Color.YELLOW); 
        pan3.setBackground(Color.YELLOW); 
         

        // Tạo và thiết lập các JButton cho bảng chơi
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                btn[i][j] = new JButton();
                btn[i][j].setBackground(Color.white);
                btn[i][j].addActionListener(this);
                tb[i][j] = 0;
                pan1.add(btn[i][j]);
            }
        }

        // Thiết lập label hiển thị thông tin lượt chơi
        l1.setText("Lượt của: " + n1);
        l1.setFont(new Font("Arial", Font.BOLD, 12)); 
        l1.setBounds(0, 0, 1500, 150); 
        l1.setForeground(Color.RED); 

        pan2.add(l1); 

        // Tạo và thiết lập các JButton cho panel nút điều khiển
        JButton blai = new JButton("Chơi lại");
        blai.setBackground(Color.GREEN);
        blai.setActionCommand("Choi lai");
        blai.addActionListener(this);
        JButton bmoi = new JButton("Chơi mới");
        bmoi.setBackground(Color.GREEN);
        bmoi.setActionCommand("Choi moi");
        bmoi.addActionListener(this);
        JButton bthua = new JButton("Xin thua");
        bthua.setBackground(Color.GREEN);
        bthua.setActionCommand("Xin thua");
        bthua.addActionListener(this);
        JButton bthoat = new JButton("Thoát");
        bthoat.setBackground(Color.GREEN);
        bthoat.setActionCommand("Thoat");
        bthoat.addActionListener(this);

        // Thêm các JButton vào panel nút điều khiển
        pan3.add(bthua);
        pan3.add(blai);
        pan3.add(bmoi);
        pan3.add(bthoat);

        // Thêm các panel vào panel chính
        pan.add(pan1);
        pan.add(pan2);
        pan.add(pan3);
        
        this.setContentPane(pan); // Đặt panel chính là nội dung của cửa sổ
    }

    // Xử lý sự kiện khi người dùng tương tác với các thành phần trên giao diện
    public void actionPerformed(ActionEvent e) {
        // Xử lý khi người chơi nhấn nút "Xin thua"
        if ("Xin thua".equalsIgnoreCase(e.getActionCommand())) {
            // Hiển thị cửa sổ thông báo người chiến thắng và đóng cửa sổ trò chơi
            if (ng % 2 == 0) {
                new end(n1, n2, n1).setVisible(true);
            } else {
                new end(n1, n2, n2).setVisible(true);
            }
            this.dispose();
        }
        // Xử lý khi người chơi nhấn nút "Chơi lại"
        if ("Choi lai".equalsIgnoreCase(e.getActionCommand())) {
            // Khởi tạo một trò chơi mới với các người chơi hiện tại và đóng cửa sổ trò chơi cũ
            new play(n1, n2).setVisible(true);
            this.dispose();
        }
        // Xử lý khi người chơi nhấn nút "Chơi mới"
        if ("Choi moi".equalsIgnoreCase(e.getActionCommand())) {
            // Hiển thị cửa sổ bắt đầu trò chơi mới và đóng cửa sổ trò chơi cũ
            new start().setVisible(true);
            this.dispose();
        }
        // Xử lý khi người chơi nhấn nút "Thoát"
        if ("Thoat".equalsIgnoreCase(e.getActionCommand())) {
            // Thoát khỏi ứng dụng
            System.exit(0);
        }
        // Xác định vị trí ô được nhấn và thực hiện lượt chơi
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (e.getSource() == btn[i][j] && tb[i][j] == 0) {
                    if (ng % 2 == 0) {
                        l1.setText("Lượt của: " + n1);
                        btn[i][j].setIcon(icon3);
                        ng++;
                        tb[i][j] = 1;
                        if (win(i, j, tb[i][j])) {
                            new end(n1, n2, n2).setVisible(true);
                            this.dispose();
                        }
                    } else {
                        l1.setText("Lượt của: " + n2);
                        btn[i][j].setIcon(icon2);
                        ng++;
                        tb[i][j] = 2;
                        if (win(i, j, tb[i][j])) {
                            new end(n1, n2, n1).setVisible(true);
                            this.dispose();
                        }
                    }
                    break;
                }
            }
        }
    }

    // Phương thức kiểm tra chiến thắng
    private boolean win(int x, int y, int gt) {
        // Các biến dùng để đếm và lưu vị trí
        int d, k, j, xd, yd, xc, yc;
        d = xd = yd = xc = yc = 0;
        // Kiểm tra chiến thắng theo hàng ngang
        for (k = -5; k <= 5; k++) {
            if (y + k >= 0 && y + k < n) {
                if (tb[x][y + k] == gt) {
                    d++;
                    yc = y + k;
                } else if (d < 5) {
                    d = 0;
                }
            }
        }
        if (d == 5) {
			for (k = -4; k <= 4; k++) {// tim toa do y dau
				if (y + k >= 0 && y + k < n) {
					if (tb[x][y + k] == gt) {
						yd = y + k;
						break;
					}
				}
			}
			// xet cac truong hop
			if (yd == 0) {
				if (tb[x][y + 1] == 0) {
					return true;
				}
			} else if (yc == n - 1) {
				if (tb[x][y - 1] == 0) {
					return true;
				}
			} else {
				if (tb[x][yd - 1] * tb[x][yc + 1] == 0) {
					return true;
				}
			}
			d = 0;
		} else {
			d = 0;
		}
//doc
		for (k = -5; k <= 5; k++) {
			if (x + k >= 0 && x + k < n) {
				if (tb[x + k][y] == gt) {
					d++;
					xc = x + k;
				} else if (d < 5) {
					d = 0;
				}
			}
		}
		if (d == 5) {
			for (k = -4; k <= 4; k++) {
				if (x + k >= 0 && x + k < n) {
					if (tb[x + k][y] == gt) {
						xd = x + k;
						break;
					}
				}
			}
			if (xd == 0) {
				if (tb[x + 1][y] == 0) {
					return true;
				}
			} else if (xc == n - 1) {
				if (tb[x - 1][y] == 0) {
					return true;
				}
			} else {
				if (tb[xd - 1][y] * tb[xc + 1][y] == 0) {
					return true;
				}
			}
			d = 0;
		} else {
			d = 0;
		}
//cheo 19:0 - 0:19
		for (k = -5, j = 5; k <= 5 && j >= -5; k++, j--) {
			if (y + k >= 0 && y + k < n && x + j >= 0 && x + j < m) {
				if (tb[x + j][y + k] == gt) {
					d++;
					xc = x + j;
					yc = y + k;
				} else if (d < 5) {
					d = 0;
				}
			}
		}
		if (d == 5) {
			for (k = -4, j = 4; k <= 4 && j >= -4; k++, j--) {
				if (y + k >= 0 && y + k < n && x + j >= 0 && x + j < m) {
					if (tb[x + j][y + k] == gt) {
						xd = x + j;
						yd = y + k;
						break;
					}
				}
			}
			if (yd == 0 || xd == n - 1) {
				if (tb[xc - 1][yc + 1] == 0)
					return true;
			} else if (yc == n - 1 || xc == 0) {
				if (tb[xd + 1][yd - 1] == 0) {
					return true;
				}
			} else {
				if (tb[xd + 1][yd - 1] * tb[xc - 1][yc + 1] == 0) {
					return true;
				}
			}
			d = 0;
		} else {
			d = 0;
		}
//cheo 0:0 - 19:19
		for (k = -5; k <= 5; k++) {
			if (y + k >= 0 && y + k < n && x + k >= 0 && x + k < m) {
				if (tb[x + k][y + k] == gt) {
					d++;
					xc = x + k;
					yc = y + k;
				} else if (d < 5) {
					d = 0;
				}
			}
		}
		if (d == 5) {
			for (k = -5; k <= 5; k++) {
				if (y + k >= 0 && y + k < n && x + k >= 0 && x + k < m) {
					if (tb[x + k][y + k] == gt) {
						xd = x + k;
						yd = y + k;
						break;
					}
				}
			}
			if (yd == 0 || xd == 0) {
				if (tb[xc + 1][yc + 1] == 0) {
					return true;
				}
			} else if (yc == n - 1 || xc == n - 1) {
				if (tb[xd - 1][yd - 1] == 0) {
					return true;
				}
			} else {
				if (tb[xd - 1][yd - 1] * tb[xc + 1][yc + 1] == 0) {
					return true;
				}
			}
		}
	
        
        return false;
    }
}
