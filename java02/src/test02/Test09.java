/* 바이너리 데이터 출력
*/

package test02;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test09 {
	public static void main(String[] args) throws IOException {
		FileOutputStream out=new FileOutputStream("test02.txt");
		char[] str={'A','B','C','가','각','간'};
		for(char c : str){
			out.write(c);
		}
		out.close();
	}
}