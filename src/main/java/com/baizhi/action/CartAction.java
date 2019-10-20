package com.baizhi.action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;

public class CartAction {
	private String id;
	private Integer count;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String addCart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		BookService bookService = new BookServiceImpl();
		if (cart==null) {
			cart = new Cart();
			Book showBookById = bookService.showBookById(id);
			CartItem cartItem = new CartItem(UUID.randomUUID().toString(),showBookById.getId(),showBookById.getBook_name(),1,showBookById.getPrice(),showBookById.getDd_price(),showBookById.getPrice(),showBookById.getDd_price());
			HashMap<String, CartItem> map = new HashMap<String, CartItem>();
			map.put(showBookById.getId(), cartItem);
			cart.setItems(map);
			cart.getAllPrice();
		}else{
			Map<String, CartItem> items = cart.getItems();
			CartItem cartItem = items.get(id);
			if (cartItem==null) {
				Book showBookById = bookService.showBookById(id);
				cartItem = new CartItem(UUID.randomUUID().toString(),showBookById.getId(),showBookById.getBook_name(),1,showBookById.getPrice(),showBookById.getDd_price(),showBookById.getPrice(),showBookById.getDd_price());
				items.put(showBookById.getId(), cartItem);
				cart.getAllPrice();
			}else{
				cartItem.setCount(cartItem.getCount()+1);
				cartItem.setAllprice(cartItem.getAllprice()+cartItem.getPrice());
				cartItem.setAlldd_price(cartItem.getAlldd_price()+cartItem.getDd_price());
				cart.getAllPrice();
			}
		}
		session.setAttribute("cart", cart);
		return "toCart";
	}
	public String updateCart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Map<String, CartItem> items = cart.getItems();
		CartItem cartItem = items.get(id);
		cartItem.setCount(count);
		cartItem.setAllprice(cartItem.getPrice()*count);
		cartItem.setAlldd_price(cartItem.getDd_price()*count);
		cart.getAllPrice();
		session.setAttribute("cart", cart);
		return "toCart";
	}
	public String deleteCart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Cart delcart = (Cart) session.getAttribute("delcart");
		Map<String, CartItem> items = cart.getItems();
		CartItem cartItem = items.get(id);
		if (delcart==null) {
			delcart = new Cart();
			HashMap<String,CartItem> map = new HashMap<String,CartItem>();
			map.put(id, cartItem);
			delcart.setItems(map);
			items.remove(id);
			cart.getAllPrice();
		}else{
			Map<String, CartItem> delitems = delcart.getItems();
			delitems.put(id, cartItem);
			items.remove(id);
			cart.getAllPrice();
		}
		session.setAttribute("cart", cart);
		session.setAttribute("delcart", delcart);
		return "toCart";
	}
	/*public String recover(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Cart delcart = (Cart) session.getAttribute("delcart");
		Map<String, CartItem> delitems = delcart.getItems();
		CartItem cartItem = delitems.get(id);
		Map<String, CartItem> items = cart.getItems();
		items.put(id, cartItem);
		delitems.remove(id);
		cart.getAllPrice();
		session.setAttribute("cart", cart);
		session.setAttribute("delcart", delcart);
		return "toCart";
	}*/
}
