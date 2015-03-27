package step17.ex4;

// 실습 목표: Decorator 설계 방법 익히기
// => Robot 예제를 통해 데코레이터를 사용하여 기능을 넣고 빼기
// => 데코레이터는 사용자 역할을 하는 클래스와 꾸미는 역할을 하는 클래로 나뉜다.
public class Test1 {

  public static void main(String[] args) {
    //1) 기본 로봇 실행
    ClearRobot r1 = new ClearRobot();
    System.out.println("청소로봇 실행!-------------------");
    r1.run();
    
    AnmaRobot r2 = new AnmaRobot();
    System.out.println("안마로봇 실행!-------------------");
    r2.run();

    //2) 기본 로봇의 기능을 확장하자!
    // 청소로봇 + 알람기능 
    AlarmDecorator d1 = new AlarmDecorator(r1);
    System.out.println("청소로봇 실행예약!-------------------");
    d1.bookRunning(3000);
    
    // 안마로봇 + 알람기능
    AlarmDecorator d2 = new AlarmDecorator(r2);
    System.out.println("안마로봇 실행예약!-------------------");
    d2.bookRunning(5000);
    
    // 안마로봇 + 중복실행 + 알람기능 
    DuplicateDecorator d3 = new DuplicateDecorator(r2);
    AlarmDecorator d4 = new AlarmDecorator(d3);
    System.out.println("안마로봇 실행예약 + 중복실행!-------------------");
    d4.bookRunning(5000);
  }

}











