package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChiTietHoaDonDTO {
	private String maMon;
	private int soLuong;
	public ChiTietHoaDonDTO(String maMon, int soLuong) {
		super();
		this.maMon = maMon;
		this.soLuong = soLuong;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
	
	
	
	
}	
