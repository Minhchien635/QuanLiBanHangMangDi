package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietChi;
import quanlybanhangmangdi.model.ChiTietChiTable;

import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.model.TablePhieuChi;
import quanlybanhangmangdi.database.*;

public class GiaoDienQuanLyThuChiController implements Initializable {

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
	private DatePicker chonngaycombobox;

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
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		if (event.getSource() == btn_DonHang) {
			GiaoDienQuanLyDonHangController menu = new GiaoDienQuanLyDonHangController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} else if (event.getSource() == btn_Menu) {
			GiaoDienQuanLyMenuController menu = new GiaoDienQuanLyMenuController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} else if (event.getSource() == btn_AppGiaoHang) {
			GiaoDienQuanLyAppController menu = new GiaoDienQuanLyAppController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} else if (event.getSource() == btn_NhanVien) {
			GiaoDienQuanLyNhanVienController menu = new GiaoDienQuanLyNhanVienController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} else if (event.getSource() == btn_ThuChi) {
			return;
		} else if (event.getSource() == btn_BaoCao) {
			GiaoDienQuanLyBaoCaoController menu = new GiaoDienQuanLyBaoCaoController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} else if (event.getSource() == btn_BaoCao) {
			GiaoDienQuanLyBaoCaoAppController menu = new GiaoDienQuanLyBaoCaoAppController();
			menu.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		}
	}

	public void show() throws IOException {

		Stage primaryStage = new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("../view/GiaoDienQuanLyThuChi.fxml"));
		Scene scene = new Scene(root, 1920, 1080);
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
		Scene scene = new Scene(root, 1082, 619);
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
	private void action_anphieuchi(ActionEvent event1) throws SQLException {
		try {
			String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Ẩn phiếu chi");
			alert.setHeaderText("Xác nhận ẩn phiếu chi " + index);

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get() == ButtonType.OK) {
				PhieuChi pc = new PhieuChi(index);
				if (pc.thayDoiTrangThai()) {
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Thông báo");
					alert1.setHeaderText(null);
					alert1.setContentText("Đã ẩn");
					alert1.showAndWait();
					loadDataPhieuChi();
				} else {
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("Lỗi");
					alert1.setHeaderText(null);
					alert1.setContentText("Ẩn thất bại");
					alert1.showAndWait();
					loadDataPhieuChi();
				}

			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn phiếu chi cần ẩn");
			alert1.showAndWait();
		}
	}

	@FXML
	private void action_xemphieuchian(ActionEvent event) {
		XemPhieuChiAnController phieuchian = new XemPhieuChiAnController();
		try {
			phieuchian.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadDataPhieuChi();
	}

	@FXML
	private void action_inphieuchi(ActionEvent event) {
		try {
			String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("In phiếu chi");
			alert.setHeaderText("Xác nhận in phiếu chi " + index);

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get() == ButtonType.OK) {
			} else if (option.get() == ButtonType.CANCEL) {
			}
		} catch (Exception e) {
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Thông báo");
			alert1.setHeaderText(null);
			alert1.setContentText("Chọn phiếu chi cần in");
			alert1.showAndWait();
		}
	}

	@FXML
	private void action_themphieuchi(ActionEvent event) throws IOException {
		ThemPhieuChiController themPhieuChi = new ThemPhieuChiController();
		themPhieuChi.show();
		loadDataPhieuChi();
	}

	@FXML
	private void action_xemphieuchi(ActionEvent event) {
		try {
			if (chonngaycombobox.isVisible()) {
				if ((chonkieuxem.getSelectionModel().equals("Theo Ngày") && chonngaycombobox.getValue() != null)
						|| chonngaycombobox.getValue() != null) {
					ObservableList<TablePhieuChi> listPhieuChi = FXCollections
							.observableArrayList(DAO.getCacPhieuChiTheoNgay(chonngaycombobox.getValue(),1));
					tablephieuchi.getItems().setAll(listPhieuChi);
					if (listPhieuChi == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Thông báo");
						alert.setHeaderText("Danh sách dữ liệu app bị trống");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText("Vui lòng chọn ngày");
					alert.showAndWait();
				}
			} else {
				if (chonthang.getValue() != null) {
					int thang = chonthang.getValue();
					ObservableList<TablePhieuChi> listPhieuChi = FXCollections
							.observableArrayList(DAO.getCacPhieuChiTheoThang(thang,1));
					tablephieuchi.getItems().setAll(listPhieuChi);
					if (listPhieuChi == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Thông báo");
						alert.setHeaderText("Danh sách dữ liệu app bị trống");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText("Vui lòng chọn tháng");
					alert.showAndWait();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void action_chonkieuxem(ActionEvent event) {
		if (chonkieuxem.getSelectionModel().getSelectedItem().equals("Theo Ngày")) {
			chonngaycombobox.setVisible(true);
			chonthang.setVisible(false);
		} else {
			chonngaycombobox.setVisible(false);
			chonthang.setVisible(true);
		}
	}

	private ObservableList<String> chonkieuxemCombobox() {
		List<String> list = Arrays.asList("Theo Ngày", "Theo Tháng");
		return FXCollections.observableArrayList(list);
	}

	public void loadDataPhieuChi() {
		ObservableList<TablePhieuChi> listPhieuChi = FXCollections.observableArrayList(DAO.getCacPhieuChi(1));
		tablephieuchi.getItems().setAll(listPhieuChi);
		if (listPhieuChi == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText("Danh sách dữ liệu app bị trống");
			alert.showAndWait();
		}
	}

	public void loadDataChiTietChi() {
		tablephieuchi.setOnMouseClicked((event) -> {
			try {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					String index = tablephieuchi.getSelectionModel().getSelectedItem().getMa();
					ObservableList<ChiTietChiTable> listChiTietChi = FXCollections
							.observableArrayList(DAO.getChiTietChi(index));
					tablechitietchi.getItems().setAll(listChiTietChi);
				}
			} catch (Exception e) {
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
			chonkieuxem.setItems(chonkieuxemCombobox());
			chonthang.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}
