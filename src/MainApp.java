import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.Login;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st) throws Exception {
		(new Login()).show(st);
		st.show();
		st.getIcons().add(new Image("images/logo.png"));
		/*
		 * st.setOnCloseRequest(new EventHandler<WindowEvent>() { public void
		 * handle(WindowEvent we) { Alert alert = new Alert(AlertType.CONFIRMATION);
		 * alert.setTitle("Confirm Exit"); alert.setHeaderText("Do you want to exit?\n"
		 * + "You can also log out if you wish!"); ButtonType yes = new
		 * ButtonType("Yes"); ButtonType logout = new ButtonType("Log Out"); ButtonType
		 * no = new ButtonType("No", ButtonData.CANCEL_CLOSE);
		 * alert.getButtonTypes().clear(); alert.getButtonTypes().addAll(yes, logout,
		 * no); Optional<ButtonType> select = alert.showAndWait(); if (select.get() ==
		 * logout) { new Logger("User Logged Out: " + (new Date()).toString()); (new
		 * Login()).show(st); // st.show(); we.consume(); } else if (select.get() ==
		 * yes) { new Logger("Stage is closing: " + (new Date()).toString()); } else {
		 * we.consume();// Window not Closing } } });
		 */
	}
}