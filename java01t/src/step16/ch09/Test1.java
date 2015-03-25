package step16.ch09;

// 실습 목적: 클래스는 왜 다중 상속을 못하는가?
// => 다중 상속의 문제점: 같은 이름의 속성이나 메서드가 있을 때 무엇을 상속해야 하는가?
// => 그래서 자바는 다중 상속을 지원하지 않는다.
public class Test1 {
  static class A {
    int a;
    public void m() {
      System.out.println("오호라....");
    }
  }
  
  static class B {
    boolean a;
    public void m() {
      System.out.println("우헤헤...");
    }
  }
  
  // 다중 상속 불가! => 오류!
  /*
  static class C extends A, B {
    // int a 또는 boolean a, 둘 중 무엇을 상속 받을 것인가?
    // A의 m() 또는 B의 m(), 둘 중 무엇을 상속 받을 것인가? 
  }
  */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}









