package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MonTrongDanhSach {
	private final SimpleStringProperty maMon;
	private final SimpleStringProperty tenMon;
	private final SimpleIntegerProperty donGia;
	private final SimpleIntegerProperty soLuong;
	
	public MonTrongDanhSach(String maMon, String tenMon, Integer donGia, Integer soLuong) {
		this.maMon = new SimpleStringProperty(maMon);
		this.tenMon = new SimpleStringProperty(tenMon);
		this.donGia = new SimpleIntegerProperty(donGia);
		this.soLuong = new SimpleIntegerProperty(soLuong);
	}
	
	public String getMaMon() {
		return maMon.get();
	}

	public String getTenMon() {
		return tenMon.get();
	}

	public Integer getDonGia() {
		return donGia.get();
	}

	public Integer getSoLuong() {
		return soLuong.get();
	}
}
