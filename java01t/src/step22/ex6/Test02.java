package step22.ex6;

/* 실습 목표: 
 * - 멤버 중첩 클래스(member inner class)
 * - 변수나 메서드처럼 public, protected, (default), private 가능
 * 
 */
public class Test02 {
  public class A {}
  class B {}
  protected class C {}
  private class D {}
  
  static public class A2 {}
  static class B2 {}
  static protected class C2 {}
  static private class D2 {}
  
  public void m() {
    class A {}
    // 로컬 중첩 클래스에는 접근 제어자를 사용할 수 없다.
    //public class B {}
    //private class C {}
    //protected class D {}
  }
}
