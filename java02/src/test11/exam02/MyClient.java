package test11.exam02;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) throws Exception {
		System.out.println("서버에 연결중입니다.");
		Socket socket=new Socket("192.168.0.67",8888);
		System.out.println("서버와 연결되었습니다.");
		
		Scanner in=new Scanner(socket.getInputStream());
		PrintStream out=new PrintStream(socket.getOutputStream());
		
		String message=prompt();
		out.println(message);
		
		String line=in.nextLine();
		
		System.out.println("서버로부터의 메세지 : "+line);
		
		in.close();
		out.close();
		socket.close();
	}
	private static String prompt() {
		System.out.print("메세지 입력 > ");
		Scanner keyboard=new Scanner(System.in);
		String message=keyboard.nextLine();
		keyboard.close();
		return message;
	}
}
