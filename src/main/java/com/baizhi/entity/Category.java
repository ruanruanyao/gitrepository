package com.baizhi.entity;

import java.util.List;

public class Category {
	private String id;
	private String cate_name;
	private Integer count;
	private String levels;
	private String parent_id;
	private List<Category> categorys;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public Category(String id, String cate_name, Integer count, String levels,
			String parent_id, List<Category> categorys) {
		this.id = id;
		this.cate_name = cate_name;
		this.count = count;
		this.levels = levels;
		this.parent_id = parent_id;
		this.categorys = categorys;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", cate_name=" + cate_name + ", count="
				+ count + ", levels=" + levels + ", parent_id=" + parent_id
				+ ", categorys=" + categorys + "]";
	}
}
