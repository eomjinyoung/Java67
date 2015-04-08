package step20.ex6;

// 실습 목표: 스레드 만들기
// => Thread 클래스를 상속 받기
//
public class Test3 {

  // 독립적으로 실행할 코드를 담은 스레드 만들기
  static class MyThread extends Thread {
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
    // 스레드 실행하기
    // 1) 스레드 객체 생성 
    MyThread t1 = new MyThread();
    // 2) 스레드 실행하기
    t1.start(); // 스레드에서 run() 메서드를 호출한다.
    
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x /= 2.34;
      System.out.println("main => " + i);
    }

    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x /= 2.34;
      System.out.println("main >>>>>>> " + i);
    }
  }

}
