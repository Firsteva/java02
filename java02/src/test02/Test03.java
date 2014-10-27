/* Quiz
 - 예외처리 강화
	파일을 읽을 때,
	1) 파일이 존재하지 않으면, 다음 문장 출력
		xxxx.xxx 파일이 존재하지 않습니다.
	2) 디렉토리라면
		xxxx.xxx 는 파일이 아닌 디렉토리입니다.
	파일을 쓸 때,
	1) 파일이 이미 존재한다면,
		xxxx.xxx 파일이 이미 존재합니다. 덮어 쓰시겠습니까? (Y/N) y or n
		y : xxxx.xxx 파일을 출력하였습니다.
		n : 작업이 취소되었습니다.
	2) 파일이 존재하지 않는다면,
		xxxx.xxx 파일을 출력하였습니다.
 */

package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		String name=args[0];
		File inF=new File(name);

		if(inF.isDirectory()) { // 파일명이 아닌 디렉토리인 경우
			System.out.println(name+" 은(는) 파일이 아닌 디렉토리입니다.");
		} else if(inF.isFile()) {
			FileInputStream in = null;
			FileOutputStream out = null;
			
			// 파일 이름
			String outName1 = name.substring(0, name.lastIndexOf('.'));
			// 확장자
			String outName2 = name.substring(name.lastIndexOf('.')+1);
			// 중복이름일시 저장할 파일이름
			String outName3 = outName1+"-1."+outName2;

			try{
				in = new FileInputStream(args[0]);
				out = new FileOutputStream(outName3);
				
				File outF=new File(outName3); // 
				
				int bR;
				
				if (outF.isFile()) {
					System.out.println(outF+
							"파일이 이미 존재합니다. 덮어쓰시겠습니까? (Y/N)");
					Scanner scan=new Scanner(System.in);
					String ans=scan.next();
					if(ans.equalsIgnoreCase("n"))
						System.out.println("취소되었습니다.");
					else if(ans.equalsIgnoreCase("y")){
						while((bR=in.read())!=-1){
							out.write(bR);
						}
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				} else {
					while((bR=in.read())!=-1){
						out.write(bR);
					}	
				}
			} catch(IOException ex) {
				System.out.println("입력 오류");
			} finally {
				try{in.close();out.close();} catch(IOException ex){}
			}
		} else {
			System.out.println(name+"파일이 존재하지 않습니다.");
		}
	} 
}
