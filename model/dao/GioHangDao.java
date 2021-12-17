package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CayBean;
import bean.GioHangBean;
import bean.KhachHangBean;

public class GioHangDao {
	
	public boolean insertGioHang(String macay,Long soluongmua,Long mahoadon) throws Exception{
		String sql = "INSERT INTO dbo.ChiTietHoaDon (macay,SoLuongMua,mahoadon)"
				+ " values(?,?,?)";
		DungChung dc = new DungChung();
		dc.KetNoi();
		try {
			
            PreparedStatement st =dc.cn.prepareStatement(sql);
            st.setString(1, macay);
            st.setLong(2, soluongmua);
            st.setLong(3, mahoadon);
           
            st.executeUpdate();     
            dc.cn.close();
            return true;
           
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	
}
