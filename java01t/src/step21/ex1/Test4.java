package step21.ex1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/* 실습 목표: 이벤트 리스너를 좀 더 쉽게 만들기
 * => 인터페이스를 미리 구현한 추상 클래스의 도움을 받는다.
 * => WindowListener를 구현하려면 해당 인터페이스의 모든 메서드(7개)를 구현해야 한다.
 * => WindowAdapter 클래스의 도움을 받으면 특정 메서드만 오버라이딩 할 수 있다.
 */


public class Test4 extends Frame {
  private static final long serialVersionUID = 1L;

  // WindowAdapter : WindowListener 인터페이스를 미리 구현한 추상 클래스이다.
  // => 이 클래스를 상속 받으면, 필요한 메서드만 오버라이딩 할 수 있어 좋다.
  class MyWindowListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) { // close 버튼 누를 때
      System.exit(0);
    }
  }
  
  public Test4(String title) {
    super(title);
    
    addWindowListener(new MyWindowListener());
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) throws Exception {
    new Test4("WindowAdapter 사용");
  }

}










