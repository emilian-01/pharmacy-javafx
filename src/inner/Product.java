package inner;

import java.io.Serializable;

public abstract class Product implements Serializable {
	private int ID;
	public static int l = 0;
	private String name;
	private String category;
	private String supplier;
	private int quantity;
	private double price;
	private Birthday expDate;

	public Product(String name, String category, String supplier, int quantity, double price, Birthday expDate) {
		ID = l++;
		this.name = name;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
		this.price = price;
		this.expDate = expDate;
	}

	public static int getL() {
		return l;
	}

	public static void setL(int l) {
		Product.l = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Birthday getExpDate() {
		return expDate;
	}

	public void setExpDate(Birthday expDate) {
		this.expDate = expDate;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}
}