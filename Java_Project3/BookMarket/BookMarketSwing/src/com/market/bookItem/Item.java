// 도서 항목 관리 패키지 생성
package com.market.bookItem;

// 장바구니 항목 관리 클래스 생성
// 주요 도서 정보를 관리하는 추상 클래스
public abstract class Item {
	String bookID;
	String name;
	int unitPrice;
	
	public Item(String bookID, String name, int unitPrice) {
		this.bookID = bookID;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	abstract String getBookID();
	
	abstract String getName();
	
	abstract int getUnitPrice();
	
	abstract void setBookID(String bookID);
	
	abstract void setName(String name);
	
	abstract void setUnitPrice(int unitPrice);
}
