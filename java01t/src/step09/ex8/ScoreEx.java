package step09.ex8;

//super() : 수퍼 클래스의 생성자 호출 문장 적용
public class ScoreEx extends Score {
  protected int soc = 50;
  protected int sci;
  
  static {
    System.out.println("ScoreEx 클래스 로딩...");
  }
  
  public ScoreEx() {
    //super(); //생략되어 있다.
    System.out.println("ScoreEx() 생성자 실행...");
    soc = 0;
  }
}
