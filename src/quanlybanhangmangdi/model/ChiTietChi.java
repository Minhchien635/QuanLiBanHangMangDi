package quanlybanhangmangdi.model;

public class ChiTietChi {
	private String maphieuchi;
	private String manl;
	private int soluong;
	private int gia;

	public ChiTietChi(String maphieuchi, String manl, int soluong, int gia) {
		this.maphieuchi = maphieuchi;
		this.manl = manl;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	public ChiTietChi(int soluong, int gia) {
		this.soluong = soluong;
		this.gia = gia;
	}

	public String getMaphieuchi() {
		return maphieuchi;
	}

	public void setMaphieuchi(String maphieuchi) {
		this.maphieuchi = maphieuchi;
	}

	public String getManl() {
		return manl;
	}

	public void setManl(String manl) {
		this.manl = manl;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

}
