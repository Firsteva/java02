package test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) {
		FileInputStream in = null;
		try{
			// 1. 입력 스트림 객체를 준비한다.
			// 현재 파일의 위치는 프로젝트 디렉토리이다.
			in = new FileInputStream("img1.jpg");

			int count=0;
			int b;
			// 2. read()를 통해 1바이트 읽기
			// 리턴타입이 int라해서 4바이트를 읽는것은 아니다.
			while((b=in.read())!=-1){
				count++;
			}
			// read() 중에 오류가 발생하면 close()를 호출도 못한다.
			// 그래서 자원을 해제하는 명령은 finally 에 두도록 하라.
			// 3. file이나 Database, Socket등의 자원은 사용한 다음
			// 	   명시적으로 해제해야만 한다. 
			// in.close();
			System.out.println("파일크기 : "+count+"바이트입니다.");
		} catch(FileNotFoundException ex) {
			System.out.println("img1.jpg 파일을 찾을 수 없습니다.");
		} catch(IOException ex) {
			System.out.println("읽기 오류!");
		} finally {
			// close()하다가 예외발생 시 아무것도 안한다.
			try{in.close();} catch(IOException ex){}
		}
	}
}
