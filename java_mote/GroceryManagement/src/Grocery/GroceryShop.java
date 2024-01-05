package Grocery;

import java.time.LocalDate;

public class GroceryShop {
private String Name;
private double pricePerUnit;
private int QtyinStock;
private LocalDate UpdateTime;




public GroceryShop(String name, double pricePerUnit, int qtyinStock, LocalDate updateTime) {
	super();
	Name = name;
	this.pricePerUnit = pricePerUnit;
	QtyinStock = qtyinStock;
	UpdateTime = updateTime;
}



@Override
public String toString() {
	return "GroceryShop [Name=" + Name + ", pricePerUnit=" + pricePerUnit + ", QtyinStock=" + QtyinStock
			+ ", UpdateTime=" + UpdateTime + "]";
}




public String getName() {
	return Name;
}
public double getPricePerUnit() {
	return pricePerUnit;
}
public int getQtyinStock() {
	return QtyinStock;
}
public LocalDate getUpdateTime() {
	return UpdateTime;
}
public void setName(String name) {
	Name = name;
}
public void setPricePerUnit(double pricePerUnit) {
	this.pricePerUnit = pricePerUnit;
}
public void setQtyinStock(int qtyinStock) {
	QtyinStock = qtyinStock;
}
public void setUpdateTime(LocalDate updateTime) {
	UpdateTime = updateTime;
}

}
