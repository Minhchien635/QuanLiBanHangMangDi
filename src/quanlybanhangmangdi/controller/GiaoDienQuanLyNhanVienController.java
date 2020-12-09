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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.AppGiaoHangTable;
import quanlybanhangmangdi.model.NhanVienDTO;
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
	    private Button btn_BaoCao1;

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
			else if(event.getSource() == btn_BaoCao1) {
				GiaoDienQuanLyBaoCaoAppController menu = new GiaoDienQuanLyBaoCaoAppController();
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
    
    @FXML
    public void themNhanVien(ActionEvent event) {
    	GiaoDienQuanLyNhanVienAddController addNhanVienView = new GiaoDienQuanLyNhanVienAddController();
    	addNhanVienView.show();
    	loadDataNhanVien();
    }
    
    @FXML
	public void xoaNhanVien(ActionEvent event) {

		NhanVienTable nhanVien = tbl_NhanVien.getSelectionModel().getSelectedItem();
		int soLuongChon = tbl_NhanVien.getSelectionModel().getSelectedIndex();
    	if(soLuongChon == -1) {
    		alertLoi("Lỗi", "Vui lòng chọn nhân viên cần xóa");
    		return ;
    	}
		if(nhanVien.getMaNhanVien()==1) {
			alertLoi("Lỗi", "Bạn không thể xóa chủ nhà hàng");
			return ;
		}
    	
		if(nhanVien.getMaNhanVien() == Test.nhanVien.getMaNhanVien()) {
			alertLoi("Lỗi", "Bạn không thể xóa chính mình");
			return ;
		}
		
		//Hiện thông báo yêu cầu xác nhận xóa nhân viên
		boolean result = alertXacNhan("Xác nhận", "Bạn có chắc chắn muốn xóa nhân viên "+nhanVien.getTenNhanVien()+" khỏi danh sách chứ?");	
		
		if(result) {
			if(xoaNhanVien(nhanVien.getMaNhanVien())) {
				alertThongBao("Thông báo", "Xóa nhân viên" + nhanVien.getTenNhanVien() + "Thành công");
				loadDataNhanVien();
			} else {
				alertLoi("Lỗi", "Xóa nhân viên thất bại");
			}
		}
	}
    
    public boolean xoaNhanVien(int maNhanVien) {
		String sql = "DELETE FROM NhanVien\r\n" + 
				"WHERE ma = "+maNhanVien;
		System.out.println(sql);
		boolean result = DataHelper.execAction(sql);
		return result;
	}
    @FXML
    public void suaNhanVien(ActionEvent event) {
    	if(tbl_NhanVien.getSelectionModel().getSelectedIndex()==-1) {
    		alertLoi("Lỗi", "Vui lòng chọn nhân viên cần chỉnh sửa");
    		return ;
    	}
    	NhanVienTable nhanVienSelected = tbl_NhanVien.getSelectionModel().getSelectedItem();
    	if(nhanVienSelected.getMaNhanVien()==1)
    	{
    		alertLoi("Lỗi", "Bạn không thể thay đổi thông tin của chủ quán");
    		return ;
    	}
    	
    	
    	try {
    		Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("../view/GiaoDienQuanLyNhanVienEdit.fxml").openStream());
			GiaoDienQuanLyNhanVienEditController editNhanVienController = (GiaoDienQuanLyNhanVienEditController)loader.getController();
			editNhanVienController.setThongTin(danhSachNhanVien, nhanVienSelected);
			Scene scene = new Scene(root,645,765);
			scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.showAndWait();
			loadDataNhanVien();
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
		iniNhanVienCol();
		loadDataNhanVien();
		setThongTinTaiKhoan();
	}
	
	
	



}
