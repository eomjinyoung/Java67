package step06.ex7;

/* 연산자가 있는 복합 자료형을 다루는 예제이다.
 * 
 * Score2에 등록된 init() 연산자를 사용하여 
 * 인스턴스 변수의 값을 초기화 한다. 
 * 
 * 즉, 복합 자료형에 정의된 연산자를 사용하는 관점에서 설명한 예제이다.
 * "인스턴스 메서드란, 그 자료형의 데이터를 다루는 연산자이다."
 * "인스턴스 메서드를 정의한다는 것은, 그 자료형을 다룰 연산자를 정의한다는 말이다."
 */

public class Test2 {

  public static void main(String[] args) {
    Score2 s1 = new Score2();
    
    // 프로그래밍 언어: s1 인스턴스에 대해 init() 명령을 호출한다.
    // 복합자료형 관점: s1에 대해 init() 연산자를 실행한다.
    // OOAD 관점: s1이라는 객체에 init() 메시지를 보낸다.
    s1.init("홍길동", 100, 90, 80);
    
    //s1에 대해 점수 합을 구하는 연산자를 실행한다.
    s1.summarize();
    
    //s1에 대해 점수 평균을 구하는 연산자를 실행한다.
    s1.average();
    
    Score2 s2 = new Score2();
    s2.init("임꺽정", 100, 100, 100);
    s2.summarize();
    s2.average();
    
    Score2 s3 = new Score2();
    s3.init("윤봉길", 100, 100, 100);
    s3.summarize();
    s3.average();
    
    //s1에 대해 내용을 화면에 출력하는 연산자를 실행한다.
    s1.print();
    s2.print();
    s3.print();
  }

}








