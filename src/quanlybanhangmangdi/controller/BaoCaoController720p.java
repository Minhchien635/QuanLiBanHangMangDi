package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.model.BaoCaoTable;
import quanlybanhangmangdi.model.ChiTietChiTable;
import quanlybanhangmangdi.model.DonHangDTO;
import quanlybanhangmangdi.model.DonHangTable;
import quanlybanhangmangdi.model.PhieuChi;
import quanlybanhangmangdi.model.TablePhieuChi;

public class BaoCaoController720p extends Application implements Initializable {

	Stage primaryStage1 = new Stage();

	@FXML
	private TableView<BaoCaoTable> tablebaocao;

	@FXML
	private TableColumn<BaoCaoTable, Integer> doanhthu;

	@FXML
	private TableColumn<BaoCaoTable, Integer> chiphi;

	@FXML
	private TableColumn<BaoCaoTable, Integer> loinhuan;

	@FXML
	private ComboBox<Integer> chonthang;

	@FXML
	private DatePicker chonngay;

	@FXML
	private Button xembaocao;

	@FXML
	private PieChart piechart;

	@FXML
	private TextField ngay;

	private int tongchi = 0;

	private int tongthu = 0;

	private int loinhuan1 = 0;

	@FXML
	private Button phantram;

	@FXML
	private Button cot;

	@FXML
	private ComboBox<String> chonkieuxem;

	@FXML
	void action_phantram(ActionEvent event) throws Exception {
		loinhuan1 = 0;
		ngay.setText(null);
		tongchi = 0;
		tongthu = 0;
		if (inPutData() == true) {
			phanTram();
			action_xembaocao(event);
		}
		loinhuan1 = 0;
		tongchi = 0;
		tongthu = 0;
	}

	private boolean inPutData() {
		try {
			if (chonngay.isVisible()) {
				if ((chonkieuxem.getSelectionModel().equals("Theo Ngày") && chonngay.getValue() != null)
						|| chonngay.getValue() != null) {
					ngay.setText(String.valueOf(chonngay.getValue()));
					ObservableList<TablePhieuChi> listPhieuChi = FXCollections
							.observableArrayList(DAO.getCacPhieuChiTheoNgay(chonngay.getValue(), 1));
					listPhieuChi.addAll(
							FXCollections.observableArrayList(DAO.getCacPhieuChiTheoNgay(chonngay.getValue(), 0)));
					if (listPhieuChi != null) {
						for (TablePhieuChi tablePhieuChi2 : listPhieuChi) {
							tongchi = tongchi + tablePhieuChi2.getTonggia();
						}
					}
					ObservableList<DonHangTable> listHoaDon = FXCollections
							.observableArrayList(DAO.getHoaDonTheoNgay(chonngay.getValue(), 1));
					listHoaDon.addAll(FXCollections.observableArrayList(DAO.getHoaDonTheoNgay(chonngay.getValue(), 0)));
					if (listHoaDon != null) {
						for (DonHangTable donHangTable : listHoaDon) {
							tongthu = tongthu + donHangTable.getTongTienThu();
						}
					}
					loinhuan1 = tongthu - tongchi;
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText("Vui lòng chọn ngày");
					alert.showAndWait();
					return false;
				}
			} else {
				if (chonthang.getValue() != null) {
					int thang = chonthang.getValue();
					ngay.setText("Tháng " + Integer.toString(chonthang.getValue()));
					ObservableList<TablePhieuChi> listPhieuChi = FXCollections
							.observableArrayList(DAO.getCacPhieuChiTheoThang(thang, 1));
					listPhieuChi.addAll(FXCollections.observableArrayList(DAO.getCacPhieuChiTheoThang(thang, 0)));
					if (listPhieuChi != null) {
						for (TablePhieuChi tablePhieuChi : listPhieuChi) {
							tongchi = tongchi + tablePhieuChi.getTonggia();
						}
					}
					ObservableList<DonHangTable> listHoaDon = FXCollections
							.observableArrayList(DAO.getHoaDonTheoThang(chonthang.getValue(), 1));
					listHoaDon
							.addAll(FXCollections.observableArrayList(DAO.getHoaDonTheoThang(chonthang.getValue(), 0)));
					if (listHoaDon != null) {
						for (DonHangTable donHangTable : listHoaDon) {
							tongthu = tongthu + donHangTable.getTongTienThu();
						}
					}
					loinhuan1 = tongthu - tongchi;
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText("Vui lòng chọn tháng");
					alert.showAndWait();
					return false;
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@FXML
	void action_xembaocao(ActionEvent event) throws Exception {
		loinhuan1 = 0;
		ngay.setText(null);
		tongchi = 0;
		tongthu = 0;
		if (inPutData() == true) {
			tablebaocao.getItems().clear();
			tablebaocao.getItems().add(new BaoCaoTable(tongthu, tongchi, loinhuan1));
		}
		loinhuan1 = 0;
		tongchi = 0;
		tongthu = 0;
	}

	public void show() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/BaoCaoTheoBieuDoPhanTram.fxml"));
		Scene scene = new Scene(root, 1082, 619);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.showAndWait();
	}

	public void phanTram() throws Exception {

		piechart.setData(getChartData());
		StackPane root = new StackPane();
		root.getChildren().add(piechart);
		Scene scene = new Scene(root, 629, 465);
		primaryStage1.setScene(scene);
		primaryStage1.setTitle("Báo cáo theo biểu đồ phần trăm");
		primaryStage1.showAndWait();

	}

	@FXML
	private void action_chonkieuxem(ActionEvent event) {
		if (chonkieuxem.getSelectionModel().getSelectedItem().equals("Theo Ngày")) {
			chonngay.setVisible(true);
			chonthang.setVisible(false);
		} else {
			chonngay.setVisible(false);
			chonthang.setVisible(true);
		}
	}

	private ObservableList<String> chonkieuxemCombobox() {
		List<String> list = Arrays.asList("Theo Ngày", "Theo Tháng");
		return FXCollections.observableArrayList(list);
	}

	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		list.addAll(new PieChart.Data("Chi phí", (tongchi * 0.1) / (tongchi + tongthu)),
				new PieChart.Data("Doanh thu", (tongthu * 0.1) / (tongchi + tongthu)));
		return list;
	}

	private void initCol() {
		doanhthu.setCellValueFactory(new PropertyValueFactory<BaoCaoTable, Integer>("doanhthu"));
		chiphi.setCellValueFactory(new PropertyValueFactory<BaoCaoTable, Integer>("chiphi"));
		loinhuan.setCellValueFactory(new PropertyValueFactory<BaoCaoTable, Integer>("loinhuan"));
	}

	private void setup() {
		try {
			initCol();
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

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
