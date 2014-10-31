/* 명령을 처리하는 메서드를 별도의 클래스 분리 => Command 패턴
 - 새로 명령어를 추가하더라도 기존 코드를 손대지 않고 
   명령을 처리할 수 있게 하자!
 - 명령어를 처리하는 메서드를 클래스로 만든다.
 - 클래스는 외부 파일이기 때문에 추가하기 쉽다.
 */
package test06;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Test01 {
	static Scanner scanner; 
	static ScoreDao scoreDao;
	static HashMap<String,Command> commandMap = new HashMap<String,Command>();

	public void init() throws Exception {
		commandMap =new HashMap<String,Command>();
		Properties props=new Properties();
		props.load(new FileReader("application-context.properties"));
		Set keySet = props.keySet();

		String classname=null;
		Class clazz=null;
		Command command=null;

		for(Object key:keySet){
			classname = (String)props.get(key);
			clazz=Class.forName(classname.trim());
			command=(Command)clazz.newInstance();
			commandMap.put((String)key, command);
			scoreDao = new ScoreDao();
			try {
				scoreDao.load();
			} catch (Exception e) {
				System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
			}
			scanner = new Scanner(System.in);
		}
	}
	
	public void service() {
		Command command = null;
		loop: 
			while (true) {
				try {
					String[] token = promptCommand();
					command = commandMap.get(token[0]);

					if (command == null) {
						System.out.println("해당 명령을 지원하지 않습니다.");
						continue;
					}

					HashMap<String,Object> params = 
							new HashMap<String,Object>();
					params.put("scoreDao", scoreDao);
					params.put("scanner", scanner);

					ArrayList<String> options = new ArrayList<String>();
					for (int i = 1; i < token.length; i++) {
						options.add(token[i]);
					}
					params.put("options", options);

					command.service(params);

					if (token[0].equals("exit"))
						break loop;

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
				}
			}
	}
	
	public void destroy(){
		scanner.close();
	}

	private String[] promptCommand() {
		System.out.print("명령>");
		String[] token = scanner.nextLine().split(" ");
		return token;
	}

	public static void main(String[] args) throws Exception {
		Test01 app=new Test01();
		app.init();
		app.service();
		app.destroy();
	}
}







