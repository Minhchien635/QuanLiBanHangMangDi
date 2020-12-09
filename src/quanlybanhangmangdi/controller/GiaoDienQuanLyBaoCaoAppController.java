package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.naming.spi.DirStateFactory.Result;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import quanlybanhangmangdi.model.AppGiaoHangTable;
import quanlybanhangmangdi.model.BaoCaoAppTable;
import quanlybanhangmangdi.model.DonHangTable;

public class GiaoDienQuanLyBaoCaoAppController implements Initializable{
		

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
    private TableView<BaoCaoAppTable> tbl_DoanhThuApp;

    @FXML
    private TableColumn<BaoCaoAppTable, String> col_MaApp;

    @FXML
    private TableColumn<BaoCaoAppTable, String> col_TenApp;

    @FXML
    private TableColumn<BaoCaoAppTable, Integer> col_PhiHoaHong;

    @FXML
    private TableColumn<BaoCaoAppTable, Integer> col_TongThu;
    
	public static ObservableList<BaoCaoAppTable> danhSachApp; 

    
	    
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
			else if(event.getSource() == btn_BaoCao) {
				GiaoDienQuanLyBaoCaoController menu = new GiaoDienQuanLyBaoCaoController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_BaoCao1) {
				return ;
			} 
		}
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyBaoCaoApp.fxml"));
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
    
    
    
    @FXML
    private void xemBaoCao(ActionEvent event) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if(cb_ChonKieuXem.getSelectionModel().getSelectedIndex() == 0) {
    		
    	}
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
    
    private void iniCol() {
    	col_MaApp.setCellValueFactory(new PropertyValueFactory<>("maApp"));
    	col_TenApp.setCellValueFactory(new PropertyValueFactory<>("tenApp"));
    	col_PhiHoaHong.setCellValueFactory(new PropertyValueFactory<>("phiHoaHong"));
    	col_TongThu.setCellValueFactory(new PropertyValueFactory<>("tongThu"));
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
    	//chọn danh sách tháng
    	cb_ChonThang.getItems().setAll(FXCollections.observableArrayList(danhSachThang));
    	cb_ChonThang.setVisible(false);
    	iniCol();
    	danhSachApp = FXCollections.observableArrayList(getDuLieuBaoCaoApp());
    	tbl_DoanhThuApp.getItems().setAll(danhSachApp);
    	
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
		for(BaoCaoAppTable baoCao : danhSachApp) {
			System.out.println(baoCao.getMaApp());
			System.out.println(baoCao.getTenApp());
			System.out.println(baoCao.getPhiHoaHong());
			System.out.println(baoCao.getTongThu());
			System.out.println("========");
		}
	}
	
	private static ArrayList<BaoCaoAppTable> getDuLieuBaoCaoApp() {
		String sql = "SELECT a.ma,a.Ten,SUM(IFNULL(hd.PhiDichVu,0)) AS PhiDichVu,SUM(IFNULL(hd.TongTienThu, 0)) AS TongTienThu FROM App a\r\n" + 
				"LEFT JOIN HoaDon hd ON a.ma = hd.MaApp\r\n" + 
				"GROUP BY a.ma;";
		ResultSet rs = DataHelper.execQuery(sql);
		
		ArrayList<BaoCaoAppTable> doanhThuTheoApp = new ArrayList<BaoCaoAppTable>();
		try {
			while(rs.next()) {
				String maApp = rs.getString("a.ma");
				String tenApp = rs.getString("a.ten");
				Integer phiHoaHong = rs.getInt("PhiDichVu");
				Integer tongThu = rs.getInt("TongTienThu");
				doanhThuTheoApp.add(new BaoCaoAppTable(maApp, tenApp, phiHoaHong, tongThu));
			}
			return doanhThuTheoApp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}


