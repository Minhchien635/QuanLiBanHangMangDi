package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import quanlybanhangmangdi.database.DataHelper;

public class NhanVienDTO {
	private int maNhanVien;
	private String hoTen;
	private int maChucVu;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String dienThoai;
	private String diaChi;
	private String taiKhoan;
	private String matKhau;
	
	public NhanVienDTO(int maChucVu, String hoTen, boolean gioiTinh, Date ngaySinh, String dienThoai, String diaChi, String taiKhoan, String matKhau) {
	
		this.hoTen = hoTen;
		this.maChucVu = maChucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	 public  NhanVienDTO(int maNhanVien, int maChucVu,String hoTen, boolean gioiTinh, Date ngaySinh, String dienThoai, String diaChi, String taiKhoan, String matKhau) {
		this.maNhanVien = maNhanVien;
		this.maChucVu = maChucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public NhanVienDTO(String tenTaiKhoan) {
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
	
	
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean luuNhanVien() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "INSERT Into NhanVien(ma,hoten,taikhoan,matkhau,gioitinh,machucvu,ngaysinh,dienthoai,diachi)\r\n" + 
				"VALUES ('"+taoMaNhanVien()+"',"+
				"'"+hoTen+"',"+
				"'"+taiKhoan+"',"+
				"'"+matKhau+"',"+
				gioiTinh+","+
				"'"+maChucVu+"',"+
				"'"+sdf.format(ngaySinh)+"',"+
				"'"+dienThoai+"',"+
				"'"+diaChi+"')";
		boolean result = DataHelper.execAction(sql);
		return result;
	}
	
	public static void main(String[] args) {	
	}
	
	static public int taoMaNhanVien() {
		String sql = "SELECT ma FROM nhanvien\r\n" + 
				"ORDER BY ma DESC\r\n" + 
				"LIMIT 1;";
		ResultSet rs = DataHelper.execQuery(sql);
		int result=0;
		try {
			while(rs.next()) {
				result = rs.getInt("ma");
			}
			return result+1;
		} catch (SQLException e) {
			return -1;
		}
	}	
}
