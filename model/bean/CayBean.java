package bean;

public class CayBean {
	private String macay;
	private String tencay;
	private Long gia;
	private String maloai;
	private String anh;
	public CayBean() {
		super();
		// TODO Auto-generated constructor stub
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
	public CayBean(String macay, String tencay, Long gia, String maloai, String anh) {
		super();
		this.macay = macay;
		this.tencay = tencay;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
	}
	
	
}
