package view;

import java.io.IOException;
import inner.Birthday;
import inner.Employee;
import inner.ADMIN;
import inner.MNG;
import inner.PHA;
import inner.Type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import outer.UserRW;

public class RegisterUser {
	private Employee ADMIN;

	public RegisterUser(Employee admin) {
		ADMIN = admin;
	}

	public void show(Stage st) {
		Label username = new Label("Username: ");
		Label password = new Label("Password: ");
		TextField userField = new TextField();
		TextField passField = new TextField();
		HBox bx1 = new HBox();
		bx1.getChildren().addAll(username, userField);
		bx1.setSpacing(5);
		bx1.setAlignment(Pos.CENTER);
		HBox bx2 = new HBox();
		bx2.getChildren().addAll(password, passField);
		bx2.setSpacing(5);
		bx2.setAlignment(Pos.CENTER);
		ToggleGroup pos = new ToggleGroup();
		RadioButton admin = new RadioButton("ADMIN");
		RadioButton mng = new RadioButton("MNG");
		RadioButton pha = new RadioButton("PHA");
		admin.setToggleGroup(pos);
		mng.setToggleGroup(pos);
		pha.setToggleGroup(pos);
		HBox bx3 = new HBox();
		bx3.getChildren().addAll(admin, mng, pha);
		bx3.setSpacing(5);
		bx3.setAlignment(Pos.CENTER);
		Label emer = new Label("Name: ");
		Label mbiemer = new Label("Surname: ");
		TextField name = new TextField();
		TextField surname = new TextField();
		HBox bx4 = new HBox();
		bx4.getChildren().addAll(emer, name);
		bx4.setSpacing(5);
		bx4.setAlignment(Pos.CENTER);
		HBox bx5 = new HBox();
		bx5.getChildren().addAll(mbiemer, surname);
		bx5.setSpacing(5);
		bx5.setAlignment(Pos.CENTER);
		DatePicker dp = new DatePicker();
		Label date = new Label("Birthday:");
		HBox bx6 = new HBox();
		bx6.getChildren().addAll(date, dp);
		bx6.setSpacing(5);
		bx6.setAlignment(Pos.CENTER);

		Button save = new Button("Save");
		Button back = new Button("Back");
		HBox bx7 = new HBox();
		bx7.getChildren().addAll(save, back);
		bx7.setSpacing(5);
		bx7.setAlignment(Pos.CENTER);
		VBox vb = new VBox();
		vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx5, bx6, bx7);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("Register New Account");
		/*** ENDVIEW **/

		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (userField.getText().length()>0 && passField.getText().length()>0 && name.getText().length()>0
						&& surname.getText().length()>0 && dp.getValue() != null
						&& (admin.isSelected() || mng.isSelected() || pha.isSelected())) {
					UserRW usrw = new UserRW();
					if (admin.isSelected())
						usrw.addEmp(new inner.ADMIN(userField.getText(), passField.getText(), name.getText(),
								surname.getText(), new Birthday(dp.getValue().toString().replace("-", "/"))));
					else if (mng.isSelected())
						usrw.addEmp(new MNG(userField.getText(), passField.getText(), name.getText(), surname.getText(),
								new Birthday(dp.getValue().toString().replace("-", "/"))));
					else
						usrw.addEmp(new PHA(userField.getText(), passField.getText(), name.getText(), surname.getText(),
								new Birthday(dp.getValue().toString().replace("-", "/"))));
					(new ADMINView(ADMIN)).show(st);
					st.show();
				}else {
					new AlertInfo("Please fill every entry data!!");
				}
			} 
		});

		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new ADMINView(ADMIN)).show(st);
				st.show();
			}
		});
	}

}
