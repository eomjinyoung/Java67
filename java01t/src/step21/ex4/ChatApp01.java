package step21.ex4;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 실습 목표: 채팅 화면 만들기
// => 기본 윈도우 준비
public class ChatApp01 extends Frame {
  private static final long serialVersionUID = 1L;

  public ChatApp01() {
    super("비트챗");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    setSize(300, 400);
  }
  
  public static void main(String[] args) {
    ChatApp01 chatApp = new ChatApp01();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }

}









