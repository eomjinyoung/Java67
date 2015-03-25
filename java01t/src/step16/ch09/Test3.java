package step16.ch09;

// 실습 목표: 다중 인터페이스 상속 받기, 다중 인터페이스 구현하기
// => 인터페이스는 클래스와 달리 여러 개의 인터페이스를 상속 받을 수 있다.
//
// 용어 정리
// 메서드의 형식 => 리턴타입, 메서드명, 파라미터 타입을 가리킴 
// => 자바 언어: "method signature"
// => C 언어: "function prototype" 
public class Test3 {
  static interface Battery {
    void charge();
    void dashboard();
    void flush();
  }
  
  static interface Car {
    void accelerate();
    void reduce();
    void stop();
    void dashboard();
    void flush(int level); // Battery의 flush()와 다르다. 형식이 다르기 때문!
  }
  
  // 인터페이스의 다중 상속!
  // 질문: 클래스는 다중 상속이 불가능하다고 했습니다.
  //      수퍼 클래스에 같은 이름의 메서드가 있을 때, 그 중에서 어떤 메서드를 상속 받아야
  ///     할지 결정할 수 없기 때문이라고 했습니다.
  //      위의 Battery 와 Car도 같은 이름의 메서드가 있습니다.
  //      따라서, 두 개 모두 상속 받을 때 충돌이 발생하지 않겠습니까?
  //
  // 답변: 인터페이스의 메서드는 구현하지 않았기 때문에 어떤 메서드를 상속 받더라도 문제가 없다.
  //      ==> 인터페이스는 다중 상속을 허용한다.
  static interface ElectricCar extends Battery, Car {
    void aircon();
  }
  
  // 다중 인터페이스 구현!
  // 질문: 여러 개의 인터페이스를 구현할 때, 
  //      그 인터페이스에 같은 형식을 갖는 메서드가 있다면(예: void dashboard()),
  //      클래스에서는 어떻게 해야 하나?
  
  // 답변: 문법으로 보면, TeslaCar는 분명히 Battery 규칙을 준수하고 있다.
  //      그래서, 둘 중 한 메서드에 대해서만 구현하면 된다.
  //
  // 특이한 질문: 각 인터페이스의 메서드를 따로 구분하여 구현하는 방법은 없습니까?
  // 평범한 답변: 없다!
  static class TeslaCar implements Battery, Car {
    @Override public void accelerate() {} // Car의 규칙
    @Override public void reduce() {} // Car의 규칙
    @Override public void stop() {} // Car의 규칙
    @Override public void charge() {} // Battery 규칙
    @Override public void dashboard() {} // Battery 규칙, Car 규칙
    @Override public void flush(int level) {}
    @Override public void flush() {}
  }
}








