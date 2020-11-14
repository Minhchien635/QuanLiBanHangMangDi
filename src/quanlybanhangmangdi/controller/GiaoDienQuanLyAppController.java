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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.AppGiaoHangTable;
import quanlybanhangmangdi.model.DonHangTable;

public class GiaoDienQuanLyAppController implements Initializable{
		
		
		
		// Cau truc chung cua view
		
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
	    
	    
	    // table
	    
	    @FXML
	    private Button themAppButton;

	    @FXML
	    private Button xoaAppButton;

	    @FXML
	    private Button suaAppButton;

	    @FXML
	    private TableView<AppGiaoHangTable> tableApp;

	    @FXML
	    private TableColumn<AppGiaoHangTable, String> maAppCol;

	    @FXML
	    private TableColumn<AppGiaoHangTable, String> tenAppCol;

	    @FXML
	    private TableColumn<AppGiaoHangTable, Integer> hoaHongCol;

	    @FXML
	    private TextField tenAppTextField;

	    @FXML
	    private TextField hoaHongTextField;

	    @FXML
	    private TextField timKiemTextField;
	    
	    
		public static ObservableList<AppGiaoHangTable> listApp; 

	    
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
			return ;
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
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyApp.fxml"));
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
    
    
    private void iniAppCol() {
		maAppCol.setCellValueFactory(new PropertyValueFactory<AppGiaoHangTable, String>("maApp"));
		tenAppCol.setCellValueFactory(new PropertyValueFactory<AppGiaoHangTable, String>("tenApp"));
		hoaHongCol.setCellValueFactory(new PropertyValueFactory<AppGiaoHangTable, Integer>("phiHoaHong"));
		
		
    }
    
    private void loadDataDanhSachApp() {
    	listApp = FXCollections.observableArrayList(DAO.getDuLieuApp());
		tableApp.getItems().setAll(listApp);
		if(listApp==null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText("Danh sách dữ liệu app bị trống");
			alert.showAndWait();
		}
    }
    
    
    @FXML
    private void themApp(ActionEvent event) {
    	//Lấy dữ liệu Tên App và Phí Hoa Hồng nhập từ textField
    	String tenApp = tenAppTextField.getText();
    	String hoaHong = hoaHongTextField.getText();
    	// Kiểm tra xem tên app đã tồn tại chưa
    	if(kiemTraTenApp(tenApp)) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText("App đã tồn tại! Vòng lòng nhập lại.");
			alert.showAndWait();
			return ;
    	}
    	
