package step22.ex5;

/* 실습 목표: 인터페이스 다중 구현이 가능하다.
 * - 다중 구현할 때 여러 인터페이스에 중복된 메서드가 있더라도
 *   클래스 입장에서는 같은 메서드이기 때문에 하나만 구현하면 된다. 
 */

public class Test02 implements A, B {

  @Override
  public int multiple(int a, int b) {
    return a * b;
  }

  @Override
  public int plus(int a, int b) {
    return a + b;
  }

  @Override
  public int minus(int a, int b) {
    return a - b;
  }
}
