package quanlybanhangmangdi.model;

public class NguyenLieu {
			private String ma;
			private String ten;
			private int gia;
			private int soluong;
			
			public NguyenLieu(String ma, String ten, int gia, int soluong) {
				this.ma = ma;
				this.ten = ten;
				this.gia = gia;
				this.soluong = soluong;
			}

			public int getSoluong() {
				return soluong;
			}

			public void setSoluong(int soluong) {
				this.soluong = soluong;
			}

			public String getMa() {
				return ma;
			}
			
			
			@Override
			public String toString() {
			// TODO Auto-generated method stub
			return getTen();
			}

			public void setMa(String ma) {
				this.ma = ma;
			}

			public String getTen() {
				return ten;
			}

			public void setTen(String ten) {
				this.ten = ten;
			}

			public int getGia() {
				return gia;
			}

			public void setGia(int gia) {
				this.gia = gia;
			}
}
