package step01;

import java.util.ArrayList;

// 복합 자료형 사용 방법
// 복합 자료형? 정수, 부동소수점, 논리 값을 모두 담을 수 있는 메모리

public class Test03 {

  public static void main(String[] args) {
    //국,영,수 점수와 총점, 평균을 저장할 수 있는 메모리가 필요하다!
    //자바에서 성적 데이터를 저장할 방법?
    //- 개발자가 복합 자료형을 정의해서 사용하면 된다.
    
    //정의 방법 => class 문법 사용
    //class 자료형 { 메모리들 }
    
    //1) Score라는 복합 자료형 정의
    class Score {
      byte kor;
      byte eng;
      byte math;
      int  total;
      float average;
    }
    
    //2) 클래스를 사용하여 메모리 준비
    // new 클래스명(); => 클래스에 정의한대로 메모리를 준비한다.
    // v1은 Score 메모리의 주소를 저장하는 변수이다.
    // v1처럼 주소를 저장하는 변수를 참조 변수라고 한다. 
    // 영어로 referece라고 부른다.
    Score v1 = new Score();
    
    //3) 복합 메모리에 값 저장하기
    //레퍼런스.변수명 = 값
    v1.kor = 100;
    v1.eng = 80;
    v1.math = 100;
    v1.total = v1.kor + v1.eng + v1.math;
    v1.average = v1.total / 3;
    
    System.out.println(v1.total);
    System.out.println(v1.average);
    
    // v1의 위치 정보를 v2에 저장
    Score v2 = v1;
    System.out.println(v2.total);
    System.out.println(v2.average);
    
    //개인의 신체 정보를 저장할 복합 자료형
    class Body {
      int no;
      float height;
      float weight;
      boolean gender;
    }
    
    //Score v2 = new Body();
    Body v3 = new Body();
    v3.no = 1;
    v3.height = 178.5f;
    v3.weight = 99.5f;
    v3.gender = false;
    
    Body v4;
    v4 = new Body();
    v4 = new Body();
  }

}










