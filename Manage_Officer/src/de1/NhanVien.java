package de1;

public class NhanVien extends CanBo {
	private String CongViec;
	public NhanVien(String name, int age, String gioitinh, String diachi, String CongViec) {
		// TODO Auto-generated constructor stub
		super(name, age, gioitinh, diachi);
		this.CongViec = CongViec;
	}
	public String getCongViec()
	{
		return CongViec;
	}
	public void setCongViec(String CongViec)
	{
		this.CongViec = CongViec;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nhan vien: ten - " + name + ", tuoi - " + age + ", gioi tinh - " + gioitinh + ", dia chi - " + diachi + ", cong viec - " + CongViec;
	}
}
