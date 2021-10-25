package view;

import java.util.ArrayList;

import inner.Employee;
import inner.PHA;
import inner.Type;
import inner.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import outer.UserRW;

public class ViewPhaforMNG {
	protected static final Employee emp = null;
	private Employee ADMIN;
	private int type = 0;

	public ViewPhaforMNG(Employee admin) {
		ADMIN = admin;
	}

	public void showDR(Stage st) {
		type = 1;
		show(st);
	}

	public void showNR(Stage st) {
		type = 2;
		show(st);
	}

	public void show(Stage st) {
		// ArrayList<Text> txt=new ArrayList<Text>();
		TableView table = new TableView();
		UserRW rw = new UserRW();
		VBox vb = new VBox();
		table.setEditable(true);
		TableColumn us = new TableColumn("Username");
		us.setMinWidth(100);
		us.setCellValueFactory(new PropertyValueFactory<>("username"));
		TableColumn nm = new TableColumn("Name");
		nm.setMinWidth(100);
		nm.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn snm = new TableColumn("Surname");
		snm.setMinWidth(100);
		snm.setCellValueFactory(new PropertyValueFactory<>("surname"));
		TableColumn bdy = new TableColumn("Birthday");
		bdy.setMinWidth(100);
		bdy.setCellValueFactory(new PropertyValueFactory<>("bdt"));
		ArrayList<User> bosh = new ArrayList<User>();
		for (Employee x : rw.readEmp()) {
			if (type == 0)
				bosh.add(x);
			else if (type == 1) {
				if (x.getType() == Type.MNG) {
					bosh.add(x);
				}
			} else if (type == 2) {
				if (x instanceof PHA) {
					bosh.add(x);
				}
			}
		}
		table.setItems(FXCollections.observableArrayList(bosh));
		table.getColumns().addAll(us, nm, snm, bdy);

		HBox hb = new HBox();
		Button add = new Button("View Stats");
		Button edit = new Button("Edit User");
		Button del = new Button("Delete User");
		Button back = new Button("Back");
		hb.getChildren().addAll(add, /*edit, del,*/ back);
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(table, hb);

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new AlertInfo("Not Available to Manager");
				//st.show();
			}
		});
		edit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				new AlertInfo("Not Available to Manager");
				/*for(Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Employee)
							(new EditUser(((Employee) x).getUsername(),
								((Employee) x).getPassword(), ((Employee) x).getName(),
								((Employee) x).getSurname(), ((Employee) x).getBdt(),
								((Employee) x).getType())).show(st);
				}
				for (Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Employee)
						rw.remove((Employee) x);
				}*/
			}
		});
		del.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				new AlertInfo("Not Available to Manager");
				/*for (Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Employee)
						rw.remove((Employee) x);
					if (type == 0)
						new ViewUsers(ADMIN).show(st);
					else if (type == 1)
						new ViewUsers(ADMIN).show(st);
					else if (type == 2)
						new ViewUsers(ADMIN).show(st);
				}*/
				
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new MNGView(emp)).show(st);
				st.show();
			}
		});
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("Users Table");
		st.show();
	}
}