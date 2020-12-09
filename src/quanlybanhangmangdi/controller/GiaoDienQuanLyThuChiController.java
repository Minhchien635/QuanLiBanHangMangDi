package quanlybanhangmangdi.controller;


import java.awt.DisplayMode;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

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
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.database.*;

public class GiaoDienQuanLyThuChiController implements Initializable{
		
	
		//public static ObservableList<PhieuChi> listPhieuChi =  FXCollections.observableArrayList(DAO.getCacPhieuChi());
		
		
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
	    
	    
	 
	    /*Các trường input dữ liệu*/
	    @FXML
	    private ComboBox<String> chonkieuxem;

	    @FXML
	    private DatePicker chonngay;
	    
	    @FXML
	    private ComboBox<Integer> chonthang;

	    @FXML
	    private Button xemphieuchi;

	    @FXML
	    private Button themphieuchi;

	    @FXML
	    private Button anphieuchi;

	    @FXML
	    private Button inphieuchi;
	    
	    @FXML
	    private TableView<PhieuChi> table;
	    
	    @FXML
	    private TableColumn<PhieuChi, Integer> manhanvien;

	    @FXML
	    private TableColumn<PhieuChi, String> maphieuchi;

	    @FXML
	    private TableColumn<PhieuChi, String> ngaychi;

	    @FXML
	    private TableColumn<PhieuChi, Integer> tongtien;

	    
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
    
    private void setThongTinTaiKhoan() {
    	try {
			// set thong tin tai khoan
			Test.setLabelThongTinDangNhap(UserIDLabel, UserNameLabel, UserPermissionLabel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //bat su kien button action
    @FXML
    private void action_anphieuchi(ActionEvent event) {
    	System.out.print("hello an phieu chi");
    }

    @FXML
    private  void action_inphieuchi(ActionEvent event) {
    	System.out.print("hello in phieu chi");
    }

    @FXML
    private void action_themphieuchi(ActionEvent event) {
    	System.out.print("hello them phieu chi");
    }

    @FXML
    private void action_xemphieuchi(ActionEvent event) {
    	System.out.print("hello xem phieu chi");
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
    	ObservableList<PhieuChi> listPhieuChi = FXCollections.observableArrayList(DAO.getCacPhieuChi());
		table.getItems().setAll(listPhieuChi);
	}

 	private void initCol() {
 		manhanvien.setCellValueFactory(new PropertyValueFactory<PhieuChi, Integer>("manhanvien"));
 		maphieuchi.setCellValueFactory(new PropertyValueFactory<PhieuChi, String>("ma"));
 		ngaychi.setCellValueFactory(new PropertyValueFactory<PhieuChi, String>("ngay"));
 		tongtien.setCellValueFactory(new PropertyValueFactory<PhieuChi, Integer>("tonggia"));
 	}
    
    private void setup() {
    	try {
    		initCol();
    		loadDataPhieuChi();
    		hienthiDropdown();
			chonkieuxem.setItems(chonkieuxemCombobox());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
	
	
	



}
