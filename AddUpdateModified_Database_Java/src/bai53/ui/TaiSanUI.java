package bai53.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

public class TaiSanUI extends JFrame {
	
	DefaultTableModel dtmTaiSan;
	JTable tblTaiSan; 
	
	public static Connection conn = null;
	public static Statement statement = null;
	
	JButton btnThemMoi, btnSua;
	
	public TaiSanUI(String title) {
		super(title);
		addControls();
		addEvents();
		ketNoiCSDLMySql();
		hienThiToanBoTaiSan();
	}

	private void hienThiToanBoTaiSan() {
		try
		{
			String sql ="select * from taisan1";
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			dtmTaiSan.setRowCount(0);
			while (result.next())
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getDate(3));
				vec.add(result.getInt(4));
				vec.add(result.getInt(5));
				dtmTaiSan.addRow(vec);
			}
		}
		catch (Exception ex)
		{
			
		}
		
	}

	private void ketNoiCSDLMySql() {
		// TODO Auto-generated method stub
		try
		{
			String strlConn = "jdbc:mysql://localhost/dbTaiSan";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			conn = driver.connect(strlConn, pro);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnThemMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TaiSanChiTietUI ui = new TaiSanChiTietUI("Thông tin chi tiết tài sản");
				ui.hienThiThongTinChiTiet();
				ui.showWindow();
				
				if (TaiSanChiTietUI.ketqua > 0)
					hienThiToanBoTaiSan();
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = tblTaiSan.getSelectedRow();
				if (row == -1) return;
				String ma = tblTaiSan.getValueAt(row, 0) + "";
				
				TaiSanChiTietUI ui = new TaiSanChiTietUI("Thông tin chi tiết tài sản");
				ui.matschon = ma; 
				ui.hienThiThongTinChiTiet();
				ui.showWindow();
				if (TaiSanChiTietUI.ketqua > 0)
					hienThiToanBoTaiSan(); 
			}
		});
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình quản lý tài sản");
		lblTitle.setFont(new Font("arial", Font.BOLD, 20));
		lblTitle.setForeground(Color.RED);
		pnNorth.add(lblTitle);
		con.add(pnNorth,BorderLayout.NORTH);
		
		dtmTaiSan = new DefaultTableModel(); 
		dtmTaiSan.addColumn("Mã tài sản");
		dtmTaiSan.addColumn("Tên tài sản");
		dtmTaiSan.addColumn("Ngày nhập");
		dtmTaiSan.addColumn("Số năm khấu hao");
		dtmTaiSan.addColumn("Trị giá");
		// them vao table
		tblTaiSan = new JTable(dtmTaiSan);
		JScrollPane scTable = new JScrollPane(tblTaiSan,
											JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
											JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(scTable,BorderLayout.CENTER);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnThemMoi = new JButton("Thêm mới");
		btnSua = new JButton("Sửa thông tin");
		pnButton.add(btnThemMoi);
		pnButton.add(btnSua);
		con.add(pnButton,BorderLayout.SOUTH);
	}
	public void showWindow()
	{
		this.setSize(800,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
}
