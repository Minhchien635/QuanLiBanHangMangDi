package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MonTrongHoaDon {
	private final SimpleStringProperty maMon;
	private final SimpleIntegerProperty soLuong;
	public MonTrongHoaDon(SimpleStringProperty maMon, SimpleIntegerProperty soLuong) {
		super();
		this.maMon = maMon;
		this.soLuong = soLuong;
	}
	
	
	
	public SimpleStringProperty getMaMon() {
		return maMon;
	}
	public SimpleIntegerProperty getSoLuong() {
		return soLuong;
	}
	
	
	
}	
