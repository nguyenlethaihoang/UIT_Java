package de1;

public class CongNhan extends CanBo {
	private int CapDo;
	public CongNhan(String name, int age, String gioitinh, String diachi, int CapDo) {
		super(name, age, gioitinh, diachi);
		this.CapDo = CapDo;
	}
	public int getCapDo()
	{
		return CapDo;
	}
	public void setCapDo(int CapDo)
	{
		this.CapDo = CapDo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nhan vien: ten - " + name + ", tuoi - " + age + ", gioi tinh - " + gioitinh + ", dia chi - " + diachi + ", cap do - " + CapDo;

	}
}
