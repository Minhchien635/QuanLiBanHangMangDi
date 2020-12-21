package quanlybanhangmangdi.controller;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietChi;

import quanlybanhangmangdi.model.NguyenLieu;
import quanlybanhangmangdi.model.NguyenLieuTable;
import quanlybanhangmangdi.model.PhieuChi;

public class ThemPhieuChiController implements Initializable {

	ObservableList<NguyenLieuTable> listNguyenlieu = FXCollections.observableArrayList();

	ObservableList<NguyenLieu> listTenNguyenLieu = FXCollections.observableArrayList();

	@FXML
	private ComboBox<Integer> soluong;

	@FXML
	private ComboBox<NguyenLieu> tennguyenlieu;

	@FXML
	private DatePicker ngaychi;

	@FXML
	private TableView<NguyenLieuTable> tablenguyenlieu;

	@FXML
	private TableColumn<NguyenLieuTable, String> tennl;

	@FXML
	private TableColumn<NguyenLieuTable, Integer> gianl;

	@FXML
	private TableColumn<NguyenLieuTable, Integer> soluongnl;

	@FXML
	private TableColumn<NguyenLieuTable, Integer> tongtiennl;

	@FXML
	private Button themnguyenlieu;

	@FXML
	private TextField thoigian;

	@FXML
	private Button taophieuchi;

	@FXML
	private Button quanlynguyenlieu;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@FXML
	void action_quanlynguyenlieu(ActionEvent event) {
		QuanLyNguyenLieuController qlnl = new QuanLyNguyenLieuController();
		try {
			qlnl.show();
			listNguyenlieu.clear();
			tablenguyenlieu.getItems().setAll(listNguyenlieu);
			setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void action_taophieuchi(ActionEvent event) throws ParseException, SQLException {
		java.util.Date t = sdf
				.parse(ngaychi.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + thoigian.getText());
		int tongtiennl = 0;
		ArrayList<ChiTietChi> e = new ArrayList<ChiTietChi>();
		for (NguyenLieuTable nguyenLieuTable : listNguyenlieu) {
			tongtiennl = nguyenLieuTable.getTongtien() + tongtiennl;
		}
		if (listNguyenlieu.isEmpty() == false) {
			PhieuChi pc = new PhieuChi(1/* Test.nhanVien.getMaNhanVien() */, t, tongtiennl, listNguyenlieu);
			if (DAO.luuDatabase(pc)) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Thông báo");
				alert.setHeaderText(null);
				alert.setContentText("Thêm đơn hàng mới thành công");
				alert.showAndWait();
				((Node) event.getSource()).getScene().getWindow().hide();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Thêm đơn hàng mới thất bại");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng chọn ' Thêm nguyên liệu '");
			alert.showAndWait();
		}
	}

	@FXML
	private void action_themnguyenlieu(ActionEvent event) {

		if (tennguyenlieu.getSelectionModel().isEmpty() == false && soluong.getSelectionModel().isEmpty() == false) {
			String manl = tennguyenlieu.getSelectionModel().getSelectedItem().getMa();
			String tennl = tennguyenlieu.getSelectionModel().getSelectedItem().getTen();
			int gianl = tennguyenlieu.getSelectionModel().getSelectedItem().getGia();
			int soluongnl = soluong.getSelectionModel().getSelectedItem();
			int tongtiennl = tennguyenlieu.getSelectionModel().getSelectedItem().getGia() * soluongnl;
			if (listNguyenlieu.isEmpty() == false) {
				int i = 0;
				for (NguyenLieuTable nguyenLieuTable : listNguyenlieu) {
					if (tennl.equals(nguyenLieuTable.getTen())) {
						nguyenLieuTable.setSoluong(soluongnl + nguyenLieuTable.getSoluong());
						nguyenLieuTable.setTongtien(tongtiennl + nguyenLieuTable.getTongtien());
						i = 1;
					}
				}
				if (i == 0) {
					NguyenLieuTable nl = new NguyenLieuTable(manl, tennl, gianl, soluongnl, tongtiennl);
					listNguyenlieu.add(nl);
				}
			} else {
				NguyenLieuTable nl = new NguyenLieuTable(manl, tennl, gianl, soluongnl, tongtiennl);
				listNguyenlieu.add(nl);
			}
			tablenguyenlieu.getItems().setAll(listNguyenlieu);
			reloadTenNguyenLieu();
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng chọn nguyên liệu và số lượng");
			alert.showAndWait();
		}
	}

	private void initCol() {
		tennl.setCellValueFactory(new PropertyValueFactory<NguyenLieuTable, String>("ten"));
		gianl.setCellValueFactory(new PropertyValueFactory<NguyenLieuTable, Integer>("gia"));
		soluongnl.setCellValueFactory(new PropertyValueFactory<NguyenLieuTable, Integer>("soluong"));
		tongtiennl.setCellValueFactory(new PropertyValueFactory<NguyenLieuTable, Integer>("tongtien"));
	}

	private void reloadTenNguyenLieu() {
		if (tennguyenlieu.getSelectionModel().isEmpty() == false && soluong.getSelectionModel().isEmpty() == false) {
			if (listNguyenlieu.isEmpty() == false) {
				int sl = tennguyenlieu.getSelectionModel().getSelectedItem().getSoluong()
						- soluong.getValue().intValue();
				tennguyenlieu.getSelectionModel().getSelectedItem().setSoluong(sl);
				tennguyenlieu.getSelectionModel().clearSelection();
				soluong.getSelectionModel().clearSelection();
			}
		}
	}

	private void chonTenNguyenLieuCombobox() {
		ObservableList<NguyenLieu> list = FXCollections.observableArrayList(DAO.getTenNguyenLieu(1));
		tennguyenlieu.setVisibleRowCount(6);
		tennguyenlieu.setItems(list);
		listTenNguyenLieu = list;
	}

	private void chonSoLuongCombobox() {
		try {
			tennguyenlieu.valueProperty().addListener(new ChangeListener<NguyenLieu>() {
				@Override
				public void changed(ObservableValue ov, NguyenLieu t, NguyenLieu t1) {
					if (tennguyenlieu.getSelectionModel().isEmpty() == false) {
						int sl = tennguyenlieu.getSelectionModel().getSelectedItem().getSoluong();
						List<Integer> ds = new ArrayList<>();
						int i = 1;
						while (i <= sl) {
							ds.add(i);
							i++;
						}
						soluong.setVisibleRowCount(5);
						soluong.setItems(FXCollections.observableArrayList(ds));
					} else {
						return;
					}
				}
			});
		} catch (Exception e) {
			return;
		}

	}

	private void setDefaultDateTime() {
		ngaychi.setValue(LocalDate.now());

		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			LocalTime currentTime = LocalTime.now();
			thoigian.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	public void show() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ThemPhieuChi.fxml"));
		Scene scene = new Scene(root, 755, 551);
		scene.getStylesheets().add(getClass().getResource("../view/ThemPhieuChiStyle.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.showAndWait();
	}

	private void setup() {
		try {
			initCol();
			chonTenNguyenLieuCombobox();
			chonSoLuongCombobox();
			setDefaultDateTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}
