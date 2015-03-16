package step09.ex7;

// 수퍼 클래스 역할!
public class Score {
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
    System.out.println("Score() 생성자 실행...");
    name = "임꺽정";
  }
}
