/* 대기열 설정하기
 - 서버에서 클라이언트 여결을 받아들일 수 있는 갯수를 지정
 */

package test11.exam02;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println("서버 소켓 생성");
		
		// 두번째 backlog값은 대기열 길이를 지정한다.
		ServerSocket ss=new ServerSocket(8888,2);
		
		System.out.println("클라이언트의 연결을 기다리는 중입니다.");
		Socket socket=ss.accept();
		System.out.println("대기중에 있는 클라이언트와 연결 됨");
		
		Scanner in=new Scanner(socket.getInputStream());
		PrintStream out=new PrintStream(socket.getOutputStream());
		
		String line=in.nextLine();
		
		if(line!=null){System.out.println("클라이언트로부터의 메세지 : "+line);
		} else {
			return;
		}
			
		String message=prompt();
		
		out.println(message);
		
		in.close();
		out.close();
		socket.close();
		ss.close();
	}

	private static String prompt() {
		System.out.println("메세지 입력 > ");
		Scanner keyboard=new Scanner(System.in);
		String message=keyboard.nextLine();
		keyboard.close();
		return message;
	}
}