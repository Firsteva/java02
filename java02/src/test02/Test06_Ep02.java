/* 재귀 호출의 이해
 - 
 */

package test02;

public class Test06_Ep02 {
	// Quiz : 1부터 50까지 더하라

	public static void main(String[] args) {
		System.out.println(displayNo(100));
	}
	public static int displayNo(int no){
		if(no==1)
			return no;
		return no+displayNo(no-1);
	}
}