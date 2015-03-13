package step08.ex2;

//클래스 변수와 클래스 메소드 생성
//=> 클래스 로딩 시 클래스 변수가 준비된다는 것을 확인한다.
public class Score {
  static int count = 100;
  
  public Score() {
    System.out.println("생성자: " + count);
    //문자열 + 숫자 => 숫자를 가지고 임시 문자열을 만들어 두 문자열을 결합시킨다.
  }
  
  public static void printCount() {
    System.out.println("클래스 메서드: " + count);
  }
}
