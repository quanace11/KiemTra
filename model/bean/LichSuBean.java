package bean;

import java.sql.Timestamp;

public class LichSuBean {
	private Long maHD;
	private Long maCTHD;
	private String tencay;
	private Long SoluongMua;
	private String anh;
	private Long gia;
	private Timestamp ngaymua;
	private Long damua;
	public Long getDamua() {
		return damua;
	}
	public void setDamua(Long damua) {
		this.damua = damua;
	}
	public LichSuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuBean(Long maHD, Long maCTHD, String anh, String tencay, Long soluongMua, Long gia, Timestamp ngaymua, Long damua) {
		super();
		this.maHD = maHD;
		this.maCTHD = maCTHD;
		this.anh = anh;
		this.tencay = tencay;
		this.SoluongMua = soluongMua;
		this.gia = gia;
		this.ngaymua = ngaymua;
		this.damua=damua;
	}
	
	public Long getMaHD() {
		return maHD;
	}
	public void setMaHD(Long maHD) {
		this.maHD = maHD;
	}
	public Long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(Long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public String getTencay() {
		return tencay;
	}
	public void setTencay(String tencay) {
		this.tencay = tencay;
	}
	public Long getSoluongMua() {
		return SoluongMua;
	}
	public void setSoluongMua(Long soluongMua) {
		SoluongMua = soluongMua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Timestamp getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Timestamp ngaymua) {
		this.ngaymua = ngaymua;
	}
	
}
