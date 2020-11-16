package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import quanlybanhangmangdi.database.ConnectionUtils;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.database.MySQLConnUtils;
import quanlybanhangmangdi.model.LoaiMonDTO;
import quanlybanhangmangdi.model.MenuTable;

public class GiaoDienQuanLyMenuEditController implements Initializable{
	private MenuTable monDaChon;
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

	
	public void show(MenuTable monDaChon) {
		
		
		try {
    		Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("../view/GiaoDienQuanLyMenuEdit.fxml").openStream());
			GiaoDienQuanLyMenuEditController editMonController = (GiaoDienQuanLyMenuEditController)loader.getController();
			editMonController.setThongTin(monDaChon);
			Scene scene = new Scene(root,645,408);
			scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setThongTin(MenuTable monDaChon) {
		this.monDaChon = monDaChon;
		txt_TenMon.setText(monDaChon.getTenMon());
		
		
		// Set thông tin loại món trùng với loại món của món đã chọn
		LoaiMonDTO loaiMonDaChon;
		for(LoaiMonDTO loaiMon : setDanhSachLoaiMon()) {
			if(loaiMon.getTenLoaiMon().equals(monDaChon.getTenLoaiMon())) {
				cb_LoaiMon.getSelectionModel().select(loaiMon);
			}
		}
		
		
		txt_GiaBan.setText(monDaChon.getGiaBan()+"");
		
	}
	
	@FXML
	public void suaMon(ActionEvent event) {
		if(txt_TenMon.getText().isEmpty()  || txt_GiaBan.getText().isEmpty() || cb_LoaiMon.getSelectionModel().isEmpty()) {
			alertLoi("Lỗi", "Vui lòng thêm đầy đủ thông tin");
			return ;
		}
		if(!kiemTraGiaBan(txt_GiaBan.getText())) {
			alertLoi("Lỗi", "Vui lòng nhập giá bán chính xác");
			return ;
		}
		
		if(luuThayDoiDatabase()) {
			alertThongBao("Thông báo", "Lưu món mới thành công");
			huy(event);
		} else {
			alertLoi("Lỗi", "Lưu món thất bại");
		}
	}
	
	private boolean luuThayDoiDatabase() {
		
		String sql = "UPDATE Mon \n"
				+ "SET maloaimon ='"+cb_LoaiMon.getSelectionModel().getSelectedItem().getMaLoaiMon()+"'"
				+ ",tenmon = '"+txt_TenMon.getText()+"'"
				+ ", giaban = "+txt_GiaBan.getText()
				+ " WHERE ma = '"+monDaChon.getMaMon()+"'";
		System.out.println(sql);
		
		return DataHelper.execAction(sql);
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
	
	
	public ArrayList<LoaiMonDTO> setDanhSachLoaiMon() {
		ArrayList<LoaiMonDTO> danhSachLoaiMon = LoaiMonDTO.getDanhSachLoaiMon();
		cb_LoaiMon.setItems(FXCollections.observableArrayList(danhSachLoaiMon));
		return danhSachLoaiMon;
	}
	
	@FXML
    private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
