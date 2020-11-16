package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.model.DanhSachMonTableQuanLyDonHang;
import quanlybanhangmangdi.model.LoaiMonDTO;
import quanlybanhangmangdi.model.MenuDTO;
import quanlybanhangmangdi.model.MenuTable;
import quanlybanhangmangdi.model.NhanVienDTO;
 
public class GiaoDienQuanLyMenuAddController implements Initializable{


    @FXML
    private TextField txt_TenMon;

    @FXML
    private ComboBox<LoaiMonDTO> cb_LoaiMon;

    @FXML
    private Button btn_Luu;

    @FXML
    private Button btn_Cancel;

    @FXML
    private TextField txt_GiaBan;

	
	public void show() {
		Stage primaryStage = new Stage();
		 
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyMenuAdd.fxml"));
			Scene scene = new Scene(root,645,432);
			scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
		    primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	
	
	//Đóng cửa sổ hiện tại
	@FXML
	private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
	public void setDanhSachLoaiMon() {
		ArrayList<LoaiMonDTO> danhSachLoaiMon = LoaiMonDTO.getDanhSachLoaiMon();
		cb_LoaiMon.setItems(FXCollections.observableArrayList(danhSachLoaiMon));
	}
	
	
	@FXML
	public void themMon(ActionEvent event) {
		if(txt_TenMon.getText().isEmpty()  || txt_GiaBan.getText().isEmpty() || cb_LoaiMon.getSelectionModel().isEmpty()) {
			alertLoi("Lỗi", "Vui lòng thêm đầy đủ thông tin");
			return ;
		}
		if(!kiemTraGiaBan(txt_GiaBan.getText())) {
			alertLoi("Lỗi", "Vui lòng nhập giá bán chính xác");
			return ;
		}
		String maLoaiMon = cb_LoaiMon.getSelectionModel().getSelectedItem().getMaLoaiMon();
		MenuDTO monMoi = new MenuDTO(maLoaiMon, txt_TenMon.getText(), Integer.parseInt(txt_GiaBan.getText()));
		if(monMoi.luuMonDataBase()) {
			alertThongBao("Thông báo", "Lưu món mới thành công");
			huy(event);
		} else {
			alertLoi("Lỗi", "Lưu món thất bại");
		}
	}
	
	public boolean kiemTraGiaBan(String s) {
		try {
			Integer giaBan = Integer.parseInt(s);
			if(giaBan > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setDanhSachLoaiMon();
	}
	

}
