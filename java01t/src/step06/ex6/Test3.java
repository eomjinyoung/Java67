package step06.ex6;

/* 
 * 인스턴스 변수를 사용하는 메서드를 좀 더 직관적이고 간결하게 표현하기
 * - 인스턴스 주소를 넘기는 방법을 더 간단히 표현한다.
 */

public class Test3 {

  public static void main(String[] args) {
    //3 * 7 - 4 + 8 / 2 = ?
    //5 - 2 * 3 * 2 = ?
    Calculator3 calc1 = new Calculator3();
    Calculator3 calc2 = new Calculator3();
    
    // 인스턴스 주소를 넘기는 위치를 앞으로 이동한다.
    // - 인스턴스 주소가 앞에 위치하므로, 다루는 메모리를 더 강조한다.
    // - 더 직관적이다.
    // - 메서드에 넘기는 것은 그 메서드가 작업하는데 필요한 값이다.
    // - 즉, 메서드가 다루는 메모리와 작업하는데 필요한 값을 분리 => 더 직관적이다.
    //Calculator3.init(3, calc1);
    
    //인스턴스 주소를 메서드 앞에 주면, 클래스 이름은 어떻게 아는가?
    //에이~ 참조 변수가 어떤 클래스의 변수인지 선언문을 보면 알 수 있지 않는가!
    //JVM 똑똑하다!
    // 인스턴스 메서드는 인스턴스 주소 없이 호출할 수 없다.
    //Calculator3.init(3); //문법 오류!
    calc1.init(3);
    calc2.init(5);
    
    calc1.multiple(7);
    calc2.minus(2);
    
    calc1.minus(4);
    calc2.multiple(3);
    
    calc1.plus(8);
    calc2.multiple(2);
    
    calc1.divide(2);
    
    System.out.printf("결과1 = %d\n", calc1.result);
    System.out.printf("결과2 = %d\n", calc2.result);
  }

}














