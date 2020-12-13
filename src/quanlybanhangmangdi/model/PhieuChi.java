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
		
		private SimpleDateFormat sdfDatabase = new SimpleDateFormat("yyyy/M/dd HH:mm:ss");
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
		public PhieuChi(String ma,int manhanvien, Date ngay, int tonggia) {
			this.ma = ma;
			this.manhanvien = manhanvien;
			this.ngay = ngay;
			this.tonggia = tonggia;
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
		
		private String taoMa() throws NumberFormatException, SQLException {
			ResultSet rs = DataHelper.execQuery("SELECT ma FROM PhieuChi \r\n" + 
					"ORDER BY ma DESC\r\n" + 
					"LIMIT 1;");
			int stt = -1;
			while(rs.next()) {
					stt = Integer.parseInt(rs.getString("ma").substring(0, 8));
			}
			stt++;
			String kq = Integer.toString(stt);
			while(kq.length() < 8) {
				kq = "0" + kq;
			}
			return kq;
		}

		public boolean luuDatabase() throws SQLException {
			
			try {
				String mapc = taoMa();
				String sql = "INSERT INTO PhieuChi(ma,manhanvien,ngay,tonggia) \r\n" + 
						"VALUES (\"" + mapc +"\","+
						"\""+getManhanvien()+"\","+
						"\""+sdfDatabase.format(getNgay())+ "\","+
						"\""+getTonggia()+ "\")";
				boolean exec = DataHelper.execAction(sql);
				if(exec) {
					for(NguyenLieuTable chiTiet : getChitietchi()) {
						String sql2 = "INSERT INTO ChiTietChi(maphieuchi, manl, soluong, gia) \r\n" + 
								"VALUES (\"" + mapc + "\"," +
								"\"" + chiTiet.getManguyenlieu() + "\"," +
								"\"" + chiTiet.getSoluong() + "\"," +
								"\"" + chiTiet.getGia() + "\")";
								exec = DataHelper.execAction(sql2);
								if(exec == false) return exec;					
						}
					
						ResultSet rs = DataHelper.execQuery("SELECT * FROM nguyenlieu") ;
						if(exec) {
							try {
								while(rs.next()) {
									String ma = rs.getString("ma");
									int soluong = rs.getInt("soluong");	
									for(NguyenLieuTable nguyenlieu : getChitietchi()) {
										if(nguyenlieu.getManguyenlieu().equals(ma)) {
											String sql4 = "UPDATE nguyenlieu SET soluong =" + (soluong  - nguyenlieu.getSoluong()) +" " + "WHERE ma =" + ma ;
											exec = DataHelper.execAction(sql4);
										}
									}
								}
								return true;
							} catch (Exception e) {
								e.printStackTrace();							
								return false;
							}
						}
				}else return exec;			
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			}
			return true;	
		}
}
