package step07.ex4;

// 생성자에서 다른 생성자를 호출하기
// this()를 이용하여 중복되는 코드를 간결하게 만들자!
public class Score2 {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  //다른 생성자를 호출하여 초기화 작업을 완료한다.
  public Score2() {
    this("홍길동");
    
    this.kor = 0;
    this.eng = 0;
    this.math = 0;
    
    summarize();
    average();
  }
  
  //이름을 받는 생성자 => 다른 생성자를 호출한다.
  public Score2(String name) {
    this(100, 100, 100, name);
  }
  
  // 다른 생성자를 이용하여 동일 작업을 처리하자!
  public Score2(String name, int kor, int eng, int math) {
    //System.out.println("this()는 반드시 첫 번째로 호출해야 한다. 문법 오류!");
    this(kor, eng, math, name);
  }
  
  public Score2(int kor, int eng, int math, String name) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.average = this.sum / 3f;
  }
  
  // 일반 메서드에서 생성자를 호출할 수 없다!
  public void summarize() {
    //this("홍길동"); //용서받지 못할 코드. 오류!
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







