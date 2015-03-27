package step17.ex5;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int total;
  float average;
  
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
}
