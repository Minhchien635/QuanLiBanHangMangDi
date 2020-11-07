import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import quanlybanhangmangdi.controller.AddBillController;
import quanlybanhangmangdi.controller.EditBillController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyController;
import quanlybanhangmangdi.controller.LoginController;
import quanlybanhangmangdi.controller.MenuQuanLyController;

public class Test extends Application{
	public static void main(String[] args) throws IOException {
		launch(args);
	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		showGiaoDienQuanLy();
	}
	
	private void showLogin() throws IOException {
		LoginController login = new LoginController();
		login.show();
	}
	
	private void showMenuQuanLy() throws IOException {
		MenuQuanLyController menuQuanLyController = new MenuQuanLyController();
		menuQuanLyController.show();
	}
	
	private void showGiaoDienQuanLy() throws IOException {
		GiaoDienQuanLyController giaoDienQuanLy = new GiaoDienQuanLyController();
		giaoDienQuanLy.show();
	}
	
	private void showAddBill() throws IOException {
		AddBillController addBill = new AddBillController();
		addBill.show();
	}
	
	private void showEditBill() throws IOException {
		EditBillController editBill = new EditBillController();
		editBill.show();
	}
}
