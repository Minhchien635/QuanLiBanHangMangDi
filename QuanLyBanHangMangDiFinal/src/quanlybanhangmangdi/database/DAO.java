package quanlybanhangmangdi.database;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;

import quanlybanhangmangdi.model.NhanVien;

public class DAO {
	public static ArrayList<NhanVien> getDuLieuNhanVien() {
		ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien";
		ResultSet rs = DataHelper.execQuery(sql);
		
		try {
			while(rs.next()) {
				int maNhanVien = rs.getInt("ma");
				int maChucVu = rs.getInt("machucvu");
				String hoTen = rs.getString("hoten");
				String dienThoai = rs.getString("dienthoai");
				String email = rs.getString("email");
				String taiKhoan = rs.getString("taikhoan");
				String matKhau = rs.getString("matkhau");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				
				danhSachNhanVien.add(new NhanVien(maNhanVien, maChucVu, hoTen, dienThoai, email, gioiTinh, taiKhoan, matKhau));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}
	
	
}
