package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xdhcsdl");
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-MJ6NFMN:1433;databaseName=QlCay;user=sa;password=123456");
		System.out.println("Da ket noi");
	}
}
