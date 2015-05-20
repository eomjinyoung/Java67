package net.bitacademy.java67;

// RuntimeException을 그냥 사용하지 않고 이렇게 서브 클래스를 만들어 사용하는 이유?
// - 코드 읽기를 쉽게하기 위해 
// - 클래스 이름 만으로 어디서 어떤 원인으로 예외가 발생했는지 바로 파악할 수 있다. 
public class DaoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public DaoException() {
    super();
  }

  public DaoException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  
}
