package bean;

import java.time.LocalDateTime;

public class HoaDonBean {
	private Long mahoadon;
	private Long makh;
	private LocalDateTime ngayMua;
	private boolean damua;
	public HoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonBean(Long mahoadon, Long makh, LocalDateTime ngayMua, boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.ngayMua = ngayMua;
		this.damua = damua;
	}
	public Long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(Long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public Long getMakh() {
		return makh;
	}
	public void setMakh(Long makh) {
		this.makh = makh;
	}
	public LocalDateTime getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(LocalDateTime ngayMua) {
		this.ngayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
}
