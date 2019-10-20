package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> showAllCategorys() {
		// TODO Auto-generated method stub
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> queryAllCategorys = mapper.queryAllCategorys();
		return queryAllCategorys;
	}

	@Override
	public void addOneCategory(String fname) {
		Category category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setCate_name(fname);
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		try{
			mapper.insertOneCategory(category);
			MybatisUtils.commit();
		}catch(Exception e){
			MybatisUtils.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void addTwoCategory(String fid, String cname) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setParent_id(fid);
		category.setCate_name(cname);
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		try{
			mapper.insertTwoCategory(category);
			MybatisUtils.commit();
		}catch(Exception e){
			MybatisUtils.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Category showCategoryByOne(String fid) {
		// TODO Auto-generated method stub
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		Category queryTwoByOne = mapper.queryTwoByOne(fid);
		return queryTwoByOne;
	}

}
