package step09.exb;

// ScoreEx의 내용을 출력하는 print() 생성
public class ScoreEx extends Score {
  protected int soc = 50;
  protected int sci;
  
  static {
    System.out.println("ScoreEx 클래스 로딩...");
  }
  
  public ScoreEx(
      String name, int kor, int eng, int math, int soc, int sci) {
    //수퍼 클래스의 기본 생성자를 호출하도록 그냥 둔다면,
    //다음과 같이 수퍼 클래스의 인스턴스 변수까지 초기화해야 한다. 귀찮다!
    /*
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    */
    
    //이런 경우 다음과 같이 수퍼 클래스의 값을 초기화 하는 생성자를 명시적으로 호출하는 것이 좋다.
    super(name, kor, eng, math);
    
    this.soc = soc;
    this.sci = sci;
    System.out.println("ScoreEx() 생성자 실행...");
  }
  
  @Override
  public void print() {
    // 새로 명령을 추가한다.
    System.out.printf("사회: %d\n", soc);
    System.out.printf("과학: %d\n", sci);
    
    //기존 명령을 수행한다.
    // 오버라이딩 하기 전의 메서드를 호출하는 방법
    // super.메서드명();
    // 의미 => 기존의 기능을 그대로 사용하고, 새로 명령을 추가할 때!
    super.print(); // 상속 받은 메서드 호출! 
    //아빠 클래스에 있는 메서드를 호출하라는 얘기는 아니다.
    //즉, super가 가리키는 것은 아빠가 아니다. 상속받은 것을 가리킨다. 
    
    //super 참조 변수를 사용하는 것은 어디에서나 가능하다.
    //super()처럼 문장의 첫 번째로 와야 하는 것은 아니다.
  }
}









