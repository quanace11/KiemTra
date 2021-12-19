package bo;

import java.util.ArrayList;

import bean.CayAdminBean;
import dao.CayAdminDao;

public class CayAdminBo {
	CayAdminDao cd=new CayAdminDao();
	public ArrayList<CayAdminBean> getCay() throws Exception{
		return cd.getCay();
	}
	public boolean delete (String ms) throws Exception{
		return cd.delete(ms);
	}
	public ArrayList<CayAdminBean>timCay (String key) throws Exception{
		ArrayList<CayAdminBean> list=new ArrayList<CayAdminBean>();
		for(CayAdminBean cBean: cd.getCay()) 
		{
			if(cBean.getTencay().toLowerCase().contains(key.toLowerCase()))
				list.add(cBean);
		}
		return list;
	}
	public ArrayList<CayAdminBean> timLoaiCay(String maLoai)throws Exception{
		ArrayList<CayAdminBean> lst = new ArrayList<>();
		for(CayAdminBean cBean: cd.getCay())
		{
			if(cBean.getMaloai().equals(maLoai)) 
			{
				lst.add(cBean);
			}
		}
		return lst;
	}
}
