package step20.ex6;

// 실습 목표: 스레드 우선순위
// 스레드 생성
// => 현재 스레드의 자식 스레드가 된다.
// => 자식 스레드는 부모 스레드의 우선 순위를 그대로 물려 받는다.
public class Test2 {

  public static void main(String[] args) {
    // 스레드를 생성할 때의 실행하는 스레드가 부모 스레드다.
    // main() 호출하는 스레드: main 스레드
    // 다음 스레드는 main의 자식 스레드이다.
    Thread t1 = new Thread();
    
    System.out.println("t1 스레드 우선순위:" + t1.getPriority());
    System.out.println("현재 main 스레드 우선순위:" + 
                Thread.currentThread().getPriority());
    
  }
}
