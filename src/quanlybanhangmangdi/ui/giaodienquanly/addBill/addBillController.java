package quanlybanhangmangdi.ui.giaodienquanly.addBill;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import quanlybanhangmangdi.database.connection.jdbc.DataHelper;

public class addBillController implements Initializable{

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
    private TableView<?> listMon;

    @FXML
    private Button xoaMonButton;

    @FXML
    private Label phiDichVu;

    @FXML
    private Label tongGia;

    
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}