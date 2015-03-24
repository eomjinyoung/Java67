package step16.ch01.control;

import step16.ch01.dao.MemberDao;
import step16.ch01.domain.User;
import step16.ch01.ui.MemberAdd;
import step16.ch01.ui.MemberChange;
import step16.ch01.ui.MemberDelete;
import step16.ch01.ui.MemberDetail;
import step16.ch01.ui.MemberInit;
import step16.ch01.ui.MemberList;

//회원 CRUD 작업을 제어하는 클래스: Control
public class MemberControl {
  MemberDao memberDao;
  MemberInit memberInit;
  MemberAdd memberAdd;
  MemberList memberList;
  MemberDetail memberDetail;
  MemberDelete memberDelete;
  MemberChange memberChange;
  
  public MemberControl() {
    memberDao = new MemberDao();
    memberInit = new MemberInit();
    memberAdd = new MemberAdd();
    memberList = new MemberList();
    memberDetail = new MemberDetail();
    memberDelete = new MemberDelete();
    memberChange = new MemberChange();
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

  public void detail(int no) {
    User user = memberDao.select(no);
    memberDetail.execute(user);
  }

  public void delete(int no) {
    boolean response = memberDelete.confirm();
    if (response == true) {
      memberDao.delete(no);
      memberDelete.execute();
    }
  }

  public void change(int no) {
    User user = memberDao.select(no);
    User changedUser = memberChange.execute(user);
    if (changedUser != null) {
      memberDao.update(no, changedUser);
    }
  }

}














