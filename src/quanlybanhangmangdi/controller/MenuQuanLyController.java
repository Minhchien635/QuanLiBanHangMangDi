package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.DonHang;

public class MenuQuanLyController implements Initializable{
	
	@FXML
    private Label UserNameLabel;

    @FXML
    private Label UserPermissionLabel;

    @FXML
    private Label UserIDLabel;

    @FXML
    private Button btn_DonHang;

    @FXML
    private Button btn_AppGiaoHang;

    @FXML
    private Button btn_Menu;

    @FXML
    private Button btn_NhanVien;

    @FXML
    private Button btn_BaoCao;

    @FXML
    private Button btn_ThuChi;
	
	public void show() throws IOException {
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/MenuQuanLy.fxml"));
		Scene scene = new Scene(root,900,630);
		scene.getStylesheets().add(getClass().getResource("../view/MenuQuanLyStyle.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
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
	 @FXML
	    private void moGiaoDienQuanLy(ActionEvent event) throws IOException {
			MenuQuanLyController menuQuanLy = new MenuQuanLyController();
			huy(event);
			menuQuanLy.show();
		}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Test.setLabelThongTinDangNhap(UserIDLabel, UserNameLabel, UserPermissionLabel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
