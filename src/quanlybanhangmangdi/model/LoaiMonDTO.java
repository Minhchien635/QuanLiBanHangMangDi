package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlybanhangmangdi.database.DataHelper;

public class LoaiMonDTO {
	private String maLoaiMon;
	private String tenLoaiMon;
	
	public LoaiMonDTO(String maLoaiMon, String tenLoaiMon) {
		super();
		this.maLoaiMon = maLoaiMon;
		this.tenLoaiMon = tenLoaiMon;
	}
	
	
	public String getMaLoaiMon() {
		return maLoaiMon;
	}
	public void setMaLoaiMon(String maLoaiMon) {
		this.maLoaiMon = maLoaiMon;
	}
	public String getTenLoaiMon() {
		return tenLoaiMon;
	}
	public void setTenLoaiMon(String tenLoaiMon) {
		this.tenLoaiMon = tenLoaiMon;
	}
	
	
	public static ArrayList<LoaiMonDTO> getDanhSachLoaiMon() {
		ArrayList<LoaiMonDTO> danhSachLoaiMon = new ArrayList<LoaiMonDTO>();
		String sql = "SELECT * FROM LoaiMon";
		ResultSet rs = DataHelper.execQuery(sql);
		
		try {
			while(rs.next()) {
				String maLoaiMon = rs.getString("ma");
				String tenLoaiMon = rs.getString("ten");
				danhSachLoaiMon.add(new LoaiMonDTO(maLoaiMon, tenLoaiMon));
			}
			return danhSachLoaiMon;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return getTenLoaiMon();
	}
	
	
}
