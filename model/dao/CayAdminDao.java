package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CayAdminBean;

public class CayAdminDao {
	public ArrayList<CayAdminBean> ds=new ArrayList<CayAdminBean>();
	public ArrayList<CayAdminBean> getCay() throws Exception{
		DungChung dc =new DungChung();
		dc.KetNoi();
		String sql="select *from cay";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		try {
			while(rs.next()) {
				String macay=rs.getString("macay");
				String tencay=rs.getString("tencay");
				Long soluong=rs.getLong("soluong");
				Long gia=rs.getLong("gia");
				String maloai=rs.getString("maloai");
				String anh =rs.getString("anh");
				Date ngaynhap=rs.getDate("NgayNhap");
				ds.add(new CayAdminBean(macay,tencay,soluong,gia,maloai,anh,ngaynhap));
			}
			cmd.close();
			rs.close();
			return ds;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean delete (String ms) throws Exception{
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "DELETE cay where macay=?";
		
		try {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			
			cmd.setString(1, ms);
			cmd.executeUpdate();
			
			dc.cn.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
