// 장바구니 항목의 예외 처리 생성을 위한 패ㅣ지
package com.market.exception;

// 사용자 예외 처리 클래스 작성
public class CartException extends Exception {
	public CartException(String str) {
		super(str);
	}
}
