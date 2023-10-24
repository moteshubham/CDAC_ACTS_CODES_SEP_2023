package core.com.app;

import java.time.LocalDate;

import enums.InkColor;

/*1. Add new Pen
2. Update stock of aPen
3.Set discount of 20% for all the pens which are not at all sold in last 3 months
4. Remove Pens which are never sold once listed in 9 months

You can define a class Pen with the following fields – 
a.	ID (unique identifier for each Pen, should be generated automatically)
b.	Brand (Example:  Cello, Parker, Reynolds etc.)
c.	Color
d.	InkColor
e.	Material (Example: Plastic, Alloy Steel, Metal etc.)
f.	Stock (Available quantity)
g.	Stock Update Date (it changed every time when admin update stock or user order executed)
h.	Stock Listing Date (date on which product is added to site for sale)
i.	Price (in INR) 
j.	Discounts (in percentage)
*/
public class Pen {
	private static int penIDCounter;
	private int penID;
	private String brand;
	private String color;
	private InkColor inkColor;
	private String material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private int price;
	private double discount;
	
		static {
		penIDCounter = 1000;
	}

		public Pen(String brand, String color, InkColor inkColor, String material, int stock, LocalDate stockUpdateDate,
				LocalDate stockListingDate, int price) {
			super();
			this.brand = brand;
			this.color = color;
			this.inkColor = inkColor;
			this.material = material;
			this.stock = stock;
			this.stockUpdateDate = stockUpdateDate;
			this.stockListingDate = stockListingDate;
			this.price = price;
			this.discount = 0;
			this.penID = ++penIDCounter;
		}

		@Override
		public String toString() {
			return "Pen [penID="+penID+", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material=" + material
					+ ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate="
					+ stockListingDate + ", price=" + price + ", discount=" + discount + "]";
		}

		public  int getPenID() {
			return penID;
		}

		public  void setPenID(int penID) {
			this.penID = penID;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public InkColor getInkColor() {
			return inkColor;
		}

		public void setInkColor(InkColor inkColor) {
			this.inkColor = inkColor;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public LocalDate getStockUpdateDate() {
			return stockUpdateDate;
		}

		public void setStockUpdateDate(LocalDate stockUpdateDate) {
			this.stockUpdateDate = stockUpdateDate;
		}

		public LocalDate getStockListingDate() {
			return stockListingDate;
		}

		public void setStockListingDate(LocalDate stockListingDate) {
			this.stockListingDate = stockListingDate;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}
	
		
}
