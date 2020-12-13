package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.main.Test;

public class GiaoDienQuanLyBaoCaoController implements Initializable{
		

    @FXML
    private Button btn_DonHang;

    @FXML
    private Button btn_Menu;

    @FXML
    private Button btn_AppGiaoHang;

    @FXML
    private Button btn_NhanVien;

    @FXML
    private Button btn_ThuChi;

    @FXML
    private Button btn_BaoCao;
    

    @FXML
    private Button btn_BaoCao1;

    @FXML
    private Label UserNameLabel;

    @FXML
    private Label UserPermissionLabel;

    @FXML
    private Label UserIDLabel;

    @FXML
    private Pane pane_BaoCao;

    @FXML
    private ComboBox<String> cb_ChonKieuXem;

    @FXML
    private Button btn_XemBaoCao;

    @FXML
    private ComboBox<String> cb_ChonThang;

    @FXML
    private DatePicker dp_ChonNgay;

    @FXML
    private Pane pane_Title;

    @FXML
    private Label btn_Title1;

	    
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) throws IOException {
	    	if(event.getSource() == btn_DonHang) {
	    		GiaoDienQuanLyDonHangController menu = new GiaoDienQuanLyDonHangController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
	    	else if(event.getSource() == btn_Menu) {
				GiaoDienQuanLyMenuController menu = new GiaoDienQuanLyMenuController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_AppGiaoHang) {
				GiaoDienQuanLyAppController menu = new GiaoDienQuanLyAppController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_NhanVien) {
				GiaoDienQuanLyNhanVienController menu = new GiaoDienQuanLyNhanVienController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_ThuChi) {
				GiaoDienQuanLyThuChiController menu = new GiaoDienQuanLyThuChiController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			} 
			else if(event.getSource() == btn_BaoCao1) {
				GiaoDienQuanLyBaoCaoAppController menu = new GiaoDienQuanLyBaoCaoAppController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_BaoCao) {
				return ;
			} 
		}
	@FXML
	private void dangXuat(ActionEvent event) throws IOException {
		if(alertXacNhan("Xác nhận", "Bạn có chắc chắn muốn đăng xuất chứ?")) {
			LoginController login = new LoginController();
			login.show();
			huy(event);
		}
	}

	public boolean alertXacNhan(String title, String header) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		Optional<ButtonType> option = alert.showAndWait();
		if(option.get() == null) {
			return false;
		} else if(option.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyBaoCao.fxml"));
		Scene scene = new Scene(root,1920,1080);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
    }
    
 public void show720p() throws IOException {
		
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyBaoCao720P.fxml"));
		Scene scene = new Scene(root,1082,619);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    @FXML
    private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    

    @FXML
    private void moGiaoDienQuanLy(ActionEvent event) throws IOException {
		MenuQuanLyController menuQuanLy = new MenuQuanLyController();
		huy(event);
		menuQuanLy.show();
	}
    private void setThongTinTaiKhoan() {
    	try {
			// set thong tin tai khoan
			Test.setLabelThongTinDangNhap(UserIDLabel, UserNameLabel, UserPermissionLabel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void setup() {
    	cb_ChonKieuXem.getItems().setAll("Theo ngày", "Theo tháng");
    	cb_ChonKieuXem.getSelectionModel().selectFirst();
    	//cho chọn tháng ẩn
    	
    	LocalDate date = LocalDate.now();
    	// Hiển thị ngày hiện tại(nếu người dùng chọn xem báo cáo theo ngày)
    	dp_ChonNgay.setValue(date);
    	ArrayList<String> danhSachThang = new ArrayList<String>();
    	for(int i = 1;i<=date.getMonthValue();i++) {
    		danhSachThang.add("Tháng "+i+"/"+date.getYear());
    	}
    	
    	cb_ChonThang.getItems().setAll(FXCollections.observableArrayList(danhSachThang));
    	cb_ChonThang.setVisible(false);
    	
    	
    }
    
    
    @FXML
    private void chonKieuXem(ActionEvent event) {
    	if(cb_ChonKieuXem.getSelectionModel().getSelectedIndex()==0) {
    		dp_ChonNgay.setVisible(true);
    		cb_ChonThang.setVisible(false);
    	} else {
    		dp_ChonNgay.setVisible(false);
    		cb_ChonThang.setVisible(true);
    	}
    }
   
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
		setThongTinTaiKhoan();
	}
}
