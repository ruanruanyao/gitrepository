package com.baizhi.entity;

import java.util.Date;

public class OrderVo {
	private String id;
	private String order_number;
	private Double price;
	private String status;
	private String name;
	private String detail;
	private Date create_time;
	@Override
	public String toString() {
		return "OrderVo [id=" + id + ", order_number=" + order_number
				+ ", price=" + price + ", status=" + status + ", name=" + name
				+ ", detail=" + detail + ", create_time=" + create_time + "]";
	}
	public OrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderVo(String id, String order_number, Double price, String status,
			String name, String detail, Date create_time) {
		this.id = id;
		this.order_number = order_number;
		this.price = price;
		this.status = status;
		this.name = name;
		this.detail = detail;
		this.create_time = create_time;
	}
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}
