package step22.ex4;

/* 실습 목표: 다중 상속이 불가한 이유?
 * A            B 
 * . plus()     .multiple()
 * . minus()    .minus()
 * 
 * Test01
 * .plus()
 * .multiple()
 * .minus() <-- 둘 중에 어떤 것을 상속 받아야 하는가?
 *              유지보수가 더 복잡해진다.
 *              자바에서는 다중 상속을 제거했다.
 * 
 */

public class Test01 extends A /*, B*/{

}
