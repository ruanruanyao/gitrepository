package com.baizhi.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class BookServiceImpl implements BookService{
	@Override
	public List<Book> showAllBooks() {
		// TODO Auto-generated method stub
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryAllBooks = mapper.queryAllBooks();
		return queryAllBooks;
	}

	@Override
	public List<Book> showBooksByLike(String key,String content) {
		// TODO Auto-generated method stub
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryByLike = mapper.queryByLike(key, content);
		return queryByLike;
	}

	@Override
	public List<Category> showTwoCategorys() {
		// TODO Auto-generated method stub
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> queryTwoCategorys = mapper.queryTwoCategorys();
		return queryTwoCategorys;
	}

	@Override
	public void addBook(Book book, File cover, String coverFileName) {
		// TODO Auto-generated method stub
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		// 获取服务器路径
		String realPath = ServletActionContext.getRequest().getRealPath("back/img");
		// 判断是否存在目标文件夹
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdir();
		}
		// 解决重名问题
		coverFileName = new Date().getTime()+"_"+coverFileName;
		// 文件上传
		try {
			FileUtils.copyFile(cover, new File(realPath,coverFileName));
			book.setId(UUID.randomUUID().toString());
			book.setSrc(coverFileName);
			mapper.insertBook(book);
			MybatisUtils.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MybatisUtils.rollback();
			// 将上传的文件删除
		}
		
	}

	@Override
	public List showBooksByOne(String fid,Integer page) {
		// TODO Auto-generated method stub
		Integer pageSize = 2; //每页显示数
		// page = 10; start = 19 ; end = 20;
		// 总页数 根据sql查询到总条数(分页前) / 每页显示数
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Integer pageCount = mapper.queryCountByOne(fid); //总条数
		Integer pageNum = (pageCount % pageSize == 0) ? pageCount / pageSize:pageCount / pageSize + 1; // 总页数 
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("pageNum", pageNum);
		if (page>=pageNum) {
			page = pageNum;
		}
		Integer start = (page-1) * pageSize + 1;
		Integer end = page * pageSize;
		List<Book> queryBooksByOne = mapper.queryBooksByOne(fid,start,end);
		return queryBooksByOne;
	}

	@Override
	public List<Book> showBooksByTwo(String cid,Integer page) {
		// TODO Auto-generated method stub
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryBooksByTwo = mapper.queryBooksByTwo(cid);
		return queryBooksByTwo;
	}

	@Override
	public Book showBookById(String id) {
		// TODO Auto-generated method stub
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Book queryBookById = mapper.queryBookById(id);
		return queryBookById;
	}

}
