package step25;

/* MyAnnotation2 테스트
 * 
 */

// value 속성과 name 속성은 기본 값이 있기 때문에 생략 가능하다.
//@MyAnnotation2
//@MyAnnotation2() // 빈 괄호를 쳐도 된다.

// "value" 이름의 속성은 값을 지정할 때 이름을 생략할 수 있다.
//@MyAnnotation2(value="okok") //OK
//@MyAnnotation2("okok") //OK

// 단 두 개 이상의 속성 값을 설정할 때는 value 이름을 생략할 수 없다.
//@MyAnnotation2("okok", name="홍길동") //Error
//@MyAnnotation2(value="okok", name="홍길동")

// 속성의 값을 지정할 때 순서는 상관없다.
@MyAnnotation2(name="홍길동", value="okok") // OK
public class MyObject2 {

}








