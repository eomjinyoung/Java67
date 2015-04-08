package step20.ex6;

// Thread
// => 프로세스에 종속되어 독립적으로 실행하는 코드 블록
// => 프로세스의 Heap, Method Area 영역을 공유
// => Stack 영역을 개별 관리
//
// JVM 프로세스도 실행할 때 여러 스레드를 보유한다.
// => 가비지 콜렉터: 프로그램 실행과는 달리 별도로 실행해야 한다.
// => main() 메서드 호출하는 스레드
// => 객체 레퍼런스 관리하는 스레드 
//
// 실습 목표: JVM이 실행할 함께 존재하는 스레드 알아내기.
// => 스레드 지도 
// 
// [TG]system <-- 최상위 스레드 그룹
//      - Reference Handler 스레드
//      - Finalizer 스레드
//      - Signal Dispatcher 스레드
//      - [TG]main
//             - main 스레드
public class Test1 {

  public static void main(String[] args) {
    // 현재 명령을 실행하는 스레드를 리턴한다.
    Thread main = Thread.currentThread();
    System.out.println("현재 스레드:" + main.getName());
    
    // 스레드가 소속되어 있는 그룹 알아내기
    ThreadGroup mainTG = main.getThreadGroup();
    System.out.println("main 스레드가 소속되어 있는 그룹: " + mainTG.getName());
    
    // main 스레드 그룹의 바깥 그룹 알아내기
    ThreadGroup systemTG = mainTG.getParent();
    System.out.println("main 그룹의 바깥 그룹은: " + systemTG.getName());
    
    // system 그룹에 속해있는 하위 스레드 그룹 알아내기
    // 1) 하위 스레드 그룹을 담을 배열을 준비한다.
    ThreadGroup[] childGroups = new ThreadGroup[100];
    
    // 2) system의 하위 그룹 목록 얻기
    int count = systemTG.enumerate(childGroups);
    
    // 3) 하위 그룹 개수만큼 그룹 이름 출력하기
    for (int i = 0; i < count; i++) 
      System.out.println(childGroups[i].getName());

    // main 그룹의 하위 스레드 그룹 알아내기
    count = mainTG.enumerate(childGroups);
    for (int i = 0; i < count; i++) 
      System.out.println(childGroups[i].getName());
    
    // system 그룹의 스레드 목록 알아내기
    Thread[] threadList = new Thread[100];
    count = systemTG.enumerate(threadList, false);
    for (int i = 0; i < count; i++) 
      System.out.println("system => " + threadList[i].getName());
    
    // main 그룹의 스레드 목록 알아내기
    count = mainTG.enumerate(threadList, false);
    for (int i = 0; i < count; i++) 
      System.out.println("main => " + threadList[i].getName());
    
    System.out.println("----------------------------");
    systemTG.list();
  }

}

















