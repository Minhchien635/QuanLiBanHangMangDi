package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.AppGiaoHangTable;
import quanlybanhangmangdi.model.MenuTable;
import quanlybanhangmangdi.model.NhanVienTable;

public class GiaoDienQuanLyMenuController implements Initializable{
		
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
	    
	    
	    // Khai báo cho button chức năng
	    @FXML
	    private Button btn_ThemMon;

	    @FXML
	    private Button btn_SuaMon;

	    @FXML
	    private Button btn_XoaMon;

	    @FXML
	    private Button btn_QuanLyLoaiMon;

	    // Get dữ liệu món
	    ObservableList<MenuTable> danhSachMon;
	    
	    
	    //Khai báo cho table danh sách món
	    @FXML
	    private TableView<MenuTable> tbl_DanhSachMon;

	    @FXML
	    private TableColumn<MenuTable, String> col_MaMon;

	    @FXML
	    private TableColumn<MenuTable, String> col_LoaiMon;

	    @FXML
	    private TableColumn<MenuTable, String> col_TenMon;

	    @FXML
	    private TableColumn<MenuTable, Integer> col_GiaBan;
	    
	    
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) throws IOException {
	    	if(event.getSource() == btn_DonHang) {
	    		GiaoDienQuanLyDonHangController menu = new GiaoDienQuanLyDonHangController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
	    	else if(event.getSource() == btn_Menu) {
				return ;
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
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyMenu.fxml"));
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
    
    
    public void iniMonCol() {
		col_MaMon.setCellValueFactory(new PropertyValueFactory<MenuTable, String>("maMon"));
		col_LoaiMon.setCellValueFactory(new PropertyValueFactory<MenuTable, String>("tenLoaiMon"));
		col_TenMon.setCellValueFactory(new PropertyValueFactory<MenuTable, String>("tenMon"));
		col_GiaBan.setCellValueFactory(new PropertyValueFactory<MenuTable, Integer>("giaBan"));
    }
    
    public void loadDataMon() {
    	// lấy dữ liệu món trong database
    	danhSachMon = FXCollections.observableArrayList(MenuTable.getDuLieuMonTable());
    	//set dữ liệu cho table danh sách món
    	tbl_DanhSachMon.getItems().setAll(danhSachMon);
    }

    
    @FXML
    public void themMon(ActionEvent event) {
    	GiaoDienQuanLyMenuAddController giaoDienThemMon = new GiaoDienQuanLyMenuAddController();
    	giaoDienThemMon.show();
    	loadDataMon();
    }
    
    @FXML
    public void xoaMon(ActionEvent event) {
    	MenuTable mon = tbl_DanhSachMon.getSelectionModel().getSelectedItem();
		int soLuongChon = tbl_DanhSachMon.getSelectionModel().getSelectedIndex();
		
		
		
		
		
    	if(soLuongChon == -1) {
    		alertThongBao("Lỗi", "Vui lòng chọn món cần xóa");
    		return ;
    	}
    	
    	boolean result = alertXacNhan("Xác nhận", "Bạn có chắc chắn muốn xóa nhân viên "+mon.getTenMon()+" khỏi danh sách chứ?");	
		
    	if(result) {
    		if(xoaMon(mon.getMaMon())) {
        		alertThongBao("Thông báo", "Xóa món thành công");
        		loadDataMon();
        	} else {
        		alertLoi("Lỗi", "Xóa món thất bại");
        	}
    	}
    
    }
    //Hàm hỗ trợ xóa món từ database
    public boolean xoaMon(String maMon) {
		String sql = "DELETE FROM mon\r\n" + 
				"WHERE ma = '"+maMon+"'";
		System.out.println(sql);
		boolean result = DataHelper.execAction(sql);
		return result;
	}
    
    
    @FXML
    public void suaMon(ActionEvent event) {
    	//Lấy món đã chọn
    	suaMon();
    }
    
    public void suaMon() {
    	MenuTable monDaChon = tbl_DanhSachMon.getSelectionModel().getSelectedItem();
        //Hiển thị form sửa cho người dùng
    	GiaoDienQuanLyMenuEditController controller = new GiaoDienQuanLyMenuEditController();
    	controller.show(monDaChon);
    	loadDataMon();
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
	
	public boolean alertXacNhan(String title, String header) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
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
	
     
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniMonCol();
		loadDataMon();
		setThongTinTaiKhoan();
		
		
		//Set bắt sự kiện double click cho bản để hiển thị sửa món
		tbl_DanhSachMon.setOnMouseClicked( event -> {
		if( event.getClickCount() == 2 ) {
		suaMon();
			   }});

	}
	
	
	



}
