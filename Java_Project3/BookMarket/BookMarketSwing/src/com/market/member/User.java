// 고객 및 관리자 관리 패키지 생성
package com.market.member;

// 사용자 클래스 작성
// Person 클래스로부터 상속받는 자식 클래스
public class User extends Person {
	public User(String name, int phone) {
		super(name, phone);
	}
	
	public User(String username, int phone, String address) {
		super(username, phone, address);
	}
}
