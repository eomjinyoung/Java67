package step12.ch05.control;

import step12.ch05.dao.MemberDao;
import step12.ch05.domain.User;
import step12.ch05.ui.MemberAdd;
import step12.ch05.ui.MemberInit;
import step12.ch05.ui.MemberList;

//회원 CRUD 작업을 제어하는 클래스: Control
public class MemberControl {
  MemberDao memberDao;
  MemberInit memberInit;
  MemberAdd memberAdd;
  MemberList memberList;
  
  public MemberControl() {
    memberDao = new MemberDao();
    memberInit = new MemberInit();
    memberAdd = new MemberAdd();
    memberList = new MemberList();
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

  public void list() {
    User[] users = memberDao.selectList();
    memberList.execute(users);
  }

}














