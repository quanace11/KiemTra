package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.LichSuAdminBean;

public class LichSuAdminDao {
	public ArrayList<LichSuAdminBean> getLichSu()throws Exception{
		ArrayList<LichSuAdminBean> list1=new ArrayList<LichSuAdminBean>();
		String sql="Select cthd.mahoadon,cthd.machitiethd,c.anh,c.tencay,cthd.SoLuongMua,c.gia,hd.NgayMua,cthd.damua from cay as c inner join ChiTietHoaDon as cthd on c.macay=cthd.macay inner join hoadon as hd on hd.mahoadon=cthd.mahoadon where cthd.damua=0"; 
		DungChung dc =new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			
			while (rs.next()) {
				 Long maHD =rs.getLong("mahoadon");
				 Long maCTHD=rs.getLong("machitiethd");
				 String anh=rs.getString("anh");
				 String tencay=rs.getString("tencay");
				 Long soluongmua=rs.getLong("SoLuongMua");
				 Long gia=rs.getLong("gia");
				 Timestamp ngaymua=rs.getTimestamp("NgayMua");
				 Long damua=rs.getLong("damua");
				 list1.add(new LichSuAdminBean(maHD,maCTHD,anh,tencay,soluongmua,gia,ngaymua,damua));
			 }
			 cmd.close();
			 rs.close();
			 return list1;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean xacnhanKh(Long id)throws Exception{
		String sql="UPDATE ChiTietHoaDon SET damua=1 where machitiethd=?";
		DungChung dc= new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			cmd.executeUpdate();
			cmd.close();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean xacnhanall() throws Exception{
		String sql="UPDATE ChiTietHoaDon SET damua=1";
		DungChung dc= new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.executeUpdate();
			cmd.close();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<LichSuAdminBean> getLichSuDaMua()throws Exception{
		ArrayList<LichSuAdminBean> list1=new ArrayList<LichSuAdminBean>();
		String sql="Select cthd.mahoadon,cthd.machitiethd,c.anh,c.tencay,cthd.SoLuongMua,c.gia,hd.NgayMua,cthd.damua from cay as c inner join ChiTietHoaDon as cthd on c.macay=cthd.macay inner join hoadon as hd on hd.mahoadon=cthd.mahoadon where cthd.damua=1"; 
		DungChung dc =new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			
			while (rs.next()) {
				 Long maHD =rs.getLong("mahoadon");
				 Long maCTHD=rs.getLong("machitiethd");
				 String anh=rs.getString("anh");
				 String tencay=rs.getString("tencay");
				 Long soluongmua=rs.getLong("SoLuongMua");
				 Long gia=rs.getLong("gia");
				 Timestamp ngaymua=rs.getTimestamp("NgayMua");
				 Long damua=rs.getLong("damua");
				 list1.add(new LichSuAdminBean(maHD,maCTHD,anh,tencay,soluongmua,gia,ngaymua,damua));
			 }
			 cmd.close();
			 rs.close();
			 return list1;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
