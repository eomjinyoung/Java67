package step21.ex4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 실습 목표: 채팅 화면 만들기
// => Frame의 BorderLayout 사용하기
// => 문제점: 아직 상단과 하단에 위젯이 겹쳐져 있다. 
// 
public class ChatApp04 extends Frame {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");
  
  public ChatApp04() {
    super("비트챗");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    // BorderLayout에게 어디에 배치할지 정확하게 알려준다.
    add(tfServerAddress, BorderLayout.NORTH);
    add(btnConnect, BorderLayout.NORTH);
    add(taContent); // 위치를 지정하지 않으면 BorderLayout.CENTER에 배치한다.
    add(tfMessage, BorderLayout.SOUTH);
    add(btnSend, BorderLayout.SOUTH);
    
    setSize(300, 400);
  }
  
  public static void main(String[] args) {
    ChatApp04 chatApp = new ChatApp04();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }

}









