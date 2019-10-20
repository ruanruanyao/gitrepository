package com.baizhi.service;

import java.io.File;
import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface BookService {
	public List<Book> showAllBooks();
	public List<Book> showBooksByLike(String key,String content);
	public List<Category> showTwoCategorys();
	public void addBook(Book book,File cover,String coverFileName);
	public List<Book> showBooksByOne(String fid,Integer page);
	public List<Book> showBooksByTwo(String cid,Integer page);
	public Book showBookById(String id);
}
