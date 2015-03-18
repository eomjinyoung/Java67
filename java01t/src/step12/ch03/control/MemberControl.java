package step12.ch03.control;

import step12.ch03.ui.MemberInit;

//회원 CRUD 작업을 제어하는 클래스: Control
public class MemberControl {
  MemberInit memberInit;
  
  public MemberControl() {
    memberInit = new MemberInit();
  }
  
  public void init() {
    memberInit.execute();
    
  }

}
