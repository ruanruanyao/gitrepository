package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;

public class UserAction {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		if("admin".equals(username)&&"admin".equals(password)){
			User user = new User();
			user.setId("1");
			user.setUsername(username);
			session.setAttribute("user", user);
		}
		Object attribute = session.getAttribute("cart");
		if (attribute==null) {
			return "toIndex";
		}else{
			return "toAddress";
		}
		
	}
}
