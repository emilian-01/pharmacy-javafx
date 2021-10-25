package view;

import java.util.Date;

import inner.Employee;
import inner.PHA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import outer.Logger;

public class PHAView {
	private PHA emp;

	public PHAView(Employee emp) {
		this.emp = (PHA) emp;
	}

	public void show(Stage st) {
		//Button search = new Button("Search");
		//search.setMinWidth(150);
		Button out = new Button("Log Out");
		out.setMinWidth(150);
		Button bill = new Button("Create new Bill");
		Button viewProducts = new Button("View Products");
		bill.setMinWidth(150);
		viewProducts.setMinWidth(150);
		VBox vb = new VBox();
		vb.getChildren().addAll(viewProducts/*,search, bill*/, out);
		vb.setSpacing(10);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("Pharmacist View");
		st.show();
		
		viewProducts.setOnAction(e->{
			(new ViewProductsforPHA()).show(st);
			st.show();
		});
		/*search.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//(new Search()).show(st);
			}
		});*/
		out.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new Logger(emp + " Logged Out: " + (new Date()).toString());
				(new Login()).show(st);
			}

		});
	}
}
