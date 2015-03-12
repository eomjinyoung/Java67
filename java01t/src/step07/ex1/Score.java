package step07.ex1;

// 생성자 적용
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  /* 예전에는 초기화 메서드를 별도로 정의했다.
  public void init(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
  */
  
  // 초기화 메서드 대신 생성자를 정의한다.
  // - 위에서 처럼 초기화 메서드를 별도로 정의하여 사용해도 되지만,
  // - 생성자를 이용하면 훨씬 더 간결하고 안전한 코드를 작성할 수 있다.
  // 안전?
  // - init() 메서드의 호출은 선택사항이다. 즉, 호출하지 않아도 컴파일할 때 아무런 문제없다.
  // - 생성자는 호출하지 않으면 컴파일 오류가 발생한다. 
  //   따라서, 인스턴스의 값을 초기화시키는 것을 강제하고 싶으면 일반 메서드로 만들지 말고,
  //   생성자를 이용하도록 하라!
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
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







