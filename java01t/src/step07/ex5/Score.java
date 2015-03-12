package step07.ex5;

// 인스턴스 블록 적용
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  // 인스턴스 초기화 블록
  {
    System.out.println("블록1-----------");
    this.name = "오호라";
    System.out.println("-------------블록1 끝");
  }
  
  //기본 생성자 선언
  public Score() {
    System.out.println("Score() 호출됨....");
    this.name = "홍길동";
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
    System.out.println("Score() 호출 완료!");
  }
  
  //이름을 받는 생성자
  public Score(String name) {
    System.out.println("Score(String) 호출됨....");
    this.name = name;
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
    System.out.println("Score(String) 호출 완료!");
  }
  
  //이름과 국어, 영어, 수학 점수를 받는 생성자
  public Score(String name, int kor, int eng, int math) {
    System.out.println("Score(String, int, int, int) 호출됨....");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
    System.out.println("Score(String, int, int, int) 호출 완료!");
  }
  
  //인스턴스 초기화 블록
  {
    System.out.println("블록2-----------");
    this.kor = 50;
    this.eng = 50;
    this.math = 50;
    System.out.println("-------------블록2 끝");
  }
  
  public Score(int kor, int eng, int math, String name) {
    System.out.println("Score(int, int, int, String) 호출됨....");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
    System.out.println("Score(int, int, int, String) 호출 완료!");
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
  
  //인스턴스 초기화 블록
  {
    System.out.println("블록3-----------");
    this.summarize();
    this.average();
    System.out.println("-------------블록3 끝");
  }
  
}







