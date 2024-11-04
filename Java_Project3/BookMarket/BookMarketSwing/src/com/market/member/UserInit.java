package com.market.member;

// 고객 정보를 관리하는 클래스 작성
public class UserInit {
	private static User mUser;
	
	public static void setmUser(User mUser) {
		UserInit.mUser = mUser;
	}
	
	public static void init(String name, int phone) {
		mUser = new User(name, phone);
	}
	
	public static User getmUser() {
		return mUser;
	}
}
