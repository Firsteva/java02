/* 문자 데이터 출력
*/

package test02;

import java.io.FileWriter;
import java.io.IOException;

public class Test10 {
	public static void main(String[] args) throws IOException {
		FileWriter out=new FileWriter("test03.txt");
		char[] str={'A','B','C','가','각','간'};
		for(char c : str){
			out.write(c);
		}
		out.close();
	}
}