package step21.ex2;

// 실습 목표: Inner class 만들기
// => 클래스 안에 클래스를 정의하는 것.
// => 클래스의 사용 범위를 특정 클래스나 블록 안으로 제한하기 위해서.
//
// 패키지 멤버 클래스
// => 보통 선언하는 클래스이다.
// 
// 1) top level inner class
// => 패키지 멤버로 만들기에는 너무 작은 클래스인 경우 특정 클래스의 inner 클래스로 만든다.
// => 예) 상수 값을 전문으로 정의하는 클래스(안드로이드에서 많이 사용)
//
// 2) member inner class
// => 특정 클래스의 인스턴스에서 사용하는 클래스.
// => 인스턴스를 통해서 생성 가능.
//
// 3) local inner class
// => 특정 메서드에서 사용하는 클래스.
// 
// 4) anonymous inner class
// => 익명 클래스이다. 단 한 인스턴스만 생성할 필요가 있을 때 사용.
// => 클래스의 이름이 없기 때문에 클래스를 정의하자마자 생성해야 한다.

public class Test1 {

  static class TopLevelInnerClass {}
  
  class MemberInnerClass {}
  
  //익명 이너 클래스
  Object obj = new Object() {};
  
  public void m() {
    class LocalInnerClass {}
    
    LocalInnerClass r = new LocalInnerClass();
    
    //익명 이너 클래스
    Object obj2 = new Object() {};
    
  }
  
  // 용어정리!
  // 클래스 멤버: static 변수, static 메서드, static inner class
  // 인스턴스 멤버: 인스턴스 변수, 인스턴스 메서드, 인스턴스 이너 클래스
  
  
  static int i;
  int j;
  
  public static void main(String[] args) {
    // 1) top level inner class 사용
    // => static 블록에서는 그냥 사용한다.
    TopLevelInnerClass r1 = new TopLevelInnerClass();
    
    // 2) member inner class 사용
    // => static 블록은 인스턴스 멤버에 접근할 수 없다.
    i = 10; // 클래스 멤버에 접근 가능 
    //j = 20; // 인스턴스가 존재하지 않기 때문에 접근 불가. 오류!
    //MemberInnerClass r2 = new MemberInnerClass();
    Test1 p = new Test1();
    p.j = 20; // 인스턴스 변수는 인스턴스가 있어야 한다.
    MemberInnerClass r2 = p.new MemberInnerClass();
    
    
    // 3) local innser class 사용 
    // => m() 메서드를 볼 것.
    //LocalInnerClass r = new LocalInnerClass(); //다른 메서드에서는 사용 불가능!
    
    // 4) anonymous inner class
    // => 문법 
    // new [수퍼클래스 또는 인터페이스](수퍼 클래스 생성자 파라미터 값) {클래스 정의}
    // => 클래스 이름이 없기 때문에 클래스를 정의하지마자 바로 인스턴스를 만들어야 한다.
    //
    /*
    class  extends Object {
      public void hello() {
        System.out.println("안녕~~");
      }
    }
    
    class  extends Object {
      public void hello() {
        System.out.println("반가워~~");
      }
    }
    */
    
    // 클래스 이름이 없으면, 다음과 같이 인스턴스 생성에 문제가 발생한다.T.T
    // p = new ();
    // p2 = new ();
    
    // 익명 이너 클래스에 대한 자세한 설명 Test2.java를 보라!
  }

}














