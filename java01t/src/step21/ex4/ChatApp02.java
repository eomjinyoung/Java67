package step21.ex4;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 실습 목표: 채팅 화면 만들기
// => 챗 화면에 들어갈 구성 요소를 준비
// => 화면을 구성하는 작은 UI 객체를 "위젯(Widget)"라고도 한다.
// 
// UI 객체의 계층 구조
// Component --> UI의 기본 속성과 기능을 정의
//   => Button, TextField, TextArea 등 ---> Atomic 컴포넌트. 최소 단위 UI 객체.
//   => Container  ---> 다른 위젯을 담을 수 있는 기능을 추가함.
//        => Panel      ---> 여러 위젯을 묶을 때 사용.
//        => Window     ---> 타이틀 바, 경계선 등을 기본으로 갖고 있는 윈도우.
//             => Dialog    ---> 최소/최대 버튼이 없는 윈도우.
//             => Frame     ---> 최소/최대 버튼이 있는 기본 윈도우.
//   => JCompoment ---> 이 계열의 클래스가 Swing 컴포넌트(JFC)이다.
//
// 자바에서 모든 UI 객체는 Component의 자손이다.
//
public class ChatApp02 extends Frame {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("연결");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("보내기");
  
  public ChatApp02() {
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
    ChatApp02 chatApp = new ChatApp02();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }

}









