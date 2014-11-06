/* 크리티컬 섹션을 동기화처리하기
 => 여러 쓰레드가 크리티컬 섹션 부분을 실행하더라도 문제없게 만들기
 => 한번에 하나의 쓰레드만 접근하게 만듬
 
 방법 :
 	1) 어떤 쓰레드가 크리티컬 섹션에 진입하면 잠근다.(lock)
 	2) 쓰레드가 일을 마치고 나올 때 잠금을 해제한다.
 문법 :
 	크리티컬 섹션 블럭에 synchronized를 붙인다.
 	예) synchronized void m(){}
 	예) synchronized(객체){}
 	
 뮤텍스(Mutex)
 => 한번에 하나의 쓰레드만이 크리티컬 섹션에 접근하는 방식
 * 여러 쓰레드가 진입하더라도 계산에 영향을 미치지 않는 코드블럭.
 => 변수를 공유하지 않는다. 즉, 로컬 변수만 사용한다.
 => Thread safe(쓰레드에 안전하다)
 => 동기화 처리를 할 필요가 없다.
 
 세마포(Semaphore)
 => 크리티컬 섹션에 진입할 수 있는 쓰레드 수 지정
 */

package test12;

public class Test05 {
	static class Account {
		long balance;

		public Account(int balance) {
			this.balance=balance;
		}

		private long delay(){ // 그냥 딜레이 주는 코드
			long l=10L;
			double b=3.15;
			b = b / l;
			b+=System.currentTimeMillis();
			return (long)(b/34.56);
		}

		synchronized public long withDraw(long money) {
			long temp=this.balance;		delay();
			temp=temp-money; 						delay();
			if(temp>=0){ 								delay();
			this.balance=temp; 	 				delay();
			return money;
			} else {delay();
			return 0;
			}
		}
	}

	static class ATM extends Thread {
		Account account;

		public ATM(String name, Account account) {
			this.setName(name);
			this.account=account;
		}

		@Override
		public void run() {
			long sum=0;
			for(int i=0;i<10000;i++) {
				if(account.withDraw(100)!=0){
					sum+=100;
				} else break;
			}
			System.out.println(this.getName()+" : "+sum+"원 출금했습니다.");
		}
	}

	public static void main(String[] args) {
		Account account=new Account(1000000);
		ATM a1=new ATM("강남",account);
		ATM a2=new ATM("양재",account);
		ATM a3=new ATM("종로",account);
		ATM a4=new ATM("부산",account);
		ATM a5=new ATM("광주",account);
		ATM a6=new ATM("강릉",account);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		a6.start();
	}
}
