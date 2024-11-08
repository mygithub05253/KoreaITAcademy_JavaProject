package Contact_Management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class project_code {
	
	static String fname = "C://Java_Project1//Project01/juso.txt";
	
	static class address {
		String name;
		String age;
		String phone;
		
		address(String s1, String s2, String s3) {
			this.name = s1;
			this.age = s2;
			this.phone = s3;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String select = "";
		System.out.printf(" \n### 친구 연락처 관리 ### \n");
		
		while(select != "4") {
			print_menu();
			select = scanner.next();
			
			switch(select) {
			case "1":
				view_juso();
				break;
			case "2":
				add_juso();
				break;
			case "3":
				delete_juso();
				break;
			case "4":
				return;
			default:
				System.out.printf("\n 잘못 입력했어요. 다시 선택하세요.\n");
			}
		}
	}
	
	// 처음에 사용자의 선택을 위한 메뉴 출력
	static void print_menu() {
		System.out.printf("\n");
		System.out.printf("1. 연락처 출력 \n");
		System.out.printf("2. 연락처 등록 \n");
		System.out.printf("3. 연락처 삭제 \n");
		System.out.printf("4. 끝내기 \n");
	}
	
	// 연락처 파일에서 기존에 입력된 내용을 읽어서 출력
	static void view_juso() throws IOException {
		String str = "";
		
		// 처음에 fname 파일이 없으면 빈 파일 생성
		File file = new File(fname);
		if(!file.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
			bw.close();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(fname));
		int i;
		
		// 기존의 연락처를 모두 읽어서 출력
		// i는 계속 1씩 증가하는 무한 루프
		for(i = 1; ; i++) {
			// 파일을 읽을 수 없는 경우
			if(!br.ready()) {
				break;
			} else {
				str = br.readLine();
				System.out.printf("%2d : %s\n", i, str);
			}
		}
		
		// i가 1이면 실제 파일에는 내용이 없음
		if(i == 1) {
			System.out.printf("\n ** 연락처 파일에 전화번호가 하나도 없어요. **\n");
		}
		
		br.close();
	}
	
	// 친구의 연락처를 추가
	static void add_juso() throws IOException {
		Scanner scanner = new Scanner(System.in);
		address adr = new address("", "", "");
		
		String wstr = "";
		
		// 파일을 추가 모드로 열기
		BufferedWriter bw = new BufferedWriter(new FileWriter(fname, true));
		
		System.out.print("이름을 입력 : ");
		adr.name = scanner.nextLine();
		System.out.print("나이를 입력 : ");
		adr.age = scanner.nextLine();
		System.out.print("전화번호를 입력 : ");
		adr.phone = scanner.nextLine();
		
		// 입력된 3개의 값을 하나의 문자열로 만들기
		wstr = adr.name + "\t" + adr.age + "\t" + adr.phone;
		
		// 파일에 문자열 쓰기
		bw.write(wstr);
		bw.newLine();
		
		bw.close();
	}
	
	// 연락처 파일에서 선택한 연락처를 제거
	static void delete_juso() throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		// 연락처 파일의 내용 전체를 저장하기 위한 문자열 배열
		// 최대 연락처 개수 => 50개 가정
		String[] read_str = new String[50];
		String str = "";
		int del_line, i, count = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(fname));
		
		// 연락처 파일이 없는 경우 돌아감
		if(!br.ready()) {
			System.out.printf("\n!! 연락처 파일이 없습니다. !!\n");
			return;
		}
		
		System.out.print("\n 삭제할 행 번호는 ? ");
		del_line = scanner.nextInt();
		
		// 파일에 있는 동안에 반복 수행, 단 최대 50번 수행
		for(i = 0; i < 50; i++) {
			if((str = br.readLine()) == null) {
				break;
			}
			
			// 삭제하는 행이 아닐 경우 추가
			if(i + 1 != del_line) {
				read_str[count] = str;
				count++;
			} else {
				System.out.printf("%d 행이 삭제되었습니다. \n", del_line);
			}
			
			br.close();
			
			// 파일을 쓰기 모드로 열고 새로운 내용 작성
			BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
			
			for(i = 0; i < count; i++) {
				bw.write(read_str[i]);
				bw.newLine();
			}
			
			bw.close();
		}
	}

}
