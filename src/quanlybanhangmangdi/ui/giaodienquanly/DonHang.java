package quanlybanhangmangdi.ui.giaodienquanly;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DonHang {
	private final SimpleStringProperty maDon;
	private final SimpleStringProperty tenApp;
	private final SimpleIntegerProperty tongMon;
	private final SimpleIntegerProperty chietKhau;
	private final SimpleStringProperty ngay;
	private final SimpleDoubleProperty tongGia;
	public DonHang(String maDon, String tenApp, Integer tongMon, Integer chietKhau, String ngay, Double tongGia) {
		super();
		this.maDon = new SimpleStringProperty(maDon);
		this.tenApp = new SimpleStringProperty(tenApp);
		this.tongMon = new SimpleIntegerProperty(tongMon);
		this.chietKhau = new SimpleIntegerProperty(chietKhau);
		this.ngay = new SimpleStringProperty(ngay);
		this.tongGia = new SimpleDoubleProperty(tongGia);
	}
	public String getMaDon() {
		return maDon.get();
	}
	public String getTenApp() {
		return tenApp.get();
	}
	public Integer getTongMon() {
		return tongMon.get();
	}
	public Integer getChietKhau() {
		return chietKhau.get();
	}
	public String getNgay() {
		return ngay.get();
	}
	public Double getTongGia() {
		return tongGia.get();
	}
	
}
