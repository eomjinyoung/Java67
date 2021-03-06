package step07.ex1;

/* 생성자
 * - 인스턴스를 생성한 후 자동 호출되는 메서드
 * - 인스턴스의 메모리를 초기화 하는 용도 
 * - 문법
 *   리턴타입이 없다.
 *   메서드 이름은 클래스 이름과 같아야 한다.
 *   파라미터를 받지 않는 생성자를 "기본 생성자(default constructor)"라고 부른다.
 *   
 */

public class Test {

  public static void main(String[] args) {
    //이전 방식
    //인스턴스 생성 후, 별도의 초기화 메서드를 호출하였다. 
    //Score s1 = new Score();
    //s1.init("홍길동", 100, 90, 80);
    //
    
    //생성자를 사용한 방식
    //인스턴스 생성 시 초기화 메서드를 바로 호출하고,
    //초기화시키는데 필요한 값을 바로 전달한다.
    // new 클래스명(호출하는 생성자의 파라미터 값);
    //Score s2 = new Score(); //생성자 호출 시 값을 넘겨주지 않으면 컴파일 오류 발생!
    Score s2 = new Score("홍길동", 100, 90, 80);
    
    s2.summarize();
    s2.average();
    s2.print();
    
    // 생성자를 따로 호출할 수 없다.
    // 인스턴스 생성할 때 호출해야 한다.
    //s2.Score("임꺽정", 100, 100, 100); //컴파일 오류! 
  }

}



















