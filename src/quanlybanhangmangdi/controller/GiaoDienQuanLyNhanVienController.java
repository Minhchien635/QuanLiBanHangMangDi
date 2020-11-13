package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.AppGiaoHangTable;
import quanlybanhangmangdi.model.NhanVienTable;

public class GiaoDienQuanLyNhanVienController implements Initializable{
		
		
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
	    private Pane pane_DonHang;

	    @FXML
	    private Pane pane_Menu;

	    @FXML
	    private Pane pane_AppGiaoHang;

	    @FXML
	    private Pane pane_NhanVien;

	    @FXML
	    private Pane pane_ThuChi;

	    @FXML
	    private Pane pane_BaoCao;
	    
	    @FXML
	    private Label btn_Title;
    
	    @FXML
	    private Label UserNameLabel;

	    @FXML
	    private Label UserPermissionLabel;

	    @FXML
	    private Label UserIDLabel;
	    
	    private static ObservableList<NhanVienTable> danhSachNhanVien;
	    
	    
	    //Tạo liên kết với giao diện
	    @FXML
	    private TableView<NhanVienTable> tbl_NhanVien;

	    @FXML
	    private TableColumn<NhanVienTable, Integer> col_Ma;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_Ten;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_ChucVu;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_GioiTinh;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_NgaySinh;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_DienThoai;

	    @FXML
	    private TableColumn<NhanVienTable, String> col_DiaChi;
	    
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) throws IOException {
	    	if(event.getSource() == btn_DonHang) {
				((Node)event.getSource()).getScene().getWindow().hide();
	    		GiaoDienQuanLyDonHangController menu = new GiaoDienQuanLyDonHangController();
				menu.show();
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
				return ;
			}
			else if(event.getSource() == btn_ThuChi) {
				GiaoDienQuanLyThuChiController menu = new GiaoDienQuanLyThuChiController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_BaoCao) {
				GiaoDienQuanLyBaoCaoController menu = new GiaoDienQuanLyBaoCaoController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
		}
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyNhanVien.fxml"));
		Scene scene = new Scene(root,1920,1080);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		primaryStage.show();
    }
    
   
    @FXML
    private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    
    //Hàm dùng để mở giao diện quản lý
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
    
    private void iniNhanVienCol() {
    	col_Ma.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
    	col_Ten.setCellValueFactory(new PropertyValueFactory<>("tenNhanVien"));
    	col_ChucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
    	col_GioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
    	col_NgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
    	col_DienThoai.setCellValueFactory(new PropertyValueFactory<>("dienThoai"));
    	col_DiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
    }
    
    private void loadDataNhanVien() {
    	danhSachNhanVien = FXCollections.observableArrayList(NhanVienTable.getDuLIeuTableNhanVien());
    	tbl_NhanVien.getItems().setAll(danhSachNhanVien);
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniNhanVienCol();
		loadDataNhanVien();
		setThongTinTaiKhoan();
	}
	
	
	



}
