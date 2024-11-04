// 장바구니 항목 관리 패키지 생성
package com.market.cart;

import java.util.ArrayList;
import com.market.bookItem.Book;

//장바구니 처리 클래스 작성
//CartInterface 인터페이스의 자식 클래스
public class Cart implements CartInterface {
	// mCartItem은 ArrayList 클래스를 이용하여 장바구니에 항목을 담는 객체 변수
	public ArrayList<CartItem> mCartItem = new ArrayList<CartItem>();
	
	/*
	static final int NUM_BOOK = 3;
	public CartItem[] mCartItem = new CartItem[NUM_BOOK];
	*/
	
	// 장바구니에 담긴 항목의 총 개수를 저장하는 변수
	public static int mCartCount = 0;
	
	// 기본 생성자
	public Cart() {
		
	}
	
	// 도서 정보 목록을 출력하는 메서드 작성
	public void printBookList(ArrayList<Book> bookList) {
		/*
		for(int i = 0; i < bookList.length; i++) {
			System.out.print(bookList[i].getBookID() + " | ");
			System.out.print(bookList[i].getName() + " | ");
			System.out.print(bookList[i].getUnitPrice() + " | ");
			System.out.print(bookList[i].getAuthor() + " | ");
			System.out.print(bookList[i].getDescription() + " | ");
			System.out.print(bookList[i].getCategory() + " | ");
			System.out.print(bookList[i].getReleaseDate() + " | ");
			System.out.println("");
		}
		*/
		
		for(int i = 0; i < bookList.size(); i++) {
			Book bookItem = bookList.get(i);
			System.out.print(bookItem.getBookID() + " | ");
			System.out.print(bookItem.getName() + " | ");
			System.out.print(bookItem.getUnitPrice() + " | ");
			System.out.print(bookItem.getAuthor() + " | ");
			System.out.print(bookItem.getDescription() + " | ");
			System.out.print(bookItem.getCategory() + " | ");
			System.out.print(bookItem.getReleaseDate() + " | ");
			System.out.println("");
		}
	}
	
	// 장바구니에 도서를 삽입하는 메서드 작성
	public void insertBook(Book book) {
		// mCartItem[mCartCount++] = new CartItem(book);
		CartItem bookItem = new CartItem(book);
		mCartItem.add(bookItem);
		mCartCount = mCartItem.size();
	}
	
	// 장바구니에 담긴 항목을 모두 삭제하는 메서드 작성
	public void deleteBook() {
		// mCartItem = new CartItem[NUM_BOOK];
		mCartItem.clear();
		mCartCount = 0;
	}
	
	// 장바구니에 담긴 항목을 출력하는 메서드 작성
	public void printCart() {
		System.out.println("장바구니 상품 목록 :");
		System.out.println("-----------------------------------------");
		System.out.println("    도서ID \t|     수량   \t|     합계");
		/*
		for(int i = 0; i < mCartCount; i++) {
			System.out.print("   " + mCartItem[i].getBookID() + "   \t| ");
			System.out.print("     " + mCartItem[i].getQuantity() + "  \t| ");
			System.out.print("   " + mCartItem[i].getTotalPrice());
			System.out.println(" ");
		}
		*/
		
		for(int i = 0; i < mCartCount; i++) {
			System.out.print("   " + mCartItem.get(i).getBookID() + "   \t| ");
			System.out.print("     " + mCartItem.get(i).getQuantity() + "  \t| ");
			System.out.print("   " + mCartItem.get(i).getTotalPrice());
			System.out.println(" ");
		}
		System.out.println("-----------------------------------------");
	}
	
	// 장바구니에 담길 도서가 장바구니에 있는 지를 확인하는 메서드 작성
	public boolean isCartInBook(String bookID) {
		boolean flag = false;
		/*
		for(int i = 0; i < mCartCount; i++) {
			if(bookID == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		*/
		
		for(int i = 0; i < mCartItem.size(); i++) {
			if(bookID.equals(mCartItem.get(i).getBookID())) {
				mCartItem.get(i).setQuantity(mCartItem.get(i).getQuantity() + 1);
				flag = true;
			}
		}
		
		return flag;
	}
	
	// 장바구니의 특정 항목을 삭제하는 메서드 작성
	public void removeCart(int numID) {
		mCartItem.remove(numID);
		mCartCount = mCartItem.size();
	}
	
}
