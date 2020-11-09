package quanlybanhangmangdi.model;

import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class DonHangTable {

	private SimpleStringProperty ma;
	private SimpleIntegerProperty maNhanVien;
	private SimpleStringProperty thoiGian;
	private SimpleStringProperty maApp;
	private SimpleStringProperty maDonApp;
	private SimpleIntegerProperty tongGia;
	private SimpleIntegerProperty chietKhau;
	private SimpleIntegerProperty phiDichVu;
	private SimpleIntegerProperty tongTienThu;
	public DonHangTable(String ma, Integer maNhanVien, String thoiGian,
			String maApp, String maDonApp, Integer tongGia,
			Integer chietKhau, Integer phiDichVu, Integer tongTienThu) {
		super();
		this.ma = new SimpleStringProperty(ma);
		this.maNhanVien = new SimpleIntegerProperty(maNhanVien);
		this.thoiGian = new SimpleStringProperty(thoiGian);
		this.maApp = new SimpleStringProperty(maApp);
		this.maDonApp = new SimpleStringProperty(maDonApp);
		this.tongGia = new SimpleIntegerProperty(tongGia);
		this.chietKhau = new SimpleIntegerProperty(chietKhau);
		this.phiDichVu = new SimpleIntegerProperty(phiDichVu);
		this.tongTienThu = new SimpleIntegerProperty(tongTienThu);
	}
	public String getMa() {
		return ma.get();
	}
	public void setMa(SimpleStringProperty ma) {
		this.ma = ma;
	}
	public Integer getMaNhanVien() {
		return maNhanVien.get();
	}
	public void setMaNhanVien(SimpleIntegerProperty maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getThoiGian() {
		return thoiGian.get();
	}
	public String getMaApp() {
		return maApp.get();
	}
	public void setMaApp(SimpleStringProperty maApp) {
		this.maApp = maApp;
	}
	public String getMaDonApp() {
		return maDonApp.get();
	}
	public void setMaDonApp(SimpleStringProperty maDonApp) {
		this.maDonApp = maDonApp;
	}
	public Integer getTongGia() {
		return tongGia.get();
	}
	public void setTongGia(SimpleIntegerProperty tongGia) {
		this.tongGia = tongGia;
	}
	public Integer getChietKhau() {
		return chietKhau.get();
	}
	public void setChietKhau(SimpleIntegerProperty chietKhau) {
		this.chietKhau = chietKhau;
	}
	public Integer getPhiDichVu() {
		return phiDichVu.get();
	}
	public void setPhiDichVu(SimpleIntegerProperty phiDichVu) {
		this.phiDichVu = phiDichVu;
	}
	public Integer getTongTienThu() {
		return tongTienThu.get();
	}
	public void setTongTienThu(SimpleIntegerProperty tongTienThu) {
		this.tongTienThu = tongTienThu;
	}
}
