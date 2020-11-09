package quanlybanhangmangdi.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import quanlybanhangmangdi.controller.GiaoDienQuanLyBaoCaoController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyThuChiController;
import quanlybanhangmangdi.controller.LoginController;

public class Test720 extends Application{

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override // ham de chay phan mem
	public void start(Stage primaryStage) throws Exception {
		showBaoCao720();
		
	}
	
	
	private void showLogin() throws IOException {
		LoginController login = new LoginController();
		login.show();
	}
	
	public void showBaoCao720() throws IOException {
		GiaoDienQuanLyBaoCaoController baoCao = new GiaoDienQuanLyBaoCaoController();
		baoCao.show720p();
	}
	
	public void showThuChi720() throws IOException {
		GiaoDienQuanLyThuChiController thuChi = new GiaoDienQuanLyThuChiController();
		thuChi.show720p();
	}
}
