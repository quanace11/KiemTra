package bo;

import java.util.ArrayList;

import bean.GioHangBean;
import dao.GioHangDao;

public class GioHangBo {
	GioHangDao ghdao=new GioHangDao();
	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
	public void themCay(String macay, String anh, String tencay, long gia, long slmua) {
		for (GioHangBean gh : ds) 
			if(gh.getMacay().equals(macay)) {
			gh.setSlMua(gh.getSlMua() + slmua);
			return;
			}
		ds.add(new GioHangBean(macay,anh,tencay,gia,slmua));
		System.out.println("ds ="+ds.size());
		
	}
	public void insertCTHD(Long mahoadon)throws Exception{
		for(GioHangBean gh : ds)
		{
			ghdao.insertGioHang(gh.getMacay(),gh.getSlMua(), mahoadon);
			
		}
	}
	
	
	public void xoa(String macay) {
		for (GioHangBean gh : ds) {
			if (gh.getMacay().equals(macay)) {
				ds.remove(gh);
				break;
			}
		}
	}
	
	
	public Long tongTien() {
		long tong = 0;
		for (GioHangBean gh: ds) 
			tong +=gh.getThanhTien();
		return tong;
		
	}
	public void update(String macay, long soluong) {
		for (GioHangBean gh : ds) {
			if (gh.getMacay().equals(macay)) {
				gh.setSlMua(soluong);
				break;
			}
		}
	}
	public int getSize() {
		return ds.size();
	}
	
}
