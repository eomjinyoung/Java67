package step09.ex3;

// 이 클래스는 ex5.ScoreEx를 위해 추가한 클래스이다.
// ex3 패키지를 공부할 때는 참고하지 말라!
//
// 내용
// - ScoreEx 자식 클래스에서도 이 클래스의 인스턴스 멤버에 접근할 수 있도록
//   protected로 선언한다.
public class Score2 {
  protected String name;
  protected int kor;
  protected int eng;
  protected int math;
  protected int sum;
  protected float aver;
  
  //kor, eng, math 변수에 값을 저장해주는 메서드 정의
  //인스턴스의 값을 저장하는 메서드를 "셋터(setter)"라고 부른다.
  public void setKor(int kor) {
    this.kor = kor;
    compute();
  }
  
  public void setEng(int eng) {
    this.eng = eng;
    compute();
  }
  
  public void setMath(int math) {
    this.math = math;
    compute();
  }

  // 인스턴스의 값을 반환하는 메서드를 "겟터(getter)"라고 부른다.
  public int getSum() {
    return sum;
  }
  public float getAver() {
    return aver;
  }
  public int getKor() {
    return kor;
  }
  public int getEng() {
    return eng;
  }
  public int getMath() {
    return math;
  }
  
  
  
  public Score2() {}
  
  public Score2(String name, int kor, int eng, int math) {
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

















