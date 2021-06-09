package bai17.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class HocBorderVaJTextAreaCheckboxRadioUI extends JFrame {
	JTextField txtTen;
	JTextArea txtDiaChi;
	JButton btnOk;
	
	JCheckBox chkDiBoi, chkDiXemPhim;
	
	JRadioButton radNam, radNu;
	ButtonGroup groupGioiTinh;
	
	
	public HocBorderVaJTextAreaCheckboxRadioUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Nhập tên: ");
		txtTen = new JTextField(20);
		
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnThongTin.add(pnTen);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		txtDiaChi = new JTextArea(5, 19);
		
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setLineWrap(true);
		
		JScrollPane sc = new JScrollPane(txtDiaChi, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(sc);
		pnThongTin.add(pnDiaChi);
		
		Border borderThongTin = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitleThongTin = new TitledBorder(borderThongTin, "Thông tin: ");
		pnThongTin.setBorder(borderTitleThongTin);
		borderTitleThongTin.setTitleColor(Color.RED);
		borderTitleThongTin.setTitleJustification(TitledBorder.CENTER);
		
		JPanel pnSoThichVaGioiTinh = new JPanel();
		//pnSoThichVaGioiTinh.setLayout(new BoxLayout(pnSoThichVaGioiTinh, BoxLayout.X_AXIS));
		
		pnSoThichVaGioiTinh.setLayout(new GridLayout(1,2));
		
		JPanel pnSoThich = new JPanel(); 
		pnSoThich.setPreferredSize(new Dimension(200, 100));
		Border borderSoThich = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleborderSoThich = new TitledBorder(borderSoThich, "Sở thích");
		pnSoThich.setBorder(titleborderSoThich);
		
		
		pnSoThich.setLayout(new BoxLayout(pnSoThich, BoxLayout.Y_AXIS));
		chkDiBoi = new JCheckBox("Đi bơi: ");
		chkDiXemPhim = new JCheckBox("Đi xem phim: ");
		pnSoThich.add(chkDiBoi);
		pnSoThich.add(chkDiXemPhim);
		pnSoThichVaGioiTinh.add(pnSoThich);
		
		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setPreferredSize(new Dimension(200, 100));
		Border borderGioiTinh = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleborderGioiTinh = new TitledBorder(borderGioiTinh, "Giới tính");
		pnGioiTinh.setBorder(titleborderGioiTinh);
		
		pnGioiTinh.setLayout(new BoxLayout(pnGioiTinh, BoxLayout.Y_AXIS));
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		groupGioiTinh = new ButtonGroup();
		groupGioiTinh.add(radNam);
		groupGioiTinh.add(radNu);
		pnGioiTinh.add(radNam);
		pnGioiTinh.add(radNu);
		pnSoThichVaGioiTinh.add(pnGioiTinh);
		
		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("OK");
		pnOk.add(btnOk);
		
		pnMain.add(pnThongTin);
		pnMain.add(pnSoThichVaGioiTinh);
		pnMain.add(pnOk);
		
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		
	}
	public void addEvents()
	{
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				xyLyLayThongTin();
			}
		});
	}
	protected void xyLyLayThongTin() {
		// TODO Auto-generated method stub
		String msg = txtTen.getText()+"\n";
		msg+=txtDiaChi.getText()+"\n";
		
		String sothich="";
		if(chkDiBoi.isSelected())
			sothich+=chkDiBoi.getText()+"\n";
		if(chkDiXemPhim.isSelected())
			sothich+=chkDiXemPhim.getText()+"\n";
		msg+=sothich+"\n";
		
		String  gioitinh="";
		if(radNam.isSelected())
			gioitinh=radNam.getText()+"\n";
		else
			gioitinh=radNu.getText()+"\n";
		
		msg+=gioitinh;
		JOptionPane.showMessageDialog(null, msg);
	}
	public void showWindows()
	{
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
