package quanlybanhangmangdi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import quanlybanhangmangdi.database.DataHelper;

public class AppGiaoHangTable {
	private SimpleStringProperty maApp;
	private SimpleStringProperty tenApp;
	private SimpleIntegerProperty phiHoaHong;
	
	public AppGiaoHangTable(String maApp, String tenApp, Integer phiHoaHong) {
		this.maApp = new SimpleStringProperty(maApp);
		this.tenApp = new SimpleStringProperty(tenApp);
		this.phiHoaHong = new SimpleIntegerProperty(phiHoaHong);
	}
	
	public AppGiaoHangTable(String tenApp, Integer phiHoaHong) {
		this.tenApp = new SimpleStringProperty(tenApp);
		this.phiHoaHong = new SimpleIntegerProperty(phiHoaHong);
	}

	public String getMaApp() {
		return maApp.get();
	}

	public void setMaApp(String maApp) {
		this.maApp = new SimpleStringProperty(maApp);
	}

	public String getTenApp() {
		return tenApp.get();
	}

	public void setTenApp(String tenApp) {
		this.tenApp = new SimpleStringProperty(tenApp);
	}

	public Integer getPhiHoaHong() {
		return phiHoaHong.get();
	}

	public void setPhiHoaHong(Integer phiHoaHong) {
		this.phiHoaHong = new SimpleIntegerProperty(phiHoaHong);
	}
	
	
	public boolean luuAppXuongCSDL() throws NumberFormatException, SQLException {
		//Câu lệnh nhập dữ liệu cho bảng APP
		String sql ="INSERT INTO app (ma, ten, phidichvu)\r\n" + 
				"VALUES " + "('"+sinhMaApp()+"',"+
				"'"+getTenApp()+"',"+
				"'"+getPhiHoaHong()+"')";
		return DataHelper.execAction(sql);
	}
	
	public static String sinhMaApp() throws NumberFormatException, SQLException {
		
		//Lấy Mã APP có số thứ tự cuối cùng từ cơ sở dữ liệu
		ResultSet rs = DataHelper.execQuery("SELECT * FROM app\r\n" + 
				"WHERE ma != 'atqua'\r\n" + 
				"order by ma DESC\r\n" + 
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
		return "APP"+cuoi;
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, SQLException {
		System.out.println(sinhMaApp());
	}
	
	
}
