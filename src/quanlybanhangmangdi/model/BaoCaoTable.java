package quanlybanhangmangdi.model;

import java.util.Date;

public class BaoCaoTable {
	private int doanhthu;
	private int chiphi;
	private int loinhuan;

	public int getDoanhthu() {
		return doanhthu;
	}

	public void setDoanhthu(int doanhthu) {
		this.doanhthu = doanhthu;
	}

	public int getChiphi() {
		return chiphi;
	}

	public void setChiphi(int chiphi) {
		this.chiphi = chiphi;
	}

	public int getLoinhuan() {
		return loinhuan;
	}

	public void setLoinhuan(int loinhuan) {
		this.loinhuan = loinhuan;
	}

	public BaoCaoTable(int doanhthu, int chiphi, int loinhuan) {
		this.doanhthu = doanhthu;
		this.chiphi = chiphi;
		this.loinhuan = loinhuan;
	}

}
