import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import quanlybanhangmangdi.controller.AddBillController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyController;
import quanlybanhangmangdi.controller.LoginController;
import quanlybanhangmangdi.controller.MenuQuanLyController;

public class Test extends Application{
	public static void main(String[] args) throws IOException {
		launch(args);
	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginController login = new LoginController();
		login.show();
	}
}
