package step24;

/* Singleton 패턴
 * 1) 생성자를 private 으로 막아라! 
 * 2) 객체를 생성하여 리턴하는 static 메서드를 선언하라!
 * 3) 인스턴스 주소를 저장할 static 변수를 만든다.
 */

public class MyClass2 {
  private MyClass2() {}
  
  private static MyClass2 instance;
  
  public static MyClass2 getInstance() {
    if (instance == null) {
      instance = new MyClass2();
    }
    return instance;
  }
}















