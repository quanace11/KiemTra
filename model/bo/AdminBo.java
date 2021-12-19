package bo;

import bean.AdminBean;
import dao.AdminDao;

public class AdminBo {
	AdminDao amDao=new AdminDao();
	public AdminBean getAdmin(String tk, String mk) throws Exception {
		return amDao.getAdmin(tk, mk);
	}
}
