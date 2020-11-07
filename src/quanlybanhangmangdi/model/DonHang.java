package quanlybanhangmangdi.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DonHang {
	String ma;
	int maNhanVien;
	Date thoiGian;
	String maApp;
	String maDonApp;
	int tongGia;
	int chietKhau;
	int phiDichVu;
	int tongTienThu;
	
	
	

	SimpleDateFormat sdfDatabase = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SimpleDateFormat sdfUI = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
}
