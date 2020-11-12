package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.model.DonHangTable;

public class XemDonHangAnController implements Initializable{

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
	
	
	public static ObservableList<DonHangTable> listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangAnTable()); 

	
	
	 public void show() throws IOException {
			
			Stage primaryStage = new Stage();
			 
	    	Parent root = FXMLLoader.load(getClass().getResource("../view/XemDonHangAn.fxml"));
			Scene scene = new Scene(root,1361,725);
			scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
		
		    primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			
			primaryStage.showAndWait();
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
	 
	 public void loadDataHoaDon() {
		 	listDonHang.clear();
		 	listDonHang = FXCollections.observableArrayList(DAO.getDuLieuDonHangAnTable());
			tableDonHang.getItems().setAll(listDonHang);
		}
	 
	 @FXML
	 public void xoaVinhVienDonHang(ActionEvent event) {
		 System.out.println("Hello world");
			Alert alert = new Alert(AlertType.CONFIRMATION);
	    	String maDon = tableDonHang.getSelectionModel().getSelectedItem().getMa();
	        alert.setTitle("Xóa đơn hàng");
	        alert.setHeaderText("Bạn chắc muốn xóa vĩnh viễn " + maDon +"?");
	        alert.setContentText("Lưu ý: Đơn hàng đã bị xóa vĩnh viễn không thể không phục");
	 
	        // option != null.
	        Optional<ButtonType> option = alert.showAndWait();
	        
	        if(option.get() == ButtonType.OK) {
	        	if(xoaDonHangCSDL(maDon)){
	        		Alert alertCompleted = new Alert(AlertType.INFORMATION);
	        		alertCompleted.setTitle("Thông báo");
	        		alertCompleted.setHeaderText("Xóa thành công");
	        		alertCompleted.showAndWait();
	        		loadDataHoaDon();
	        	}
	        }
		}
	 
	 public boolean xoaDonHangCSDL(String maDon) {
		 if(!xoaChiTietHoaDonCSDL(maDon)) return false;
		 boolean result;
			
			result = DataHelper.execAction("DELETE FROM hoadon\r\n" + 
					"WHERE ma = '"+maDon+"'");
			
			
			return result;
	 }
	 
	 public boolean xoaChiTietHoaDonCSDL(String maDon) {
		 boolean result;
			
			result = DataHelper.execAction("DELETE FROM ChiTietHoaDon\r\n" + 
					"WHERE mahd = '"+maDon+"'");
			
			
			return result;
	 }
	 
	 @FXML
	 private void huy(ActionEvent event) {
	    	((Node)event.getSource()).getScene().getWindow().hide();
	 }
	 
	 
	 public void khoiPhucDonHang(ActionEvent event) {
		 Alert alert = new Alert(AlertType.CONFIRMATION);
	    	String maDon = tableDonHang.getSelectionModel().getSelectedItem().getMa();
	        alert.setTitle("Khôi phục đơn hàng");
	        alert.setHeaderText("Bạn chắc chắn muốn khôi phục " + maDon +" đã bị ẩn");
	        Optional<ButtonType> option = alert.showAndWait();
	        
	        if(option.get() == ButtonType.OK) {
	        	if(hienDonHangCSDL(maDon)){
	        		Alert alertCompleted = new Alert(AlertType.INFORMATION);
	        		alertCompleted.setTitle("Thông báo");
	        		alertCompleted.setHeaderText("Khôi phục đơn hàng thành công");
	        		alertCompleted.showAndWait();
	        		loadDataHoaDon();
	        	}
	        }
	 }
	 
	 private boolean hienDonHangCSDL(String maHoaDon) {
			boolean result;
			
			result = DataHelper.execAction("UPDATE HoaDon\r\n" + 
					"SET TrangThai = TRUE\r\n" + 
					"WHERE ma = " +"'"+maHoaDon+"';");
			
			
			return result;
		}
	 
	
	 
	 
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniColHoaDon();
		loadDataHoaDon();
	}
	
}
