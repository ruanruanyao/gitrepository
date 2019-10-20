package com.baizhi.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;

public class BookAction {
	private List<Book> books;
	private String key;
	private String content;
	private Book book;
	private File cover;
	private String coverFileName;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String showAllBooks(){
		BookService bookService = new BookServiceImpl();
		List<Book> showAllBooks = bookService.showAllBooks();
		books = showAllBooks;
		return "toShowAll";
	}
	public String showBookByLike(){
		BookService bookService = new BookServiceImpl();
		List<Book> showBooksByLike = bookService.showBooksByLike(key, content);
		books = showBooksByLike;
		return "toShowAll";
	}
	public String showAddBook(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		BookService bookService = new BookServiceImpl();
		List<Category> showTwoCategorys = bookService.showTwoCategorys();
		session.setAttribute("TwoCategory", showTwoCategorys);
		return "toAddBook";
	}
	public String addBook(){
		BookService bookService = new BookServiceImpl();
		bookService.addBook(book, cover, coverFileName);
		List<Book> showAllBooks = bookService.showAllBooks();
		books = showAllBooks;
		return "toShowAll";
	}
}
