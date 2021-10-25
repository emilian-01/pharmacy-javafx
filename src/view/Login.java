package view;

import java.util.Date;

import inner.Employee;
import inner.Type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import outer.Logger;
import outer.UserRW;

public class Login {

	public void show(Stage st) {
		GridPane gPane = new GridPane();
		VBox vBox = new VBox();
		Label usernameLabel = new Label("Username");
		usernameLabel.setTextFill(Color.WHITE);
		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("Usermane");
		usernameTextField.setMaxWidth(150);
		Label passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		passwordField.setMaxWidth(150);
		Button loginButton = new Button("Login");
		loginButton.setMaxWidth(150);
		vBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton);
		vBox.setSpacing(10);
		gPane.setAlignment(Pos.CENTER);
		gPane.getChildren().addAll(vBox);
		gPane.setStyle("-fx-background-image: url('images/bGround.jpg'); -fx-background-size: 100% 100%;");
		Scene sc = new Scene(gPane, 500, 400);
		st.setTitle("Login");
		st.setScene(sc);

		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				UserRW us = new UserRW();
				if (usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {
					new AlertInfo("Please enter your username and password!");
				} else {
					Employee emp = us.checkUser(usernameTextField.getText(), passwordField.getText());
					if (emp == null) {
						new AlertInfo("Username or Password you have entered\ndoesn't match any account!");
					} else {
						new Logger(emp + " logged in the system at " + (new Date()).toString());
						if (emp.getType().equals(Type.ADMIN)) {
							(new ADMINView(emp)).show(st);
						} else if (emp.getType().equals(Type.MNG)) {
							(new MNGView(emp)).show(st);
						} else if (emp.getType().equals(Type.PHA)) {
							(new PHAView(emp)).show(st);
						}
					}
				}
			}
		});
	}
}