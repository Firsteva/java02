/* 애노테이션 사용
 - 애노테이션이란? 컴파일러나 JVM에게 전달하는 주석
 
 1. 애노테이션 정의
- MyAnnotation 생성
 2. 애노테이션 적용
 - 홍길동 값 입력
 3. 애노테이션 추출
 
 */

package test07.episode.step02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 애노테이션의 속성 선언 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String value();
	String name();
	
	// 값을 설정하지 않아도 기본으로 갖는 값 = 선택 속성
	String country() default "korea";
	
	int age();
	
	String[] language();
}
