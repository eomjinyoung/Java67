package step24;

/* 실습 목표: Singleton 패턴의 사용
 * Singleton 패턴
 * - 객체를 오직 한 개만 생성하게 만드는 설계 기법  
 */
public class Test01 {

  public static void main(String[] args) {
    // 1) 일반적인 객체 생성
    MyClass p1 = new MyClass();
    
    // 2) 팩토리 메서드를 통해 객체 생성
    MyClass p2 = MyClassFactory.createInstance();
    
    // 3) 싱글톤 기법을 통해 객체 생성
    // 생성자가 private이기 때문에 직접 객체를 생성할 수 없다.
    //MyClass2 p3 = new MyClass2();
    
    MyClass2 p3 = MyClass2.getInstance();

  }

}


















