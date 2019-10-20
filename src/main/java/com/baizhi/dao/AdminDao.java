package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Admin;

public interface AdminDao {
	public Admin queryAdminByUsername(String username);
}
