package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	public List<Category> showAllCategorys();
	public void addOneCategory(String fname);
	public void addTwoCategory(String fid,String cname);
	public Category showCategoryByOne(String fid);
	// public List<Category> showCB2(); ××××
}
