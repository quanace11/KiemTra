package bo;

import java.util.ArrayList;

import bean.CayBean;
import dao.CayDao;

public class CayBo {
	CayDao cayDao=new CayDao();
	public ArrayList<CayBean> getCay() throws Exception{
		return cayDao.getCay();
	}
	public ArrayList<CayBean>timCay (String key) throws Exception{
		ArrayList<CayBean> find=new ArrayList<CayBean>();
		for(CayBean cBean: cayDao.getCay()) 
		{
			if(cBean.getTencay().toLowerCase().contains(key.toLowerCase()))
				find.add(cBean);
		}
		return find;
	}
	public ArrayList<CayBean> timLoaiCay(String maLoai)throws Exception{
		ArrayList<CayBean> lst = new ArrayList<>();
		for(CayBean cBean: cayDao.getCay())
		{
			if(cBean.getMaloai().equals(maLoai)) 
			{
				lst.add(cBean);
			}
		}
		return lst;
	}
	public CayBean timKiemMaCay(String key) throws Exception {
		ArrayList<CayBean> lst= getCay();
		for(CayBean cay : lst) {
			if(cay.getMacay().equals(key)) {
				return cay;
			}
		}
		return null;
	}
}
