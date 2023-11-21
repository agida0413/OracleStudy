package com.sist.dao;

public class ProductVO {
private int product_rank  ;
private double product_grade;
private String product_name ,product_price,p_image,product_sale ,sale_price  ;


public int getProduct_rank() {
	return product_rank;
}
public void setProduct_rank(int product_rank) {
	this.product_rank = product_rank;
}
public double getProduct_grade() {
	return product_grade;
}
public void setProduct_grade(double product_grade) {
	this.product_grade = product_grade;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_price() {
	return product_price;
}
public void setProduct_price(String product_price) {
	this.product_price = product_price;
}
public String getP_image() {
	return p_image;
}
public void setP_image(String p_image) {
	this.p_image = p_image;
}
public String getProduct_sale() {
	return product_sale;
}
public void setProduct_sale(String product_sale) {
	this.product_sale = product_sale;
}
public String getSale_price() {
	return sale_price;
}
public void setSale_price(String sale_price) {
	this.sale_price = sale_price;
}

}