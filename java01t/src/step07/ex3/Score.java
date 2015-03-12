package step07.ex3;

// 기본 생성자를 직접 추가
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  // 생성자? 인스턴스 생성 후, 사용하기 전에 뭔가 준비할 작업이 있다면 바로 그 명령어를 
  //       작성하는 위치가 생성자이다. 그 작업이 인스턴스 변수의 초기화 작업이든, 
  //       DB에서 데이터를 가져오는 작업이든, 서버에서 파일을 다운로드 받는 작업이든,
  //       HDD에서 파일을 읽어오는 작업이든 간에.
  // 인스턴스 생성할 때 반드시 초기화되어야 할 변수가 있다면,
  // 기본 생성자에서 초기화시킨다. 
  // 이럴 경우 기본 생성자를 추가하는 것이다.
  // => 다음 생성자는 그냥 기본 생성자 호출을 확인하기 위해서 어거지스럽게 추가한 것이다.
  public Score() {
    System.out.println("Score 인스턴스 생성");
    this.name = "홍길동";
    this.kor = 100;
    this.eng = 100;
    this.math = 100;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  /* 예전에는 초기화 메서드를 별도로 정의했다.
  public void init(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
  */

  /*
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
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







