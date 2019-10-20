package com.baizhi.entity;

import java.util.Collection;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> items;
	private Double cart_price;
	private Double ddcart_price;
	
	@Override
	public String toString() {
		return "Cart [items=" + items + ", cart_price=" + cart_price
				+ ", ddcart_price=" + ddcart_price + "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Map<String, CartItem> items, Double cart_price,
			Double ddcart_price) {
		this.items = items;
		this.cart_price = cart_price;
		this.ddcart_price = ddcart_price;
	}
	public Map<String, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<String, CartItem> items) {
		this.items = items;
	}
	public Double getCart_price() {
		return cart_price;
	}
	public void setCart_price(Double cart_price) {
		this.cart_price = cart_price;
	}
	public Double getDdcart_price() {
		return ddcart_price;
	}
	public void setDdcart_price(Double ddcart_price) {
		this.ddcart_price = ddcart_price;
	}
	// 计算购物车总价|总当当价
	public void getAllPrice(){
		Collection<CartItem> values = items.values();
		Double price = 0.0;
		Double dd_price = 0.0;
		for (CartItem item : values) {
			price += item.getPrice()*item.getCount();
			dd_price += item.getDd_price()*item.getCount();
		}
		this.cart_price = price;
		this.ddcart_price = dd_price;
	}
}
