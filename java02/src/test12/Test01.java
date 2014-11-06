/* JVM이 기본으로 생성하는 쓰레드 조사 */
package test12;

public class Test01 {
	public static void main(String[] args) {
		// 현재 이 명령을 수행하는 쓰레드 알아내기
		Thread t = Thread.currentThread();
		System.out.println("1) main() 호출 쓰레드 : "+t.getName());
		
		// main 쓰레드가 소속되어있는 쓰레드그룹 알아내기
		ThreadGroup g=t.getThreadGroup();
		System.out.println("2) main쓰레드가 소속된 그룹 : "+t.getName());
		
		// main 쓰레드그룹의 상위그룹 알아내기
		ThreadGroup parent=g.getParent();
		System.out.println("3) main TG의 상위그룹 : "+parent.getName());
		
		// system TG의 상위그룹 알아내기
		// system TG가 최상위 그룹이다.
		
		/*parent=parent.getParent();
		System.out.println("4) system TG의 상위그룹 : "+parent.getName());*/
		
		// 6574-4723
		browseThreadInfo(parent,0);
		
	}
	
	public static void browseThreadInfo(ThreadGroup tg, int level){
		displaySpaces(level);
		System.out.println("└──▶["+tg.getName()+"]");
		
		ThreadGroup[] groups=new ThreadGroup[10];
		int groupCount=0;
		
		groupCount=tg.enumerate(groups, false);
		for(int i=0;i<groupCount;i++){
			displaySpaces(level+1);
			browseThreadInfo(groups[i],level+1);
		}
		
		Thread[] threads=new Thread[10];
		int threadCount=0;
		
		// 하위쓰레드 알아내기
		threadCount=tg.enumerate(threads, false);
		for(int i=0;i<threadCount;i++){
			displaySpaces(level+2);
			System.out.println("  └──▶"+threads[i].getName());
		}
	}
	
	public static void displaySpaces(int count){
		for(int i=0;i<count;i++)System.out.println("  ");
	}
}
