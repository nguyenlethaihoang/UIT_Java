package de1;

public class CanBo {
	protected String name;
	protected int age;
	protected String gioitinh;
	protected String diachi;
	public CanBo(String name, int age, String gioitinh, String diachi) {
		this.name = name;
		this.age = age;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getGioitinh()
	{
		return gioitinh;
	}
	public void setGioiTinh(String gioitinh)
	{
		this.gioitinh = gioitinh;
	}
	public String getDiachi()
	{
		return gioitinh;
	}
	public void setDiaChi(String diachi)
	{
		this.diachi = diachi;
	}
}
