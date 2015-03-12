package step07.ex6;

// 초기화 문장을 이용하여 인스턴스 변수의 값을 초기화시키기.
// - 인스턴스가 생성 => 초기화 문장이 실행 => 생성자가 호출
// 
// 인스턴스가 준비되면, 모든 변수는 0으로 자동 초기화 된다.
// 클래스 변수(static 변수)도 0으로 자동 초기화 된다.
// 메서드의 로컬 변수는 0으로 초기화되지 않는다.
//
// 0으로 초기화 된다는 것?
// byte, short, int, long, float, double => 0으로 초기화 됨.
// boolean => false로 초기화 됨. false는 결국 0이다.
// char => 유니코드 0x00000000으로 초기화 됨. 결국 0이다. 

public class Score {
  String name = "홍길동";
  int kor = 50;
  int eng = 50;
  int math = 50;
  int sum;
  float average;

  public Score() {
    // 로컬 변수는 자동으로 초기화 되지 않기 때문에, 다음과 같이
    // 변수를 선언한 후 바로 값을 꺼내려 하면 컴파일 오류가 발생한다.
    //int i;
    //System.out.println(i);
    
    //인스턴스 변수는 인스턴스 생성 시 자동 초기화 되기 때문에 그냥 값을 꺼내도 된다. 
    // 어차피 꺼내봐야 0이다.
    System.out.println(this.sum);
    
    this.summarize();
    this.average();
  }
  
  public Score(String name) {
    this(); //초기화 문장을 통해 저장된 값으로 총점과 평균을 먼저 구하자!
    this.name = name; // 이름을 저장하자.
  }
  
  public Score(String name, int kor, int eng, int math) {
    this(kor, eng, math, name);
  }
  
  public Score(int kor, int eng, int math, String name) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    
    this.summarize();
    this.average();
  }
  
  public void summarize() {
    this.sum = this.kor + this.eng + this.math;
  }
  
  public void average() {
    this.average = this.sum / 3f;
  }
  
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







