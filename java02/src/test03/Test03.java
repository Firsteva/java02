package test03;

import java.util.Scanner;

public class Test03 {
	static Scanner scanner;
	public static void main(String[] args) {
		scanner=new Scanner(System.in);
		Loop:
			while(true){
				String[] token = promptCommand();

				switch(token[0]){
				case "help" :
					System.out.println("list");
					System.out.println("view 인덱스");
					System.out.println("add 이름 국어 영어 수학");
					System.out.println("delete 인덱스");
					System.out.println("update 인덱스");
					System.out.println("exit");
				break;
				case "add" :
					System.out.println("저장하였습니다.");
					break;
				case "list" :
					System.out.println("목록");
					break;
				case "view" :
					System.out.println("상세정보");
					break;
				case "delete" :
					System.out.println("삭제하였습니다.");
					break;
				case "update" :
					System.out.println("변경하였습니다.");
					break;
				case "exit" :
					System.out.println("파일에 저장하였습니다.");
					break Loop;
				default :
					System.out.println("이 명령어를 지원하지 않습니다.");
				}
				scanner.close();
			}
	}

	private static String[] promptCommand() {
		System.out.println("명령> ");

		String[] token=scanner.nextLine().split(" ");
		return token;
	}
}