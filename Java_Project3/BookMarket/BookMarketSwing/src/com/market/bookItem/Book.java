// 도서 항목 관리 패키지 생성
package com.market.bookItem;

// 도서 정보 관리 클래스 생성
// Item 추상 클래스의 자식 클래스
public class Book extends Item{
	private String author;
	private String description;
	private String category;
	private String releaseDate;
	
	public Book(String bookID, String name, int unitPrice) {
		super(bookID, name, unitPrice);
	}
	
	public Book(String bookID, String name, int unitPrice, String author, String description, String category, String releaseDate) {
		super(bookID, name, unitPrice);
		this.author = author;
		this.description = description;
		this.category = category;
		this.releaseDate = releaseDate;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
