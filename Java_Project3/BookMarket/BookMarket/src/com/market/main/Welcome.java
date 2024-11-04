// 메인 메서드를 포함한 클래스의 패키지 생성
package com.market.main;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import com.market.bookItem.Book;
import com.market.cart.Cart;
import com.market.member.Admin;
import com.market.member.User;
import com.market.exception.CartException;

public class Welcome {
	// 도서의 개수에 대한 상수 선언
	static final int NUM_BOOK = 3;
	
	// 도서 정보의 개수에 대한 상수 선언
	static final int NUM_ITEM = 7;
	
	// 장바구니에 도서 추가를 위한 변수(상수) 선언
	// static CartItem[] mCartItem = new CartItem[NUM_BOOK];
	// static int mCartCount = 0;
	static Cart mCart = new Cart();
	
	// 고객의 정보를 저장하기 위한 변수(상수) 선언
	static User mUser;

	public static void main(String[] args) {
		// System.out.println("Welcome to Shopping Mall");
		// System.out.println("Welcome to Book Market!");
		
		// 도서 정보를 저장할 2차원 배열 생성
		// String[][] mBook = new String[NUM_BOOK][NUM_ITEM];
		// Book[] mBookList = new Book[NUM_BOOK];
		// Book[] mBookList;
		ArrayList<Book> mBookList;
		
		// 도서 개수를 저장하기 위한 변수 선언
		int mTotalBook = 0;
		
		// 사용자의 정보(이름과 연락처)를 입력받고 저장
		Scanner input = new Scanner(System.in);
		
		// 이름은 문자열로, 연락처는 정수로 입력받기
		System.out.print("당신의 이름을 입력하세요 : ");
		String userName = input.next();
				
		System.out.print("연락처를 입력하세요 : ");
		int userMobile = input.nextInt();
		
		// User 클래스의 객체를 생성하여 입력 받은 고객의 정보 저장
		mUser = new User(userName, userMobile);
		
		// 변수를 이용하여 인사말 출력하기
		// 인사말을 문자열 변수에 새롭게 저장하고 출력
		String greeting = "Welcom to Shopping Mall";
		String tagline = "Welcome to Book Market!";
		
		// 메뉴 선택 종료하기
		// 선택할 메뉴를 보여주는 코드를 감싸도록 반복문 작성
		boolean quit = false;
		
		while(!quit) {
			System.out.println("******************************************************");
			System.out.println("\t" + greeting);
			System.out.println("\t" + tagline);
			System.out.println("******************************************************");
			
			/*
			// 메인 메뉴 항목 만들기
			System.out.println(" 1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
			System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
			System.out.println(" 3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
			System.out.println(" 7. 영수증 표시하기 \t8. 종료");
			System.out.println("******************************************************");
			*/
			
			// 선택 가능한 메뉴 목록 출력 메서드 호츌
			menuIntroduction();
			
			// 메뉴 선택의 예외 처리 생성
			// 메인 메뉴 선택에서 오류가 발생했을 때 예외로 처리하도록 함
			try {
				// 메인 메뉴 선택하기
				// 온라인 서점의 메인 메뉴를 만들어 사용자 입력 처리를 통해 메뉴 선택
				// 메뉴 번호 입력받고 출력하기
				System.out.print("메뉴 번호를 선택해주세요 : ");
				int num = input.nextInt();
				
				/*
				  if (num < 1 || num > 8) {
					System.out.println("1부터 8까지의 숫자를 입력하세요.");
				}
				  
				 */
				if (num < 1 || num > 9) {
					System.out.println("1부터 9까지의 숫자를 입력하세요.");
				} else {
					// 메뉴 정보 표시 및 종료하기
					// 제어문을 이용하여 선택 가능한 메뉴 정보를 출력
					// 반복문을 이용하여 종료 메뉴를 선택하기 전까지 메뉴 지속적으로 선택 가능
					switch(num) {
					case 1:
						/*
						// 고객 정보 출력하기
						System.out.println("현재 고객 정보 : ");
						System.out.println("이름 " + userName + " 연락처 " + userMobile);
						*/
						
						// 고객 정보 출력 메서드 호출
						menuGuestInfo(userName, userMobile);
						break;
					case 2:
						// System.out.println("장바구니 상품 목록 보기 : ");
						
						// 장바구니 상품 목록 확인 메서드 호출
						menuCartItemList();
						break;
					case 3:
						// System.out.println("장바구니 비우기");
						
						// 장바구니 비우는 메서드 호출
						menuCartClear();
						break;
					case 4:
						// System.out.println("장바구니에 항목 추가하기 : ");
						
						// totalFileToBookList() 메서드를 호출하여 도서 개수 저장
						mTotalBook = totalFileToBookList();
						
						// 도서 개수에 따라 도서 정보를 저장하기 위한 배열 초기화
						// mBookList = new Book[mTotalBook];
						mBookList = new ArrayList<Book>();
						
						// 장바구니에 항목 추가하는 메서드 호출
						// menuCartAddItem(mBook);
						menuCartAddItem(mBookList);
						break;
					case 5:
						// System.out.println("5. 장바구니의 항목 수량 줄이기");
						
						// 장바구니의 항목 수량 줄이는 메서드 호출
						menuCartRemoveItemCount();
						break;
					case 6:
						// System.out.println("6. 장바구니의 항목 삭제하기");
						
						// 장바구니의 항목 삭제하는 메서드 호출
						menuCartRemoveItem();
						break;
					case 7:
						// System.out.println("7. 영수증 표시하기");
						
						// 영수증 표시하는 메서드 호출
						menuCartBill();
						break;
					case 8:
						// System.out.println("8. 종료");
						
						// 종료 메서드 호출
						menuExit();
						break;
					case 9:
						menuAdminLogin();
						break;
					}
				}
			} catch(CartException e) {
				System.out.println(e.getMessage());
				quit = true;
			} catch(Exception e) {
				System.out.println("올바르지 않은 메뉴 선택으로 종료합니다.");
				quit = true;
			}
		} 
		
	}
	
