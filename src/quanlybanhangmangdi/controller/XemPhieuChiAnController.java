package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert.AlertType;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.model.TablePhieuChi;

public class XemPhieuChiAnController implements Initializable {
	@FXML
	private TableView<TablePhieuChi> tablephieuchi;

	@FXML
	private TableColumn<TablePhieuChi, String> tennhanvien;

	@FXML
	private TableColumn<TablePhieuChi, String> maphieuchi;

	@FXML
	private TableColumn<TablePhieuChi, Date> ngaychi;

	@FXML
	private TableColumn<TablePhieuChi, Integer> tongtien;

	@FXML
	private Button khoiphuc;

	@FXML
	private Button xoa;

	@FXML
	private void action_khoiphuc(ActionEvent event) {
		try {
			String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Khôi phuc");
			alert.setHeaderText("Xác nhận khôi phục " + index);

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get() == ButtonType.OK) {
				PhieuChi pc = new PhieuChi(index);
				if (pc.thayDoiTrangThai()) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Thông báo");
					alert1.setHeaderText(null);
					alert1.setContentText("Khôi phục thành công");
					alert1.showAndWait();
					loadDataPhieuChi();
				} else {
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("Lỗi");
					alert1.setHeaderText(null);
					alert1.setContentText("Khôi phục thất bại");
					alert1.showAndWait();
					loadDataPhieuChi();
				}

			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn phiếu chi cần khôi phục");
			alert1.showAndWait();
		}
		loadDataPhieuChi();
	}

	@FXML
	void action_xoa(ActionEvent event) {
		try {
			String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Xóa");
			alert.setHeaderText("Xóa phiếu chi " + index);

			Optional<ButtonType> option = alert.showAndWait();
			if (option.get() == ButtonType.OK) {
				PhieuChi pc = new PhieuChi(index);
				if (DAO.XoaPhieuChi(pc)) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Thông báo");
					alert1.setHeaderText(null);
					alert1.setContentText("Đã xóa");
					alert1.showAndWait();
					loadDataPhieuChi();
				} else {
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("Lỗi");
					alert1.setHeaderText(null);
					alert1.setContentText("Xóa thất bại");
					alert1.showAndWait();
					loadDataPhieuChi();
				}

			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn phiếu chi cần xóa");
			alert1.showAndWait();
		}
	}

	public void show() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/XemPhieuChiAn.fxml"));
		Scene scene = new Scene(root, 755, 438);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.showAndWait();
	}

	public void loadDataPhieuChi() {
		ObservableList<TablePhieuChi> listPhieuChi = FXCollections.observableArrayList(DAO.getCacPhieuChi(0));
		tablephieuchi.getItems().setAll(listPhieuChi);
		if (listPhieuChi == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText("Danh sách dữ liệu app bị trống");
			alert.showAndWait();
		}
	}

	private void initCol() {
		tennhanvien.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, String>("tennhanvien"));
		maphieuchi.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, String>("ma"));
		ngaychi.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, Date>("ngay"));
		tongtien.setCellValueFactory(new PropertyValueFactory<TablePhieuChi, Integer>("tonggia"));
	}

	private void setup() {
		try {
			initCol();
			loadDataPhieuChi();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}

}
