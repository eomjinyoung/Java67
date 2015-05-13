package step22.ex5;

/* 실습 목표: 인터페이스의 다중 상속
 * - 인터페이스의 메서드는 구현하지 않았기 때문에 다중 상속해도 문제가 없다.
 * - 그래서 자바는 인터페이스의 다중 상속을 허용한다.
 * 
 * A            B 
 * . plus();    .multiple();
 * . minus();   .minus();
 * 
 * Test01
 * .plus();
 * .multiple();
 * .minus(); <-- 둘 중에 어떤 것을 상속 받아도 된다.
 * .divide();
 */
public interface Test01 extends A, B{
  int divid(int a, int b);
}
