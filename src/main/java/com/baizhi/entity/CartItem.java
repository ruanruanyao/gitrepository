package com.baizhi.entity;

public class CartItem {
	private String id; //购物项唯一标识
	private String book_id;
	private String book_name;
	private Integer count;
	private Double price;
	private Double dd_price;
	private Double allprice;
	private Double alldd_price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDd_price() {
		return dd_price;
	}
	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Double getAlldd_price() {
		return alldd_price;
	}
	public void setAlldd_price(Double alldd_price) {
		this.alldd_price = alldd_price;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", book_id=" + book_id + ", book_name="
				+ book_name + ", count=" + count + ", price=" + price
				+ ", dd_price=" + dd_price + ", allprice=" + allprice
				+ ", alldd_price=" + alldd_price + "]";
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(String id, String book_id, String book_name, Integer count,
			Double price, Double dd_price, Double allprice, Double alldd_price) {
		this.id = id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.count = count;
		this.price = price;
		this.dd_price = dd_price;
		this.allprice = allprice;
		this.alldd_price = alldd_price;
	}
}
