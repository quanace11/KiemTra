package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.LichSuBean;

public class LichSuDao {
	public ArrayList<LichSuBean> lichSu(long mkh) throws Exception{
		ArrayList<LichSuBean> list=new ArrayList<LichSuBean>();
		String sql="select cthd.mahoadon,cthd.machitiethd,c.anh,c.tencay,cthd.SoLuongMua,c.gia,hd.NgayMua,cthd.damua from cay as c inner join ChiTietHoaDon as cthd on c.macay=cthd.macay inner join hoadon as hd on hd.mahoadon=cthd.mahoadon where makh=?";
		
		DungChung dc=new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd= dc.cn.prepareStatement(sql);
			cmd.setLong(1, mkh);
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
				 list.add(new LichSuBean(maHD,maCTHD,anh,tencay,soluongmua,gia,ngaymua,damua));
			 }
			 cmd.close();
			 rs.close();
			 return list;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
