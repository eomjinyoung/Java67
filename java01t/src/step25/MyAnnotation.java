package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 애노테이션 정의
 * - 애노테이션을 정의할 때 유지 정책을 반드시 설정해야 한다.
 * 
 * RetentionPolicy
 * - SOURCE : 컴파일할 때 버린다.
 * - CLASS : .class 파일에 주석을 유지한다. 실행할 때 읽을 수 없다. 
 *           유지 정책을 지정하지 않으면 이 설정을 기본으로 사용한다.
 * - RUNTIME : .class 파일에 주석을 유지한다. 
 *             실행할 때 Reflection API를 사용하여 읽을 수 있다.
 *             
 * 애노테이션 속성
 * - 문법
 *   타입 속성명() default 기본값;
 *
 * - 기본 값이 없는 속성 : 필수 속성이다. 생략하면 안된다.
 *   예) String name();
 *   
 * - 기본 값이 있는 속성 : 생략해도 된다.
 *   예) String name() default "홍길동";            
 */

@Retention(RetentionPolicy.RUNTIME) // 실행 중에 이 애노테이션 값을 읽을 수 있도록 설정한다.
public @interface MyAnnotation {
  String name();  // default가 없으면 필수 속성이다. 
                  // 속성 값을 설정하지 않으면 컴파일 오류가 발생한다.
  String email() default "test@test.com"; // default가 있기 때문에 선택 사항이다. 
}