	// 메뉴별 메서드 만들기
	// 1. 선택 가능한 메뉴 목록 출력 메서드 작성
	public static void menuIntroduction() {
		System.out.println(" 1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t8. 종료");
		System.out.println(" 9. 관리자 로그인");
		System.out.println("******************************************************");
	}
	
	// 2. 입력 받은 고객 정보 출력 메서드 작성
	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("현재 고객 정보 : ");
		// Person person = new Person(name, mobile);
		// System.out.println("이름 " + person.getName() + " 연락처 " + person.getPhone());
		
		System.out.println("이름 " + mUser.getName() + "  연락처 " + mUser.getPhone());
	}
	
	// 3. 장바구니 상품 목록 확인 메서드 작성
	public static void menuCartItemList() {
		/*
		System.out.println("2. 장바구니 상품 목록 보기");
		System.out.println("-----------------------------------------");
		System.out.println("    도서ID \t|     수량   \t|     합계");
		for(int i = 0; i < mCartCount; i++) {
			System.out.print("   " + mCartItem[i].getBookID() + "   \t| ");
			System.out.print("     " + mCartItem[i].getQuantity() + "  \t| ");
			System.out.print("   " + mCartItem[i].getTotalPrice());
			System.out.println(" ");
		}
		System.out.println("-----------------------------------------");
		*/
		if(mCart.mCartCount >= 0) {
			mCart.printCart();
		}
	}
	
	// 4. 장바구니 비우기 메서드 작성
	public static void menuCartClear() throws CartException {
		// System.out.println("3. 장바구니 비우기");
		if(mCart.mCartCount == 0) {
			// System.out.println("장바구니에 항목이 없습니다.");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			if(str.toUpperCase().equals("Y")) {
				System.out.println("장바구니의 모든 항목을 삭제했습니다.");
				// mCart.mCartItem = new CartItemBook[NUM_BOOK];
				mCart.deleteBook();
			}
		}
	}
	
	// 5. 장바구니에 항목 추가하는 메서드 작성
	public static void menuCartAddItem(ArrayList<Book> bookList) {
		// System.out.println("4. 장바구니에 항목 추가하기");
		
		// 도서 정보를 저장하는 메서드 호출
		BookList(bookList);
		
		// 도서 정보 출력
		/*
		for(int i = 0; i < NUM_BOOK; i++) {
			for(int j = 0; j < NUM_ITEM; j++) {
				System.out.print(book[i][j] + " | ");
			}
			System.out.println("");
		}
		*/
		mCart.printBookList(bookList);
		
		// 입력받은 도서의 ID 확인하기 메서드
		// 장바구니에 추가할 도서의 ID가 도서 목록에 포함되어 있으면 종료
		// 포함되어 있지 않으면 다시 입력하도록 함
		boolean quit = false;
		
		// 장바구니에 항목을 추가하지 않을 때까지 반복
		while(!quit) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
			
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			boolean flag = false;
			int numID = -1;
			
			for(int i = 0; i < bookList.size(); i++) {
				// 입력된 도서의 ID와 저장되어 있는 도서 정보의 ID가 일치하는지 확인
				// 일치하면 도서 정보와 numID와 flag 변수에 값을 변경하여 저장하고 반복문 종료
				if(str.equals(bookList.get(i).getBookID())) {
					numID = i;
					flag = true;
					break;
				}
			}
				
			// 변수 flag가 참이면 반복문을 종료
			// 거짓이면 '다시 입력해주세요' 출력
			if(flag) {
				// 장바구니에 추가 여부 묻기
				// 입력한 도서의 ID가 도서 목록에 있으면 장바구니에 추가할 것인지를 확인한 후 종료하도록 함
				System.out.print("장바구니에 추가하겠습니까? Y | N : ");
				str = input.nextLine();
					
				// 입력값을 대문자로 변경하여 Y이면 도서가 장바구니에 추가되었다는 메시지 출력
				if(str.toUpperCase().equals("Y")) {
					System.out.println(bookList.get(numID).getBookID() + " 도서가 장바구니에 추가되었습니다.");
						
					// 장바구니에 넣기
					/*
					if(!isCartInBook(book[numID][0]))
						mCartItem[mCartCount++] = new CartItem(book[numID]);
					*/
					if(!isCartInBook(bookList.get(numID).getBookID())) {
						// mCartItem[mCartCount++] = new CartItem(book[numID]);
						// mCartItem[mCartCount++] = new CartItemBook(bookList[numID]);
						// mCart.mCartCount = mCartCount++;
						// mCartCount++;
						mCart.insertBook(bookList.get(numID));
					}
				}
				quit = true;
			} else 
				System.out.println("다시 입력해 주세요.");
		}
	}
	
	// 장바구니에 항목 추가하는 메서드 작성
	public static boolean isCartInBook(String bookID) {
		/*
		boolean flag = false;
		for(int i = 0; i < mCartCount; i++) {
			if(bookID == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		
		return flag;
		*/
		return mCart.isCartInBook(bookID);
	}
		
	// 6. 장바구니의 항목 수량 줄이는 메서드 작성
	public static void menuCartRemoveItemCount() {
		System.out.println("5. 장바구니의 항목 수량 줄이기");
	}
	
	// 7. 장바구니의 항목 삭제하는 메서드 작성
	public static void menuCartRemoveItem() throws CartException {
		// System.out.println("6. 장바구니의 항목 삭제하기");
		if(mCart.mCartCount == 0) {
			// System.out.println("장바구니에 항목이 없습니다.");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			menuCartItemList();
			boolean quit = false;
			while(!quit) {
				System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numID = -1;
				
				for(int i = 0; i < mCart.mCartCount; i++) {
					if(str.equals(mCart.mCartItem.get(i).getBookID())) {
						numID = i;
						flag = true;
						break;
					}
				}
				
				if(flag) {
					System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N ");
					str = input.nextLine();
					if(str.toUpperCase().equals("Y")) {
						System.out.println(mCart.mCartItem.get(numID).getBookID() + " 장바구니에서 도서가 삭제되었습니다.");
						
						// 배열 이동
						/*
						CartItemBook[] cartItem = new CartItem[NUM_BOOK];
						int num = 0;
						
						for(int i = 0; i < mCartCount; i++) {
							if(numID != i) {
								cartItem[num++] = mCart.mCartItem[i];
							}
						}
						mCartCount = num;
						mCart.mCartCount = num;
						mCart.mCartItem = cartItem;
						*/
						mCart.removeCart(numID);
					}
					quit = true;
				} else {
					System.out.println("다시 입력해주세요.");
				}
			}
		}
	}
	
	// 8. 영수증 표시하는 메서드 작성
	public static void menuCartBill() throws CartException {
		// System.out.println("7. 영수증 출력하기");
		
		// 장바구니에 항목이 없는 경우
		if(mCart.mCartCount == 0) {
			// System.out.println("장바구니에 항목이 없습니다.");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			// 장바구니에 항목이 있는 경우
			System.out.println("배송받을 분은 고객 정보와 일치합니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			// 고객 정보와 동일한 경우
			if(str.toUpperCase().equals("Y")) {
				System.out.print("배송지를 입력해주세요 : ");
				String address = input.nextLine();
				
				// 주문 영수증 출력
				// 배송을 위한 고객 정보와 영수증 출력을 위한 printBill() 메서드 호출
				printBill(mUser.getName(), String.valueOf(mUser.getPhone()), address);
			} else {
				// 고객 정보와 동일하지 않은 경우
				System.out.print("배송받을 고객명을 입력하세요 : ");
				String name = input.nextLine();
				
				System.out.print("배송받을 고객의 연락처를 입력하세요 : ");
				String phone = input.nextLine();
				
				System.out.print("배송받을 고객의 배송지를 입력해주세요 : ");
				String address = input.nextLine();
				
				printBill(name, phone, address);
			}
		}
	}
	
	// 11. 영수증을 출력하는 메서드 작성
	public static void printBill(String name, String phone, String address) {
		// MM//dd//yyyy 형식의 현재 날짜 정보 얻음
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("---------------배송받을 고객 정보---------------");
		System.out.println("고객명 : " + name + "   \t\t연락처 : " + phone);
		System.out.println(" 배송지 : " + address + "\t\t발송일 : " + strDate);
		
		// 장바구니에 담긴 항목 출력
		mCart.printCart();
		
		// 장바구니에 담긴 항목의 총 금액 산출
		int sum = 0;
		for(int i = 0; i < mCart.mCartCount; i++) {
			sum += mCart.mCartItem.get(i).getTotalPrice();
		}
		
		// 장바구니에 담긴 항목의 총 금액 출력
		System.out.println("\t\t\t주문 총 금액 : " + sum + "원\n");
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	
	// 9. 종료 메서드 작성
	public static void menuExit() {
		System.out.println("8. 종료");
	}
	
	// 10. 관리자 로그인 정보 확인 메서드 작성
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String adminID = input.next();
		
		System.out.print("비밀번호 : ");
		String adminPW = input.next();
		
		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		
		if(adminID.equals(admin.getID()) && adminPW.equals(admin.getPassword())) {
			String[] writeBook = new String[7];
			System.out.println("도서 정보를 추가하겠습니까? Y | N");
			String str = input.next();
			
			// 관리자의 인증을 거쳐 새로운 도서 정보를 키보드를 입력받을 수 있도록 함
			if(str.toUpperCase().equals("Y")) {
				// 날짜 클래스 Date와 SimpleDateFormate을 이용하여 도서 ID를 "ISBN" + 날짜 시간으로 자동 설정
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
				String strDate = formatter.format(date);
				writeBook[0] = "ISBN" + strDate;
				System.out.println("도서 ID : " + writeBook[0]);
				
				// 키보드로 한 행 입력 시 엔터키를 입력으로 처리
				String str1 = input.nextLine();
				// 키보드로 한 행씩 입력받은 도서 정보를 배열 writeBook에 저장
				System.out.print("도서명 : ");
				writeBook[1] = input.nextLine();
				System.out.print("가격 : ");
				writeBook[2] = input.nextLine();
				System.out.print("저자 : ");
				writeBook[3] = input.nextLine();
				System.out.print("설명 : ");
				writeBook[4] = input.nextLine();
				System.out.print("분야 : ");
				writeBook[5] = input.nextLine();
				System.out.print("출판일 : ");
				writeBook[6] = input.nextLine();
				
				// 관리자 인증을 거쳐 키보드로 입력한 새로운 도서 정보를 파일에 저장하도록 함
				try {
					// book.txt 파일에 쓰기 위해 FileWriter 객체 생성
					FileWriter fw = new FileWriter("C://Java_Project2//BookMarket//BookMarket/book.txt", true);
					
					// 새로 입력받은 도서 정보를 book.txt 파일에 저장
					for(int i = 0; i < 7; i++) {
						fw.write(writeBook[i] + "\n");
						fw.close();
						System.out.println("새 도서 정보가 저장되었습니다.");
					}
				} catch(Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("이름 " + admin.getName() + "  연락처 " + admin.getPhone());
				System.out.println("아이디 " + admin.getID() + "  비밀번호 " + admin.getPassword());
			}
		} else {
			System.out.println("관리자 정보가 일치하지 않습니다.");
		}
	}
	
	// 도서 정보 저장하기
	// 요소 : ISBN, 도서명, 정가, 저자, 도서 설명, 도서 분야, 출간일
	
	// 도서 정보를 저장하는 메서드 작성
	public static void BookList(ArrayList<Book> bookList) {
		/*book[0][0] = "ISBN1234";
		book[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2] = "27000";
		book[0][3] = "송미영";
		book[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
		book[0][5] = "IT전문서";
		book[0][6] = "2018/10/08";
		
		book[1][0] = "ISBN1235";
		book[1][1] = "안드로이드 프로그래밍";
		book[1][2] = "33000";
		book[1][3] = "우재남";
		book[1][4] = "실습 단계별 명쾌한 멘토링";
		book[1][5] = "IT전문서";
		book[1][6] = "2022/01/22";
		
		book[2][0] = "ISBN1236";
		book[2][1] = "스크래치";
		book[2][2] = "22000";
		book[2][3] = "고광일";
		book[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
		book[2][5] = "컴퓨터입문";
		book[2][6] = "2019/06/10";*/
		
		/*
		bookList[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000);
		bookList[0].setAuthor("송미영");
		bookList[0].setDescription("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
		bookList[0].setCategory("IT전문서");
		bookList[0].setReleaseDate("2018/10/08");
		
		bookList[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000);
		bookList[1].setAuthor("우재남");
		bookList[1].setDescription("실습 단계별 명쾌한 멘토링!");
		bookList[1].setCategory("IT전문서");
		bookList[1].setReleaseDate("2022/01/22");
		
		bookList[2] = new Book("ISBN1236", "스크래치", 22000);
		bookList[2].setAuthor("고광일");
		bookList[2].setDescription("컴퓨팅 사고력을 키우는 블록 코딩");
		bookList[2].setCategory("컴퓨터입문");
		bookList[2].setReleaseDate("2019/06/10");
		*/
		
		setFileToBookList(bookList);
	}
	
	// 12. 파일에서 도서의 개수를 얻는 메서드 작성
	public static int totalFileToBookList() {
		try {
			// book.txt 파일을 읽기 위한 FileReader 객체 생성
			FileReader fr = new FileReader("C://Java_Project2//BookMarket//BookMarket/book.txt");
			
			// 파일에서 한 행씩 읽기 위한 BufferedReader 객체 생성
			BufferedReader reader = new BufferedReader(fr);
			
			String str;
			// 도서의 개수를 저장하기 위한 지역 변수 선언
			int num = 0;
			
			// 파일에서 읽을 행이 없을 때까지 반복
			while((str = reader.readLine()) != null) {
				if(str.contains("ISBN")) {
					// 파일에서 읽은 한 행에 문자열 "ISBN"이 포함되어 있으면 도서의 개수 num을 1 증가
					++num;
				}
				
				reader.close();
				fr.close();
				return num;
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	// 13. 파일에서 도서 정보 목록을 읽어 배열에 저장하는 메서드 작성
	public static void setFileToBookList(ArrayList<Book> bookList) {
		try {
			FileReader fr = new FileReader("C://Java_Project2//BookMarket//BookMarket/book.txt");
			BufferedReader reader = new BufferedReader(fr);
			
			String str2;
			String[] readBook = new String[7];
			// int count = 0;
			
			// 파일에서 읽을 행이 없을 때까지 반복
			while((str2 = reader.readLine()) != null) {
				// 파일에서 읽은 한 행에 문자열 "ISBN"이 포함되어 있으면 도서 정보에 대해 한 행씩 읽어 지역 변수 readBook에 저장
				if(str2.contains("ISBN")) {
					readBook[0] = str2;
					readBook[1] = reader.readLine();
					readBook[2] = reader.readLine();
					readBook[3] = reader.readLine();
					readBook[4] = reader.readLine();
					readBook[5] = reader.readLine();
					readBook[6] = reader.readLine();
				}
				
				// Book 클래스의 생성자를 통해 도서 정보 저장
				// bookList[count++] = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]), readBook[3], readBook[4], readBook[5], readBook[6]);
				Book bookItem = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]), readBook[3], readBook[4], readBook[5], readBook[6]);
				
				bookList.add(bookItem);
			}
			reader.close();
			fr.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
