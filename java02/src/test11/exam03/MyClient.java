// 서버와 여러번 데이터 전송

package test11.exam03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	static Scanner keyboard=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("서버에 연결중입니다.");
		Socket socket=new Socket("192.168.0.67",8888);
		System.out.println("서버와 연결되었습니다.");

		Scanner in=new Scanner(socket.getInputStream());
		PrintStream out=new PrintStream(socket.getOutputStream());

		String message=null;
		String line=null;
		
		while(true){		
			message=prompt();
			out.println(message);
			line=in.nextLine();
			System.out.println("서버로부터의 메세지 : "+line);
			if(line.equalsIgnoreCase("さようなら")){
				System.out.println("서버와의 연결이 해제되었습니다.");
				break;
			}
		}
		
		in.close();
		out.close();
		socket.close();
		keyboard.close();
	}
	private static String prompt() {
		System.out.print("메세지 입력 > ");
		String message=keyboard.nextLine();
		return message;
	}
}
