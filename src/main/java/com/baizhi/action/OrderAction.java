package com.baizhi.action;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class OrderAction {
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String addOrder(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getId();
		String id = address.getId();
		String addrid = UUID.randomUUID().toString();
		if (id=="aaa"||"aaa".equals(id)) {
			// 地址的新增
			address.setUser_id(userid);
			address.setId(addrid);
			AddressDao mapper = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
			mapper.insertAddress(address);
		}
		// 订单添加
		Cart cart = (Cart) session.getAttribute("cart");
		Order order = new Order();
		String orderid = UUID.randomUUID().toString();
		String ordernumber = UUID.randomUUID().toString();
		order.setId(orderid);
		order.setOrder_number(ordernumber);
		order.setCreate_time(new Date());
		order.setTotal_price(cart.getDdcart_price());
		order.setUser_id(userid);
		order.setAddr_id(address.getId());
		// insert order
		OrderDao mapper = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
		mapper.insertOrder(order);
		// 订单项添加
		Map<String, CartItem> items = cart.getItems();
		OrderItemDao mapper2 = MybatisUtils.getSqlSession().getMapper(OrderItemDao.class);
		for (CartItem item : items.values()) {
			OrderItem orderItem = new OrderItem(UUID.randomUUID().toString(),item.getDd_price(),item.getCount(),item.getAlldd_price(),item.getBook_id(),orderid);
			// insert orderItem
			mapper2.insertItem(orderItem);
		}
		MybatisUtils.commit();
		return "toOk";
	}
}
