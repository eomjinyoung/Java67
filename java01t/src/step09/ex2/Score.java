package step09.ex2;

//캡슐화 적용 후
//접근 제어자(access modifier): private, (default), protected, public
//1) private : 클래스 멤버만 접근 가능.
//2) (default) : 패키지 멤버는 접근 가능.
//3) protected : 패키지 멤버 + 자식 클래스 접근 가능.
//4) public : 모두 접근 가능

// sum 변수에 직접 접근해서 발생하는 문제를 해결함!

public class Score {
  // 복합 자료형의 인스턴스 변수는 자식 클래스가 접근할 수 있게 허용하는 것이 보통이다.
  protected String name;
  protected int kor;
  protected int eng;
  protected int math;
  
  //총점과 평균은 계산한 값이어야 하기 때문에 직접 값을 할당하는 것을 막자!
  //이전 예제의 경우처럼 sum 변수의 값을 직접 바꿔서 발생한 문제를 막을 수 있다.
  private int sum;
  private float aver;
  
  public Score() {}
  
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    compute();
  }
  
  public void compute() {
    sum = kor + eng + math;
    aver = sum / 3f;
  }
  
  public void print() {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        name, kor, eng, math, sum, aver);
  }
}

















