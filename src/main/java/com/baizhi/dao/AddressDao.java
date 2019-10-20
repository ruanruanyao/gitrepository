package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	// 根据用户id查询
	public List<Address> queryAddressesById(String id); 
	// 根据地址id查询
	public Address queryAddressById(String id);
	public void insertAddress(Address address);
}
