package bo;

import dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hdDao = new HoaDonDao();
	public boolean insertHoaDon(Long makh) throws Exception {
		return hdDao.insertHoaDon(makh);
	}
	public Long getMaHoaDon() throws Exception{
		return hdDao.getMaHoaDon();
	}
}
