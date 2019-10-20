package com.baizhi.service;

import javax.servlet.http.HttpSession;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MybatisUtils;

public class AdminServiceImpl implements AdminService{

	@Override
	public String login(String username, String password, String code,
			HttpSession session) {
		// TODO Auto-generated method stub
		// 获取session中的验证码
		String imageCode = (String) session.getAttribute("code");
		// 验证码比对
		if (!code.equals(imageCode)) {
			return "codeError";
		}
		// 查询管理员
		AdminDao mapper = MybatisUtils.getSqlSession().getMapper(AdminDao.class);
		Admin queryAdminByUsername = mapper.queryAdminByUsername(username);
		// 用户是否存在比对
		if (queryAdminByUsername==null) {
			return "usernameError";
		}
		// 密码比对
		if (!queryAdminByUsername.getPassword().equals(password)) {
			return "passwordError";
		}
		session.setAttribute("admin", queryAdminByUsername);
		return "success";
	}

}
