package step17.ex6;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int total;
  float average;
  
  // 테스트 할 때 간단히 User 객체의 내용을 확인하기 위해.
  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", total=" + total + ", average=" + average + "]";
  }

  // 빈 인스턴스를 생성할 수 있도록 기본 생성자도 만든다.
  public Score() {}
  
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.total = kor + eng + math;
    this.average = this.total / 3f;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public float getAverage() {
    return average;
  }

  public void setAverage(float average) {
    this.average = average;
  }
  
  
  
}
