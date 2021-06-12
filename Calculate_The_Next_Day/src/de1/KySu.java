package de1;

import javax.swing.JOptionPane;

public class KySu extends CanBo {
	private String nganhDaoTao;
	public KySu(String name, int age, String gioitinh, String diachi, String nganhDaoTao) {
		super(name, age, gioitinh, diachi);
		this.nganhDaoTao = nganhDaoTao;
	}
	
	public String getNganhDaoTao()
	{
		return this.nganhDaoTao;
	}
	public void setNganhDaoTao(String nganhDaoTao)
	{
		this.nganhDaoTao = nganhDaoTao;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ky su: ten - " + name + ", tuoi - " + age + ", gioi tinh - " + gioitinh + ", dia chi - " + diachi + ", nganh dao tao - " + nganhDaoTao;
	}
}
