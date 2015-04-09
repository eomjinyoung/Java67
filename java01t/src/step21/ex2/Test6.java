package step21.ex2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/* 실습 목표: 로컬 익명 이너 클래스로 리스너 구현하기
 * => 인스턴스를 한 번 밖에 쓰지 않는다면 굳이 참조 변수를 선언할 필요가 없다.
 */
public class Test6 extends Frame {
  private static final long serialVersionUID = 1L;

  
  public Test6(String title) {
    super(title);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) throws Exception {
    new Test6("WindowAdapter 사용");
  }

}










