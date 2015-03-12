package step07.ex7;

// 클래스 변수와 인스턴스 변수
public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
  }
}
