package bean;

public class KhachHangBean {
	private Long makh;
	private String hoten;
	private String diachi;
	private String sodt;
	private String email;
	public Long getMakh() {
		return makh;
	}
	public void setMakh(Long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public KhachHangBean(Long makh, String hoten, String diachi, String sodt, String email) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
	}
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
