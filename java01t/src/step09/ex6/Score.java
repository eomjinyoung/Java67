package step09.ex6;

// 수퍼 클래스 역할!
public class Score {
  protected String name;
  protected int kor;
  protected int eng;
  protected int math;
  protected int sum;
  protected float aver;
  
  static {
    System.out.println("Score 클래스 로딩...");
  }
}
