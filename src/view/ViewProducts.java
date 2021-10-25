package view;

import java.util.ArrayList;

import inner.Product;
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
import outer.ProductRW;
import inner.Product;

public class ViewProducts {
	//private Product prod;
	private int type = 0;
	private Employee emp;
	public ViewProducts() {
		
	}
	
	public void show(Stage st) {
		TableView table = new TableView();
		ProductRW rw = new ProductRW();
		VBox vb = new VBox();
		table.setEditable(true);
		TableColumn tc1 = new TableColumn("Name");
		tc1.setMinWidth(100);
		tc1.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn tc2 = new TableColumn("Category");
		tc2.setMinWidth(100);
		tc2.setCellValueFactory(new PropertyValueFactory<>("category"));
		TableColumn tc3 = new TableColumn("Supplier");
		tc3.setMinWidth(100);
		tc3.setCellValueFactory(new PropertyValueFactory<>("supplier"));
		TableColumn tc4 = new TableColumn("Quantity");
		tc4.setMinWidth(100);
		tc4.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		TableColumn tc5 = new TableColumn("Price");
		tc5.setMinWidth(100);
		tc5.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn tc6 = new TableColumn("Exp. Date");
		tc6.setMinWidth(100);
		tc6.setCellValueFactory(new PropertyValueFactory<>("expDate"));

		ArrayList<Product> tc = new ArrayList<Product>();
		for (Product x : rw.readProd()) {
			tc.add(x);
		}
		table.setItems(FXCollections.observableArrayList(tc));
		table.getColumns().addAll(tc1, tc2, tc3, tc4, tc5, tc6);

		HBox hb = new HBox();
		Button add = new Button("Add Product");
		Button edit = new Button("Edit Product");
		Button del = new Button("Delete Product");
		Button back = new Button("Back");
		hb.getChildren().addAll(add, edit, del, back);
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(table, hb);

		add.setOnAction(e -> {
			(new NewProduct()).show(st);
			st.show();
		});

		edit.setOnAction(e->{
			
				for (Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Product)
						(new EditProduct(((Product) x).getName(), ((Product) x).getCategory(),
								((Product) x).getSupplier(), ((Product) x).getQuantity(),
								((Product) x).getPrice(), ((Product) x).getExpDate())).show(st);
				}	
				
				for (Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Product)
						rw.remove((Product) x);
				}
			}
		);

		del.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				for (Object x : table.getSelectionModel().getSelectedItems()) {
					if (x instanceof Product)
						rw.remove((Product) x);
				}
				new ViewProducts().show(st);
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
		st.setTitle("Products Table");
		st.show();
	}
}