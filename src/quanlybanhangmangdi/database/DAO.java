package quanlybanhangmangdi.database;

import java.sql.Date; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.protocol.a.TracingPacketReader;

import javafx.collections.ObservableList;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.AppGiaoHangTable;

import quanlybanhangmangdi.model.ChiTietChi;
import quanlybanhangmangdi.model.ChiTietChiTable;
import quanlybanhangmangdi.model.ChiTietHoaDonDTO;
import quanlybanhangmangdi.model.DanhSachMonTableQuanLyDonHang;
import quanlybanhangmangdi.model.DonHangDTO;
import quanlybanhangmangdi.model.DonHangTable;
import quanlybanhangmangdi.model.NguyenLieu;
import quanlybanhangmangdi.model.NguyenLieuTable;
import quanlybanhangmangdi.model.NhanVienDTO;
import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.model.TablePhieuChi;

public class DAO {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static  ArrayList<NhanVienDTO> getDuLieuNhanVien() {
		ArrayList<NhanVienDTO> danhSachNhanVien = new ArrayList<NhanVienDTO>();
		String sql = "SELECT * FROM nhanvien";
		ResultSet rs = DataHelper.execQuery(sql);
		
		try {
			while(rs.next()) {
				int maNhanVien = rs.getInt("ma");
				int maChucVu = rs.getInt("machucvu");
				String hoTen = rs.getString("hoten");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String dienThoai = rs.getString("dienthoai");
				String diaChi = rs.getString("diachi");
				String taiKhoan = rs.getString("taikhoan");
				String matKhau = rs.getString("matkhau");
				NhanVienDTO a = new NhanVienDTO(hoTen);
				danhSachNhanVien.add(new NhanVienDTO(maNhanVien, maChucVu, hoTen, gioiTinh, ngaySinh, dienThoai, diaChi, taiKhoan, matKhau));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}
	
	public static ArrayList<DonHangDTO> getDuLieuDonHang() {
		ArrayList<DonHangDTO> danhSachDonHang = new ArrayList<DonHangDTO>();
		String query = "SELECT * FROM HoaDon WHERE TrangThai = 1";
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
						new DonHangDTO(maDon, maNV, d, maApp, maDonApp, tongGia, chietKhau, phiDichVu, tongTienThu, getCacChiTietDon(maDon)));
			}
			return danhSachDonHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	public static ArrayList<ChiTietHoaDonDTO> getCacChiTietDon(String maDon) {
		ArrayList<ChiTietHoaDonDTO> danhSachChiTiet = new ArrayList<ChiTietHoaDonDTO>();
		String query = "SELECT * FROM ChiTietHoaDon WHERE maHD = \" "+maDon +"\"";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maMon = rs.getString("mamon");
				int soLuong = rs.getInt("soLuong");
				danhSachChiTiet.add(new ChiTietHoaDonDTO(maMon, soLuong));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<DonHangTable> getDuLieuDonHangTable() {
		ArrayList<DonHangTable> danhSachDonHang = new ArrayList<DonHangTable>();
		String query = "SELECT hd.ma, hd.ThoiGian, nv.hoten, hd.maApp, hd.madontrenapp, hd.chietkhau,hd.tonggia,hd.phidichvu,hd.tongtienthu FROM HoaDon hd\r\n" + 
				"JOIN NhanVien nv ON hd.maNV = nv.ma\r\n" + 
				"WHERE TRANGTHAI = 1";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maDon = rs.getString("ma");
				Timestamp d = rs.getTimestamp("ThoiGian");
				String tenNhanVien = rs.getString("hoten");
				String maApp = rs.getString("MaApp");
				String maDonApp = rs.getString("MaDonTrenApp");
				int chietKhau = rs.getInt("ChietKhau");
				int tongGia = rs.getInt("TongGia");
				int phiDichVu = rs.getInt("PhiDichVu");
				int tongTienThu = rs.getInt("TongTienThu");
				danhSachDonHang.add(new DonHangTable(maDon, tenNhanVien, sdf.format(d), getTenAppTuMaApp(maApp), maDonApp,tongGia, chietKhau, phiDichVu, tongTienThu));
			}
			return danhSachDonHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<DonHangTable> getDuLieuDonHangNhanVienTable() {
		ArrayList<DonHangTable> danhSachDonHang = new ArrayList<DonHangTable>();
		String query = "SELECT hd.ma, hd.ThoiGian, nv.hoten, hd.maApp, hd.madontrenapp, hd.chietkhau,hd.tonggia,hd.phidichvu,hd.tongtienthu FROM HoaDon hd\r\n" + 
				"JOIN NhanVien nv ON hd.maNV = nv.ma\r\n" + 
				"WHERE DATE(thoigian) = CURDATE() AND TrangThai = 1";
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				String maDon = rs.getString("ma");
				Timestamp d = rs.getTimestamp("ThoiGian");
				String tenNhanVien = rs.getString("hoten");
				String maApp = rs.getString("MaApp");
				String maDonApp = rs.getString("MaDonTrenApp");
				int chietKhau = rs.getInt("ChietKhau");
				int tongGia = rs.getInt("TongGia");
				int phiDichVu = rs.getInt("PhiDichVu");
				int tongTienThu = rs.getInt("TongTienThu");
				danhSachDonHang.add(new DonHangTable(maDon, tenNhanVien, sdf.format(d), getTenAppTuMaApp(maApp), maDonApp,tongGia, chietKhau, phiDichVu, tongTienThu));
			}
			return danhSachDonHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<DonHangTable> getDuLieuDonHangAnTable() {
		ArrayList<DonHangTable> danhSachDonHang = new ArrayList<DonHangTable>();
		String query = "SELECT * FROM HoaDon WHERE TrangThai = 0";
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
	
	public static ArrayList<TablePhieuChi> getCacPhieuChiTheoNgay(LocalDate ld) {
		ArrayList<TablePhieuChi> danhSach = new ArrayList<TablePhieuChi>();
		String query = "SELECT * FROM PhieuChi WHERE ngay LIKE " + " '" + ld + "%' " + "AND " + "trangthai = 1" ;
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				int manhanvien = rs.getInt("manhanvien");
				String query1 =  "SELECT * FROM NhanVien" + 
				" WHERE ma = " + "\"" + manhanvien +"\"";
				ResultSet rs1 = DataHelper.execQuery(query1);
				rs1.next();
				String tennhanvien = rs1.getString("hoten");
				String maphieuchi = rs.getString("ma");
				Timestamp ngay = rs.getTimestamp("ngay");
				int tongtien = rs.getInt("tonggia");
				danhSach.add(new TablePhieuChi(maphieuchi, manhanvien, tennhanvien, ngay, tongtien));
			}																			
			return danhSach;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<TablePhieuChi> getCacPhieuChiTheoThang(int th) {
		ArrayList<TablePhieuChi> danhSach = new ArrayList<TablePhieuChi>();
		String fm = String.format("%02d", th);
		String query = "SELECT * FROM PhieuChi WHERE ngay LIKE " + " '%-" + fm + "-%' " + "AND " + "trangthai = 1" ;
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				int manhanvien = rs.getInt("manhanvien");
				String query1 =  "SELECT * FROM NhanVien" + 
				" WHERE ma = " + "\"" + manhanvien +"\"";
				ResultSet rs1 = DataHelper.execQuery(query1);
				rs1.next();
				String tennhanvien = rs1.getString("hoten");
				String maphieuchi = rs.getString("ma");
				Timestamp ngay = rs.getTimestamp("ngay");
				int tongtien = rs.getInt("tonggia");
				danhSach.add(new TablePhieuChi(maphieuchi, manhanvien, tennhanvien, ngay, tongtien));
			}																			
			return danhSach;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<TablePhieuChi> getCacPhieuChi(int trangthai) {
		ArrayList<TablePhieuChi> danhSach = new ArrayList<TablePhieuChi>();
		String query = "SELECT * FROM PhieuChi WHERE trangthai = " + trangthai;
		ResultSet rs = DataHelper.execQuery(query);
		
		try {
			while(rs.next()) {
				int manhanvien = rs.getInt("manhanvien");
				String query1 =  "SELECT * FROM NhanVien" + 
				" WHERE ma = " + "\"" + manhanvien +"\"";
				ResultSet rs1 = DataHelper.execQuery(query1);
				rs1.next();
				String tennhanvien = rs1.getString("hoten");
				String maphieuchi = rs.getString("ma");
				Timestamp ngay = rs.getTimestamp("ngay");
				int tongtien = rs.getInt("tonggia");
				danhSach.add(new TablePhieuChi(maphieuchi, manhanvien, tennhanvien, ngay, tongtien));
			}																			
			return danhSach;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  static ArrayList<ChiTietChiTable> getChiTietChi(String maphieuchi){
    	ArrayList<ChiTietChiTable> list = new ArrayList<ChiTietChiTable>();
	 	String sql = "SELECT * FROM ChiTietChi" + 
			" WHERE maphieuchi = " + "\"" + maphieuchi +"\"";
    	ResultSet rs = DataHelper.execQuery(sql);
    	try {
			
    		while(rs.next()) {
				String manguyenlieuchitietchi = rs.getString("manl");
					String s = "SELECT * FROM NguyenLieu" + 
							" WHERE ma = " + "\"" + manguyenlieuchitietchi +"\"";
				    ResultSet r = DataHelper.execQuery(s);
				    r.next();
				    String tennl = r.getString("ten");
				int soluongchitietchi = rs.getInt("soluong");
				int giachitietchi = rs.getInt("gia");
				int tongtien = soluongchitietchi * giachitietchi;
				ChiTietChiTable chitiet = new ChiTietChiTable(tennl,giachitietchi,soluongchitietchi,tongtien);
				list.add(chitiet);	
			}
			return list;
		} catch (SQLException e) {
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
	
	
	public static ArrayList<DanhSachMonTableQuanLyDonHang> getDanhSachMonQLDH(String maDon) {
		String sql = "SELECT Mon.tenMon,ChiTietHoaDon.soLuong, Mon.giaban FROM ChiTietHoaDon\r\n" + 
				"JOIN Mon ON ChiTietHoaDon.mamon = Mon.ma\r\n" + 
				"WHERE mahd = " + "\"" +maDon+"\"";
		ResultSet rs = DataHelper.execQuery(sql);
		ArrayList<DanhSachMonTableQuanLyDonHang> dsMon = new ArrayList<DanhSachMonTableQuanLyDonHang>();
		try {
			while(rs.next()) {
				String tenMon = rs.getString("tenMon");
				int soLuong = rs.getInt("soLuong");
				int donGia = rs.getInt("giaban");
				dsMon.add(new DanhSachMonTableQuanLyDonHang(tenMon, soLuong, donGia*soLuong));
			}
			
			return dsMon;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<AppGiaoHangTable> getDuLieuApp() {
		ArrayList<AppGiaoHangTable> danhSachApp = new ArrayList<AppGiaoHangTable>();
		String sql = "SELECT * FROM App";		
		ResultSet rs = DataHelper.execQuery(sql);
		
		try {
			while(rs.next()) {
				String maApp = rs.getString("ma");
				String tenApp = rs.getString("ten");
				Integer phiHoaHong = rs.getInt("phidichvu");
				danhSachApp.add(new AppGiaoHangTable(maApp, tenApp, phiHoaHong));
			}		
			return danhSachApp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<NguyenLieu> getTenNguyenLieu() {
		ArrayList<NguyenLieu>  listNguyenLieu = new ArrayList<NguyenLieu>();
		String sql = "SELECT * FROM NguyenLieu";
		ResultSet rs = DataHelper.execQuery(sql);
		try {
			while(rs.next()) {
				String ma = rs.getString("ma");
				String ten = rs.getString("ten");
				int gia = rs.getInt("gia");
				int soluong = rs.getInt("soluong");
				listNguyenLieu.add(new NguyenLieu(ma, ten, gia,soluong));
			}
			return listNguyenLieu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
public static  boolean luuDatabase(PhieuChi pc) throws SQLException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			ResultSet rs = DataHelper.execQuery("SELECT ma FROM PhieuChi \r\n" + 
					"ORDER BY ma DESC\r\n" + 
					"LIMIT 1;");
			int stt = -1;
			while(rs.next()) {
					stt = Integer.parseInt(rs.getString("ma"));
					System.out.print(stt);					
			}
			stt++;
			String kq = Integer.toString(stt);
			System.out.print(kq);
			if(kq.length() < 8) {
				while(kq.length() < 8) {
					kq = "0" + kq;
				}
			}else {
				int kq1 = Integer.parseInt(kq);
				kq = Integer.toString(kq1);
			}
			
			String mapc = kq;
			String sql = "INSERT INTO PhieuChi(ma,manhanvien,ngay,tonggia) \r\n" + 
					"VALUES (\"" + mapc + "\"," +
					"\"" + pc.getManhanvien() + "\"," +
					"\"" + sdf1.format(pc.getNgay()) + "\"," +
					"\"" + pc.getTonggia() + "\")";
			boolean exec = DataHelper.execAction(sql);
			if(exec) {
				for(NguyenLieuTable chiTiet : pc.getChitietchi()) {
					String sql2 = "INSERT INTO ChiTietChi(maphieuchi, manl, soluong, gia) \r\n" + 
							"VALUES (\"" + mapc + "\"," +
							"\"" + chiTiet.getManguyenlieu() + "\"," +
							"\"" + chiTiet.getSoluong() + "\"," +
							"\"" + chiTiet.getGia() + "\")";
							exec = DataHelper.execAction(sql2);
							if(exec == false) return exec;					
					}
				
					ResultSet rs1 = DataHelper.execQuery("SELECT * FROM nguyenlieu") ;
					if(exec) {
						try {
							while(rs1.next()) {
								String ma = rs1.getString("ma");
								int soluong = rs1.getInt("soluong");	
								for(NguyenLieuTable nguyenlieu : pc.getChitietchi()) {
									if(nguyenlieu.getManguyenlieu().equals(ma)) {
										String sql4 = "UPDATE nguyenlieu SET soluong =" + (soluong  - nguyenlieu.getSoluong()) +" " + "WHERE ma =" + ma ;
										exec = DataHelper.execAction(sql4);
									}
								}
							}
							return true;
						} catch (Exception e) {
							e.printStackTrace();							
							return false;
						}
					}
			}else return exec;			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	public static  boolean suaNguyeLieu(NguyenLieu nl){
		try {
			String sql = "UPDATE nguyenlieu SET ten = '" + upperCaseFirst(nl.getTen()) + "', gia =  " + nl.getGia() + ", soluong = " + nl.getSoluong() + " " + "WHERE ma =" + nl.getMa() ;
			DataHelper.execAction(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean XoaPhieuChi (PhieuChi pc){
		try {
			String sql = "DELETE FROM chitietchi WHERE maphieuchi = " + pc.getMa();
			DataHelper.execAction(sql);
			if(DataHelper.execAction(sql)) {
				sql = "DELETE FROM phieuchi WHERE ma = " + pc.getMa();
				DataHelper.execAction(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean XoaNguyenLieu(NguyenLieu nl) throws SQLException  {
		try {
			String sql = "DELETE FROM nguyenlieu WHERE ma = " + nl.getMa();
			DataHelper.execAction(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String upperCaseFirst(String value) {
        char[] array = value.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        return new String(array);
    }
	
	public static boolean luuNguyenLieu(NguyenLieu nl) {
		ResultSet rs = DataHelper.execQuery("SELECT ma FROM nguyenlieu \r\n" + 
				"ORDER BY ma DESC\r\n" + 
				"LIMIT 1;");
		int stt = -1;
		try {
			while(rs.next()) {
					stt = Integer.parseInt(rs.getString("ma").substring(0, 8));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		stt++;
		String kq = Integer.toString(stt);
		while(kq.length() < 8) {
			kq = "0" + kq;
		}
		
		String manl = kq;
		String tennl = upperCaseFirst(nl.getTen());
		String sql = "INSERT INTO nguyenlieu(ma,ten,gia,soluong)" + " VALUE  ('" + manl + "', '" + tennl + "', " + nl.getGia() + ", " + nl.getSoluong() + ")";
		DataHelper.execAction(sql);
		return true;
	}
}
