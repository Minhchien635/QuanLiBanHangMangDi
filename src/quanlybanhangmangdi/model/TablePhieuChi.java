package quanlybanhangmangdi.model;

import java.util.Date;

import javafx.collections.ObservableList;

public class TablePhieuChi extends PhieuChi {
	private String tennhanvien;

	public String getTennhanvien() {
		return tennhanvien;
	}

	public TablePhieuChi(String ma, int manhanvien, String tennhanvien, Date ngay, int tonggia) {
		super(ma, manhanvien, ngay, tonggia);
		this.tennhanvien = tennhanvien;
	}

	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}

}
