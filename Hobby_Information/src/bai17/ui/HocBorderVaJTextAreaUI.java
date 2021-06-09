package bai17.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class HocBorderVaJTextAreaUI extends JFrame {
	JTextField txtTen;
	JTextArea txtDiaChi;
	JButton btnOk;
	public HocBorderVaJTextAreaUI(String title)
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
		
		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("OK");
		pnOk.add(btnOk);
		
		pnMain.add(pnThongTin);
		pnMain.add(pnOk);
		
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		
	}
	public void addEvents()
	{
		
	}
	public void showWindows()
	{
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
