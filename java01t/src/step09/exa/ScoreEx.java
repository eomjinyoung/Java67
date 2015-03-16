package step09.exa;

//super() 호출
public class ScoreEx extends Score {
  protected int soc = 50;
  protected int sci;
  
  static {
    System.out.println("ScoreEx 클래스 로딩...");
  }
  
  public ScoreEx() {
    // 수퍼 클래스에 기본 생성자가 없다면, 
    // 다음과 같이 명시적으로 수퍼 클래스의 특정 생성자를 호출해야 한다. 반드시!
    // 또는 수퍼 클래스에 기본 생성자가 있다고 하더라도,
    // 다른 생성자를 호출하고 싶을 때 다음과 같이 그 생성자를 명시적으로 호출한다.
    super("홍길동", 0, 0, 0);
    
    System.out.println("ScoreEx() 생성자 실행...");
    //super(); //수퍼 클래스의 생성자를 호출하는 문장은 반드시 첫 번째로 와야 한다.  
    soc = 0;
  }
}
