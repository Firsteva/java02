package test03;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Loop:
			while(true){
				System.out.println("명령> ");

				String[] token=scanner.nextLine().split(" ");

				switch(token[0]){
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
				case "help" :
					System.out.println("명령어");
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
}