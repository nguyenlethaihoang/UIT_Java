package de1.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de1.CanBo;
import de1.CongNhan;
import de1.KySu;
import de1.NhanVien;
import de1.QuanLyCanBo;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class QuanLyUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtGioiTinh;
	private JTextField txtDiaChi;
	private JTextField txtTimTen;
	private JTextField txtChange;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyUI frame = new QuanLyUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyUI() {
		
		QuanLyCanBo quanlycanbo = new QuanLyCanBo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 619);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9: ");
		panel_4.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		panel_4.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh: ");
		panel_3.add(lblGioiTinh);
		
		txtGioiTinh = new JTextField();
		panel_3.add(txtGioiTinh);
		txtGioiTinh.setColumns(10);
		
		JLabel lblTuoi = new JLabel("Tu\u1ED5i: ");
		panel_2.add(lblTuoi);
		
		txtTuoi = new JTextField();
		panel_2.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		JLabel lblTen = new JLabel("T\u00EAn: ");
		panel_1.add(lblTen);
		
		txtTen = new JTextField();
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblChange = new JLabel("Th\u00F4ng tin: ");
		
		JRadioButton radKySu = new JRadioButton("K\u1EF9 s\u01B0");
		buttonGroup.add(radKySu);
		radKySu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChange.setText("Ngành đào tạo: ");
			}
		});
		panel.add(radKySu);
		
		JRadioButton radNhanVien = new JRadioButton("Nh\u00E2n vi\u00EAn");
		radNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChange.setText("Công việc: ");
			}
			
		});
		buttonGroup.add(radNhanVien);
		panel.add(radNhanVien);
		
		JRadioButton radCongNhan = new JRadioButton("C\u00F4ng nh\u00E2n");
		radCongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChange.setText("Cấp độ: ");
			}
		});
		buttonGroup.add(radCongNhan);
		panel.add(radCongNhan);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10);
		
		
		panel_10.add(lblChange);
		
		txtChange = new JTextField();
		panel_10.add(txtChange);
		txtChange.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radKySu.isSelected())
				{
					CanBo canbo = new KySu(txtTen.getText(), Integer.parseInt(txtTuoi.getText()), txtGioiTinh.getText(), txtDiaChi.getText(), txtChange.getText());
					quanlycanbo.themCanBo(canbo);
					JOptionPane.showMessageDialog(null, canbo.toString());
				}
				if (radCongNhan.isSelected())
				{
					CanBo canbo = new CongNhan(txtTen.getText(), Integer.parseInt(txtTuoi.getText()), txtGioiTinh.getText(), txtDiaChi.getText(), Integer.parseInt(txtChange.getText()));
					quanlycanbo.themCanBo(canbo);
					JOptionPane.showMessageDialog(null, canbo.toString());
				}
				if (radNhanVien.isSelected())
				{
					CanBo canbo = new NhanVien(txtTen.getText(), Integer.parseInt(txtTuoi.getText()), txtGioiTinh.getText(), txtDiaChi.getText(), txtChange.getText());
					quanlycanbo.themCanBo(canbo);
					JOptionPane.showMessageDialog(null, canbo.toString());
				}
			}
		});
		panel_5.add(btnThem);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JLabel lblTimTen = new JLabel("T\u00ECm t\u00EAn: ");
		panel_6.add(lblTimTen);
		
		txtTimTen = new JTextField();
		panel_6.add(txtTimTen);
		txtTimTen.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		
		
		JLabel lblTimThongTin = new JLabel(".............");
		lblTimThongTin.setBackground(Color.LIGHT_GRAY);

		
		
		JButton btnTim = new JButton("T\u00ECm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quanlycanbo.timTenCanBo(txtTimTen.getText()).forEach(canbo -> {
					lblTimThongTin.setText(canbo.toString());
					//JOptionPane.showMessageDialog(null, canbo.toString());
				});
			}
		});

		
		panel_7.add(btnTim);
		panel_7.add(lblTimThongTin);	
		
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		JTextArea txtHienCanBo = new JTextArea();
		txtHienCanBo.setRows(3);
		txtHienCanBo.setForeground(new Color(0, 0, 0));
		txtHienCanBo.setBackground(Color.LIGHT_GRAY);
		txtHienCanBo.setWrapStyleWord(true);
		txtHienCanBo.setLineWrap(true);
		txtHienCanBo.setColumns(20);
		
		JButton btnHienCanBo = new JButton("Hi\u1EC7n c\u00E1n b\u1ED9: ");
		btnHienCanBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHienCanBo.setText(quanlycanbo.hienThiDanhSachCanBo());
				
			}
		});
		panel_8.add(btnHienCanBo);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane);
		
		
		panel_8.add(txtHienCanBo);
		
		JScrollBar scrollBar = new JScrollBar();
		panel_8.add(scrollBar);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		panel_9.add(btnThoat);
	}

}
