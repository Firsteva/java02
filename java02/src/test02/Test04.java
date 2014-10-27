/* Quiz
 - Test04 원본파일명 출력할경로명
 - 출력할 파일명이 다음과 같은 경우,
 	예) Test04 img1.jpg aaa
 	aaa 폴더를 먼저 생성하고, 그 폴더 아래에 읽어들인 파일을 출력한다.
*/

package test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test04 {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try{
			in = new FileInputStream(args[0]);
			String name=args[0];
			String outName1 = name.substring(0, name.lastIndexOf('.'));
			String outName2 = name.substring(name.lastIndexOf('.')+1);
			out = new FileOutputStream(outName1+"-1."+outName2);
			int b;
			while((b=in.read())!=-1){
				out.write(b);
			}
		} catch(FileNotFoundException ex) {
			System.out.println("img1.jpg 파일을 찾을 수 없습니다.");
		} catch(IOException ex) {
			System.out.println("읽기 오류!");
		} finally {
			try{in.close();out.close();} catch(IOException ex){}
		}
	}
}