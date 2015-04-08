package step21.ex1;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/*실습 목표: close 버튼을 눌렀을 때 시스템(JVM)을 종료하기
 *=> Close 버튼을 누르면 WindowEvent가 발생한다.
 *=> JVM은 WindowEvent를 처리할 객체를 찾는다.
 *=> 그 이벤트 처리 객체의 windowClosing() 메서드를 호출한다.
 *
 * 이벤트 처리 과정
 * 1) 사용자가 윈도우의 close 버튼을 누른다.
 * 2) OS는 마우스 신호를 받는다.
 * 3) OS는 어떤 윈도에서 발생된 이벤트인지 좌표를 가지고 검사한다.
 * 4) OS는 해당 윈도우의 MessageQueue에 이벤트 정보를 저장한다.
 * 5) 만약 그 윈도우가 JVM이 생성한 윈도우라면,
 * 
 * JVM이 이벤트를 처리하는 과정
 * 6) MessageQueue에 들어 있는 이벤트 정보를 꺼내서,
 *    이벤트 유형에 따라 EventObject 서브 클래스의 객체를 생성하여 이벤트 정보를 옮긴다.
 *    예) 윈도우의 close 버튼 이벤트는 WindowEvent 객체에 저장된다.
 *    * EventObject: 이벤트 정보를 표현하는 최상위 객체.
 *    
 * 7) 그 EventObject 객체를 EventQueue에 보관한다.
 *    * EventQueue: 이벤트 객체를 순서대로 저장하는 보관소. 
 * 
 * 8) EventDispatchThread는 계속 EventQueue를 감시하고 있다가,
 *    이벤트가 하나 들어 오면 그 이벤트를 꺼낸다.
 * 
 * 9) 이벤트 정보를 조사하여 그 이벤트를 받을 객체에 전달한다.
 * 
 * 10) 해당 객체를 이벤트를 처리할 객체를 찾아서, 규칙에 따라 적절한 메서드를 호출한다.
 *    * 이벤트를 처리하는 객체를 "리스너"라 부른다.
 *    * 규칙? 각각의 이벤트마다 리스너가 반드시 구현해야할 메서드를 정의하고 있다.
 *    예) WindowEvent --> WindowListener(인터페이스)
 *    
 *    * 이벤트를 처리하는 클래스는 반드시 그 규칙에 따라 작성해야 한다.
 *      인터페이스를 구현해야 한다.
 *    예) WindowEvent를 처리하는 클래스는 WindowListener 규칙에 따라 메서드를 만들어야 한다.
 *        곧 WindowListener 구현체가 바로 WindowEvent 처리자이다.
 *
 * 
 * 그림^^
 * 
 * [OS] 이벤트 정보 --> JVM MessageQueue 저장 --> Event 정보 가공 
 *       --> EventQueue 저장 
 * [EventDispatchThread] EventQueue 감시 --> EventQueue에서 Event객체를 꺼냄
 *      --> 이벤트를 발생시킨 윈도우 객체에 전달 --> 이벤트 처리자(리스너)를 찾아서 메서드 호출 
 *      
 *         
 * 이벤트 리스너
 * => 이벤트 소스(이벤트를 발생시킨 위젯)와 리스너(이벤트를 처리하는 객체) 사이의 호출 규칙이다.
 * => 이벤트가 발생했을 때 해당 위젯은 그 이벤트에 맞는 리스너를 찾아서 메서드를 호출한다.
 * => 각 이벤트 마다 호출 규칙이 정해져 있다.
 * => 이벤트 - 리스너 호출 규칙(인터페이스) 
 *    WindowEvent - WindowListener
 *    MouseEvent  - MouseListener
 *    KeyEvent    - KeyListener
 * => 이벤트 소스 객체는 각 이벤트의 호출 규칙에 따라 메서드를 호출한다.
 *                     
 * 실습 목표 해결
 * 1) close 버튼을 눌렀을 때 발생되는 이벤트: WindowEvent
 * 2) WindowEvent를 처리할 때 호출하는 메서드 규칙: WindowListener
 * 3) 특히 close 버튼에 대해 호출하는 메서드 : windowClosing()
 * 
 * 코딩 작업
 * 1) WindowListener를 구현한 클래스를 만든다.
 * 2) windowClosing() 메서드가 호출될 때 JVM을 종료하는 코드를 넣는다.
 * 3) WindowEvent를 발생시키는 Frame 객체에 리스너를 등록한다.
 */


public class Test3 extends Frame {
  private static final long serialVersionUID = 1L;

  class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {} //윈도우를 열때

    @Override
    public void windowClosing(WindowEvent e) { // close 버튼 누를 때
      System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {} // 윈도우를 끝낼 때

    @Override
    public void windowIconified(WindowEvent e) {} //윈도우가 최소화되었을 때

    @Override
    public void windowDeiconified(WindowEvent e) {}//윈도우가 다시 원래 크기로 복원되었을 때

    @Override
    public void windowActivated(WindowEvent e) {} //윈도우가 포커스를 가질 때

    @Override
    public void windowDeactivated(WindowEvent e) {} //윈도우가 포커스를 잃을 때
    
  }
  
  public Test3(String title) {
    super(title);
    
    addWindowListener(new MyWindowListener());
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) throws Exception {
    new Test3("리스너를 첨부한 윈도우");
  }

}










