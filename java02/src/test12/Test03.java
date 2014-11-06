/* 특정 명령어 블럭을 Thread로 분리하기
 1) Thread 클래스를 상속받아 만들기
 2) Runnable 인터페이스를 구현하기 
 */
package test12;

import java.util.Date;

public class Test03 {
	static class MyAlarm implements Runnable{

		@Override
		public void run() {
			int count=0;
			while(true){
				if(count++>10)break;
				Date today=new Date();
				System.out.println("\n"+today);
				try{Thread.currentThread().sleep(1000);}
				catch(Exception ex){}
			}
		}
	}
	public static void main(String[] args) {
		new Thread(new MyAlarm()).start();
		for(int i=0;i<100000000;i++){
			double d1=3.14159;
			double d2=123.456;
			d1=d1/d2;
			if((i%10000)==0)System.out.println(".");
		}
	}
}