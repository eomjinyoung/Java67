package step09.ex9;

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
    super(); //this()나 super()는 반드시 첫 번째 문장으로 와야 한다.
    System.out.println("Score() 생성자 실행...");
    name = "임꺽정";
  }
}










