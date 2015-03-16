package step09.ex9;

//super() 호출
public class ScoreEx extends Score {
  protected int soc = 50;
  protected int sci;
  
  static {
    System.out.println("ScoreEx 클래스 로딩...");
  }
  
  public ScoreEx() {
    super();
    System.out.println("ScoreEx() 생성자 실행...");
    //super(); //수퍼 클래스의 생성자를 호출하는 문장은 반드시 첫 번째로 와야 한다.  
    soc = 0;
  }
}
