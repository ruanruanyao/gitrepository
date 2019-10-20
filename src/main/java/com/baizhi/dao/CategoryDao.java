package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryDao {
	public List<Category> queryAllCategorys();
	public void insertOneCategory(Category category);
	public void insertTwoCategory(Category category);
	public List<Category> queryTwoCategorys();
	public Category queryTwoByOne(String fid);
}
