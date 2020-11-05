package quanlybanhangmangdi.ui.giaodienquanly.addBill;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import quanlybanhangmangdi.database.connection.jdbc.DataHelper;

public class addBillController implements Initializable{

	
	
	
	
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
    private TextField soLuong;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;


    @FXML
    private Button xoaMonButton;

    @FXML
    private Label phiDichVu;

    @FXML
    private Label tongGia;

    
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
    private void addBill(ActionEvent event) {
    	
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
		
		
	}
	
	
	@FXML
	private void xoaMon(ActionEvent event) {
		listMon.removeAll(table.getSelectionModel().getSelectedItem());
		System.out.println("Hello world");
	}
	
	
	// dat thoi gian mat dinh cho label Date
	private void setDefaultDateTime() {
		Calendar cal = Calendar.getInstance();
		datePicker.setValue(LocalDate.now());
	}
}