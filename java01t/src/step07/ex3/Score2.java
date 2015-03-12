package step07.ex3;

// 파라미터를 갖는 생성자를 만든다.
public class Score2 {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  // 파라미터를 갖는 생성자를 만든다.
  // 생성자가 단 하나라도 있으면, 기본 생성자가 자동으로 추가되지 않는다.(주의!)
  public Score2(String name) {
    System.out.println("Score 인스턴스 생성");
    this.name = name;
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  // 인스턴스의 점수 합을 구하는 연산자 정의
  public void summarize() {
    this.sum = this.kor + this.eng + this.math;
  }
  
  // 인스턴스의 점수 평규을 구하는 연산자 정의
  public void average() {
    this.average = this.sum / 3f;
  }
  
  // 인스턴스의 값을 출력하는 연산자 정의
  public void print() {
    System.out.println("-------------------------");
    System.out.printf("이름: %s\n", this.name);
    System.out.printf("국어: %d\n", this.kor);
    System.out.printf("영어: %d\n", this.eng);
    System.out.printf("수학: %d\n", this.math);
    System.out.printf("총점: %d\n", this.sum);
    System.out.printf("평균: %.1f\n", this.average);
    System.out.println("-------------------------");
  }
  
}







