/* 바이너리 데이터를 읽어오기
 - FileInputStream
 - 텍스트 파일을 바이너리 스트림 객체를 사용하여 읽기
 - read() : 1바이트씩 읽는다.
*/

package test02;

import java.io.FileInputStream;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) throws IOException {
		FileInputStream in=new FileInputStream("test01.txt");
		int b=-1;
		while((b=in.read())!=-1){
			System.out.println(Integer.toHexString(b));
		}
		in.close();
	}
}