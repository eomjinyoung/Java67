package step05;

/* 메서드 호출과 스택 
 * - 메서드 호출 시 스택에 쌓인다는 개념을 좀 더 깊이 실험.
 * - 스택 메모리 그림을 그리고 변수의 생성과 해제 상황을 묘사하라!
 */
public class Test08 {

  static void m1(int a) {
    a += 10;
    m2(a);
    System.out.printf("m1(): %d\n", a);
  }
  
  static void m2(int a) {
    a += 10;
    m3(a);
    System.out.printf("m2(): %d\n", a);
  }
  
  static void m3(int a) {
    a += 10;
    System.out.printf("m3(): %d\n", a);
  }
  
  public static void main(String[] args) {
    int a = 7;
    m1(a);

  }

}
