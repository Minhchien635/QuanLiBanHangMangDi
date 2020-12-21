package quanlybanhangmangdi.model;

public class ChiTietChiTable extends ChiTietChi {
	private int tongtien;
	private String nguyenlieu;

	public String getNguyenlieu() {
		return nguyenlieu;
	}

	public void setNguyenlieu(String nguyenlieu) {
		this.nguyenlieu = nguyenlieu;
	}

	public ChiTietChiTable(String nguyenlieu, int gia, int soluong, int tongtien) {
		super(gia, soluong);
		this.nguyenlieu = nguyenlieu;
		this.tongtien = tongtien;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

}
