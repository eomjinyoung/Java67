package step21.ex4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 실습 목표: 채팅 화면 만들기
// => 북쪽과 남쪽에 겹쳐진 위젯을 풀기
// => How? Panel 컨테이너를 사용한다.
// 
public class ChatApp05 extends Frame {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");
  
  public ChatApp05() {
    super("비트챗");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    // BorderLayout에게 어디에 배치할지 정확하게 알려준다.
    Panel connectPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
    connectPanel.add(tfServerAddress);
    connectPanel.add(btnConnect);
    add(connectPanel, BorderLayout.NORTH);

    add(taContent); // 위치를 지정하지 않으면 BorderLayout.CENTER에 배치한다.

    Panel messagePanel = new Panel(); // 기본 가운데 정렬
    messagePanel.add(tfMessage);
    messagePanel.add(btnSend);
    add(messagePanel, BorderLayout.SOUTH);
    
    setSize(300, 400);
  }
  
  public static void main(String[] args) {
    ChatApp05 chatApp = new ChatApp05();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }

}









