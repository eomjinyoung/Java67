package step20.ex6;

// 실습 목표: 스레드 생명주기 
// => Thread는 한 번 실행을 종료하면 다시 실행할 수 없다.
//
// new Thread -----------> Runnable <--------> Not Runnable
//                             |
//                             |
//                           Dead
//
// Runnable 상태란? CPU racing 참여한 상태. 곧 CPU를 받을 수 있는 상태.
// Not Runnable 상태란? CPU racing에 배제된 상태. 곧 CPU를 배분에서 제외한 상태.

// 1) new Thread 상태: 객체 생성할 때
// 2) new Thread -> Runnable 상태: start()
// 3) Runnable -> Not Runnable: sleep(), wait()
// 4) Not Runnable -> Runnable: timeout, notify(), notifyAll()
// 5) Runnable -> Dead: 실행 종료!
//
// 주의!
// 6) Runnable -> new Thread: 불가!
// 7) Dead -> Runnable: 불가!
public class Test6 {

  static class MyThread extends Thread {
    int state = 0;
    
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        System.out.println("Thread $$$$ " + i);
      }
      state = 1;
    }
  }
  
  public static void main(String[] args) throws Exception {
    MyThread t1 = new MyThread();
    t1.start(); 
    
    while(true) {
      if (t1.state == 1) {
        System.out.println("다시 스레드 시작!");
        t1.start(); // 오류! 실행 종료된 스레드는 다시 시작시킬 수 없다.
      } else {
        System.out.println("아직 스레드 실행중.......");
      }
      Thread.currentThread().sleep(10); // 50 밀리초 동안 CPU racing에 참여하지 말아라!
      // 50밀리초가 지난 다음 다시 CPU 쟁탈전에 참가한다.
      // 주의! 50밀리초가 지난 다음 즉시 CPU를 갖는 것이 아니다!
    }
    
  }

}







