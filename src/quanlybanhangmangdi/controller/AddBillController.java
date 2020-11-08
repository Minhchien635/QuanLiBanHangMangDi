package quanlybanhangmangdi.controller;

import java.io.IOException; 
import java.net.URL; 
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.main.Test;
import quanlybanhangmangdi.model.ChiTietHoaDon;
import quanlybanhangmangdi.model.DonHang;
import quanlybanhangmangdi.model.MonTrongDanhSach;

public class AddBillController implements Initializable{

	
	
	
	
	ObservableList<MonTrongDanhSach> listMon =  FXCollections.observableArrayList();
	
    @FXML
    private ComboBox<String> chonMon;

    @FXML
    private Button themMonButton;

    @FXML
    private ComboBox<String> nguonDon;

    @FXML
    private ComboBox<String> chonLoaiMon;

    @FXML
    private TextField chietKhau;

    @FXML
    private TextField maDonApp;

    @FXML
    private Label soLuong;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;


    @FXML
    private Button xoaMonButton;

    @FXML
    private Label phiDichVuLabel;

    @FXML
    private Label tongThuLabel;
    
    @FXML
    private Label tongGiaLabel;

    
    @FXML
    private TableView<MonTrongDanhSach> table;

    @FXML
    private TableColumn<MonTrongDanhSach, String> maMon;

    @FXML
    private TableColumn<MonTrongDanhSach, String> tenMon;

    @FXML
    private TableColumn<MonTrongDanhSach, Integer> donGia;

    @FXML
    private TableColumn<MonTrongDanhSach, Integer> soLuongColumn;
    
    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField timeLabel;

