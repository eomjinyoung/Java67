package step17.ex4;

// Robot에 기능을 덧 붙이는 역할
// - 이 클래스는 안마 기능을 덧 붙인다.
// - Decorator 역할을 수행하는 클래스는
//   1) 주요 클래스와 동일하게 같은 수퍼 클래스를 상속 받아야 한다.
//   2) 생성자에서 기능을 확장할 객체를 받아야 한다.
public class AlarmDecorator extends Robot {
  Robot robot;
  
  public AlarmDecorator(Robot robot) {
    this.robot = robot;
  }
  
  @Override
  public void run() {
    // 데코레이터 역할을 수행하는 클래스는 직접 작업을 해서는 안된다.
    // 생성자에서 받은 객체를 사용하여 작업을 수행한다. 
    robot.run();
  }
  
  public void bookRunning(int millis) {
    try {
      Thread.sleep(millis);
      run();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}







