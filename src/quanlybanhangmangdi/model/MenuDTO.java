package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlybanhangmangdi.database.DataHelper;

public class MenuDTO {
	private String maMon;
	private String maLoaiMon;
	private String tenMon;
	private int giaBan;
	
	
	
	
	public MenuDTO(String maMon, String maLoaiMon, String tenMon, int giaBan) {
		super();
		this.maMon = maMon;
		this.maLoaiMon = maLoaiMon;
		this.tenMon = tenMon;
		this.giaBan = giaBan;
	}




	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getMaLoaiMon() {
		return maLoaiMon;
	}
	public void setMaLoaiMon(String maLoaiMon) {
		this.maLoaiMon = maLoaiMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	
	
	private static String taoMaMon() throws NumberFormatException, SQLException {
		ResultSet rs = DataHelper.execQuery("SELECT ma FROM Mon\r\n" + 
				"ORDER BY ma DESC\r\n" + 
				"LIMIT 1;");
		
		int stt = -1; //Tạo ra số mặc định. nếu không có app nào -> stt sẽ tăng lên 0
		while(rs.next()) {
			//chuyển dữ liệu đã lấy về Integer
				stt = Integer.parseInt(rs.getString("ma").substring(3, 5)); 
		}
		stt++;
		
		String cuoi = Integer.toString(stt);
		
		//Tạo cho đủ 2 số
		while(cuoi.length() < 2) {
			cuoi = "0" + cuoi;
		}
		return "MON"+cuoi;
	}
	
	public MenuDTO(String maLoaiMon, String tenMon, int giaBan) {
		super();
		this.maLoaiMon = maLoaiMon;
		this.tenMon = tenMon;
		this.giaBan = giaBan;
	}




	public boolean luuMonDataBase() {
		try {
			String sql = "INSERT INTO Mon(ma, maloaimon, tenmon,giaban)\r\n" + 
					"VALUES ('"+taoMaMon()+"',"+
					"'"+maLoaiMon+"',"+
					"'"+tenMon+"',"+
					"'"+giaBan+"');";

			boolean result = DataHelper.execAction(sql);
			return result;		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, SQLException {
		System.out.println(taoMaMon());
	}
	
}
