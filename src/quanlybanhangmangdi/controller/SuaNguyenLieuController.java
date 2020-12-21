package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quanlybanhangmangdi.database.DAO;
import quanlybanhangmangdi.model.NguyenLieu;

public class SuaNguyenLieuController implements Initializable {

	@FXML
	private TextField tennguyenlieu;

	@FXML
	private Button luunguyenlieu;

	@FXML
	private TextField gia;

	@FXML
	private TextField soluong;

	private String manl;

	public boolean IsNumber(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	@FXML
	void action_luunguyenlieu(ActionEvent event) {
		if (!tennguyenlieu.getText().isEmpty() && !gia.getText().isEmpty() && !soluong.getText().isEmpty()) {
			if (IsNumber(gia.getText()) == false) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Thông báo");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng nhập Giá là Số");
				alert.showAndWait();
			}
			if (IsNumber(soluong.getText()) == false) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Thông báo");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng nhập Số Lượng là Số");
				alert.showAndWait();
			}
			if (IsNumber(gia.getText()) && IsNumber(soluong.getText())) {
				String tennl = tennguyenlieu.getText();
				int gianl = Integer.parseInt(gia.getText());
				int soluongnl = Integer.parseInt(soluong.getText());

				NguyenLieu nl = new NguyenLieu(manl, tennl, gianl, soluongnl);
				if (DAO.suaNguyeLieu(nl)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Đã sửa");
					alert.showAndWait();
					((Node) event.getSource()).getScene().getWindow().hide();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Sửa thất bại");
					alert.showAndWait();
				}
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng cung cấp đầy đủ thông tin nguyên liệu");
			alert.showAndWait();
		}
	}

	public void loadNguyenLieu(NguyenLieu nguyenlieu) {
		manl = nguyenlieu.getMa();
		tennguyenlieu.setText(nguyenlieu.getTen());
		gia.setText(String.valueOf(nguyenlieu.getGia()));
		soluong.setText(String.valueOf(nguyenlieu.getSoluong()));
	}

	public void show(NguyenLieu nl) throws IOException {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("../view/SuaNguyenLieu.fxml").openStream());
			;
			SuaNguyenLieuController snl = (SuaNguyenLieuController) loader.getController();
			snl.loadNguyenLieu(nl);
			Scene scene = new Scene(root, 534, 294);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void setup() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}
