package test11.exam08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {

	private static final long serialVersionUID = 1L;

	TextField serverAddr=new TextField(20);
	TextField name=new TextField(10);
	Button connectBtn=new Button("연결");
	TextArea content=new TextArea();
	TextField input=new TextField(30);
	Button sendBtn=new Button("보내기");
	public ChatClient(){
		// 윈도우 준비
		Panel toolbar=new Panel(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(new Label("이름 : "));
		toolbar.add(name);
		toolbar.add(new Label("서버 : "));
		toolbar.add(serverAddr);
		toolbar.add(connectBtn);

		this.add(toolbar,BorderLayout.NORTH);
		this.add(content,BorderLayout.CENTER);

		Panel bottom=new Panel();
		bottom.add(input);
		bottom.add(sendBtn);

		this.add(bottom,BorderLayout.SOUTH);

		// 리스너 등록
		// 윈도우 이벤트를 처리할 리스너 객체 등록
		// WindowListener 인터페이스를 구현한 객체여야 한다.
		this.addWindowListener(new MyWindowListener());
		
		// ActionEvent는 버튼을 눌렀을 때 발생하는 이벤트이다.
		// connectBtn.addActionListener(new MyConnectListener());
		
		// 실무에서는 한번밖에 안쓸 객체라면 inner클래스로 정의한다. => 가독성 향상
		connectBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("연결 버튼 pushed");
			}	
		});
		sendBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Send 버튼 pushed");
			}
		});
	}

	public static void main(String[] args) {

		ChatClient wnd=new ChatClient();
		wnd.setSize(400,600);
		wnd.setVisible(true);
	}
	
	// WindowListener를 직접 구현하지 말고,
	// 미리 구현한 WindowAdapter를 상속받아라.
	class MyWindowListener extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);;
		}	
	}
}