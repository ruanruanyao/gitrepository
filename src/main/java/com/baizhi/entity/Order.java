package com.baizhi.entity;

import java.util.Date;

public class Order {
	private String id;
	private String order_number;
	private Date create_time;
	private Double total_price;
	private String addr_id;
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Order(String id, String order_number, Date create_time,
			Double total_price, String addr_id, String user_id) {
		this.id = id;
		this.order_number = order_number;
		this.create_time = create_time;
		this.total_price = total_price;
		this.addr_id = addr_id;
		this.user_id = user_id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_number=" + order_number
				+ ", create_time=" + create_time + ", total_price="
				+ total_price + ", addr_id=" + addr_id + ", user_id=" + user_id
				+ "]";
	}
	
}
