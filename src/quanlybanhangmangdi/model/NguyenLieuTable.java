package quanlybanhangmangdi.model;

public class NguyenLieuTable{
	private String manguyenlieu;
	private String tennguyenlieu;
	private int gia;
	private int soluong;
	private int tongtien;
	
	public NguyenLieuTable(String manguyenlieu, String tennguyenlieu, int gia, int soluong, int tongtien) {
		this.manguyenlieu = manguyenlieu;
		this.tennguyenlieu = tennguyenlieu;
		this.gia = gia;
		this.soluong = soluong;
		this.tongtien = tongtien;
	}
	public String getManguyenlieu() {
		return manguyenlieu;
	}
	public void setManguyenlieu(String manguyenlieu) {
		this.manguyenlieu = manguyenlieu;
	}
	public String getTennguyenlieu() {
		return tennguyenlieu;
	}
	public void setTennguyenlieu(String nguyenlieu) {
		this.tennguyenlieu = nguyenlieu;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
}
