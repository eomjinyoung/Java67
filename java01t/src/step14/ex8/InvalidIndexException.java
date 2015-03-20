package step14.ex8;

// 특별한 기능 없다.
// 그냥 오류 상황을 클래스 이름 만으로 직관적으로 파악할 수 있도록 서브 클래스를 만든 것이다.
public class InvalidIndexException extends Exception {
  public InvalidIndexException() {
    super();
  }

  public InvalidIndexException(String message) {
    super(message);
  }
}
