package quanlybanhangmangdi.model;

public class ChiTietChiTable {
			private String nguyenlieu;
			private int gia;
			private int soluong;
			private int tongtien;
			public ChiTietChiTable(String nguyenlieu, int gia, int soluong, int tongtien) {
				super();
				this.nguyenlieu = nguyenlieu;
				this.gia = gia;
				this.soluong = soluong;
				this.tongtien = tongtien;
			}
			public String getNguyenlieu() {
				return nguyenlieu;
			}
			public void setNguyenlieu(String nguyenlieu) {
				this.nguyenlieu = nguyenlieu;
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
