package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DanhSachMonTableQuanLyDonHang {
	private final SimpleStringProperty tenMon;
	private final SimpleIntegerProperty soLuong;
	private final SimpleIntegerProperty donGia;
	public DanhSachMonTableQuanLyDonHang(String tenMon, Integer soLuong, Integer donGia) {
		super();
		this.tenMon = new SimpleStringProperty(tenMon);
		this.soLuong = new SimpleIntegerProperty(soLuong);
		this.donGia = new SimpleIntegerProperty(donGia);
	}
	public String getTenMon() {
		return tenMon.get();
	}
	public Integer getSoLuong() {
		return soLuong.get();
	}
	public Integer getDonGia() {
		return donGia.get();
	
	}
}
