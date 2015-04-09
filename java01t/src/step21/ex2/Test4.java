package step21.ex2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/* 실습 목표: 멤버 익명 이너 클래스로 리스너 구현하기
 * => 익명 이너 클래스는 인스턴스를 하나 밖에 만들 수 없다.
 * => 인스턴스가 한 개만 필요한 경우 익명 이너 클래스 사용하라!
 */
public class Test4 extends Frame {
  private static final long serialVersionUID = 1L;

  WindowListener listener = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  };
  
  public Test4(String title) {
    super(title);

    addWindowListener(listener);
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) throws Exception {
    new Test4("WindowAdapter 사용");
  }

}










