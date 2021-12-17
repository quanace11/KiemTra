package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CayBean;

public class CayDao {
	public ArrayList<CayBean> getCay() throws Exception{
		ArrayList<CayBean> ds= new ArrayList<CayBean>();
		DungChung dc=new DungChung();
		dc.KetNoi();
		String sql ="SELECT * From cay";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		try {
			while(rs.next()) {
				String maCay=rs.getString("macay");
				String tenCay=rs.getString("tencay");
				Long gia=rs.getLong("gia");
				String maLoai=rs.getString("maloai");
				String anh=rs.getString("anh");
				ds.add(new CayBean(maCay,tenCay,gia,maLoai,anh));
				
			}
			
			rs.close();
			dc.cn.close();
			return  ds;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
