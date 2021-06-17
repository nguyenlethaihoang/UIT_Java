package bai50;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class TestConnectionToMySql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String strConn="jdbc:mysql://localhost/dbtaisan"; 
			Properties pro = new Properties();
			pro.put("username", "root"); // root la account mac dinh luc ta cai dat XAMP
			pro.put("password", "");
			Driver  driver = new Driver();
			Connection conn = driver.connect(strConn, pro);
			if(conn!=null)
				System.out.println("Kết nối tới CSDL dbTaiSan thành công");
			else
				System.err.println("Kết nối tới CSDL dbTaiSan thất bạn");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
