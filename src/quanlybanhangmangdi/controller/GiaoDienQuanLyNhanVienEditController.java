package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.model.DanhSachMonTableQuanLyDonHang;
import quanlybanhangmangdi.model.NhanVienDTO;
import quanlybanhangmangdi.model.NhanVienTable;
 
public class GiaoDienQuanLyNhanVienEditController implements Initializable{

	private ObservableList<NhanVienTable> danhSachNhanVien;
	private NhanVienTable nhanVienSelected;
	
	@FXML
    private TextField txt_HoTen;

    @FXML
    private ComboBox<String> cb_ChucVu;

    @FXML
    private ComboBox<String> cb_GioiTinh;

    @FXML
    private DatePicker dp_NgaySinh;

    @FXML
    private TextField txt_DienThoai;

    @FXML
    private TextArea txa_DiaChi;

    @FXML
    private Button btn_Luu;

    @FXML
    private Button btn_Cancel;

    @FXML
    private TextField txt_TaiKhoan;

    @FXML
    private PasswordField txt_MatKhau;
    
    @FXML
    private Label lbl_TaiKhoan;
	
    private NhanVienTable nhanVien1;
	
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public void show() {

	}
	
	
	@FXML
	public void suaNhanVien(ActionEvent event) {
		Integer maNhanVien = nhanVienSelected.getMaNhanVien();
		
		if(!kiemTraThongTin()) return ;
		
		if(luuChinhSuaDatabase()) {
			alertThongBao("Thông báo", "Lưu thành công");
			huy(event);
		} else {
			alertLoi("Lỗi", "Lưu thất bại");
		}
		
	}
	
	
	@FXML
	public boolean luuChinhSuaDatabase() {
		//Cú pháp đưa datepick về dạng date
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String hoTen = txt_HoTen.getText();
		String matKhau = txt_MatKhau.getText();
		boolean gioiTinh = cb_GioiTinh.getSelectionModel().getSelectedItem().equals("Nữ") ? false : true;
		int maChucVu = cb_ChucVu.getSelectionModel().getSelectedItem().equals("Nhân Viên")? 1 : 2;
		java.util.Date ngaySinh =  Date.from(dp_NgaySinh.getValue().atStartOfDay(defaultZoneId).toInstant());
		String dienThoai = txt_DienThoai.getText();
		String diaChi = txa_DiaChi.getText();
		
		
		String sql = "UPDATE NhanVien SET hoten = '" +hoTen+"',"
				+ "matkhau = '" +matKhau+"',"
				+ "machucvu =   "+maChucVu+","
				+ "gioitinh =  "+gioiTinh+","
				+ "ngaysinh =  '"+sdf.format(ngaySinh)+"',"
				+ "dienthoai =  '"+dienThoai+"',"
				+ "diachi = '" +diaChi+"'\n"+ 
				"WHERE ma = " + nhanVienSelected.getMaNhanVien();
		System.out.println(sql);
		boolean result = DataHelper.execAction(sql);
		return result;
	}
	
	public void setThongTin(ObservableList<NhanVienTable> danhSachNhanVien, NhanVienTable nhanVienSelected) {
		this.danhSachNhanVien = danhSachNhanVien;
		this.nhanVienSelected = nhanVienSelected;
		
		txt_HoTen.setText(nhanVienSelected.getTenNhanVien());
		txt_TaiKhoan.setText(nhanVienSelected.getTaiKhoan());
		txt_MatKhau.setText(nhanVienSelected.getMatKhau());
		
		cb_ChucVu.setItems(FXCollections.observableArrayList("Nhân Viên", "Quản Lý"));
		if(nhanVienSelected.getChucVu().equals("Nhân Viên")) {
			cb_ChucVu.getSelectionModel().select(0);
		} else {
			cb_ChucVu.getSelectionModel().select(1);
		}
		
		
		cb_GioiTinh.setItems(FXCollections.observableArrayList("Nam", "Nữ"));
		if(nhanVienSelected.getGioiTinh().equals("Nữ")) cb_GioiTinh.getSelectionModel().select(1);
		else cb_GioiTinh.getSelectionModel().select(0);
		
		
		dp_NgaySinh.setValue(LocalDate.parse(nhanVienSelected.getNgaySinh(),formatter));
		
		txt_DienThoai.setText(nhanVienSelected.getDienThoai());
		txa_DiaChi.setText(nhanVienSelected.getDiaChi());
		
	}
	
	
	
	
	
	public void alertLoi(String title, String header) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	public void alertThongBao(String title, String header) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	public void alertXacNhan(String title, String header) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	
	//Kiểm tra xem thông tin nhập trên form có hợp lệ không
	@FXML
	public boolean kiemTraThongTin() {
		String dienThoai = txt_DienThoai.getText();
		//Nếu những text field cần điền bị trống
		if( txt_HoTen.getText().isEmpty() || txt_TaiKhoan.getText().isEmpty() || txt_MatKhau.getText().isEmpty() || dp_NgaySinh.getValue() == null || txt_DienThoai.getText().isEmpty() || txa_DiaChi.getText().isEmpty())
		{
			alertLoi("Thông báo", "Vui lòng điền đầy đủ thông tin");
			return false;
		} else if (dienThoai.length()!=10){
			// nếu độ dài của số điện thoại khác 10
			alertLoi("Thông báo", "Vui lòng nhập số điện thoại đúng quy định");
			return false;
		}
		return true;
	}
	
	
	//Đóng cửa sổ hiện tại
	@FXML
	private void huy(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
