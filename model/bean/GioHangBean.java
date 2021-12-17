package bean;

public class GioHangBean {
	private String macay;
	private String anh;
	private String tencay;
	private Long gia;
	private Long slMua;
	private Long thanhTien;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public GioHangBean(String macay, String anh, String tencay, Long gia, Long slMua) {
		super();
		this.macay = macay;
		this.anh = anh;
		this.tencay = tencay;
		this.gia = gia;
		this.slMua = slMua;
		this.thanhTien=gia*slMua;
	}


	public Long getThanhTien() {
		return gia*slMua;
	}


	public void setThanhTien(Long thanhTien) {
		this.thanhTien = gia*slMua;
	}


	public String getMacay() {
		return macay;
	}
	public void setMacay(String macay) {
		this.macay = macay;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getTencay() {
		return tencay;
	}
	public void setTencay(String tencay) {
		this.tencay = tencay;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSlMua() {
		return slMua;
	}
	public void setSlMua(Long slMua) {
		this.slMua = slMua;
	}
	
	
	
}
