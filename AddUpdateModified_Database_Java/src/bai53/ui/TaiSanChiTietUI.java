package bai53.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaiSanChiTietUI extends JDialog {
	
	JTextField txtMa, txtTen, txtNgayNhap, txtSoNamKhauHao, txtGiaTri;
	JButton btnLuu;
	
	Connection conn = TaiSanUI.conn;
	Statement statement = TaiSanUI.statement;
	
	public String matschon  = "";
	
	public static int ketqua=-1;
	
	public TaiSanChiTietUI(String title)
	{
		this.setTitle(title);
		addConTrols();
		addEvents();
		if (matschon.length() != 0)
		{
			hienThiThongTinChiTiet();
			
		}
	}

	public void hienThiThongTinChiTiet() {
		// TODO Auto-generated method stub
		try 
		{
			String sql = "select * from taisan1 where ma='"+matschon+"'";
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next())
			{
				txtMa.setText(result.getString(1));
				txtTen.setText(result.getString(2));
				txtNgayNhap.setText(result.getString(3)+"");
				txtSoNamKhauHao.setText(result.getInt(4)+"");
				txtGiaTri.setText(result.getInt(5)+"");
				
			}
			//txtMa.setEditable(false);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				xuLyLuu();
				
			}
		});
	}

	protected void xuLyLuu() {
		// TODO   Auto-generated method stub
		if (matschon.length() == 0)
		{
			try
			{
				String sql = "insert into taisan1 values('"+txtMa.getText()+"', '"+txtTen.getText()+"', '"+txtNgayNhap.getText()+"', '"+txtSoNamKhauHao.getText()+"', '"+txtGiaTri.getText()+"')";
				statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				ketqua = x;
				// ẩn màn hình này đi
				dispose();  
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		} 
		else 
		{
			try 
			{
				String sql = "update taisan1 set ten='"+txtTen.getText()+"'"
						+ ",ngaynhaphang='"+txtNgayNhap.getText()+"'"
						+ ",sonamkhauhao="+txtSoNamKhauHao.getText() 
						+ ",giatri="+txtGiaTri.getText()+" where ma='" + txtMa.getText()+"'";
				statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				ketqua = x;
				dispose(); // an man hinh di
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	private void addConTrols() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Mã TS: ");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		con.add(pnMa);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen= new JLabel("Tên: ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		con.add(pnTen);
		
		JPanel pnNgayNhap = new JPanel();
		pnNgayNhap.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
		txtNgayNhap = new JTextField(20);
		pnNgayNhap.add(lblNgayNhap);
		pnNgayNhap.add(txtNgayNhap);
		con.add(pnNgayNhap);
		
		JPanel pnSoNamKhauHao = new JPanel();
		pnSoNamKhauHao.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSoNamKhauHao = new JLabel("Số năm khấu hao: ");
		txtSoNamKhauHao = new JTextField(20);
		pnSoNamKhauHao.add(lblSoNamKhauHao);
		pnSoNamKhauHao.add(txtSoNamKhauHao);
		con.add(pnSoNamKhauHao);
		
		JPanel pnGiaTri = new JPanel();
		pnGiaTri.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGiaTri = new JLabel("Giá trị: ");
		txtGiaTri = new JTextField(20);
		pnGiaTri.add(lblGiaTri);
		pnGiaTri.add(txtGiaTri);
		con.add(pnGiaTri);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnLuu = new JButton("Lưu tài sản");
		pnButton.add(btnLuu);
		con.add(pnButton);
		
		// canh deu label
		lblGiaTri.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblMa.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblNgayNhap.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblTen.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
	}
	public void showWindow()
	{
		this.setSize(400,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
