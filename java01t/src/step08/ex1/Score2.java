package step08.ex1;

// 클래스 변수의 활용
// - 학생의 카운트를 Score2 클래스에서 관리한다.
//
// 클래스의 변수의 생성 시점
// - 클래스가 로딩될 때 Method Aread 영역에 준비된다.
public class Score2 {
  // 전체 학생의 수와 같이 개별적으로 관리하는 데이터가 아니고,
  // 여러 인스턴스에서 공유해야 하는 데이터는 클래스 변수에 보관한다.
  static int count; //전체 학생의 수를 저장
  
  int no; //학생의 고유번호 
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  
  public Score2(String name, int kor, int eng, int math) {
    //같은 클래스의 클래스 변수를 사용할 때는 클래스 이름을 생략할 수 있다.
    //Score2.count => count
    this.no = ++count;
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
  }
}












