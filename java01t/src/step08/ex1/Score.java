package step08.ex1;

// 클래스 변수의 활용
public class Score {
  int no; //학생의 고유번호 
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  
  public Score(int no, String name, int kor, int eng, int math) {
    this.no = no;
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
  }
}
