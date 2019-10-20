package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderVo;

public interface OrderDao {
	public void insertOrder(Order order);
	public List<OrderVo> queryOrders();
}
