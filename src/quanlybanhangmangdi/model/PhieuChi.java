package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.ObservableList;
import quanlybanhangmangdi.database.DataHelper;

public class PhieuChi {
	private String ma;
	private int manhanvien;
	private Date ngay;
	private int tonggia;
	private int trangthai;

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	private SimpleDateFormat sdfDatabase = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private ObservableList<NguyenLieuTable> chitietchi;

	public ObservableList<NguyenLieuTable> getChitietchi() {
		return chitietchi;
	}

	public void setChitietchi(ObservableList<NguyenLieuTable> chitietchi) {
		this.chitietchi = chitietchi;
	}

	public PhieuChi(int manhanvien, Date ngay, int tonggia, ObservableList<NguyenLieuTable> listNguyenlieu) {
		this.manhanvien = manhanvien;
		this.ngay = ngay;
		this.tonggia = tonggia;
		this.chitietchi = listNguyenlieu;
	}

	public PhieuChi(String ma, int manhanvien, Date ngay, int tonggia) {
		this.ma = ma;
		this.manhanvien = manhanvien;
		this.ngay = ngay;
		this.tonggia = tonggia;
	}

	public PhieuChi(String ma) {
		this.ma = ma;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public int getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getTonggia() {
		return tonggia;
	}

	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
	}

	public boolean thayDoiTrangThai() throws SQLException {
		try {
			String sql = "SELECT * FROM phieuchi WHERE ma = " + this.ma;
			ResultSet rs = DataHelper.execQuery(sql);
			rs.next();
			int trangthai = rs.getInt("trangthai");
			String sql1 = "UPDATE phieuchi SET trangthai = " + (trangthai == 1 ? 0 : 1) + " " + "WHERE ma =" + this.ma;
			DataHelper.execAction(sql1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
