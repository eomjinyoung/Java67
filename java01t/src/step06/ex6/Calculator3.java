package step06.ex6;

/* 인스턴스 메서드
 * - 인스턴스가 있어야만 작업을 수행할 수 있는 메서드.
 * - 인스턴스를 사용하는 메서드는 인스턴스 메서드로 만들어라!
 * - 인스턴스를 사용하지 않는 메서드는 클래스 메서드(스태틱 메서드)로 선언하라!
 * - 인스턴스 메서드로 선언하면, 메서드를 호출할 때 
 *   메서드 앞에 인스턴스 주소를 줄 수 있다. 
 *   => 클래스 메서드로 처리하는 것 보다 더 코드가 간결해진다.
 * - 문법: 
 *    1) static 을 빼라!
 *    2) 인스턴스 주소를 받는 파라미터를 선언하지 말아라!
 *       그럼, 인스턴스 주소는 어디에?
 *    3) 자바는 인스턴스 메서드에 대해 인스턴스 주소를 담고 있는
 *       숨겨진 변수를 자동으로 제공한다.
 *       => 그 숨겨진 변수의 이름은? this 
 *        
 */
public class Calculator3 {
  public int result;
 
  //인스턴스 메서드 선언
  public void init(int value) {
    // 인스턴스 주소를 갖고 있는 숨겨진 변수가 있다. this!!!!!!!
    // 따로 인스턴스 주소를 받을 파라미터를 선언할 필요가 없다.
    this.result = value;
  }
  
  public void plus(int value) {
    this.result += value;
  }
  
  public void minus(int value) {
    this.result -= value;
  }
  
  public void multiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }
  
  public void remainder(int value) {
    this.result %= value;
  }
}














