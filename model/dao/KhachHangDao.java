package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.KhachHangBean;

public class KhachHangDao {
	public KhachHangBean checkDn(String un,String pass)throws Exception{
		try {
			DungChung dc =new DungChung();
			KhachHangBean kh=null;
			dc.KetNoi();
			String sql="SELECT makh,hoten,diachi,sodt,email from KhachHang where tendn=? and pass=?";
			PreparedStatement  cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,un);
			cmd.setString(2,pass);
			ResultSet rs=cmd.executeQuery();
			if(rs.next()==false)
				return null;
			else
			{
				Long makh=rs.getLong("makh");
				String hoten=rs.getString("hoten");
				String diachi=rs.getString("diachi");
				String sodt =rs.getString("sodt");
				String email=rs.getString("email");
				kh=new KhachHangBean(makh,hoten,diachi,sodt,email);
			}
			rs.close();
			dc.cn.close();
			return kh;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean insertKH(String hoten,String diachi,String sodt,String email,String tendn,String pass)throws Exception{
		
			String sql ="INSERT INTO dbo.KhachHang(hoten,diachi,sodt,email,tendn,pass)"+" values(?,?,?,?,?,?)";
			DungChung dc=new DungChung();
			dc.KetNoi();
			try {
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1, hoten);
			cmd.setString(2, diachi);
			cmd.setString(3, sodt);
			cmd.setString(4, email);
			cmd.setString(5, tendn);
			cmd.setString(6, pass);
			cmd.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean checkLogin(String tendangnhap) throws Exception{
		String sqlString = "Select * from dbo.KhachHang where tendn=?";
		boolean checktendangnhap = false;
		DungChung dc= new DungChung();
		dc.KetNoi();
		try {
			
            PreparedStatement cmd =dc.cn.prepareStatement(sqlString);
            cmd.setString(1, tendangnhap);
            ResultSet rs = cmd.executeQuery();
            if(rs.next() == false) {
            	checktendangnhap = true;
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return checktendangnhap;
	}
	
}
