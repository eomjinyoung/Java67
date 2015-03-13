package step08.ex3;

//스태틱 블록 사용
//- 클래스가 로딩 된 후 인스턴스 블록처럼 자동을 실행하는 블록이다.
//
// 클래스 로딩 절차
// - 클래스 파일을 찾는다.
// - 바이트코드 유효 여부를 검사한다.
// - 클래스 파일을 Method Area 영역에 로딩한다.
// - 클래스 변수를 Method Area에 준비시킨다.
// - 클래스 변수의 초기화 문장을 실행한다.
// - 클래스 블록을 실행한다.
public class Score {
  static int count = 100;
  
  //스태틱 블록 선언
  static {
    System.out.println("Score 클래스를 로딩했습니다.");
    count = 200;
  }
  
  public Score() {
    System.out.println("생성자: " + count);
    //문자열 + 숫자 => 숫자를 가지고 임시 문자열을 만들어 두 문자열을 결합시킨다.
  }
  
  public static void printCount() {
    System.out.println("클래스 메서드: " + count);
  }
}
