package com.market.bookItem;

import java.io.*;
import java.util.ArrayList;

// 도서 정보 파일(book.txt)을 읽어와 관리하는 클래스 작성
public class BookInit {
	private static ArrayList<Book> mBookList;
	private static int mTotalBook = 0;
	
	public static void init() {
		mTotalBook = totalFileToBookList();
		mBookList = new ArrayList<Book>();
		setFileToBookList(mBookList);
	}
	
	public static int totalFileToBookList() {
		try {
			FileReader fr = new FileReader("book.txt");
			BufferedReader reader = new BufferedReader(fr);
			
			String str;
			int num = 0;
			while((str = reader.readLine()) != null) {
				if(str.contains("ISBN")) {
					++num;
				}
			}
			reader.close();
			fr.close();
			return num;
		} catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static void setFileToBookList(ArrayList<Book> bookList) {
		try {
			FileReader fr = new FileReader("book.txt");
			BufferedReader reader = new BufferedReader(fr);
			
			String str2;
			String[] readBook = new String[7];
			
			while((str2 = reader.readLine()) != null) {
				if(str2.contains("ISBN")) {
					readBook[0] = str2;
					readBook[1] = reader.readLine();
					readBook[2] = reader.readLine();
					readBook[3] = reader.readLine();
					readBook[4] = reader.readLine();
					readBook[5] = reader.readLine();
					readBook[6] = reader.readLine();
				}
				
				Book bookItem = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]), readBook[3], readBook[4], readBook[5], readBook[6]);
				bookList.add(bookItem);
			}
			reader.close();
			fr.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<Book> getmBookList() {
		return mBookList;
	}
	
	public static void setmBookList(ArrayList<Book> mBookList) {
		BookInit.mBookList = mBookList;
	}
	
	public static int getmTotalBook() {
		return mTotalBook;
	}
	
	public static void setmTotalBook(int mTotalBook) {
		BookInit.mTotalBook = mTotalBook;
	}
}
