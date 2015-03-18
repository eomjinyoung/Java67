package step12.ch04.control;

import step12.ch04.dao.MemberDao;
import step12.ch04.domain.User;
import step12.ch04.ui.MemberAdd;
import step12.ch04.ui.MemberInit;

//회원 CRUD 작업을 제어하는 클래스: Control
public class MemberControl {
  MemberDao memberDao;
  MemberInit memberInit;
  MemberAdd memberAdd;
  
  public MemberControl() {
    memberDao = new MemberDao();
    memberInit = new MemberInit();
    memberAdd = new MemberAdd();
  }
  
  public void init() {
    memberInit.execute();
    
  }

  public void add() {
    User user = memberAdd.execute();
   
    if (user != null) {
      memberDao.insert(user);
    }
  }

}














