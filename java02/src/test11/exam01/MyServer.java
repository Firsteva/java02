/* ServerSocket 사용법
 * 
*/
package test11.exam01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws Exception {
		// 클라이언트와 통신을 담당할 객체 생성
		System.out.println("서버 소켓 생성");
		ServerSocket ss=new ServerSocket(8888);
		
		// 연결대기중인 클라이언트중 하나 선택하기
		// => 선택한 클라이언트와의 통신을 담당할 Socket 객체를 리턴
		System.out.println("클라이언트의 연결을 기다리는 중입니다.");
		Socket socket=ss.accept();
		System.out.println("대기중에 있는 클라이언트와 연결 됨");
		
		// 소켓을 통해 읽고 쓰기 위한 I/O 스트림 얻기
		Scanner in=new Scanner(socket.getInputStream());
		PrintStream out=new PrintStream(socket.getOutputStream());
		
		// 클라이언트가 보낸 문자열 읽기
		// 클라이언트에서 한줄의 문자열을 보내기 전까지 리턴하지 않는다.
		// 실행이 완료될 때까지 리턴하지 않는다. == blocking
		String line=in.nextLine();
		
		// 클라이언트가 보낸 메세지를 출력
		System.out.println(line);
		
		// 사용자에게서 문자열을 한줄 입력받는다. 
		String message=prompt();
		
		// 클라이언트로 보낸다.
		// 클라이언트에서 문자열을 모두 받을 때까지 리턴하지 않는다. == blocking
		// 입출력은 항상 blocking으로 다룬다. 
		// 단점 해결 ==> Java non-blocking API 등장
		out.println(message);
		
		in.close();
		out.close();
		socket.close();
		ss.close();
	}

	private static String prompt() {
		System.out.println(">");
		Scanner keyboard=new Scanner(System.in);
		String message=keyboard.nextLine();
		keyboard.close();
		return message;
	}
}
