package quanlybanhangmangdi.database;

import java.sql.Date;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietHoaDon;
import quanlybanhangmangdi.model.DonHang;
import quanlybanhangmangdi.model.DonHangTable;
import quanlybanhangmangdi.model.NhanVien;

public class DAO {
	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static ArrayList<NhanVien> getDuLieuNhanVien() {
		ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien";
		ResultSet rs = DataHelper.execQuery(sql);
		
		
		
		try {
			while(rs.next()) {
				int maNhanVien = rs.getInt("ma");
				int maChucVu = rs.getInt("machucvu");
				String hoTen = rs.getString("hoten");
				String dienThoai = rs.getString("dienthoai");
				String email = rs.getString("email");
				String taiKhoan = rs.getString("taikhoan");
				String matKhau = rs.getString("matkhau");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				
				danhSachNhanVien.add(new NhanVien(maNhanVien, maChucVu, hoTen, dienThoai, email, gioiTinh, taiKhoan, matKhau));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}
	
	public static ArrayList<DonHang> getDuLieuDonHang() {
		ArrayList<DonHang> danhSachDonHang = new ArrayList<DonHang>();
		String query = "SELECT * FROM HoaDon";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maDon = rs.getString("ma");
				Date d = rs.getDate("ThoiGian");
				int maNV = rs.getInt("MaNV");
				String maApp = rs.getString("MaApp");
				String maDonApp = rs.getString("MaDonTrenApp");
				int chietKhau = rs.getInt("ChietKhau");
				int tongGia = rs.getInt("TongGia");
				int phiDichVu = rs.getInt("PhiDichVu");
				int tongTienThu = rs.getInt("TongTienThu");
				danhSachDonHang.add(
						new DonHang(maDon, maNV, d, maApp, maDonApp, tongGia, chietKhau, phiDichVu, tongTienThu, getCacChiTietDon(maDon)));
			}
			return danhSachDonHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static ArrayList<ChiTietHoaDon> getCacChiTietDon(String maDon) {
		ArrayList<ChiTietHoaDon> danhSachChiTiet = new ArrayList<ChiTietHoaDon>();
		String query = "SELECT * FROM ChiTietHoaDon WHERE maHD = \" "+maDon +"\"";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maMon = rs.getString("mamon");
				int soLuong = rs.getInt("soLuong");
				danhSachChiTiet.add(new ChiTietHoaDon(maMon, soLuong));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<DonHangTable> getDuLieuDonHangTable() {
		ArrayList<DonHangTable> danhSachDonHang = new ArrayList<DonHangTable>();
		String query = "SELECT * FROM HoaDon";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maDon = rs.getString("ma");
				Timestamp d = rs.getTimestamp("ThoiGian");
				int maNV = rs.getInt("MaNV");
				String maApp = rs.getString("MaApp");
				String maDonApp = rs.getString("MaDonTrenApp");
				int chietKhau = rs.getInt("ChietKhau");
				int tongGia = rs.getInt("TongGia");
				int phiDichVu = rs.getInt("PhiDichVu");
				int tongTienThu = rs.getInt("TongTienThu");
				danhSachDonHang.add(new DonHangTable(maDon, Test.nhanVien.getHoTen(), sdf.format(d), getTenAppTuMaApp(maApp), maDonApp,tongGia, chietKhau, phiDichVu, tongTienThu));
			}
			return danhSachDonHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	static private String getTenAppTuMaApp(String maApp)  {
    	String sql = "SELECT ten FROM app\r\n" + 
    			" WHERE ma = " + "\"" + maApp +"\"";
    	ResultSet rs = DataHelper.execQuery(sql);
    		String tenApp = null;
			try {
				while(rs.next()) {
					tenApp = rs.getString("ten");
				}
				return tenApp;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
    	
    }
	
	
}
