package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation4 {
  String value();
  String[] subjects() default {"국어","영어","수학"};
  int[] scores() default {0,0,0};
}
