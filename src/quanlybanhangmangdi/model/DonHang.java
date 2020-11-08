package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import quanlybanhangmangdi.database.DataHelper;

public class DonHang {
	
	private String ma;
	private int maNhanVien;
	private Date thoiGian;
	private String maApp;
	private String maDonApp;
	private int tongGia;
	private int chietKhau;
	private int phiDichVu;
	private int tongTienThu;
	private ArrayList<ChiTietHoaDon> danhSachChiTiet;

	private SimpleDateFormat sdfDatabase = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private SimpleDateFormat sdfUI = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private SimpleDateFormat sdfMaNgay = new SimpleDateFormat("ddMMyyyy-HHmmss");

	public DonHang(int maNhanVien, Date thoiGian, String maApp, String maDonApp, int tongGia, int chietKhau,
			int phiDichVu, int tongTienThu, ArrayList<ChiTietHoaDon> danhSachChiTiet) {
		super();
		this.maNhanVien = maNhanVien;
		this.thoiGian = thoiGian;
		this.maApp = maApp;
		this.maDonApp = maDonApp;
		this.tongGia = tongGia;
		this.chietKhau = chietKhau;
		this.phiDichVu = phiDichVu;
		this.tongTienThu = tongTienThu;
		this.danhSachChiTiet = danhSachChiTiet;
	}
	
	private String taoMa() throws NumberFormatException, SQLException {
		ResultSet rs = DataHelper.execQuery("SELECT ma FROM hoadon \r\n" + 
				"ORDER BY ma DESC\r\n" + 
				"LIMIT 1;");
		int stt = -1;
		while(rs.next()) {
				stt = Integer.parseInt(rs.getString("ma"));
				System.out.print(stt);
		++stt;
		
		
		String kq = maApp.substring(0, 2);
		String cuoi = Integer.toString(stt);
		while(cuoi.length() < 8) {
			cuoi = "0" + cuoi;
		}
		kq += cuoi;
		return kq;
	
	}
	
	public boolean luuDatabase() {
		
		try {
			String maHD = taoMa();
			String sql = "INSERT INTO HoaDon(ma, MaNV, ThoiGian, MaApp, TongTienThu, MaDonTrenApp, ChietKhau, TongGia, PhiDichVu) \r\n" + 
					"VALUES (\"" + maHD +"\","+
					"\""+getMaNhanVien()+"\","+
					"\""+sdfDatabase.format(getThoiGian())+ "\","+
					"\""+getMaApp()+"\","+
					"\""+getTongTienThu()+"\","+
					"\"" + getMaDonApp() + "\","+
					"\"" + getChietKhau() + "\","+
					"\"" + getTongGia() + "\","+
					"\"" + getPhiDichVu() + "\",)";
			boolean exec = DataHelper.execAction(sql);
			if(exec) {
				for(ChiTietHoaDon chiTiet : getDanhSachMon()) {
					String sql2 = "INSERT INTO ChiTietHoaDon(mahd, mamon, soluong) \r\n" + 
							"VALUES (\"" + maHD + "\"," +
							"\"" + chiTiet.getMaMon() + "\"," +
							"\"" + chiTiet.getSoLuong() + "\",)";
					exec = DataHelper.execAction(sql2);
				}
			}
			
			return exec;
			
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
				
	}
		
	public ArrayList<ChiTietHoaDon> getDanhSachMon() {
		return danhSachChiTiet;
	}
	
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public Date getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getMaApp() {
		return maApp;
	}
	public void setMaApp(String maApp) {
		this.maApp = maApp;
	}
	public String getMaDonApp() {
		return maDonApp;
	}
	public void setMaDonApp(String maDonApp) {
		this.maDonApp = maDonApp;
	}
	public int getTongGia() {
		return tongGia;
	}
	public void setTongGia(int tongGia) {
		this.tongGia = tongGia;
	}
	public int getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(int chietKhau) {
		this.chietKhau = chietKhau;
	}
	public int getPhiDichVu() {
		return phiDichVu;
	}
	public void setPhiDichVu(int phiDichVu) {
		this.phiDichVu = phiDichVu;
	}
	public int getTongTienThu() {
		return tongTienThu;
	}
	public void setTongTienThu(int tongTienThu) {
		this.tongTienThu = tongTienThu;
	}
	
	public void setDanhSachMon(ArrayList<ChiTietHoaDon> danhSachMon) {
		this.danhSachChiTiet = danhSachMon;
	}

	
}
