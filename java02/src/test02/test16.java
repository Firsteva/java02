/* buffer의 사용
 - 한 바이트씩 데이터를 읽는 것보다 여러 바이트를 한꺼번에 읽는 것이
 		속도가 더 빠르다.
 - 이유 :
 		데이터 읽기 속도 = Data Seek Time + Data Access Time
 		예) 퀀텀 하드
 		Data Seek Time(데이터 위치를 찾는 시간) : 4.2ms => 0.0042초
 		Data Transfer Time(데이터 전송시간) : 3Gb / Sec => 0.000003초 / 1byte
 		
 		1byte 읽기 시간 = 0.0042초 + 0.000003초 = 0.004203초
 		100byte = 0.4203초
 		
 		한번 찾았을 때 100바이트 읽기 = 0.0042초 + (0.0003 * 100)초 = 0.0045초
 		
 		메모리(10ns) = 0.00000001초
 		
 */

package test02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class test16 {
	// BufferdInputStream
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test.pdf");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		int b=0;
		long start = System.currentTimeMillis();
		while((b=in2.read())!=-1){} // 1바이트씩 읽기
		long end = System.currentTimeMillis();
		
		System.out.println(end-start+"/1000초"); // 0.155초
		in.close();
	}
	// 버퍼 사용 후
	public static void main01(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test.pdf");
		
		byte[] buf=new byte[1024]; // 1024바이트씩 읽기
		int len=0;
		long start = System.currentTimeMillis();
		while((len=in.read(buf))!=-1){}
		long end = System.currentTimeMillis();
		
		System.out.println(end-start+"/1000초"); // 0.005초
		in.close();
	}
	// 버퍼 사용 전
	public static void main02(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test.pdf");
		
		int b;
		long start = System.currentTimeMillis();
		while((b=in.read())!=-1){} // 1바이트씩 읽기
		long end = System.currentTimeMillis();
		
		System.out.println(end-start+"/1000초"); // 3214초
		in.close();
	}
}
