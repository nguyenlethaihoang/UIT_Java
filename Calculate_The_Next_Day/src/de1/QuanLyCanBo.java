package de1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyCanBo {
	private List<CanBo> canbo;
	
	public QuanLyCanBo() {
		this.canbo = new ArrayList<>();
	}
	public void themCanBo(CanBo canbo1)
	{
		this.canbo.add(canbo1);
	}
	public List<CanBo> timTenCanBo(String name) {
        return this.canbo.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toList());
    }
    public String hienThiDanhSachCanBo() {
    	String chuoi = "";
        for (int i = 0; i < canbo.size(); i++)
        	chuoi += canbo.get(i).toString()+ "\n";
        return chuoi;
    }


}
