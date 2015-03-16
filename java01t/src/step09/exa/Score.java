package step09.exa;

// 기본 생성자를 제거하여 서브 클래스에서 기본 생성자를 호출하지 못하도록 한다.
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
  
  public Score(String name, int kor, int eng, int math) {
    super(); 
    System.out.println("Score() 생성자 실행...");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
}










