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
import quanlybanhangmangdi.model.PhieuChi;

public class XemNguyenLieuAnController implements Initializable {
	@FXML
	private TableView<NguyenLieu> tablenguyenlieu;

	@FXML
	private TableColumn<NguyenLieu, String> tennguyenlieu;

	@FXML
	private TableColumn<NguyenLieu, Integer> gia;

	@FXML
	private TableColumn<NguyenLieu, Integer> soluong;

	@FXML
	private Button khoiphuc;

	@FXML
	void action_khoiphuc(ActionEvent event) {
		try {
			String index = tablenguyenlieu.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Khôi phuc");
			alert.setHeaderText("Xác nhận khôi phục " + index);

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get() == ButtonType.OK) {
				NguyenLieu nl =new NguyenLieu(index);
				if (nl.thayDoiTrangThai()) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Thông báo");
					alert1.setHeaderText(null);
					alert1.setContentText("Khôi phục thành công");
					alert1.showAndWait();
					loadNguyenLieu();
				} else {
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("Lỗi");
					alert1.setHeaderText(null);
					alert1.setContentText("Khôi phục thất bại");
					alert1.showAndWait();
					loadNguyenLieu();
				}

			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn nguyên liệu cần khôi phục");
			alert1.showAndWait();
		}
		loadNguyenLieu();
	}

	private void loadNguyenLieu() {
		ObservableList<NguyenLieu> listNguyenLieu = FXCollections.observableArrayList(DAO.getTenNguyenLieu(0));
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
		Parent root = FXMLLoader.load(getClass().getResource("../view/XemNguyenLieuAn.fxml"));
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
