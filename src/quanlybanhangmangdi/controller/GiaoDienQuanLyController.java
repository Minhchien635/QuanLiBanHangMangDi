package quanlybanhangmangdi.controller;



import java.io.IOException;
import java.net.URL;
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

public class GiaoDienQuanLyController implements Initializable{
		
		
		
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
    private void handleButtonAction(ActionEvent event) {
		if(event.getSource() == btn_DonHang) {
			pane_DonHang.toFront();
			btn_Title.setText("Quản Lý Đơn Hàng");
		}
		else if(event.getSource() == btn_Menu) {
			pane_Menu.toFront();
			btn_Title.setText("Quản Lý Menu");
		}
		else if(event.getSource() == btn_AppGiaoHang) {
			pane_AppGiaoHang.toFront();
			btn_Title.setText("Quản Lý Các App");
		}
		else if(event.getSource() == btn_NhanVien) {
			pane_NhanVien.toFront();
			btn_Title.setText("Quản Lý Nhân Viên");
		}
		else if(event.getSource() == btn_ThuChi) {
			pane_ThuChi.toFront();
			btn_Title.setText("Quản lý Thu Chi");
		}
		else if(event.getSource() == btn_BaoCao) {
			pane_BaoCao.toFront();
			btn_Title.setText("Báo cáo");
		}
	}
    
    public void show() throws IOException {
    			
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLy.fxml"));
		Scene scene = new Scene(root,1920,1080);
		scene.getStylesheets().add(getClass().getResource("../view/GiaoDienQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		
		
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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	



}
