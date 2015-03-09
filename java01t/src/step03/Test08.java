package step03;

/* 
 * 조건 연산자 : 피연산자(operand)가 논리 값이어야 한다.
 * - &&, ||, ?:
 * 1) && - 두 개의 논리 값이 모두 true일 때, 결과는 true.
 * 2) || - 둘 중 하나라도 true이면, 결과는 true.
 * 3) 조건 ? 문장1 : 문장2 - 조건이 true면 문장1 수행. false면 문장2 수행.
 */
public class Test08 {

  public static void main(String[] args) {
    int v1 = 10, v2 = 20;
    //System.out.printf("%b", v1 && v2); // 피연산자가 int이다. 오류! 
    
    System.out.printf("%b, %b\n", true && true, true && false);
    System.out.printf("%b, %b\n", false || false, true || false);
    System.out.printf("%s\n", (11 < 11) ? "작다" : "크거나 같다");
    
    
    // && vs &
    // x && y : x가 거짓이면 y는 수행하지 않는다.(효율적)
    // x & y : x가 거짓이라도 y를 끝까지 수행한다.(비효율적)
    // & 또는 |의 경우 피연산자가 논리 값이라면, 
    // 비트 연산자가 아니라  AND, OR 논리 연산자로 동작한다.
    boolean v3 = false;
    boolean r1 = (10 > 100) && (v3 = true);
    System.out.printf("%b, %b\n", r1, v3);
    
    v3 = false;
    r1 = (10 > 100) & (v3 = true);
    System.out.printf("%b, %b\n", r1, v3);
    
    // || vs |
    // x || y : x가 true이면 y를 실행하지 않는다.(효율적)
    // x | y : x가 true일지라도 y를 끝까지 실행한다.(비효율적)
    v3 = false;
    r1 = (10 < 100) || (v3 = true);
    System.out.printf("%b, %b\n", r1, v3);
    
    v3 = false;
    r1 = (10 < 100) | (v3 = true);
    System.out.printf("%b, %b\n", r1, v3);
    
  }

}














