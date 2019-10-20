package com.baizhi.entity;

public class OrderItem {
	private String id;
	private Double price;
	private Integer count;
	private Double amount;
	private String book_id;
	private String order_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public OrderItem(String id, Double price, Integer count, Double amount,
			String book_id, String order_id) {
		this.id = id;
		this.price = price;
		this.count = count;
		this.amount = amount;
		this.book_id = book_id;
		this.order_id = order_id;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", price=" + price + ", count=" + count
				+ ", amount=" + amount + ", book_id=" + book_id + ", order_id="
				+ order_id + "]";
	}
}