    	// Kiểm tra xem textfield có bị trống không
    	if((!tenApp.isEmpty())&&(!hoaHong.isEmpty())) {
    		// kiểm tra phí hoa hồng hợp lệ và tên app đã tồn tại chưa
    		if( ( kiemTraPhiHoaHong( hoaHong ) ) && ( !kiemTraTenApp(tenApp) ) ) {
    			if(themAppVaoCSDL(tenApp, Integer.parseInt(hoaHong))) {
    				Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setTitle("Thông báo");
    				alert.setHeaderText("Lưu app giao hàng "+tenApp +" xuống database thành công!");
    				alert.showAndWait();
    				loadDataDanhSachApp();
    			} else {
    				Alert alert = new Alert(AlertType.ERROR);
    				alert.setTitle("Thông báo");
    				alert.setHeaderText("Lưu app giao hàng "+tenApp +" xuống database thất bại!");
    				alert.showAndWait();
    			}
    			
    		} else {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Lỗi");
    			alert.setHeaderText("Phí hoa hồng không hợp lệ hoặc tên đã tồn tại, vui lòng nhập lại");
    			alert.show();
    		}
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText("Vui lòng điền đầy đủ thông tin");
			alert.show();
    	}
    }
    

	// Kiểm tra xem App đã tồn tại trong hệ thống chưa
    private boolean kiemTraTenApp(String tenApp) {
    	for(AppGiaoHangTable app: listApp) {
    		if(app.getTenApp().contains(tenApp)) return true;
    	}
    	return false;
    }
    
    private boolean themAppVaoCSDL(String tenApp, int phiHoaHong) {
    	AppGiaoHangTable appLuuDatabase = new AppGiaoHangTable(tenApp, phiHoaHong);
    	try {
			return appLuuDatabase.luuAppXuongCSDL();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    	
    }
    
    

    
    
    
    private boolean kiemTraPhiHoaHong(String phiHoaHong) {
    	// Kiểm tra phí hoa hồng có trong khoảng từ 1 đến 100 ko
    	
    	try {
    		int intHoaHong = Integer.parseInt(phiHoaHong);
    		if((intHoaHong>=0)&& (intHoaHong<= 100) ) return true;
		} catch (Exception e) {
			return false;
		}
    	
    	return false;
    }
    
    
    @FXML private void suaThongTinApp(ActionEvent event) {
    	AppGiaoHangTable app = tableApp.getSelectionModel().getSelectedItem();
    	
    	if(app.getMaApp().equals("atqua")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Thông báo");
        	alert.setHeaderText("Bạn không thể sửa mục Ăn Tại Quán");
        	alert.show();
        	return ;
    	}
    	
    	String tenApp = app.getTenApp();
    	String phiHoaHong = Integer.toString(app.getPhiHoaHong());
    	if(tenApp.equals(tenAppTextField.getText()) && phiHoaHong.equals(hoaHongTextField.getText())) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText("Bạn không thay đổi bất kỳ thông tin gì. Vui lòng nhập thay đổi");
			alert.show();
    	} else {
    		
    		//Kiểm tra phí hoa hồng
    		if(!kiemTraPhiHoaHong(hoaHongTextField.getText())) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Lỗi");
    			alert.setHeaderText("Phí hoa hồng không hợp lệ, vui lòng nhập lại");
    			alert.show();
    			return ;
    		}
    		if(thayDoiThongTinApp(app.getMaApp(), tenAppTextField.getText(), hoaHongTextField.getText()+"")) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Thông báo");
    			alert.setHeaderText("Sửa thông tin app thành công!");
    			alert.show();
    		}
    		else {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Lỗi");
    			alert.setHeaderText("Sửa thông tin app thất bại");
    			alert.show();
    		}
    	}
    	loadDataDanhSachApp();
    }
    
    
    @FXML private void xoaApp(ActionEvent event) {
    	AppGiaoHangTable app = tableApp.getSelectionModel().getSelectedItem();
    	if(app.getMaApp().equals("atqua")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Thông báo");
        	alert.setHeaderText("Bạn không thể xóa mục Ăn Tại Quán");
        	alert.show();
        	return ;
    	}
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Thông báo");
		alert.setHeaderText("Bạn có chắn chắn xóa hoàn toàn thông tin App "+app.getTenApp()+"Khỏi hệ thống không?");


		 Optional<ButtonType> option = alert.showAndWait();
		 
		 if(option.get() == ButtonType.OK) {
			 if(xoaAppDatabase(app.getMaApp())) {
				 	alert = new Alert(AlertType.INFORMATION);
		        	alert.setTitle("Thông báo");
		        	alert.setHeaderText("Xóa thành công");
		        	alert.show();
			 } else {
				 alert.setTitle("Thông báo");
				 alert.setHeaderText("Xóa Thất Bại");
				 alert.show();
			 }
		 }
		 
		 loadDataDanhSachApp();
		
		
    }
    
    
    private boolean xoaAppDatabase(String maApp) {
    	String sql = "DELETE FROM APP\r\n" + 
    			"WHERE ma = '"+maApp+"'";
    	
    	boolean result = DataHelper.execAction(sql);
    	return result;
    }
    
    
    private static boolean thayDoiThongTinApp(String maApp, String tenAppMoi, String phiHoaHongMoi) {
    	String sql = "UPDATE app\r\n" + 
    			"SET ten = '" + tenAppMoi +"', phidichvu = " +phiHoaHongMoi + 
    			" WHERE ma = " + "'"+maApp+"'";
    	boolean result = DataHelper.execAction(sql);
    	return result;
    }
    
   
    
    
    
    @FXML
    private void showThongTin() {
    	AppGiaoHangTable app = tableApp.getSelectionModel().getSelectedItem();
    	tenAppTextField.setText(app.getTenApp());
    	hoaHongTextField.setText(app.getPhiHoaHong()+"");
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniAppCol();
		loadDataDanhSachApp();
		setThongTinTaiKhoan();
	}
	
	
	



}
