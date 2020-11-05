package quanlybanhangmangdi.ui.login;


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
import quanlybanhangmangdi.database.Controller;
import quanlybanhangmangdi.database.connection.jdbc.DataHelper;
import quanlybanhangmangdi.model.NhanVien;

public class LoginController implements Initializable{

	@FXML
    private TextField taiKhoanTextField;

    @FXML
    private PasswordField matKhauTextField;

    @FXML
    private Button dangNhapButton;
    
    @FXML private Label trangThaiLabel;
	
	private TaiKhoan tk = new TaiKhoan();
	
	private ArrayList<NhanVien> danhSachNhanVien = Controller.getDuLieuNhanVien();
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../mainmenu/MainMenu.fxml"));
		Scene scene = new Scene(root,920,620);
		scene.getStylesheets().add(getClass().getResource("../mainmenu/application.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
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
	
	public void updateModel() {
		//da kiem tra
		tk.setTenTaiKhoan(getTenTaiKhoan());
		tk.setMatKhau(getMatKhau());
		
	}
	
	public TaiKhoan getTaiKhoan() {
		return tk;
	}
	
	
	
}
