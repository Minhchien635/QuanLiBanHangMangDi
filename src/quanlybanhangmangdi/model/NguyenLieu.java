package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlybanhangmangdi.database.DataHelper;

public class NguyenLieu {
	private String ma;
	private String ten;
	private int gia;
	private int soluong;
	private int trangthai;

	public NguyenLieu(String ma, String ten, int gia, int soluong) {
		this.ma = ma;
		this.ten = ten;
		this.gia = gia;
		this.soluong = soluong;
	}

	public NguyenLieu(String ten, int gia, int soluong) {
		this.ten = ten;
		this.gia = gia;
		this.soluong = soluong;
	}

	public NguyenLieu(String ma) {
		this.ma = ma;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getMa() {
		return ma;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTen();
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public boolean thayDoiTrangThai() throws SQLException {
		try {
			String sql = "SELECT * FROM nguyenlieu WHERE ma = " + this.ma;
			ResultSet rs = DataHelper.execQuery(sql);
			rs.next();
			int trangthai = rs.getInt("trangthai");
			String sql1 = "UPDATE nguyenlieu SET trangthai = " + (trangthai == 1 ? 0 : 1) + " " + "WHERE ma ="
					+ this.ma;
			DataHelper.execAction(sql1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
