package step09.exb;

// Score의 내용을 출력하는 print() 메서드 생성
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
  
  public Score() {}
  
  public Score(String name, int kor, int eng, int math) {
    super(); 
    System.out.println("Score() 생성자 실행...");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
  
  public void print() {
    System.out.printf("이름: %s\n", name);
    System.out.printf("국어: %d\n", kor);
    System.out.printf("영어: %d\n", eng);
    System.out.printf("수학: %d\n", math);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", aver);
  }
}










