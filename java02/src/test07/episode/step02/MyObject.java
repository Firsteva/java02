package test07.episode.step02;

// 오류 발생
// default값이 설정되지 않은 속성은 필수입력 항목이다.
// 2개 이상의 속성을 설정할 때는 value 이름을 생략할 수 없다.
@MyAnnotation(
		value="okok",
		age = 30,
		// language = { "korean", "english" },
		// 배열에 값을 하나만 넣을 때는 중괄호를 생략할 수 있다.
		language = "korean",
		name = "홍길동"
		)
public class MyObject {
	
}
