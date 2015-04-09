package step21.ex4;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 실습 목표: 채팅 화면 만들기
// => 준비한 위젯을 프레임 윈도우에 넣기
// => 실행하면 보내기 버튼이 화면 전체를 채운다.
// => 이유? 레이아웃 관리자가 위젯을 그렇게 배치하기 때문이다.
//
// 레이아웃 관리자?
// => 컨테이너에 넣는 자식 위젯의 배치를 관리한다.
// 
// 레이아웃 관리자 유형
// 1) BorderLayout : 동, 서, 남, 북, 가운데, 이렇게 다섯 개의 영역에 위젯을 배치한다.
//                   Frame 윈도우의 기본 레이아웃 관리자다.
//                   하나의 영역에 오직 한 개의 위젯만 올 수 있다.
// 2) FlowLayout : 왼쪽에서 오른쪽으로 위젯을 배치한다. 윈도우의 너비를 넘어가면 줄을 바꿔
//                 배치한다. 가운데 정렬을 수행한다.
//                 Panel 컨테이너의 기본 레이아웃 관리자다.
// 3) GridLayout : 전체 영역을 지정된 너비, 높이로 동일한 크기로 쪼갠다.
//                 위젯을 바둑판 식으로 배치한다.
// 4) GridBagLayout : GridLayout에 셀 병합 기능을 추가하였다.
// 5) CardLayout : 같은 위치에 위젯을 겹쳐서 배치한다. 탭을 구현할 때 사용.
// 6) BoxLayout : 위젯을 묶어 수평 정렬 또는 수직 정렬하여 배치한다.
// 7) 레이아웃 매니저를 설정하지 않으면 절대 좌표로 배치한다.
//
// 컨테이너가 직접 배치하지 않고, 레이아웃 매니저가 배치를 수행한다.
//
public class ChatApp03 extends Frame {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");
  
  public ChatApp03() {
    super("비트챗");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    add(tfServerAddress);
    add(btnConnect);
    add(taContent);
    add(tfMessage);
    add(btnSend);
    
    setSize(300, 400);
  }
  
  public static void main(String[] args) {
    ChatApp03 chatApp = new ChatApp03();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);

  }

}









