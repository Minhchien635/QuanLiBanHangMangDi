package quanlybanhangmangdi.model;

public class NhanVien {
	private int maNhanVien;
	private int maChucVu;
	private String hoTen;
	private String dienThoai;
	private String email;
	private boolean gioiTinh;
	private String taiKhoan;
	private String matKhau;
	
	
	
	
	
	public NhanVien(int maNhanVien, int maChucVu, String hoTen, String dienThoai, String email, boolean gioiTinh,
			String taiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.maChucVu = maChucVu;
		this.hoTen = hoTen;
		this.dienThoai = dienThoai;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	
	
	
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
}
