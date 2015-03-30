package step17.exb;

import java.io.Serializable;

// 질력화 버전 정보를 추가하기 전
public class Score implements Serializable {
  private static final long serialVersionUID = 100L;
  
  String name;
  int kor;
  int eng;
  int math;
  
  //기존 Score 클래스에 과학, 사회 점수 추가!
  int sci; 
  int soc;
  
  transient int total;
  transient float average;
  
  //toString() 재 생성
  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", sci=" + sci + ", soc=" + soc + "]";
  }

  // 과학, 사회 점수 추가하여 계산
  public void compute() {
    total = kor + eng + math + sci + soc;
    average = total / 5f;
  }
  
  public Score() {}

  // 과학, 사회 점수 추가!
  public Score(String name, int kor, int eng, int math, int sci, int soc) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sci = sci;
    this.soc = soc;
    compute();
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

  public int getSci() {
    return sci;
  }

  public void setSci(int sci) {
    this.sci = sci;
  }

  public int getSoc() {
    return soc;
  }

  public void setSoc(int soc) {
    this.soc = soc;
  }
  
  
  
}
