package quanlybanhangmangdi.controller;



import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietHoaDonDTO;
import quanlybanhangmangdi.model.DanhSachMonTableQuanLyDonHang;
import quanlybanhangmangdi.model.DonHangDTO;
import quanlybanhangmangdi.model.DonHangTable;
import quanlybanhangmangdi.model.MonTrongDanhSach;

public class GiaoDienNhanVien implements Initializable{
		
		public static ObservableList<DonHangTable> listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangNhanVienTable()); 
		
		public static ObservableList<DanhSachMonTableQuanLyDonHang> listMon;
		
		
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
	    private TableColumn<DonHangTable, String> nhanVienCol;

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
	    private TableView<DanhSachMonTableQuanLyDonHang> dsMonTable;

	    @FXML
	    private TableColumn<DanhSachMonTableQuanLyDonHang, String> tenMonCol;

	    @FXML
	    private TableColumn<DanhSachMonTableQuanLyDonHang, Integer> soLuongCol;

	    @FXML
	    private TableColumn<DanhSachMonTableQuanLyDonHang, Integer> donGiaCol;

	   
	
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienNhanVien.fxml"));
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
    	loadDataHoaDon();
    }
    
   

    @FXML
    private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
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
		
		iniColDSMon();
		loadDataHoaDon();
		iniColHoaDon();
		setThongTinTaiKhoan();
	}
	
	
	
	
	
	
	
	public TableView<DonHangTable> getTableDonHang() {
		return tableDonHang;
	}

	public void setTableDonHang(TableView<DonHangTable> tableDonHang) {
		this.tableDonHang = tableDonHang;
	}

	public void loadDataHoaDon() {
		listDonHang.clear();
		listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangTable());
		tableDonHang.getItems().setAll(listDonHang);
	}
	
	private void iniColHoaDon() {
		maDonCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("ma"));
		thoiGianCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("thoiGian"));
		nhanVienCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("maNhanVien"));
		nguonDonCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("maApp"));
		maDonAppCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, String>("maDonApp"));
		chietKhauCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("chietKhau"));
		tongTienCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("tongGia"));
		phiDichVuCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("phiDichVu"));
		tongThuCol.setCellValueFactory(new PropertyValueFactory<DonHangTable, Integer>("tongTienThu"));
	}
	
	
	private void iniColDSMon() {
		tenMonCol.setCellValueFactory(new PropertyValueFactory<DanhSachMonTableQuanLyDonHang, String>("tenMon"));
		soLuongCol.setCellValueFactory(new PropertyValueFactory<DanhSachMonTableQuanLyDonHang, Integer>("soLuong"));
		donGiaCol.setCellValueFactory(new PropertyValueFactory<DanhSachMonTableQuanLyDonHang, Integer>("donGia"));
	}
	
	@FXML
	public void hienThiDanhSachMon() {
		if(tableDonHang.getSelectionModel().isEmpty()) return ;
		String maDon = tableDonHang.getSelectionModel().getSelectedItem().getMa();
		listMon  =  FXCollections.observableArrayList(DAO.getDanhSachMonQLDH(maDon));
		dsMonTable.setItems(listMon);
	}
	
	
	
	@FXML
	public void tamXoaDonHang() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	String maDon = tableDonHang.getSelectionModel().getSelectedItem().getMa();
        alert.setTitle("Xóa đơn hàng");
        alert.setHeaderText("Bạn chắc chắn muốn di chuyển đơn hàng " + maDon +" xuống thùng rác");
 
        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
        
        if(option.get() == ButtonType.OK) {
        	if(anDonHangCSDL(maDon)){
        		Alert alertCompleted = new Alert(AlertType.INFORMATION);
        		alertCompleted.setTitle("Thông báo");
        		alertCompleted.setHeaderText("Xóa thành công");
        		alertCompleted.showAndWait();
        		loadDataHoaDon();
        		listMon.clear();
        	}
        }
	}
	
	private boolean anDonHangCSDL(String maHoaDon) {
		boolean result;
		
		result = DataHelper.execAction("UPDATE HoaDon\r\n" + 
				"SET TrangThai = FALSE\r\n" + 
				"WHERE ma = " +"'"+maHoaDon+"';");
		
		
		return result;
	}

	  @FXML
	    void moDonHangAn(ActionEvent event) throws IOException {
		  	XemDonHangAnController an = new XemDonHangAnController();
		  	an.show();
		  	loadDataHoaDon();
	    }


}
