package quanlybanhangmangdi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BaoCaoAppTable {
	
		private SimpleStringProperty maApp;
		private SimpleStringProperty tenApp;
		private SimpleIntegerProperty phiHoaHong;
		private SimpleIntegerProperty tongThu;
		
		
		public BaoCaoAppTable(String maApp, String tenApp, Integer phiHoaHong, Integer tongThu) {
			super();
			this.maApp = new SimpleStringProperty(maApp);
			this.tenApp = new SimpleStringProperty(tenApp);
			this.phiHoaHong = new SimpleIntegerProperty(phiHoaHong);
			this.tongThu = new SimpleIntegerProperty(tongThu);
		}
		
		
		public String getMaApp() {
			return maApp.get();
		}
		public String getTenApp() {
			return tenApp.get();
		}
		public Integer getPhiHoaHong() {
			return phiHoaHong.get();
		}
		public Integer getTongThu() {
			return tongThu.get();
		}
		
		
}
