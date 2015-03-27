package step17.ex9;

import java.io.Serializable;

// 특정 인스턴스 변수를 질력화 대상에서 제외하기
// => "이 인스턴스 변수는 임시적으로(일시적으로) 사용하는 값을 보관하는 용도이다" 라고 선언!
// => transient 명령 붙이기
// => 참고로 deserialize한 후(바이트 배열을 인스턴스로 만든 후)
//    총점과 평균을 다시 계산해야 한다.
//    => compute() 메서드를 추가하라!
public class Score implements Serializable {
  String name;
  int kor;
  int eng;
  int math;
  
  // transient 로 선언된 인스턴스 변수의 값을 직렬화에 포함되지 않는다.
  // 바이트 배열로 만들어지지 않는다. => 파일로 출력되지 않는다.
  transient int total;
  transient float average;
  
  // 테스트 할 때 간단히 User 객체의 내용을 확인하기 위해.
  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", total=" + total + ", average=" + average + "]";
  }

  // 이 메서드는 deserialize 한 후 바로 호출해야 한다. Test 클래스 참조하라!
  public void compute() {
    total = kor + eng + math;
    average = total / 3f;
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
