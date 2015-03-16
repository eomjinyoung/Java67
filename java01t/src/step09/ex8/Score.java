package step09.ex8;

// 자바의 최상위 클래스 "Object"
// - 자바의 모든 클래스의 최상위 클래스는 java.lang.Object 클래스이다.
// - 개발자가 상속 받지 않으면, 컴파일러가 상속 받도록 처리한다.
public class Score /*extends Object*/ {
  protected String name = "홍길동";
  protected int kor;
  protected int eng;
  protected int math;
  protected int sum;
  protected float aver;
  
  static {
    System.out.println("Score 클래스 로딩...");
  }
  
  public Score() {
    //모든 생성자는 무조건 첫 번째로 수퍼 클래스의 기본 생성자를 호출하는 문장이 생략되어 있다.
    //super(); //엥, Score의 수퍼 클래스는 없는데요? 답: 있다. who? Object 클래스
    
    System.out.println("Score() 생성자 실행...");
    name = "임꺽정";
  }
}










