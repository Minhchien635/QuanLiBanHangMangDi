package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MonTrongDanhSach {
	private String maMon;
	private String tenMon;
	private int donGia;
	private int soLuong;
	
	
	public MonTrongDanhSach(String maMon, String tenMon, int donGia, int soLuong) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaMon() {
		return maMon;
	}



	public String getTenMon() {
		return tenMon;
	}

	public int getDonGia() {
		return donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	
	
}
