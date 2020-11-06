package quanlybanhangmangdi.controller;


import java.io.IOException; 
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import quanlybanhangmangdi.model.NhanVien;

public class LoginController implements Initializable{

	@FXML
    private TextField taiKhoanTextField;

    @FXML
    private PasswordField matKhauTextField;

    @FXML
    private Button dangNhapButton;
    
    @FXML private Label trangThaiLabel;
	
	
	private ArrayList<NhanVien> danhSachNhanVien = quanlybanhangmangdi.database.DAO.getDuLieuNhanVien();
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void show() throws IOException {
		
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
		Scene scene = new Scene(root,750,500);
		scene.getStylesheets().add(getClass().getResource("../view/LoginStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	@FXML
	public void kiemTraTaiKhoanHopLe() throws IOException {
		
		if(taiKhoanTextField.getText().equals("")&&matKhauTextField.getText().equals("")) {
			trangThaiLabel.setText("Vui lòng nhập tài khoản và mật khẩu");
		} else {
			if(kiemTraTaiKhoanTonTai(taiKhoanTextField.getText())) {
				if(kiemTraMatKhau(taiKhoanTextField.getText(), matKhauTextField.getText())) {
					System.out.println("Dang nhap thanh cong");
					if(kiemTraQuyenTaiKhoan(taiKhoanTextField.getText())==2) {
						moGiaoDienQuanLy();
					} else {
						moGiaoDienNhanVien();
					}
				} else {
					trangThaiLabel.setText("Mật khẩu không chính xác. Vui lòng nhập lại.");
				}
			}
			else trangThaiLabel.setText("Tài khoản không tồn tại!");
		}
	}
	
	private void moGiaoDienNhanVien() {
		// TODO Auto-generated method stub
		
	}

	private void moGiaoDienQuanLy() throws IOException {
		MenuQuanLyController menuQuanLyController = new MenuQuanLyController();
		menuQuanLyController.show();
		
	}

	public boolean kiemTraMatKhau(String taiKhoan, String matKhau) {
		for(NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.getTaiKhoan().equals(taiKhoan)) {
				if(nhanVien.getMatKhau().equals(matKhau))
					return true;
			}
		}
		return false;
	}
	
	public int kiemTraQuyenTaiKhoan(String tenTaiKhoan) {
		for(NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.getTaiKhoan().equals(tenTaiKhoan)) {
				return nhanVien.getMaChucVu();
			}
		}
		return 0;
	}
	
	public boolean kiemTraTaiKhoanTonTai(String tenTaiKhoan) {
		for(NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.getTaiKhoan().equals(tenTaiKhoan)) return true;
		}
		return false;
	}
	
	public String getTenTaiKhoan() {
		return taiKhoanTextField.getText();
	}
	
	public String getMatKhau() {
		return matKhauTextField.getText();
	}
	
	
	
	
}
