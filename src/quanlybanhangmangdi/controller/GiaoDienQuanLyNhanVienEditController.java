package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.model.DanhSachMonTableQuanLyDonHang;
import quanlybanhangmangdi.model.NhanVienDTO;
import quanlybanhangmangdi.model.NhanVienTable;
 
public class GiaoDienQuanLyNhanVienEditController implements Initializable{

	@FXML
    private TextField txt_HoTen;

    @FXML
    private ComboBox<String> cb_ChucVu;

    @FXML
    private ComboBox<String> cb_GioiTinh;

    @FXML
    private DatePicker dp_NgaySinh;

    @FXML
    private TextField txt_DienThoai;

    @FXML
    private TextArea txa_DiaChi;

    @FXML
    private Button btn_Luu;

    @FXML
    private Button btn_Cancel;

    @FXML
    private TextField txt_TaiKhoan;

    @FXML
    private PasswordField txt_MatKhau;
    
    @FXML
    private Label lbl_TaiKhoan;
	
    private NhanVienTable nhanVien1;
	
	
	public void show() {

		
		
	}
	
	
	@FXML
	public void suaNhanVien(ActionEvent event) {
	}
	
	public void setTaiKhoan(String taiKhoan) {
		lbl_TaiKhoan.setText(taiKhoan);
	}
	
	
	
	
	
	public void alertLoi(String title, String header) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	public void alertThongBao(String title, String header) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	public void alertXacNhan(String title, String header) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	
	//Kiểm tra xem thông tin nhập trên form có hợp lệ không
	@FXML
	public boolean kiemTraThongTin() {
		String dienThoai = txt_DienThoai.getText();
		//Nếu những text field cần điền bị trống
		if( txt_HoTen.getText().isEmpty() || txt_TaiKhoan.getText().isEmpty() || txt_MatKhau.getText().isEmpty() || dp_NgaySinh.getValue() == null || txt_DienThoai.getText().isEmpty() || txa_DiaChi.getText().isEmpty())
		{
			alertLoi("Thông báo", "Vui lòng điền đầy đủ thông tin");
			return false;
		} else if (dienThoai.length()!=10){
			// nếu độ dài của số điện thoại khác 10
			alertLoi("Thông báo", "Vui lòng nhập số điện thoại đúng quy định");
			return false;
		}
		return true;
	}
	
	
	//Đóng cửa sổ hiện tại
	@FXML
	private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
