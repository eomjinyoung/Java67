package net.bitacademy.java67.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 용도: 자동으로 생성되어야할 객체에 대해 붙인다.
 * - ApplicationContext 객체는 이 애노테이션이 붙은 클래스를 찾아서
 *   객체를 생성한다.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value() default ""; // 객체를 저장할 때 key로 사용할 값.
}
