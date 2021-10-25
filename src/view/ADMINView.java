package view;

import inner.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ADMINView {
	private Employee ADMIN;

	public ADMINView(Employee admin) {
		ADMIN = admin;
	}

	public void show(Stage st) {
		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
		Menu rec = new Menu("Record");
		Menu hlp = new Menu("Help");
		mb.getMenus().addAll(file, rec, hlp);

		MenuItem rg = new MenuItem("Register");
		/*
		 * Menu edt = new Menu("Edit"); MenuItem edtMNG = new MenuItem("Manager");
		 * MenuItem edtPHA = new MenuItem("Pharmacist"); edt.getItems().addAll(edtMNG,
		 * edtPHA);
		 */
		MenuItem exit = new MenuItem("Exit");
		file.getItems().addAll(rg, /* edt, */ exit);

		MenuItem vDR = new MenuItem("View Managers");
		MenuItem vNR = new MenuItem("View Pharmacists");
		// MenuItem vPT=new MenuItem("View Patients");
		rec.getItems().addAll(vDR, vNR/* ,vPT */);
		MenuItem about = new MenuItem("About");
		hlp.getItems().add(about);

		Button view = new Button("View");
		view.setMinWidth(100);
		Button reg = new Button("Register");
		reg.setMinWidth(100);
		/*
		 * Button edit = new Button("Edit"); edit.setMinWidth(100); Button del = new
		 * Button("Delete"); del.setMinWidth(100);
		 */
		Button out = new Button("LogOut");
		out.setMinWidth(100);
		VBox vb = new VBox();
		vb.getChildren().addAll(view, reg, /*
											 * edit, del,
											 */ out);
		vb.setSpacing(15);
		vb.setAlignment(Pos.CENTER);

		view.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new ViewUsers(ADMIN)).show(st);
				st.show();
			}
		});
		rg.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new RegisterUser(ADMIN)).show(st);
				st.show();
			}
		});
		reg.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				(new RegisterUser(ADMIN)).show(st);
				st.show();
			}

		});
		out.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
		/*
		 * edit.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent arg0) { (new
		 * EditUser(ADMIN)).show(st); st.show(); } });
		 */
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(1);
			}
		});
		vDR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new ViewUsers(ADMIN)).showDR(st);
				st.show();
			}
		});
		vNR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new ViewUsers(ADMIN)).showNR(st);
				st.show();
			}
		});
		about.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new AlertInfo("This app is created by EMILIAN CIKALLESHI ©\n" + "Thank you for using the app!!",
						"About");
			}
		});

		BorderPane bp = new BorderPane();
		bp.setStyle("-fx-background-color: #87CEEB");
		bp.setTop(mb);
		bp.setCenter(vb);
		Scene scene = new Scene(bp, 500, 400);
		st.setScene(scene);
		st.setTitle("ADMIN View");
	}

}
