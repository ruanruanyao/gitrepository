package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class AddressAction {
	private String id;
	private Address addr;
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String showAddresses(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if (user==null) {
			return "toLogin";
		}else{
			String id = user.getId();
			// 根据id查询用户
			AddressDao mapper = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
			List<Address> queryAddressesById = mapper.queryAddressesById(id);
			session.setAttribute("addresses", queryAddressesById);
			return "toAddress";
		}
	}
	public String queryAddressById(){
		AddressDao mapper = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		Address queryAddressById = mapper.queryAddressById(id);
		addr = queryAddressById;
		return "toAddr";
	}
}
