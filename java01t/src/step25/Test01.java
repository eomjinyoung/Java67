package step25;

import java.lang.annotation.Annotation;

/* 실습 목표: 애노테이션 사용법
 * 1) 애노테이션 정의
 * 2) 애노테이션 적용
 * 3) 애노테이션 정보 추출
 * 
 * Comment(주석)?
 * - 한 줄 주석(//내용...)
 * - 여러 줄 주석(/* 내용.... * /)
 * - 컴파일할 때 주석은 제거된다. 즉 .class 파일에 주석 정보가 없다.
 * 
 * Annotation(특별한 주석)?
 * - @주석명(속성=값,속성=값,...)
 * - 정책에 따라 다음과 같이 다뤄진다.
 *   . 컴파일 할 때 제거된다.
 *   . .class 파일에 유지된다. 단, 실행할 때 읽을 수 없다.
 *   . .class 파일에 유지된다. 실행할 때 읽을 수 있다.
 */
public class Test01 {

  public static void main(String[] args) throws Exception {
    // 애노테이션 정보 추출
    //1) 클래스 정보를 알아낸다.
    Class clazz = MyObject4.class;
    
    //2) 클래스 정보로부터 애노테이션 추출
    // - 특정 애노테이션 추출하기
    MyAnnotation4 anno = 
        (MyAnnotation4)clazz.getAnnotation(MyAnnotation4.class);
    
    // - 애노테이션 속성 값 추출
    System.out.println(anno.value());
    for (String subject : anno.subjects()) {
      System.out.print(subject + ",");
    }
    System.out.println();
    for (int score : anno.scores()) {
      System.out.print(score + ",");
    }
    
  }

}







