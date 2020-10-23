package quanlybanhangmangdi.ui.giaodienquanly;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class MenuModuleController implements Initializable{
		@FXML private TableView<DonHang> tableDonHang;
		@FXML private TableColumn<DonHang, String> maDon;
		@FXML private TableColumn<DonHang, String> tenApp;
		@FXML private TableColumn<DonHang, Integer> tongMon;
		@FXML private TableColumn<DonHang, Integer> chietKhau;
		@FXML private TableColumn<DonHang, String> ngay;
		@FXML private TableColumn<DonHang, Double> tongGia;
	
		public ObservableList<DonHang> listDonHang = FXCollections.observableArrayList(
				new DonHang("001", "Grab", 3, 40, "14/6/2020", 67.0),
				new DonHang("002", "Go-Viet", 5, 20, "14/6/2020", 12.2),
				new DonHang("003", "Bamin", 7, 0, "14/6/2020", 13.0),
				new DonHang("004", "Now", 9, 0, "14/6/2020", 57.7),
				new DonHang("005", "Grab", 8, 0, "14/6/2020", 53.3),
				new DonHang("006", "Grab", 12, 0, "14/6/2020", 67.5),
				new DonHang("007", "Grab", 1, 0, "14/6/2020", 189.5),
				new DonHang("008", "Baemin", 5, 10, "20/9/2020", 15.0)
				);
		
		
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
    private void handleButtonAction(ActionEvent event) {
		if(event.getSource() == btn_DonHang) {
			pane_DonHang.toFront();
			btn_Title.setText("Quản Lý �?ơn Hàng");
		}
		else if(event.getSource() == btn_Menu) {
			pane_Menu.toFront();
			btn_Title.setText("Quản Lý Menu");
		}
		else if(event.getSource() == btn_AppGiaoHang) {
			pane_AppGiaoHang.toFront();
			btn_Title.setText("Quản Lý Các App");
		}
		else if(event.getSource() == btn_NhanVien) {
			pane_NhanVien.toFront();
			btn_Title.setText("Quản Lý Nhân Viên");
		}
		else if(event.getSource() == btn_ThuChi) {
			pane_ThuChi.toFront();
			btn_Title.setText("Quản Lý Thu Chi");
		}
		else if(event.getSource() == btn_BaoCao) {
			btn_Title.setText("Báo Cáo");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Set table view DonHang
		maDon.setCellValueFactory(new PropertyValueFactory<DonHang, String>("maDon"));
		tenApp.setCellValueFactory(new PropertyValueFactory<DonHang, String>("tenApp"));
		tongMon.setCellValueFactory(new PropertyValueFactory<DonHang, Integer>("tongMon"));
		chietKhau.setCellValueFactory(new PropertyValueFactory<DonHang, Integer>("chietKhau"));
		ngay.setCellValueFactory(new PropertyValueFactory<DonHang, String>("ngay"));
		tongGia.setCellValueFactory(new PropertyValueFactory<DonHang, Double>("tongGia"));
		
		tableDonHang.setItems(listDonHang);
	}


}
