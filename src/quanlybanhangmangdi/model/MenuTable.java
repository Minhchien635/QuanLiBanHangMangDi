package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import quanlybanhangmangdi.database.DataHelper;

public class MenuTable {
	private SimpleStringProperty maMon;
	private SimpleStringProperty tenLoaiMon;
	private SimpleStringProperty tenMon;
	private SimpleIntegerProperty giaBan;
	
	
	
	
	public MenuTable(String maMon, String tenLoaiMon, String tenMon, Integer giaBan) {
		super();
		this.maMon = new SimpleStringProperty(maMon);
		this.tenLoaiMon = new SimpleStringProperty(tenLoaiMon);
		this.tenMon = new SimpleStringProperty(tenMon);
		this.giaBan = new SimpleIntegerProperty(giaBan);
	}
	
	public static ArrayList<MenuTable> getDuLieuMonTable() {
		ArrayList<MenuTable> danhSachMon = new ArrayList<MenuTable>();
		String sql = "SELECT m.ma,lm.ten,m.tenmon,m.giaban FROM mon m\r\n" + 
				"JOIN loaimon lm ON m.maloaimon = lm.ma;";
		ResultSet rs = DataHelper.execQuery(sql);
		try {
			while(rs.next()) {
				// truyền lấy dữ liệu từng hàng trong database
				String maMon = rs.getString("m.ma");
				String loaiMon = rs.getString("lm.ten");
				String tenMon = rs.getString("m.tenmon");
				Integer giaBan = rs.getInt("m.giaban");
				// tạo món mới
				MenuTable mon = new MenuTable(maMon, loaiMon, tenMon, giaBan);
				danhSachMon.add(mon);
			}
			return danhSachMon;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getMaMon() {
		return maMon.get();
	}
	public String getTenLoaiMon() {
		return tenLoaiMon.get();
	}
	public String getTenMon() {
		return tenMon.get();
	}
	public Integer getGiaBan() {
		return giaBan.get();
	}
	
	
}
