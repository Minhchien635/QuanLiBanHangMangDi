package quanlybanhangmangdi.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import quanlybanhangmangdi.database.DataHelper;

public class NhanVien {
	private int maNhanVien;
	private int maChucVu;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String dienThoai;
	private String diaChi;
	private String taiKhoan;
	private String matKhau;
	
	
	
	public NhanVien(int maNhanVien, int maChucVu, boolean gioiTinh, Date ngaySinh, String dienThoai, String diaChi,
			String taiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.maChucVu = maChucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	public NhanVien(String tenTaiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public String getHoTen() {
		String sql = "SELECT * FROM NhanVien WHERE ma = "+maNhanVien;
		String ten = null;
		ResultSet rs = DataHelper.execQuery(sql);
		try {
			while(rs.next()) {
				ten = rs.getString("hoten");
			}
			return ten;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
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
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
