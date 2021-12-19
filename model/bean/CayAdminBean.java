package bean;

import java.sql.Date;

public class CayAdminBean {
	private String macay;
	private String tencay;
	private Long soluong;
	private Long gia;
	private String maloai;
	private String anh;
	private Date NgayNhap;
	public CayAdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CayAdminBean(String macay, String tencay, Long soluong, Long gia, String maloai, String anh, Date ngayNhap) {
		super();
		this.macay = macay;
		this.tencay = tencay;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
		NgayNhap = ngayNhap;
	}
	public String getMacay() {
		return macay;
	}
	public void setMacay(String macay) {
		this.macay = macay;
	}
	public String getTencay() {
		return tencay;
	}
	public void setTencay(String tencay) {
		this.tencay = tencay;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	
}
