package bo;

import java.util.ArrayList;

import bean.LichSuBean;
import dao.LichSuDao;

public class LichSuBo {
	LichSuDao lsd =new LichSuDao();
	public ArrayList<LichSuBean> getHistorys(long mkh) throws Exception{
		return lsd.lichSu(mkh);
	}
}
