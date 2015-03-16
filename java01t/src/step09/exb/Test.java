package step09.exb;

// super 참조 변수
// - 오버라이딩 하기 전의 메서드를 가리킬 때 사용한다.
public class Test {

  public static void main(String[] args) {
    ScoreEx s1 = new ScoreEx("홍길동", 100, 100, 90, 90, 100);
    s1.print(); //ScoreEx가 오버라이딩한 print() 메서드이다.
  }

}















