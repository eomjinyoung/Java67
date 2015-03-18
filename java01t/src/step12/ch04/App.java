package step12.ch04;

import step12.ch04.control.MemberControl;

public class App {

  public static void main(String[] args) {
    MemberControl memberControl = new MemberControl();

    //1) MemberControl에게 init() 메시지를 보낸다.
    memberControl.init();
    
    //2)사용자에게 프롬프트를 출력한다.
    //3)사용자로부터 명령어를 입력 받는다.
    //4)명령어에 따라 MemberControl을 실행한다.
    //5)만약 명령어가 "quit"이라면, 반복을 멈춘다.
    //2) 번으로 돌아간다.
  }

}
