package step05;

/*
 * 명령어를 조직화시키는 문법 
 * 1.메서드 : 명령어 보따리
 * 1) 단순 메서드 
 * void 보따리명() { 명령어들... }
 * 
 * 2) 값을 반환하는 메서드
 * [반환하는 값의 자료형] 보따리명() {
 *    명령어들...
 *    return 반환할 값;
 * }
 * 예:
 * float pi() {
 *   return 3.14159f;
 * }
 * 
 * 3) 값을 전달해야 하는 메서드
 * void 보따리명(전달한 값을 담을 변수 선언, ...) { 명령어들...}
 * 예:
 * void hello(String name) {
 *   System.out.println(name + "님 반갑습니다");
 * }
 * 
 * 4) 값을 받아서 명령어를 수행한 후 그 결과를 반환하는 메서드
 * [반환할 값의 자료형] 보따리명 (전달한 값을 담을 변수 선언, ...) {
 *    명령어들...
 *    return 결과;
 * }
 * 예:
 * int plus(a, b) {
 *   return a + b;
 * }
 *  
 */

public class Test01 {

  // 값을 받아서 명령어를 수행하는 메서드의 활용 예 
  // 명령어 보따리(함수=메서드) 정의!
  static void printBitShiftValue(int value) {
    System.out.println("---------------------");
    System.out.printf("%d, %x\n", value, value);
    System.out.printf("<< 4: %x\n", value << 4);
    System.out.printf(">> 4: %x\n", value >> 4);
    System.out.printf(">>> 4: %x\n", value >>> 4);
    System.out.println("---------------------");
  }
  
  public static void main(String[] args) {
    int value = 1784302138; //0x6a5a4a3a
    
    //명령어 보따리 사용! = 함수 호출 = 메서드 호출
    printBitShiftValue(value);
    
    /*
    System.out.println("---------------------");
    System.out.printf("%d, %x\n", value, value);
    System.out.printf("왼쪽으로 4비트 이동(<<): %x\n", value << 4);
    System.out.printf("오른쪽으로 4비트 이동(>>): %x\n", value >> 4);
    System.out.printf("오른쪽으로 4비트 이동(>>>): %x\n", value >>> 4);
    System.out.println("---------------------");
    */
    
    value = -1784302138;
    
    printBitShiftValue(value);
    /*
    System.out.println("---------------------");
    System.out.printf("%d, %x\n", value, value);
    System.out.printf("왼쪽으로 4비트 이동(<<): %x\n", value << 4);
    System.out.printf("오른쪽으로 4비트 이동(>>): %x\n", value >> 4);
    System.out.printf("오른쪽으로 4비트 이동(>>>): %x\n", value >>> 4);
    System.out.println("---------------------");
    */
    
    printBitShiftValue(34567);
    printBitShiftValue(-2745);
    printBitShiftValue(10);
  }

}












