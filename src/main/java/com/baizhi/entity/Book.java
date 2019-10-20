package com.baizhi.entity;

import java.util.Date;

public class Book {
	private String id;
	private String book_name;
	private String author;
	private Double price;
	private Double dd_price;
	private String company;
	private Date publish_time;
	private String public_count;
	private String isbn;
	private Date print_time;
	private String print_count;
	private Integer sale_count;
	private String cate_id;
	private String e_recommend;
	private String src;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDd_price() {
		return dd_price;
	}
	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getPublic_count() {
		return public_count;
	}
	public void setPublic_count(String public_count) {
		this.public_count = public_count;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}
	public String getPrint_count() {
		return print_count;
	}
	public void setPrint_count(String print_count) {
		this.print_count = print_count;
	}
	public Integer getSale_count() {
		return sale_count;
	}
	public void setSale_count(Integer sale_count) {
		this.sale_count = sale_count;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getE_recommend() {
		return e_recommend;
	}
	public void setE_recommend(String e_recommend) {
		this.e_recommend = e_recommend;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", book_name=" + book_name + ", author="
				+ author + ", price=" + price + ", dd_price=" + dd_price
				+ ", company=" + company + ", publish_time=" + publish_time
				+ ", public_count=" + public_count + ", isbn=" + isbn
				+ ", print_time=" + print_time + ", print_count=" + print_count
				+ ", sale_count=" + sale_count + ", cate_id=" + cate_id
				+ ", e_recommend=" + e_recommend + ", src=" + src + "]";
	}
	public Book(String id, String book_name, String author, Double price,
			Double dd_price, String company, Date publish_time,
			String public_count, String isbn, Date print_time,
			String print_count, Integer sale_count, String cate_id,
			String e_recommend, String src) {
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.dd_price = dd_price;
		this.company = company;
		this.publish_time = publish_time;
		this.public_count = public_count;
		this.isbn = isbn;
		this.print_time = print_time;
		this.print_count = print_count;
		this.sale_count = sale_count;
		this.cate_id = cate_id;
		this.e_recommend = e_recommend;
		this.src = src;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
