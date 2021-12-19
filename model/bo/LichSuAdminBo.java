package bo;

import java.util.ArrayList;

import bean.LichSuAdminBean;
import dao.LichSuAdminDao;

public class LichSuAdminBo {
	LichSuAdminDao lsDao=new LichSuAdminDao();
	public ArrayList<LichSuAdminBean> getLichSu()throws Exception{
		return lsDao.getLichSu();
	}
	public boolean xacnhanKh(Long id)throws Exception{
		return lsDao.xacnhanKh(id);
	}
	public boolean xacnhanall() throws Exception{
		return lsDao.xacnhanall();
	}
	public ArrayList<LichSuAdminBean> getLichSuDaMua()throws Exception{
		return lsDao.getLichSuDaMua();
	}
		
}
