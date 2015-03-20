package step14.ex7;

// Exception에 기능을 추가하거나 인스턴스를 변수를 추가하지는 않았지만,
// 다음과 같이 자식 예외 클래스를 만들어 사용한다.
// => 클래스 이름 자체가 예외 상황을 표현한다. => 소스 코드 가독성이 좋다.
// => 예외를 자식 클래스로 정의하면, 캐치할 때 구분할 수 있다.
// 
public class PoolOverflowException extends Exception {
  //생성자를 선언하지 않으면, 다음과 같이 기본 생성자가 자동으로 만들어진다.
  //=> 상위 클래스의 다양한 생성자를 호출할 수 없다.
  //=> 자동으로 생성된 생성자는 오직 상위 클래스의 기본 생성자만 호출하기 때문이다.
  /*
  public PoolOverflowException() {
    super();
  }
   */
  
  // 상위 클래스의 다른 생성자를 호출하고 싶다면, 명시적으로 생성자를 만들라!
  public PoolOverflowException() {
    super();
  }

  public PoolOverflowException(String message, Throwable cause) {
    super(message, cause);
  }

  public PoolOverflowException(String message) {
    super(message);
  }
  
}









