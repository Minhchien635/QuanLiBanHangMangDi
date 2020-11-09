package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.DonHang;
import quanlybanhangmangdi.model.DonHangTable;
import quanlybanhangmangdi.model.MonTrongDanhSach;

public class GiaoDienQuanLyDonHangController implements Initializable{
		
		public static ObservableList<DonHangTable> listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangTable()); 
		
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
	    
	    @FXML
	    private TableView<DonHangTable> tableDonHang;

	    @FXML
	    private TableColumn<DonHangTable, String> maDonCol;

	    @FXML
	    private TableColumn<DonHangTable, String> thoiGianCol;

	    @FXML
	    private TableColumn<DonHangTable, Integer> nhanVienCol;

	    @FXML
	    private TableColumn<DonHangTable, String> nguonDonCol;

	    @FXML
	    private TableColumn<DonHangTable, String> maDonAppCol;

	    @FXML
	    private TableColumn<DonHangTable, Integer> chietKhauCol;

	    @FXML
	    private TableColumn<DonHangTable, Integer> tongTienCol;

	    @FXML
	    private TableColumn<DonHangTable, Integer> phiDichVuCol;

	    @FXML
	    private TableColumn<DonHangTable, Integer> tongThuCol;

	    @FXML
	    private Label btn_Title1;

	   
	    @FXML
	    private void handleButtonAction(ActionEvent event) throws IOException {
	    	if(event.getSource() == btn_DonHang) {
	    		return ;
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
			else if(event.getSource() == btn_BaoCao) {
				GiaoDienQuanLyBaoCaoController menu = new GiaoDienQuanLyBaoCaoController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
		}
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyDonHang.fxml"));
		Scene scene = new Scene(root,1920,1080);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);

		
		primaryStage.show();
    }
    
 
    @FXML
    private void moGiaoDienThemDonHang(ActionEvent event) throws IOException {
    	AddBillController addBill = new AddBillController();
    	addBill.show();
    }
    
   
    
    
    @FXML
    private void moGiaoDienSuaDonHang(ActionEvent event) throws IOException {
    	Stage primaryStage = new Stage();
 
    	Parent root = FXMLLoader.load(getClass().getResource("editBill/editBill.fxml"));
		Scene scene = new Scene(root,965,760);
		scene.getStylesheets().add(getClass().getResource("editBill/application.css").toExternalForm());
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniColHoaDon();
		loadDataHoaDon();
		setThongTinTaiKhoan();
	}
	
	@FXML
	public void refershData(ActionEvent event) {
		loadDataHoaDon();
		System.out.println();
	}
	
	
	
	
	
	public TableView<DonHangTable> getTableDonHang() {
		return tableDonHang;
	}

	public void setTableDonHang(TableView<DonHangTable> tableDonHang) {
		this.tableDonHang = tableDonHang;
	}

	public void loadDataHoaDon() {
		listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangTable());
		tableDonHang.getItems().setAll(listDonHang);
		System.out.println("Hello world");
	}
	
	private void iniColHoaDon() {
		maDonCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("ma"));
		thoiGianCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("thoiGian"));
		nhanVienCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("maNhanVien"));
		nguonDonCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("maApp"));
		maDonAppCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("maDonApp"));
		chietKhauCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("chietKhau"));
		tongTienCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("tongGia"));
		phiDichVuCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("phiDichVu"));
		tongThuCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("tongTienThu"));
	}
	
	
	



}
