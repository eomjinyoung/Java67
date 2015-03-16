package step09.ex7;

//서브 클래스 역할!
public class ScoreEx extends Score {
  protected int soc = 50;
  protected int sci;
  
  static {
    System.out.println("ScoreEx 클래스 로딩...");
  }
  
  public ScoreEx() {
    System.out.println("ScoreEx() 생성자 실행...");
    soc = 0;
  }
}
