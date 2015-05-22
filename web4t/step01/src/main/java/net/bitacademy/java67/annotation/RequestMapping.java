package net.bitacademy.java67.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 용도 : 요청이 들어왔을 때 호출될 메서드를 표시하는 용도 */

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
  String value() default "";
  String method() default "";
}
