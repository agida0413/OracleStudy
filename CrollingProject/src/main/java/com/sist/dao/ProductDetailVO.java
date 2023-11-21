package com.sist.dao;

public class ProductDetailVO {
private int pno,product_stack;
private String product_name, shipment,product_category,product_expire_date;
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public int getProduct_stack() {
	return product_stack;
}
public void setProduct_stack(int product_stack) {
	this.product_stack = product_stack;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getShipment() {
	return shipment;
}
public void setShipment(String shipment) {
	this.shipment = shipment;
}

public String getProduct_category() {
	return product_category;
}
public void setProduct_category(String product_category) {
	this.product_category = product_category;
}
public String getProduct_expire_date() {
	return product_expire_date;
}
public void setProduct_expire_date(String product_expire_date) {
	this.product_expire_date = product_expire_date;
}

}
