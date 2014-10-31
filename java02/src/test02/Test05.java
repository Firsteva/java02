/* File 기본 사용
 - 
*/

package test02;

import java.io.File;

// /home/bit/git/java02/java02
public class Test05 {
	public static void main(String[] args) throws Exception {
		File f=new File("../../java02/java02");
		
		System.out.println(f.getAbsolutePath());
		// 결과 : /home/bit/git/java02/java02/../../java02/java02
		
		System.out.println(f.getCanonicalPath());
		// 결과 : /home/bit/git/java02/java02
		
		System.out.println(f.getPath());
		// 결과 : ../../java02/java02
		
		System.out.println(f.getName());
		// 결과 : java02
		
		System.out.println(f.getParent());
		// 결과 : ../../java02
	}
}