package quanlybanhangmangdi.model;

import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class DonHangTable {

	private SimpleStringProperty ma;
	private SimpleStringProperty tenNhanVien;
	private SimpleStringProperty thoiGian;
	private SimpleStringProperty tenApp;
	private SimpleStringProperty maDonApp;
	private SimpleIntegerProperty tongGia;
	private SimpleIntegerProperty chietKhau;
	private SimpleIntegerProperty phiDichVu;
	private SimpleIntegerProperty tongTienThu;
	public DonHangTable(String ma, String maNhanVien, String thoiGian,
			String maApp, String maDonApp, Integer tongGia,
			Integer chietKhau, Integer phiDichVu, Integer tongTienThu) {
		super();
		this.ma = new SimpleStringProperty(ma);
		this.tenNhanVien = new SimpleStringProperty(maNhanVien);
		this.thoiGian = new SimpleStringProperty(thoiGian);
		this.tenApp = new SimpleStringProperty(maApp);
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
	public String getMaNhanVien() {
		return tenNhanVien.get();
	}
	public void setMaNhanVien(SimpleStringProperty maNhanVien) {
		this.tenNhanVien = maNhanVien;
	}
	public String getThoiGian() {
		return thoiGian.get();
	}
	public String getMaApp() {
		return tenApp.get();
	}
	public void setMaApp(SimpleStringProperty maApp) {
		this.tenApp = maApp;
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
