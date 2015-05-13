package step22.ex6;

/* 실습 목표: 인스턴스 블록 사용
 * - 생성자를 만들 수 없는 상황에서, 
 *   인스턴스를 생성할 때 반드시 초기화해야 하는 경우에 인스턴스 블록을 사용한다.
 * - 인스턴스 블록은 생성자처럼 매번 객체를 생성할 때마다 실행한다.
 */
public class Test03 {
  static interface Calc {
    int plus(int a, int b);
  }
  
  public static void test(Calc p) {
    System.out.println(p.plus(100, 200));
  }
  
  public static void main(String[] args) {
    class MyCalc implements Calc {
      public int plus(int a, int b) {
        return a + b;
      }
    }
    
    test(new MyCalc());
    
    test(new Calc() {
      public int plus(int a, int b) {
        return a + b;
      }
      {
        System.out.println("오호라..인스턴스 생성됨.");
      }
    });
  }
}














