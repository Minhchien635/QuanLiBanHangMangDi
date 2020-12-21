package quanlybanhangmangdi.model;

public class NguyenLieuTable extends NguyenLieu {
	private int tongtien;

	public NguyenLieuTable(String manguyenlieu, String tennguyenlieu, int gia, int soluong, int tongtien) {
		super(manguyenlieu, tennguyenlieu, gia, soluong);
		this.tongtien = tongtien;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
}
