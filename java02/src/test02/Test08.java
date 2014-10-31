/* 문자 데이터 읽어오기
 - FileReader
 - 텍스트 파일을 문자 스트림 객체를 사용하여 읽기
 - read() : 한 '문자' 단위로 읽는다. => 리턴 값은 '유니코드'이다.
 	* 한 문자 => 알파벳(1), 한글(3), ...
*/

package test02;

import java.io.FileReader;
import java.io.IOException;

public class Test08 {
	public static void main(String[] args) throws IOException {
		FileReader in=new FileReader("test01.txt");
		int b=-1;
		while((b=in.read())!=-1){
			System.out.println(Integer.toHexString(b));
		}
		in.close();
	}
}