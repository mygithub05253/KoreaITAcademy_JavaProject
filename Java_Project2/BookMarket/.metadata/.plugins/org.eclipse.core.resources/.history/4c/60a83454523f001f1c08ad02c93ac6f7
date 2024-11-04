// 장바구니 항목 관리 패키지 생성
package com.market.cart;

// 장바구니 클래스 작성

import com.market.bookItem.Book;

public class CartItem {
	// private String[] itemBook = new String[7];
	private Book itemBook;
	private String bookID;
	private int quantity;
	private int totalPrice;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	/* public CartItem(String[] book) {
		this.itemBook = book;
		this.bookID = book[0];
		this.quantity = 1;
		updateTotalPrice();
	}
	
	public String[] getItemBook() {
		return itemBook;
	}
	
	public void setItemBook(String[] itemBook) {
		this.itemBook = itemBook;
	} */
	
	public CartItem(Book bookList) {
		this.itemBook = bookList;
		this.bookID = bookList.getBookID();
		this.quantity = 1;
		updateTotalPrice();
	}
	
	public Book getItemBook() {
		return itemBook;
	}
	
	public void setItemBook(Book itemBook) {
		this.itemBook = itemBook;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public void setBookID(String bookID) {
		this.bookID = bookID;
		this.updateTotalPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void updateTotalPrice() {
		// totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
		totalPrice = this.itemBook.getUnitPrice() * this.quantity;
 	}
}
