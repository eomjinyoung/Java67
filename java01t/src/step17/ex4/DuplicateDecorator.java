package step17.ex4;

// 로봇을 두 번 연속 실행하는 역할
// 데코레이터 만들기
// 1) 생성자에서 실제 일을 할 로봇 객체를 받는다.
public class DuplicateDecorator extends Robot {
  Robot robot;
  
  public DuplicateDecorator(Robot robot) {
    this.robot = robot;
  }
  
  @Override
  public void run() {
    robot.run();
    robot.run();
  }

}
