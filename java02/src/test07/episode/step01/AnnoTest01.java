package test07.episode.step01;

import java.lang.annotation.Annotation;

public class AnnoTest01 {
	// Class 관리자를 통해 특정 애노테이션 객체만 추출하기.
	public static void main(String[] args) {
		Class clazz=MyObject.class;

		MyAnnotation myAnno=
				(MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
		System.out.println(myAnno.value());
	}
	
	// Class 객체를 얻는 또다른 방법
	// JVM은 클래스를 로딩할 때, 자동으로 'class'라는 이름의 static변수를 만들어둔다.
	// 이 변수에는 로딩된 클래스를 다루는 'class 객체' 주소가 들어있다.
	public static void main02(String[] args) {
		// 클래스 로딩방법1 : 인스턴스를 통해 얻기
		// MyObject obj=new MyObject();
		// Class clazz=obj.getClass();
		
		// 클래스 로딩방법2 : Class.forName() 통해 얻기
		// Class clazz=Class.forName("test07.episode.MyObject");
		
		// 클래스 로딩방법3 : 클래스의 스태틱 변수를 통해 얻기
		Class clazz=MyObject.class;
		
		// 모든 애노테이션은 java.lang.annotation.Annotation 인터페이스를
		// 자동으로 구현한다.
		// 따라서 우리가 만든 MyAnnotation도 이 인터페이스를 구현한다.
		Annotation[] annos=clazz.getAnnotations();
		for(Annotation anno:annos){
			System.out.println(anno.toString());
		}
		
		MyAnnotation myAnno=(MyAnnotation)annos[0];
		System.out.println(myAnno.value());
	}
}