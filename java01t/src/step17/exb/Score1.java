package step17.exb;

import java.io.Serializable;

// 개발자가 직접 클래스의 버전을 지정한다.
//
public class Score1 implements Serializable {
  private static final long serialVersionUID = 100L;

  String name;
  int kor;
  int eng;
  int math;
  
  transient int total;
  transient float average;
  
  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", total=" + total + ", average=" + average + "]";
  }

  public void compute() {
    total = kor + eng + math;
    average = total / 3f;
  }
  
  public Score1() {}
  
  public Score1(String name, int kor, int eng, int math) {
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
