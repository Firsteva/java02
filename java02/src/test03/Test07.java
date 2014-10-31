package test03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test07 {
	
	static Scanner scanner;
	static ArrayList<Score> list = new ArrayList<Score>();
	
	static class Score implements Serializable {
		
		private static final long serialVersionUID = 1L;
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;

		public Score(){}
		
		public Score(String name,int kor,int eng,int math){
			this.name=name;
			this.kor=kor;
			this.eng=eng;
			this.math=math;
		}
	}
	
	public static void main(String[] args) {
		scanner=new Scanner(System.in);
		Loop:
			while(true){
				try{
					String[] token = promptCommand();

					switch(token[0]){
					case "help" :
						doHelp();
						break;
					case "add" :
						doAdd(token);
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
				} catch (Exception e) {
					//e.printStackTrace(); 개발하는동안만
					System.out.println("올바르지 않은 입력입니다.");
				}
			}
		scanner.close();
	}


	private static void doHelp() {
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");
	}


	private static void doAdd(String[] token) {
		Score score=new Score(token[1],
				Integer.parseInt(token[2]),
				Integer.parseInt(token[3]),
				Integer.parseInt(token[4]));
		list.add(score);
		System.out.println("이름 : "+score.name);
		System.out.println("국어 : "+score.kor);
		System.out.println("영어 : "+score.eng);
		System.out.println("수학 : "+score.math);
		System.out.println("저장하였습니다.");
	}


	private static String[] promptCommand() {
		System.out.print("명령> ");

		String[] token=scanner.nextLine().split(" ");
		return token;
	}
}