package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	public List<Book> queryAllBooks();
	public List<Book> queryByLike(@Param("key")String key,@Param("content")String content);
	public void insertBook(Book book);
	public List<Book> queryRecommend();
	public List<Book> queryHotAndNew();
	public List<Book> queryBooksByOne(@Param("fid")String fid,@Param("start")Integer start,@Param("end")Integer end);
	public List<Book> queryBooksByTwo(String cid);
	public Integer queryCountByOne(String fid);
	public Integer queryCountByTwo(String cid);
	public Book queryBookById(String id);
}
