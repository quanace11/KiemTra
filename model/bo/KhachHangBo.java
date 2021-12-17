package bo;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao= new KhachHangDao();
	public KhachHangBean checkDn(String un,String pass)throws Exception{
		return khdao.checkDn(un, pass);
	}
	public boolean insertKH(String hoten,String diachi,String sodt,String email,String tendn,String pass)throws Exception{
		return khdao.insertKH(hoten, diachi, sodt, email, tendn, pass);
	}
	public boolean checkLogin(String tendangnhap) throws Exception{
		return khdao.checkLogin(tendangnhap);
	}
}
