package quanlybanhangmangdi.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.model.LoaiMonDTO;
import quanlybanhangmangdi.model.MenuTable;
import quanlybanhangmangdi.model.NhanVienTable;

public class GiaoDienQuanLyMenuLoaiMonController implements Initializable{
	
	 @FXML
	    private TableView<LoaiMonDTO> tbl_LoaiMon;

	    @FXML
	    private TableColumn<LoaiMonDTO, String> col_MaLoaiMon;

	    @FXML
	    private TableColumn<LoaiMonDTO, String> col_TenLoaiMon;

	    @FXML
	    private Button btn_Them;

	    @FXML
	    private Button btn_Sua;
	    
	    @FXML
	    private Button btn_Xoa;

	    @FXML
	    private TextField txt_TenLoaiMon;

	    private static ObservableList<LoaiMonDTO> danhSachLoaiMon;
	
	
	public void show() throws IOException {
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyMenuLoaiMon.fxml"));
		Scene scene = new Scene(root,1083,701);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setScene(scene);
		
		primaryStage.showAndWait();
	}
	
	


    @FXML
    void suaLoaiMon(ActionEvent event) {
    	String tenLoaiMon = txt_TenLoaiMon.getText();
    	String maLoaiMon = tbl_LoaiMon.getSelectionModel().getSelectedItem().getMaLoaiMon();
    	if(tenLoaiMon.isEmpty()) {
    		alertLoi("Lỗi", "Vui lòng nhập tên loại món");
    		return ;
    	}
    	if(!kiemTraTenLoaiMon(tenLoaiMon)) {
    		alertLoi("Lổi", "Tên loại món đã bị trùng. Vui lòng nhập tên khác.");
    		return ;
    	}
    	
    	if(suaLoaiMonDatabase(maLoaiMon, tenLoaiMon)) {
    		alertThongBao("Thông báo", "Thay đổi thông tin loại món thành công");
    		iniCol();
    	} else {
    		alertLoi("Lỗi", "Thay đổi thông tin loại món thất bại");
    	}
    }

    @FXML
    void themLoaiMon(ActionEvent event) {
    	String tenLoaiMon = txt_TenLoaiMon.getText();
    	
    	if(tenLoaiMon.isEmpty()) {
    		alertLoi("Lỗi", "Vui lòng nhập tên loại món");
    		return ;
    	}
    	if(!kiemTraTenLoaiMon(tenLoaiMon)) {
    		alertLoi("Lổi", "Tên loại món đã bị trùng. Vui lòng nhập tên khác.");
    		return ;
    	}
    	
    	if(themLoaiMonDatabase(tenLoaiMon)) {
    		alertThongBao("Thông báo", "Thêm loại món mới thành công");
    		iniCol();
    	} else {
    		alertLoi("Lỗi", "Thêm loại món mới thất bại");
    	}
    	
    }
    
    private boolean suaLoaiMonDatabase(String maLoaiMon, String tenLoaiMon) {
    	String sql = "UPDATE LoaiMon" + 
    			" SET ten = '"+tenLoaiMon+"'" + 
    			" WHERE ma = '"+maLoaiMon+"'";
    	return DataHelper.execAction(sql);
    }
    
    private boolean themLoaiMonDatabase(String tenLoaiMon) {
    	String sql = "INSERT INTO LoaiMon(ma,ten) "
    			+ "VALUES ('"+sinhMaLoaiMon()+"',"+
    			"'"+tenLoaiMon+"')";
    	
    	return DataHelper.execAction(sql);
    }
    
    private static String sinhMaLoaiMon() {
    	String sql = "SELECT COUNT(ma) FROM LoaiMon";
    	String ma = "";
    	ResultSet rs = DataHelper.execQuery(sql);
    	try {
			while(rs.next()) {
				//Tăng giá trị của ma thêm 1
				ma = (rs.getInt("COUNT(ma)")+1) + "";
			}
			
			while(ma.length() < 2) {
				ma = "0" + ma;
			}
			
			return "LMO"+ma;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    private boolean kiemTraTenLoaiMon(String ten) {
    	for(LoaiMonDTO loaiMon:danhSachLoaiMon) {
    		if(loaiMon.getTenLoaiMon().equals(ten)) return false;
    	}
    	return true;
    }
   



    @FXML
    void xoaLoaiMon(ActionEvent event) {
    	String maLoaiMon = tbl_LoaiMon.getSelectionModel().getSelectedItem().getMaLoaiMon();
    	String tenLoaiMon = tbl_LoaiMon.getSelectionModel().getSelectedItem().getTenLoaiMon();
    	boolean rs = alertXacNhan("Thông báo", "Bạn có chắc chắn muốn xóa loại món "+tenLoaiMon);
    	if(rs) {
    		if(xoaLoaiMonDatabase(maLoaiMon)) {
    			alertThongBao("Thông báo", "Xóa loại món thành công");
    			iniCol();
    		} else {
    			alertLoi("Lỗi", "Xóa loại món thất bại");
    		}
    	}
    	

    }
    
    private boolean xoaLoaiMonDatabase(String maLoaiMon) {
    	String sql = "DELETE FROM LoaiMon WHERE ma = '"+maLoaiMon+"'";
    	return DataHelper.execAction(sql);
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
		if (option.get() == ButtonType.OK) return true;
		return false;

	}
    
    
	public void iniCol() {
		col_MaLoaiMon.setCellValueFactory(new PropertyValueFactory<LoaiMonDTO, String>("maLoaiMon"));
		col_TenLoaiMon.setCellValueFactory(new PropertyValueFactory<LoaiMonDTO, String>("tenLoaiMon"));
		danhSachLoaiMon = FXCollections.observableArrayList(LoaiMonDTO.getDanhSachLoaiMon());
		tbl_LoaiMon.getItems().setAll(danhSachLoaiMon);
	}
    
    @FXML
	public void hienThongTinLoaiMon() {
		LoaiMonDTO loaiMon = tbl_LoaiMon.getSelectionModel().getSelectedItem();
		txt_TenLoaiMon.setText(loaiMon.getTenLoaiMon());
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniCol();
		
	}
	
	

}
