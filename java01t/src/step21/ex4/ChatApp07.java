package step21.ex4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

// 실습 목표: 채팅 화면 만들기
// => connect 버튼과 send 버튼을 눌러을 때 이벤트 처리하기.
// => 익명 이너 클래스를 사용하는 대신에 직접 인터페이스를 구현한다.
//
public class ChatApp07 extends Frame implements ActionListener {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");
  
  public ChatApp07() {
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
    
    btnConnect.addActionListener(this);
    btnSend.addActionListener(this);
    
    
    setSize(300, 400);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnConnect) {
      JOptionPane.showMessageDialog(null, "오호라...연결연결..");
      
    } else if (e.getSource() == btnSend) {
      JOptionPane.showMessageDialog(null, "보내보내...");
    }
    
  }

  public static void main(String[] args) {
    ChatApp07 chatApp = new ChatApp07();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);
    
  }
}









