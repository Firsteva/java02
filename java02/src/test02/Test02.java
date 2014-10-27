/* Quiz
 - 파일을 복제하는 기능을 구현하시오.
 - $ Test02 /home/bit/javaide/workspace/java02/img1.jpg(엔터)
   => img1.jpg 파일을 복제하여 img1_1.jpg
   
 - 힌트 : 출력은 FileOutputStram 클래스를 사용하라.
*/

package test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test02 {
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