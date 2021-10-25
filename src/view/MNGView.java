package view;

import java.util.Date;

import inner.Employee;
import inner.MNG;
import inner.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import outer.Logger;
import outer.ProductRW;

public class MNGView {
	private static final Employee ADMIN = null;
	private MNG emp;

	public MNGView(Employee emp) {
		this.emp = (MNG) emp;
	}

	public void show(Stage st) {
		// Button search=new Button("Search");
		// Button patients=new Button("My Patients");
		// Button register=new Button("Register");
		Button viewProducts = new Button("View Products");
		Button viewPha = new Button("Pharmacists");
		Button stats = new Button("Statistics");
		Button out = new Button("Log Out");
		Button cNP = new Button("New Product");
		out.setMinWidth(120);
		cNP.setMinWidth(120);
		stats.setMinWidth(120);
		viewProducts.setMinWidth(120);
		viewPha.setMinWidth(120);
		VBox vb = new VBox();
		vb.getChildren().addAll(viewProducts,cNP/* , patients,register */, viewPha, stats, out);
		vb.setSpacing(15);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("Manager View");
		st.show();

		/*
		 * register.setOnAction(new EventHandler<ActionEvent>(){
		 * 
		 * @Override public void handle(ActionEvent arg0) { (new
		 * RegisterPatient(emp)).show(st); }view.setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent arg0) {
		 * 
		 * } }); });
		 */
		viewProducts.setOnAction(e->{
			(new ViewProducts()).show(st);
			st.show();
		});
		cNP.setOnAction(e->{
			(new NewProduct()).show(st);
			st.show();
		});
		viewPha.setOnAction(e -> {
			(new ViewPhaforMNG(emp)).showNR(st);
				st.show();
		});
		stats.setOnAction(e->{
			new AlertInfo("The total income for this period of time is: "+SellProduct.income,"Total Income");
		});
		out.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new Logger(emp + " Logged Out: " + (new Date()).toString());
				(new Login()).show(st);
			}

		});
	}

}
