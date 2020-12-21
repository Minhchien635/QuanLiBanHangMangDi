package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.security.Principal;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.model.NguyenLieu;
import quanlybanhangmangdi.model.NguyenLieuTable;
import quanlybanhangmangdi.model.PhieuChi;

public class QuanLyNguyenLieuController implements Initializable {
	@FXML
	private TableView<NguyenLieu> tablenguyenlieu;

	@FXML
	private TableColumn<NguyenLieu, String> tennguyenlieu;

	@FXML
	private TableColumn<NguyenLieu, Integer> gia;

	@FXML
	private TableColumn<NguyenLieu, Integer> soluong;

	@FXML
	private Button sua;

	@FXML
	private Button annguyenlieu;

	@FXML
	private Button xemnguyenlieuan;

	@FXML
	void action_annguyenlieu(ActionEvent event) {
		try {
			String index = tablenguyenlieu.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Ẩn nguyên liệu");
			alert.setHeaderText("Xác nhận ẩn nguyên liệu " + index);

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get() == ButtonType.OK) {
				NguyenLieu nl = new NguyenLieu(index);
				if (nl.thayDoiTrangThai()) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Thông báo");
					alert1.setHeaderText(null);
					alert1.setContentText("Đã ẩn");
					alert1.showAndWait();
					loadNguyenLieu();
				} else {
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("Lỗi");
					alert1.setHeaderText(null);
					alert1.setContentText("Ẩn thất bại");
					alert1.showAndWait();
					loadNguyenLieu();
					;
				}

			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn nguyên liệu cần ẩn");
			alert1.showAndWait();
		}
	}

	@FXML
	void action_xemnguyenlieuan(ActionEvent event) {
		XemNguyenLieuAnController nla = new XemNguyenLieuAnController();
		try {
			nla.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadNguyenLieu();
	}

	@FXML
	void action_taonguyenlieu(ActionEvent event) {
		TaoNguyenLieuController tnl = new TaoNguyenLieuController();
		try {
			tnl.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadNguyenLieu();
	}

	@FXML
	private void action_sua(ActionEvent event) {
		try {
			NguyenLieu nl = tablenguyenlieu.getSelectionModel().getSelectedItem();
			if (nl != null) {
				SuaNguyenLieuController snl = new SuaNguyenLieuController();
				snl.show(nl);
			} else {
				throw new IOException();
			}
			loadNguyenLieu();
		} catch (IOException e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn nguyên liệu cần sửa");
			alert1.showAndWait();
		}
	}

	/*
	 * @FXML void action_xoa(ActionEvent event) { try { String index =
	 * tablenguyenlieu.getSelectionModel().getSelectedItem().getMa(); Alert alert =
	 * new Alert(AlertType.CONFIRMATION); alert.setTitle("Xóa");
	 * alert.setHeaderText("Xóa phiếu chi " + index);
	 * 
	 * Optional<ButtonType> option = alert.showAndWait(); if (option.get() ==
	 * ButtonType.OK) { NguyenLieu nl = new NguyenLieu(index);
	 * if(DAO.XoaNguyenLieu(nl)) { Alert alert1 = new
	 * Alert(Alert.AlertType.INFORMATION); alert1.setTitle("Thông báo");
	 * alert1.setHeaderText(null); alert1.setContentText("Đã xóa");
	 * alert1.showAndWait(); loadNguyenLieu(); }else { Alert alert1 = new
	 * Alert(Alert.AlertType.ERROR); alert1.setTitle("Lỗi");
	 * alert1.setHeaderText(null); alert1.setContentText("Xóa thất bại");
	 * alert1.showAndWait(); loadNguyenLieu(); }
	 * 
	 * } else if (option.get() == ButtonType.CANCEL) { } } catch (Exception e) {
	 * Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
	 * alert1.setTitle("Thông báo"); alert1.setHeaderText(null);
	 * alert1.setContentText("Chọn nguyên liệu cần xóa"); alert1.showAndWait(); } }
	 */
	private void loadNguyenLieu() {
		ObservableList<NguyenLieu> listNguyenLieu = FXCollections.observableArrayList(DAO.getTenNguyenLieu(1));
		tablenguyenlieu.getItems().clear();
		tablenguyenlieu.getItems().addAll(listNguyenLieu);
	}

	private void initCol() {
		tennguyenlieu.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("ten"));
		gia.setCellValueFactory(new PropertyValueFactory<NguyenLieu, Integer>("gia"));
		soluong.setCellValueFactory(new PropertyValueFactory<NguyenLieu, Integer>("soluong"));
	}

	public void show() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/QuanLyNguyenLieu.fxml"));
		Scene scene = new Scene(root, 755, 438);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.showAndWait();
	}

	private void setup() {
		try {
			initCol();
			loadNguyenLieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}

}
