package step25;

/* 애노테이션 정의
 * - 이름을 생략할 수 있는 특별한 속성 "value"
 */
public @interface MyAnnotation2 {
  String value() default "ok";
  String name() default "ok";
}
