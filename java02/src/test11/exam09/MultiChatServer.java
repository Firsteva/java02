package test11.exam09;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MultiChatServer {
	ServerSocket serverSocket;
	HashMap<Integer, PrintStream> outputMap=new HashMap<>();

	class ChatListener extends Thread {
		int id;
		Scanner in;
		MultiChatServer server;

		public ChatListener(int id, Scanner in, MultiChatServer server) {
			this.id=id;
			this.in=in;
			this.server=server;
		}

		@Override
		public void run() {
			try{
				String message;
				while(true){
					message=in.nextLine();
					server.send(message);
				}
			}catch(Exception e){
				server.invalidate(id);
			}
		}
	}

	public void service() throws Exception {
		serverSocket = new ServerSocket(8888);

		Socket socket=null;
		Scanner in=null;
		PrintStream out=null;
		int count=0;
		
		while (true){
			
			try{
				socket=serverSocket.accept();
				in=new Scanner(socket.getInputStream());
				out=new PrintStream(socket.getOutputStream());
				
				count++;
				
				// 출력 스트림 보관 => 나중에 출력할 때 쓸 것이다.
				outputMap.put(count,out);
				
				// 입력 스트림은 리스너에게 맡긴다.
				new ChatListener(count, in, this).start();
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}


	public void invalidate(int id) {
		outputMap.remove(id);
	}

	synchronized public void send(String message) {
		Set<Entry<Integer,PrintStream>> entryset=outputMap.entrySet();
		outputMap.keySet();
		for(Entry<Integer,PrintStream> entry : entryset){
			try {
				entry.getValue().println(message);
				
			} catch(Exception e){
				outputMap.remove(entry.getKey());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		MultiChatServer server=new MultiChatServer();
		server.service();
	}
}
