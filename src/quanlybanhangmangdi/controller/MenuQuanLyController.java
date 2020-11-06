package quanlybanhangmangdi.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuQuanLyController {
	public void show() throws IOException {
		Stage primaryStage = new Stage();
		 
    	Parent root = FXMLLoader.load(getClass().getResource("../view/MenuQuanLy.fxml"));
		Scene scene = new Scene(root,900,630);
		scene.getStylesheets().add(getClass().getResource("../view/MenuQuanLyStyle.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
