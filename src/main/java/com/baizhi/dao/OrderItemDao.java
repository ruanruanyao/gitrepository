package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.OrderItem;
import com.baizhi.entity.OrderItemVo;

public interface OrderItemDao {
	public void insertItem(OrderItem orderItem);
	// 根据订单id查询
	public List<OrderItemVo> queryItemsById(String id);
}
