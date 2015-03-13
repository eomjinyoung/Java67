package step09.ex1;

//캡슐화 적용 전
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  //0으로 초기화된 인스턴스를 생성할 수 있도록, 기본 생성자를 정의한다.
  public Score() {}
  
  public Score(String name, int kor, int eng, int math) {
    //숨겨진 로컬 변수 this
    //Score this = 새로 만든 인스턴스의 주소;
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    
    //같은 멤버의 메서드를 호출할 때도, this를 생략할 수 있다.
    //(같은 클래스에 소속되어 있는 메서드를 호출할 때도,)
    //this.compute();
    compute();
  }
  
  public void compute() {
    //Score this = 메서드를 호출할 때 넘겨준 인스턴스 주소
    
    //로컬 변수와 인스턴스 변수 사이에 혼동할 일이 없다. => this 생략 가능!
    //this.sum = this.kor + this.eng + this.math;
    sum = kor + eng + math;
    aver = sum / 3f;
  }
  
  // 혼동할게 없다면, this 레퍼런스는 생략할 수 있다.
  // - 로컬 변수가 있는지 찾아보고 없다면, 인스턴스 변수로 간주한다. 
  public void print() {
    //Score this = 메서드를 호출할 때 넘겨준 인스턴스 주소
    
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        name, kor, eng, math, sum, aver);
  }
}

















