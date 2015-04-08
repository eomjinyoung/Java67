package step20.ex6;

// 실습 목표: Runnable 인터페이스로 스레드를 구현할 때 장점
// => 인터페이스는 누구나 구현할 수 있다.
//
public class Test5 implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x /= 2.34;
      System.out.println("Thread $$$$ " + i);
    }
  }
  
  public static void main(String[] args) {
    // Runnable 클래스를 스레드로 실행하기
    // 1) 스레드 객체 생성 
    Thread t1 = new Thread(new Test5());
    // 2) 스레드 실행하기
    t1.start(); // 스레드에서 run() 메서드를 호출한다.
    
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x /= 2.34;
      System.out.println("main => " + i);
    }

    
  }

}
