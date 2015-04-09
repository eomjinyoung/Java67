package step21.ex2;

// 실습 목표: 인터페이스를 구현한 인명 이너 클래스 만들기

public class Test3 {

  static class Mover {
    
  }
  
  static interface Car {
    void run();
    void stop();
  }
  
  static interface Engine {
    
  }
  
  public static void main(String[] args) {
    Car c = new Car() {
      public void run() {
        System.out.println("달린다!");
      }
      
      public void stop() {
        System.out.println("멈춘다...");
      }
    };
    
    c.run();
    c.stop();
    

  }

}














