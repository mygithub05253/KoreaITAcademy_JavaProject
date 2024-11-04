// 고객 및 관리자 관리 패키지 생성
package com.market.member;

// 관리자 클래스 작성
// Person 클래스로부터 상속받는 자식 클래스
public class Admin extends Person {
	private String id = "Admin";
	private String password = "Admin1234";
	
	public Admin(String name, int phone) {
		super(name, phone);
	}
	
	public String getID() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
}
