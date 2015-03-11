package step06.ex7;

// 복합자료형에 배정 연산자를 추가한다.
// = ? 아니, 기존의 배정 연산자는 재정의 할 수 없다.
// 메서드로 표현한다.
public class Score2 {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  //배정 연산자 정의
  //- 연산자이니까 어디에서든 사용할 수 있도록 공개해야 한다. public
  //- 이 경우 init() 메서드는 Score 자료형을 위한 연산자로서 기능을 수행한다.
  //- 인스턴스 메서드는 자료형의 데이터를 다루는 관계로 연산자로 취급한다.
  //- 객체지향 분석/설계(OOAD)에서는 메서드를 operator로 표현한다.
  public void init(String name, int kor, int eng, int math) {
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







