package quanlybanhangmangdi.model;

public class TaiKhoan {
	private String taiKhoan;
	private String tenNhanVien;
	private String quyenNhanVien;
	
	public TaiKhoan(String taiKhoan, String tenNhanVien, String quyenNhanVien) {
		super();
		this.taiKhoan = taiKhoan;
		this.tenNhanVien = tenNhanVien;
		this.quyenNhanVien = quyenNhanVien;
	}
	
	
	
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getQuyenNhanVien() {
		return quyenNhanVien;
	}
	public void setQuyenNhanVien(String quyenNhanVien) {
		this.quyenNhanVien = quyenNhanVien;
	}
	
	
	
}
