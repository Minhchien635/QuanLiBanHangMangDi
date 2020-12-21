package quanlybanhangmangdi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

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

public class TaoNguyenLieuController implements Initializable {
	@FXML
	private Button taonguyenlieu;

	@FXML
	private TextField tennguyenlieu;

	@FXML
	private TextField gia;

	@FXML
	private TextField soluong;

	public boolean IsNumber(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	@FXML
	private void action_taonguyenlieu(ActionEvent event) {
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

				NguyenLieu nl = new NguyenLieu(tennl, gianl, soluongnl);
				if (DAO.luuNguyenLieu(nl)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Tạo thành công");
					alert.showAndWait();
					((Node) event.getSource()).getScene().getWindow().hide();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Tạo thất bại");
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

	public void show() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/TaoNguyenLieu.fxml"));
		Scene scene = new Scene(root, 534, 294);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.showAndWait();
	}

	private void setup() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setup();
	}
}
