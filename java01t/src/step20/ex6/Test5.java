package step20.ex6;

// 실습 목표: 스레드 만들기
// => Runnable 인터페이스 구현하기
//
// 실무에서는 Thread를 상속 받는 방법 보다 Runnable을 구현하는 방법을 많이 쓴다.
//
public class Test5 {

  // 독립적으로 실행할 코드를 담은 클래스 만들기
  static class MyWork implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        double x = 20.12345;
        x /= 2.34;
        System.out.println("Thread $$$$ " + i);
      }
    }
  }
  
  public static void main(String[] args) {
    // Runnable 클래스를 스레드로 실행하기
    // 1) 스레드 객체 생성 
    Thread t1 = new Thread(new MyWork());
    // 2) 스레드 실행하기
    t1.start(); // 스레드에서 run() 메서드를 호출한다.
    
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x /= 2.34;
      System.out.println("main => " + i);
    }

    
  }

}
