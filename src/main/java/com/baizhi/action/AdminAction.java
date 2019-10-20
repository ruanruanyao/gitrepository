package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;

public class AdminAction{
	private String username;
	private String password;
	private String code;
	private String msg;
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		AdminService adminService = new AdminServiceImpl();
		String login = adminService.login(username, password, code, session);
		if (login.equals("codeError")) {
			msg = "验证码错误";
			return "error";
		}
		if (login.equals("usernameError")) {
			msg = "用户不存在";
			return "error";
		}
		if (login.equals("passwordError")) {
			msg = "密码错误";
			return "error";
		}
		return "success";
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

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
}
