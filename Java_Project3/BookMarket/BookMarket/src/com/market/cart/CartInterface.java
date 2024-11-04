// 장바구니 항목 관리 패키지 생성
package com.market.cart;

import java.util.ArrayList;
import com.market.bookItem.Book;

//장바구니 처리 인터페이스 작성
public interface CartInterface {
	void printBookList(ArrayList<Book> p);
	boolean isCartInBook(String id);
	void insertBook(Book p);
	void removeCart(int numID);
	void deleteBook();
}
