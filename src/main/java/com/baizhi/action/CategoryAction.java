package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;

public class CategoryAction {
	private String fname;
	private String fid;
	private String cname;
	private String cid;
	private List<Book> books;
	private Category cate;
	private Integer page;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String showAllCategorys(){
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> showAllCategorys = categoryService.showAllCategorys();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("categorys", showAllCategorys);
		return "toShowAll";
	}
	public String addOneCategory(){
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.addOneCategory(fname);
		List<Category> showAllCategorys = categoryService.showAllCategorys();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("categorys", showAllCategorys);
		return "toShowAll";
	}
	/*
	 * 查询所有的1级类别
	 * 展示所有类别信息中包含了所有的1级类别
	 */
	public String showOneCategory(){
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> showAllCategorys = categoryService.showAllCategorys();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("categorys", showAllCategorys);
		return "toAddTwo";
	}
	/*
	 * 添加2级类别
	 */
	public String addTwoCategory(){
		// 数据添加
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.addTwoCategory(fid, cname);
		// 数据展示
		List<Category> showAllCategorys = categoryService.showAllCategorys();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("categorys", showAllCategorys);
		return "toShowAll";
	}
	
	/* 前台
	 * 2级页面
	 */
	public String showFrontTwo(){
		BookService bookService = new BookServiceImpl();
		if (page==null) {
			page = 1;
		}
		if(cid==null){
			// 根据1级类别查询
			List<Book> showBooksByOne = bookService.showBooksByOne(fid,page);
			/*
			 *  SELECT *
				from D_BOOK d left join D_CATEGORY c
				on d.CATE_ID = c.id
				where c.PARENT_ID = #{fid}
			 */
			// session.set("X","数据")
			books = showBooksByOne;
		}else{
			// 根据2级类别查询
			List<Book> showBooksByTwo = bookService.showBooksByTwo(cid,page);
			/*
			 * SELECT * from D_BOOK where CATE_ID = #{cid}
			 */
			books = showBooksByTwo;
		}
		CategoryService categoryService = new CategoryServiceImpl();
		Category showCategoryByOne = categoryService.showCategoryByOne(fid);
		// ca.showDetailCategory(fid) ---> dao.queryDetailCategory(fid);
		// 查询到一个1级分类对象
		// session.set("X","数据")
		cate = showCategoryByOne;
		return "toShowTwoPage";
	}
	
}
