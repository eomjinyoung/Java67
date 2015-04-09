package step21.ex2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/* 실습 목표: 로컬 익명 이너 클래스로 리스너 구현하기
 */
public class Test5 extends Frame {
  private static final long serialVersionUID = 1L;

  
  public Test5(String title) {
    super(title);

    WindowListener listener = new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    
    addWindowListener(listener);
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) throws Exception {
    new Test5("WindowAdapter 사용");
  }

}










