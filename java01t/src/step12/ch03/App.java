package step12.ch03;

import step12.ch03.control.MemberControl;

public class App {

  public static void main(String[] args) {
    MemberControl memberControl = new MemberControl();

    //1) MemberControl에게 init() 메시지를 보낸다.
    memberControl.init();
  }

}
