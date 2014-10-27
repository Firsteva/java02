/* finally 블럭
 - try 블럭에서 예외가 발생하든 안하든 반드시 수행하는 블럭
 - try 블럭에서 생성한 자원을 해제하는 코드를 finally에 둔다.      
 */
package test01;

import java.util.Scanner;

public class Exception08 {
  static int a;
  static int b;
  static String op;
  
  static class Calculator {
    public static int compute(int a, int b, String op) 
        /*throws Exception*/ { 
      switch (op) {
      case "+": return a + b;
      case "-": return a - b;
      default: 
        throw new RuntimeException("지원하지 않는 연산자입니다.");
      }
    }
  }
  
  public static void printResult() /*throws Exception*/ {
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("결과는 = " + Calculator.compute(a, b, op));
  }
  
  public static void printContent() /*throws Exception*/ {
    System.out.println("******************");
    printResult();
    System.out.println("******************");
  }
  
  // 이렇게 일반 메서드 호출하듯이 printContent()를 호출할 수 있다.
  // throws절 생략가능! => 코드가 간결해짐.
  public static void printPage() /*throws Exception*/ {
    System.out.println("머리말 정보....");
    printContent();
    System.out.println("꼬리말 정보....");
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("a=");
    a = Integer.parseInt(scanner.nextLine());
    
    System.out.print("b=");
    b = Integer.parseInt(scanner.nextLine());
    
    System.out.print("연산자=");
    op = scanner.nextLine();
    
    try {
      printPage();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
    	System.out.println("오호라..finally");
    }
  }
}
















