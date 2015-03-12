package step07.ex4;

// 오버로딩을 이용하여 생성자를 여러 개 선언하기
// - 같은 이름을 갖는 생성자를 여러 개 선언할 수 있는 이유?
// - 자바는 오버로딩이라는 개념을 문법으로 지원한다.
// - 파라미터의 개수나 타입만 다르다면 같은 이름으로 여러 개를 선언할 수 있다.
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  //기본 생성자 선언
  public Score() {
    this.name = "홍길동";
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  //이름을 받는 생성자
  public Score(String name) {
    this.name = name;
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  //이름과 국어, 영어, 수학 점수를 받는 생성자
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  public Score(int kor, int eng, int math, String name) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  // 변수 명은 메서드를 구분하는데 아무런 소용이 없다.
  // 따라서 다음과 같이 타입과 개수는 같은 변수 명이 다른 메서드를 추가할 수 없다.
  // 메서드를 구분하는 방법?
  // 호출하는 쪽에서 어떤 값을 던지느냐에 따라 메서드를 찾기 때문이다.
  // 다음은 오류!
  /*
  public Score(int eng, int kor, int math, String name) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  */
  
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







