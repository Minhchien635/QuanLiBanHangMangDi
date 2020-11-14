package quanlybanhangmangdi.model;

import java.lang.reflect.Executable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import quanlybanhangmangdi.database.DataHelper;

public class NhanVienTable {
	private SimpleIntegerProperty maNhanVien;
	private SimpleStringProperty tenNhanVien;
	private SimpleStringProperty chucVu;
	private SimpleStringProperty gioiTinh;
	private SimpleStringProperty ngaySinh;
	private SimpleStringProperty dienThoai;
	private SimpleStringProperty diaChi;
	private SimpleStringProperty taiKhoan;
	private SimpleStringProperty matKhau;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public NhanVienTable(Integer maNhanVien,String tenNhanVien, String chucVu, String gioiTinh, String ngaySinh, String dienThoai,
			String diaChi, String taiKhoan, String matKhau) {
		super();
		this.tenNhanVien = new SimpleStringProperty(tenNhanVien);
		this.maNhanVien = new SimpleIntegerProperty(maNhanVien);
		this.chucVu = new SimpleStringProperty(chucVu);
		this.gioiTinh = new SimpleStringProperty(gioiTinh);
		this.ngaySinh = new SimpleStringProperty(ngaySinh);
		this.dienThoai = new SimpleStringProperty(dienThoai);
		this.diaChi = new SimpleStringProperty(diaChi);
		this.taiKhoan = new SimpleStringProperty(taiKhoan);
		this.matKhau = new SimpleStringProperty(matKhau);
	}
	
	public String getTaiKhoan() {
		return taiKhoan.get();
	}


	public String getMatKhau() {
		return matKhau.get();
	}

	public String getTenNhanVien() {
		return tenNhanVien.get();
	}
	
	public Integer getMaNhanVien() {
		return maNhanVien.get();
	}
	public String getMaChucVu() {
		return chucVu.get();
	}

	public String getGioiTinh() {
		return gioiTinh.get();
	}

	public String getNgaySinh() {
		return ngaySinh.get();
	}

	public String getDienThoai() {
		return dienThoai.get();
	}

	public String getDiaChi() {
		return diaChi.get();
	}
	
	
	
	public static ArrayList<NhanVienTable> getDuLIeuTableNhanVien() {
		 ArrayList<NhanVienTable> danhSachNhanVien = new ArrayList<NhanVienTable>();
		String sql = "SELECT nv.ma, nv.hoten, cv.ten, nv.gioitinh, nv.ngaysinh, nv.dienthoai, nv.diachi, nv.taikhoan, nv.matkhau FROM NhanVien nv\r\n" + 
				"JOIN ChucVu cv On nv.machucvu = cv.ma";
		ResultSet rs = DataHelper.execQuery(sql);
		try {
			while(rs.next()) {
				Integer maNhanVien = rs.getInt("ma");
				String tenNhanVien = rs.getString("hoten");
				String chucVu = rs.getString("ten");
				String gioiTinh = rs.getString("gioiTinh");
				if(gioiTinh.equals("0")) gioiTinh = "Nữ";
				else {
					gioiTinh = "Nam";
				}
				
				String ngaySinh = sdf.format(rs.getDate("ngaysinh"));
				String dienThoai = rs.getString("dienthoai");
				String diaChi = rs.getString("diachi");
				String taiKhoan = rs.getString("taikhoan");
				String matKhau = rs.getString("matkhau");
				danhSachNhanVien.add(new NhanVienTable(maNhanVien, tenNhanVien, chucVu, gioiTinh, ngaySinh, dienThoai, diaChi, taiKhoan, matKhau));
			}
			return danhSachNhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
