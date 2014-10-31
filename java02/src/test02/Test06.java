/* File을 사용하여 디렉토리 안의 파일목록을 출력한다.
 - 
*/

package test02;

import java.io.File;

// /home/bit/git/java02/java02
public class Test06 {
	public static void main(String[] args) throws Exception {
		displayList(".");
	}
	public static void displayList(String filename){
		System.out.println(filename);
		
		File f=new File(filename);
		if(f.isDirectory()){
			String[] files=f.list();
			for(String name : files){
				displayList(f.getPath()+"/"+name);
			}
		}	else {
			
		}
	}
}