package step23;

import java.lang.reflect.Modifier;

/* 실습 목표: Class 객체 사용
 * 
 */
public class Test02 {

  public static void main(String[] args) {
    Class clazz = String.class;
   
    //1) 클래스 전체 이름 알아내기
    System.out.printf("전체 클래스명: %s\n", clazz.getName());
    
    //2) 패키지 이름을 제외한 클래스 이름
    System.out.printf("클래스 이름: %s\n", clazz.getSimpleName());

    //3) 클래스 타입 이름(전체 이름)
    System.out.printf("클래스 타입 이름: %s\n", clazz.getTypeName());
    
    //4) 클래스 변경자 정보 알아내기
    // - public, private, (default), protected, static, final, ...
    int modifier = clazz.getModifiers();
    if (
        (modifier & Modifier.PUBLIC) // 특정 비트의 값을 추출한다. 
          == Modifier.PUBLIC // 추출한 값이 1인지 아닌지 비교한다.
        ) {
      System.out.println("public ");
    }
    System.out.printf("static? %b\n", 
        (modifier & Modifier.STATIC) > 0 ? true:false);
    System.out.printf("final? %b\n", 
        (modifier & Modifier.FINAL) > 0 ? true:false);

  }

}










