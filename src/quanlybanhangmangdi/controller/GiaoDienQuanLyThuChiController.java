package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietChi;
import quanlybanhangmangdi.model.ChiTietChiTable;

import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.model.TablePhieuChi;
import quanlybanhangmangdi.database.*;

public class GiaoDienQuanLyThuChiController implements Initializable{

	    @FXML
	    private TableColumn<ChiTietChiTable, String> nguyenlieuchitietchi;

	    @FXML
	    private TableColumn<ChiTietChiTable, Integer> giachitietchi;

	    @FXML
	    private TableColumn<ChiTietChiTable, Integer> soluongchitietchi;

	    @FXML
	    private TableColumn<ChiTietChiTable, Integer> tongtienchitietchi;
		
		
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
	    

	    @FXML
	    private ComboBox<String> chonkieuxem;

	    @FXML
	    private DatePicker chonngay;
	    
	    @FXML
	    private ComboBox<Integer> chonthang;

	    @FXML
	    private Button xemphieuchi;
	    
	    @FXML
	    private Button xemphieuchian;

	    @FXML
	    private Button themphieuchi;

	    @FXML
	    private Button anphieuchi;

	    @FXML
	    private Button inphieuchi;
	    
	    @FXML
	    private TableView<TablePhieuChi> tablephieuchi;
	    
	    @FXML
	    private TableView<ChiTietChiTable> tablechitietchi;
	    
	    @FXML
	    private TableColumn<TablePhieuChi, String> tennhanvien;

	    @FXML
	    private TableColumn<TablePhieuChi, String> maphieuchi;

	    @FXML
	    private TableColumn<TablePhieuChi, Date> ngaychi;

	    @FXML
	    private TableColumn<TablePhieuChi, Integer> tongtien;

	    
	    @FXML
	    private void huy(ActionEvent event) {
	    	((Node)event.getSource()).getScene().getWindow().hide();
	    }
	    
	    
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
				return ;
			}
			else if(event.getSource() == btn_BaoCao) {
				GiaoDienQuanLyBaoCaoController menu = new GiaoDienQuanLyBaoCaoController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
			else if(event.getSource() == btn_BaoCao) {
				GiaoDienQuanLyBaoCaoAppController menu = new GiaoDienQuanLyBaoCaoAppController();
				menu.show();
				((Node)event.getSource()).getScene().getWindow().hide();
			}
		}
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyThuChi.fxml"));
		Scene scene = new Scene(root,1920,1080);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);

		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		primaryStage.show();
    }
    
    public void show720p() throws IOException {
		Stage primaryStage = new Stage();
		chonkieuxemCombobox();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyThuChi720p.fxml"));
		Scene scene = new Scene(root,1082,619);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    private void moGiaoDienQuanLy(ActionEvent event) throws IOException {
		MenuQuanLyController menuQuanLy = new MenuQuanLyController();
		huy(event);
		menuQuanLy.show();
	}
    
    @FXML
    private void action_anphieuchi(ActionEvent event) {
    }
    
    @FXML
    void action_xemphieuchian(ActionEvent event) {
    }

    @FXML
    private  void action_inphieuchi(ActionEvent event) {
    }

    @FXML
    private void action_themphieuchi(ActionEvent event) throws IOException {
			ThemPhieuChiController themPhieuChi = new ThemPhieuChiController();
			themPhieuChi.show();
			loadDataPhieuChi();
    }

    @FXML
    private void action_xemphieuchi(ActionEvent event) {
    }
    
    @FXML
    void action_chonkieuxem(ActionEvent event) {
    	
    }
    
    @FXML
    void action_chonngay(ActionEvent event) {
    }

    @FXML
    void action_chonthang(ActionEvent event) {
    }
    
    private ObservableList<String> chonkieuxemCombobox(){
    	List<String> list = Arrays.asList("Theo Ngày","Theo Tháng");
     	return FXCollections.observableArrayList(list);
    }
    
    private ObservableList<Integer> chonthangCombobox(){
    	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
     	return FXCollections.observableArrayList(list);
    }
    
    private void hienthiDropdown() {
		chonthang.setVisibleRowCount(6);
		chonthang.setItems(chonthangCombobox());
	}
    
    public void loadDataPhieuChi() {
    	ObservableList<TablePhieuChi> listPhieuChi = FXCollections.observableArrayList(DAO.getCacPhieuChi());
    	tablephieuchi.getItems().setAll(listPhieuChi);
    	if(listPhieuChi==null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText("Danh sách dữ liệu app bị trống");
			alert.showAndWait();
		}
	}
    
    public void loadDataChiTietChi() {
    	tablephieuchi.setOnMouseClicked((event) -> {
    	    if (event.getButton().equals(MouseButton.PRIMARY)) {
    	        String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
    	        ObservableList<ChiTietChiTable> listChiTietChi = FXCollections.observableArrayList(DAO.getChiTietChi(index));
                tablechitietchi.getItems().setAll(listChiTietChi);
    	    }
    	});
    }
    
    
 	private void initCol() {
 		tennhanvien.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, String>("tennhanvien"));
 		maphieuchi.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, String>("ma"));
 		ngaychi.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, Date>("ngay"));
 		tongtien.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, Integer>("tonggia"));
 	}
    
 	private void initCol1() {
 		nguyenlieuchitietchi.setCellValueFactory(new PropertyValueFactory<ChiTietChiTable, String>("nguyenlieu"));
 		soluongchitietchi.setCellValueFactory(new PropertyValueFactory<ChiTietChiTable, Integer>("soluong"));
 		giachitietchi.setCellValueFactory(new PropertyValueFactory<ChiTietChiTable, Integer>("gia"));
 		tongtienchitietchi.setCellValueFactory(new PropertyValueFactory<ChiTietChiTable, Integer>("tongtien"));
 	}
 	
    private void setup() {
    	try {
    		initCol();
    		initCol1();
    		loadDataChiTietChi();
    		loadDataPhieuChi();	
   
    		hienthiDropdown();
			chonkieuxem.setItems(chonkieuxemCombobox());
		} 
    		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}
