package bai16.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinhBac1UI extends JFrame {
	// Instance varible: bien toan cuc
	JTextField txtHeSoA, txtHeSoB, txtKetQua;
	JButton btnGiai, btnThoat, btnHelp;
	
	ActionListener eventGiai = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			xuLyGiaiPhuongTrinh();
		}
	};
	
	public PhuongTrinhBac1UI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	protected void xuLyGiaiPhuongTrinh() {
		// TODO Auto-generated method stub
		// Lấy giá trị từ JTextField xuống
		String hsa = txtHeSoA.getText();
		String hsb = txtHeSoB.getText();
		double a = Double.parseDouble(hsa);
		double b = Double.parseDouble(hsb);
		if(a == 0 && b == 0)
		{
			// gán giá trị lên JTextField
			txtKetQua.setText("Vô số nghiệm");
		}
		else if(a == 0 && b != 0)
		{
			txtKetQua.setText("Vô nghiệm");
		}
		else 
		{
			double x = -b/a;
			txtKetQua.setText("x="+x );
		}
		
	}
	public void addEvents()
	{
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnGiai.addActionListener(eventGiai);
	}
	public void addControls()
	{
		// tạo container
		Container con = getContentPane();
		// tạo panel
		JPanel pnMain = new JPanel();
		// layout từ trên xuống, liệt kê theo từng dòng
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// thêm panel vào container
		con.add(pnMain);
		
		// Dòng 1: tiêu đề
		JPanel pnTitle = new JPanel();
		// layout tiêu đề được sắp xếp theo dạng Flow Layout
		pnTitle.setLayout(new FlowLayout());
		// tạo label với tiêu đề:
		JLabel lblTieuDe = new JLabel("Giải phương trình bậc 1");
		// thêm label tiêu đề vào panel tiêu đề
		pnTitle.add(lblTieuDe);
		// thêm panel tiêu đề vào panel main
		pnMain.add(pnTitle);
		// Đặt màu chữ cho label
		lblTieuDe.setForeground(Color.blue);
		Font fontTieuDe = new Font("arial", Font.BOLD, 20);
		lblTieuDe.setFont(fontTieuDe);
		
		
		// Hệ số A
		JPanel pnHeSoA = new JPanel();
		pnHeSoA.setLayout(new FlowLayout());
		JLabel lblHeSoA = new JLabel("Hệ số a: ");
		txtHeSoA = new JTextField(15);
		pnHeSoA.add(lblHeSoA);
		pnHeSoA.add(txtHeSoA);
		pnMain.add(pnHeSoA);
		
		// Hệ số B
		JPanel pnHeSoB = new JPanel();
		pnHeSoB.setLayout(new FlowLayout());
		JLabel lblHeSoB = new JLabel("Hệ số b: ");
		txtHeSoB = new JTextField(15);
		pnHeSoB.add(lblHeSoB);
		pnHeSoB.add(txtHeSoB);
		pnMain.add(pnHeSoB);
		
		//
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnGiai = new JButton("Giải");
		btnThoat = new JButton("Thoát");
		// gán hình 
		btnThoat.setIcon(new ImageIcon("hinh/exit.png"));
		
		btnHelp = new JButton("Help");
		pnButton.add(btnHelp);
		pnButton.add(btnGiai);
		pnButton.add(btnThoat);
		pnMain.add(pnButton);
		
		//
		JPanel pnKetQua = new JPanel();
		pnKetQua.setLayout(new FlowLayout());
		JLabel lblKetQua = new JLabel("Kết quả: ");
		txtKetQua = new JTextField(15);
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetQua);
		pnMain.add(pnKetQua);
	}
	public void showWindow()
	{
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
