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
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

// 실습 목표: 채팅 화면 만들기
// => 서버에 메시지 보내기.
// => 서버가 보낸 메시지 받아서 메시지 창에 출력하기.
// 
// ActionEvent
// => Button을 눌렀을 때
// => TextField에서 엔터를 쳤을 때
// => ActionEvent를 발생시키는 객체는 액션 명령을 등록할 수 있다.
// => 액션 명령은 이벤트에 보관되면, 이벤트를 구분할 때 사용할 수 있다.
// => 액션 명령을 이용하면 여러 버튼을 같은 액션으로 묶을 수 있다.
// 
public class ChatApp09 extends Frame 
    implements ActionListener, Runnable {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");

  Socket socket;
  Scanner in;
  PrintStream out;

  public ChatApp09() {
    super("비트챗");

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          out.println("quit");
          String response = in.nextLine();
          taContent.append(response + "\n");

        } catch (Exception ex) {
          // 연결 끊다가 오류 났는데 어쩌라고? 무시!
        } finally {
          try {in.close();} catch (Exception ex) {}
          try {out.close();} catch (Exception ex) {}
          try {socket.close();} catch (Exception ex) {}
        }
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
    btnConnect.setActionCommand("connectAction");
    tfServerAddress.addActionListener(this);

    btnSend.addActionListener(this);
    btnSend.setActionCommand("sendAction");
    tfMessage.addActionListener(this);

    setSize(300, 400);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 액션 명령으로 구분할 수도 있음. 참고!
    if (e.getActionCommand().equals("connectAction")
        || e.getSource() == tfServerAddress) {
      try {
        socket = new Socket(tfServerAddress.getText(), 8888);
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());

        taContent.append("서버와 연결되었습니다\n");

        new Thread(this).start();


      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "서버 연결 실패!");
      }

    } else if (e.getSource() == btnSend || e.getSource() == tfMessage) {
      try {
        out.println(tfMessage.getText());
        tfMessage.setText("");
        tfMessage.requestFocus();

      } catch (Exception e2) {
        JOptionPane.showMessageDialog(null, "메시지 전송 실패!");
      }
    }

  }
  
  @Override
  public void run() {
    try {
      while (true) {
        taContent.append(in.nextLine() + "\n");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "메시지 수신 실패!");
    }
  }

  public static void main(String[] args) {
    ChatApp09 chatApp = new ChatApp09();

    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }
}