    @FXML
    private Label chietKhauLabel;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
    
    
    public void show() throws IOException {
    	
    	
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/AddBill.fxml"));
		Scene scene = new Scene(root,965,760);
		scene.getStylesheets().add(getClass().getResource("../view/AddBillStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
    }
    
    
    //Luu mon vao database
    @FXML
    private void addBill(ActionEvent event) throws ParseException {
    	java.util.Date t = sdf.parse(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/M/yyyy"))+" "+timeLabel.getText());
    	System.out.println(sdf.format(t));
    	String maApp = getMaAppTuTenApp(nguonDon.getValue());
    	
    	// lay ma mon
    	String maDonTrongApp = maDonApp.getText();
    	
    	
    	ArrayList<ChiTietHoaDon> danhSachChiTiet = new ArrayList<ChiTietHoaDon>();
    	for(MonTrongDanhSach mon : listMon) {
    		danhSachChiTiet.add(new ChiTietHoaDon(mon.getMaMon(), mon.getSoLuong()));
    	}
    	
    	int phiDichVu = Integer.parseInt(phiDichVuLabel.getText());
    	int tongGia = Integer.parseInt(tongGiaLabel.getText());
    	int chietKhau = Integer.parseInt(chietKhauLabel.getText());
    	int tongThu = Integer.parseInt(tongThuLabel.getText());
    	
    	DonHang donMoi = new DonHang(Test.nhanVien.getMaNhanVien(), t, maApp, maDonApp.getText(), tongGia, chietKhau, phiDichVu, tongThu, danhSachChiTiet); 
    	
    	if(donMoi.luuDatabase()) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setHeaderText("Thông báo");
    		alert.setContentText("Thêm đơn hàng mới thành công");
    		alert.showAndWait();
    		((Node)event.getSource()).getScene().getWindow().hide();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText("Thông báo");
    		alert.setContentText("Thêm đơn hàng mới thất bại");
    		alert.showAndWait();
    		((Node)event.getSource()).getScene().getWindow().hide();
    	}
    	
    	//new DonHang(Test.nhanVien.getMaNhanVien(),t, 1,maApp, maDonApp, tongGia, chietKhau, phiDichVu, tongThu, danhSachChiTiet)
    }
    
    @FXML
    private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    private String getMaAppTuTenApp(String tenApp)  {
    	String sql = "SELECT ma FROM app\r\n" + 
    			" WHERE ten = " + "\"" + tenApp +"\"";
    	ResultSet rs = DataHelper.execQuery(sql);
    		String maApp = null;
			try {
				while(rs.next()) {
					maApp = rs.getString("ma");
				}
				return maApp;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
    	
    }
    
    

    
    private ObservableList<String> addLoaiMonComboBox() throws SQLException {
    	ArrayList<String> cacLoaiMon = new ArrayList<String>();
    	String sql = "SELECT * FROM LoaiMon";
    	ResultSet rs = DataHelper.execQuery(sql);
    	while(rs.next()) {
    		String tenLoaiMon = rs.getString("ten");
    		cacLoaiMon.add(tenLoaiMon);
    	}
    	
    	return FXCollections.observableArrayList(cacLoaiMon);
    }
    
    
    private ObservableList<String> addMonComboBox() throws SQLException {
    	ArrayList<String> mon = new ArrayList<String>();
    	String sql = "SELECT loaimon.ten, mon.tenmon FROM mon\r\n" + 
    			"JOIN loaimon ON mon.maloaimon = loaimon.ma\r\n" + 
    			"WHERE loaimon.ten = " + "\"" + chonLoaiMon.getValue()+"\"";
    	ResultSet rs = DataHelper.execQuery(sql);
    	
    	while(rs.next()) {
    		String tenMon = rs.getString("tenmon");
    		mon.add(tenMon);
    	}
    	
    	return FXCollections.observableArrayList(mon);
    }
    
    
    //thuc hien khi da chon mon
    @FXML
    private void addMon(ActionEvent event) throws SQLException {
    	chonMon.setItems(addMonComboBox());
    }
    
    
    //lay nguon don trong database
    private ObservableList<String> addNguonDon() throws SQLException {
    	ArrayList<String> nguonDon = new ArrayList<String>();
    	String sql = "SELECT ten FROM App";
    	ResultSet rs = DataHelper.execQuery(sql);
    	
    	while(rs.next()) {
    		String tenApp = rs.getString("ten");
    		nguonDon.add(tenApp);
    	}
    	
    	return FXCollections.observableArrayList(nguonDon);
    }
    
    
    // Setup cac combobox cho form
    private void setup() {
    	try {
			chonLoaiMon.setItems(addLoaiMonComboBox());
			nguonDon.setItems(addNguonDon());
			nguonDon.getSelectionModel().selectFirst();
			initCol(); // tao column cho bang
			setDefaultDateTime(); // lay time
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
	
	// ham tao column khi khoi chay
	private void initCol() {
		maMon.setCellValueFactory(new PropertyValueFactory<MonTrongDanhSach, String>("maMon"));
		tenMon.setCellValueFactory(new PropertyValueFactory<MonTrongDanhSach, String>("tenMon"));
		donGia.setCellValueFactory(new PropertyValueFactory<MonTrongDanhSach, Integer>("donGia"));
		soLuongColumn.setCellValueFactory(new PropertyValueFactory<MonTrongDanhSach, Integer>("soLuong"));
		table.setItems(listMon);
	}
	
	
	
	//bat su kien va tao them mon vao listMon
	@FXML
	private void themMon(ActionEvent event) throws SQLException {
		String mon = chonMon.getValue();
		String sql = "SELECT ma, tenmon,giaban FROM mon\r\n" + 
				"WHERE tenMon = " + "\"" + mon + "\"";
		ResultSet rs = DataHelper.execQuery(sql);
		String maMon = "";
		String tenMon ="";
		Integer donGia = 0;
		while(rs.next()) {
			maMon = rs.getString("ma");
			tenMon = rs.getString("tenmon");
			donGia = rs.getInt("giaban");
			MonTrongDanhSach monMoi = new MonTrongDanhSach(maMon, tenMon, donGia, Integer.parseInt(soLuong.getText()));
			listMon.add(monMoi);
		}
		
		
		thayDoiPhiDichVuVaTongThu();
		
	}
	
	
	@FXML
	private void xoaMon(ActionEvent event) throws SQLException {
		if(table.getSelectionModel().getSelectedIndex()>0)
		
		{
			listMon.removeAll(table.getSelectionModel().getSelectedItem());
			tinhTongGia();
			thayDoiPhiDichVuVaTongThu();
		}
			
		
		
	}
	
	
	// dat thoi gian mat dinh cho label Date
	private void setDefaultDateTime() {
		Calendar cal = Calendar.getInstance();
		datePicker.setValue(LocalDate.now());
		

		LocalTime time = LocalTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		String timeString = time.format(myFormat);
		timeLabel.setText(timeString);
		
		
	}
	
	@FXML
	private void tangSoLuong(ActionEvent event) {
		soLuong.setText((Integer.parseInt(soLuong.getText())+1)+"");
		
	}
	
	
	@FXML
	private void giamSoLuong(ActionEvent event) {
		if(Integer.parseInt(soLuong.getText())<=1) {
			return;
		}
		
		soLuong.setText((Integer.parseInt(soLuong.getText())-1)+"");
	}
	
	
	
	// Hien thi tien khi co thay doi.
	private int tinhTongGia() {
		int tong = 0;
		for(MonTrongDanhSach monTrongDanhSach : listMon) {
			tong += monTrongDanhSach.getDonGia()*monTrongDanhSach.getSoLuong();
		}
		return tong;
	}
	
	private int layPhanTramPhiDichVu() throws SQLException {
		int phiDichVu = 0;
		String nguonDonString = nguonDon.getValue();
		
		String sql = "SELECT * FROM App\r\n" + 
				"WHERE ten = " + "\"" + nguonDonString +"\"" ;
		ResultSet rs = DataHelper.execQuery(sql);
		while(rs.next()) {
			phiDichVu = rs.getInt("phidichvu");
		}
		return phiDichVu;
	}
	
	private int tinhPhiDichVu() throws SQLException {
		
		return (tinhTongGia()*layPhanTramPhiDichVu())/100;
	}
	
	
	@FXML
	private void phiDichVu() throws SQLException {
		phiDichVuLabel.setText(tinhPhiDichVu()+"");
	}
	
	private int lamTronTien(int tien) {
		int le = tien % 1000;
		if (le == 500 || le == 0) {
			return tien;
		}
		if (le > 0 && le < 500) {
			return tien - le + 500;
		}
		
		return tien - le + 1000;
	}
	
	private int tinhTongThu() throws SQLException {
		return lamTronTien(tinhTongGia()*(100-layPhanTramPhiDichVu())/100-tinhChietKhau());
	}
	
	private int tinhChietKhau() {
		return tinhTongGia()*Integer.parseInt(chietKhau.getText())/100;
	}
	
	private void tongThu() throws SQLException {
		tongThuLabel.setText(tinhTongThu()+"");
	}
	
	@FXML
	private void thayDoiPhiDichVuVaTongThu() throws SQLException {
		tongThu();
		phiDichVu();
		chietKhauLabel.setText(tinhChietKhau()+"");
		tongGiaLabel.setText(tinhTongGia()+"");
	}
}