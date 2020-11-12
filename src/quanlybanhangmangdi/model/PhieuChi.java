package quanlybanhangmangdi.model;

public class PhieuChi {
		private String ma;
		private int manhanvien;
		private String ngay;
		private int tonggia;
		
		public PhieuChi(String ma, int manhanvien, String ngay, int tonggia) {
			super();
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

		public String getNgay() {
			return ngay;
		}

		public void setNgay(String ngay) {
			this.ngay = ngay;
		}

		public int getTonggia() {
			return tonggia;
		}

		public void setTonggia(int tonggia) {
			this.tonggia = tonggia;
		}
		
}
