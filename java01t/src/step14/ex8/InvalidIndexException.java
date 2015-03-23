package step14.ex8;

// 특별한 기능 없다.
// 그냥 오류 상황을 클래스 이름 만으로 직관적으로 파악할 수 있도록 서브 클래스를 만든 것이다.
// 단, RuntimeException의 서브 클래스로 만든다.
// - 예외 처리를 반드시 호출자가 할 필요가 없다.
// - 예외 처리 코드를 어디에 둘 것인지 개발자가 선택할 수 있다.
// - 예외 처리를 할 것인지의 여부도 개발자가 선택할 수 있다.
// => 예외 처리의 빡빡함을 좀 더 유연하게 가져간다.
public class InvalidIndexException extends RuntimeException {
  public InvalidIndexException() {
    super();
  }

  public InvalidIndexException(String message) {
    super(message);
  }
}
