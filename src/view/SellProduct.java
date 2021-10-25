package view;

import java.util.Date;

import inner.Birthday;
import inner.Employee;
import inner.ProdChild;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import outer.Bills;
import outer.ProductRW;

public class SellProduct {
	private Employee emp;
	public static double income = 0;
	private String name;
	private String category;
	private String supplier;
	private int quantity;
	private double price;
	private Birthday expDate;
	String a;

	public SellProduct(String name, String category, String supplier, int quantity, double price, Birthday expDate) {
		// System.out.println(name+category+supplier+quantity+price+expDate);
		this.name = name;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
		this.price = price;
		this.expDate = expDate;
	}

	public void show(Stage st) {
		Label nameLabel = new Label("Name: ");
		Label categoryLabel = new Label("Category: ");
		Label nameField = new Label(this.name);
		// TextField nameField = new TextField();
		// nameField.setText();
		Label categoryField = new Label(this.category);
		// categoryField.setText();
		HBox bx1 = new HBox();
		bx1.getChildren().addAll(nameLabel, nameField);
		bx1.setSpacing(5);
		bx1.setAlignment(Pos.CENTER);
		HBox bx2 = new HBox();
		bx2.getChildren().addAll(categoryLabel, categoryField);
		bx2.setSpacing(5);
		bx2.setAlignment(Pos.CENTER);
		HBox bxs = new HBox();
		Label supplierl = new Label("Supplier: ");
		Label supField = new Label(this.supplier);
		// supField.setText();
		bxs.getChildren().addAll(supplierl, supField);
		bxs.setSpacing(5);
		bxs.setAlignment(Pos.CENTER);
		HBox bx3 = new HBox();
		bx3.setSpacing(5);
		bx3.setAlignment(Pos.CENTER);
		Label quantityLabel = new Label("Quantity");
		TextField quantityField = new TextField();
		quantityField.setPromptText(Integer.toString(this.quantity));
		quantityField.setMaxWidth(50);
		bx3.getChildren().addAll(quantityLabel, quantityField);
		Label pricel = new Label("Price per each($): ");
		Label priceField = new Label(String.valueOf(this.price));
		HBox bx4 = new HBox();
		// priceField.setText(Double.toString(this.price));
		bx4.getChildren().addAll(pricel, priceField);
		bx4.setSpacing(5);
		bx4.setAlignment(Pos.CENTER);
		Label expDP = new Label("12/4/2019");
		Label sellDate = new Label("Sell Date:");
		HBox bx5 = new HBox();
		// expDP.setPromptText("");
		bx5.getChildren().addAll(sellDate, expDP);
		bx5.setSpacing(5);
		bx5.setAlignment(Pos.CENTER);

		Button sell = new Button("SELL");
		Button back = new Button("Back");
		HBox bx6 = new HBox();
		bx6.getChildren().addAll(sell, back);
		bx6.setSpacing(5);
		bx6.setAlignment(Pos.CENTER);
		VBox vb = new VBox();
		vb.getChildren().addAll(bx1, bx2, bxs, bx3, bx4, bx5, bx6);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #87CEEB");
		Scene sc = new Scene(vb, 500, 400);
		st.setScene(sc);
		st.setTitle("Sell Product");
		/*** ENDVIEW **/

		sell.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if ((Integer.parseInt(quantityField.getText()))<=quantity) {
				ProductRW prrw = new ProductRW();
				prrw.addProd(new ProdChild(name, category, supplier,
						(quantity - (Integer.parseInt(quantityField.getText()))), price,
						new Birthday(expDate.toString().replace("-", "/"))));
				a = "bill"+(new Date()).getTime()+"\n\nPharmacy\nName : " + name + "\nPrice : " + price + " x " + (Integer.parseInt(quantityField.getText()))
						+ "\nDate : " + (new Date()).toString() + "\nTotal price : "
						+ (Integer.parseInt(quantityField.getText())) * price;
				income += (Integer.parseInt(quantityField.getText())) *price;
				new Bills(a);
				(new PHAView(emp)).show(st);
				st.show();
			} else {
				new AlertInfo("There are no enough from this medicine!");
			}}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ProductRW prrw = new ProductRW();
				prrw.addProd(new ProdChild(name, category, supplier,
						quantity , price,
						new Birthday(expDate.toString().replace("-", "/"))));
				(new ViewProducts()).show(st);
			}
		});
	}
}