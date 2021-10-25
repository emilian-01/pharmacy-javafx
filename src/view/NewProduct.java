package view;

import inner.Birthday;
import inner.Employee;
import inner.MNG;
import inner.PHA;
import inner.ProdChild;
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
import outer.ProductRW;
import outer.UserRW;
import inner.Product;
public class NewProduct {
	private Employee emp;

	

	public void show(Stage st) {
		Label name = new Label("Name: ");
		Label category = new Label("Category: ");
		TextField nameField = new TextField();
		TextField categoryField = new TextField();
		HBox bx1 = new HBox();
		bx1.getChildren().addAll(name, nameField);
		bx1.setSpacing(5);
		bx1.setAlignment(Pos.CENTER);
		HBox bx2 = new HBox();
		bx2.getChildren().addAll(category, categoryField);
		bx2.setSpacing(5);
		bx2.setAlignment(Pos.CENTER);
		HBox bxs = new HBox();
		Label supplier = new Label("Supplier: ");
		TextField supField = new TextField();
		bxs.getChildren().addAll(supplier, supField);
		bxs.setSpacing(5);
		bxs.setAlignment(Pos.CENTER);
		HBox bx3 = new HBox();
		bx3.setSpacing(5);
		bx3.setAlignment(Pos.CENTER);
		Label quantityLabel  = new Label("Quantity");
		TextField quantityField = new TextField();
		bx3.getChildren().addAll(quantityLabel, quantityField);
		Label price = new Label("Price ($): ");
		TextField priceField = new TextField();
		HBox bx4 = new HBox();
		bx4.getChildren().addAll(price, priceField);
		bx4.setSpacing(5);
		bx4.setAlignment(Pos.CENTER);
		DatePicker expDP = new DatePicker();
		Label expDate = new Label("Exp. Date:");
		HBox bx5 = new HBox();
		bx5.getChildren().addAll(expDate, expDP);
		bx5.setSpacing(5);
		bx5.setAlignment(Pos.CENTER);

		Button add = new Button("ADD");
		Button back = new Button("Back");
		HBox bx6 = new HBox();
		bx6.getChildren().addAll(add, back);
		bx6.setSpacing(5);
		bx6.setAlignment(Pos.CENTER);
		VBox vb = new VBox();
		vb.getChildren().addAll(bx1, bx2,bxs, bx3, bx4, bx5, bx6);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("ADD New Product");
		/*** ENDVIEW **/

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try{if (nameField.getText().length()>0 && categoryField.getText().length()>0 && supField.getText().length()>0
						&& quantityField.getText().length()>0 && priceField.getText().length()>0 && 
						expDP.getValue() != null) {
					
					ProductRW prrw = new ProductRW();
					
					prrw.addProd(new ProdChild(nameField.getText(), categoryField.getText(),supField.getText(),
							Integer.parseInt(quantityField.getText()),
							Double.parseDouble(priceField.getText()),
							new Birthday(expDP.getValue().toString().replace("-", "/"))));
					
					(new MNGView(emp)).show(st);
					st.show();
				}
			}catch (NumberFormatException exception) {
	            exception.printStackTrace();
	        } catch (Exception exception) {
	           
	        	exception.printStackTrace();
	        }
	        
				
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				(new MNGView(emp)).show(st);
				st.show();
			}
		});
	}

}
