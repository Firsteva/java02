/* 클라이언트와 여러번 데이터 주고받기 */

package test11.exam03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	static Scanner keyboard=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("서버 소켓 생성");

		ServerSocket ss=new ServerSocket(8888,2);

		System.out.println("클라이언트의 연결을 기다리는 중입니다.");
		Socket socket=ss.accept();
		System.out.println("대기중에 있는 클라이언트와 연결 됨");

		Scanner in=new Scanner(socket.getInputStream());
		PrintStream out=new PrintStream(socket.getOutputStream());

		while(true){
			String line=in.nextLine();
			System.out.println("클라이언트로부터의 메세지 : "+line);
			if(line.equalsIgnoreCase("quit")){
				out.println("さようなら");
				break;
			}
			String message=prompt();
			out.println(message);
		}
		in.close();
		out.close();
		socket.close();
		ss.close();
		keyboard.close();
	}

	private static String prompt() {
		System.out.println("메세지 입력 > ");
		String message=keyboard.nextLine();
		return message;
	}
}