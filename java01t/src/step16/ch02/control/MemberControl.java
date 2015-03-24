package step16.ch02.control;

import java.util.ArrayList;
import java.util.HashMap;

import step16.ch02.dao.MemberDao;
import step16.ch02.domain.User;
import step16.ch02.ui.MemberAdd;
import step16.ch02.ui.MemberChange;
import step16.ch02.ui.MemberDelete;
import step16.ch02.ui.MemberDetail;
import step16.ch02.ui.MemberInit;
import step16.ch02.ui.MemberList;

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
    // 빈 바구니를 준비한다.
    HashMap<String,Object> box = new HashMap<String,Object>();
    
    // 빈 바구니를 주며, 등록할 사용자 정보를 요청한다.
    memberAdd.execute(box); // 사용자 정보를 빈 바구니에 담는다.
    
    // 바구니에 "user"라는 키로 저장된 사용자 정보를 꺼낸다.
    User user = (User) box.get("user");
    
    if (user != null) {
      memberDao.insert(user);
    }
  }

  public void list() {
    ArrayList<User> users = memberDao.selectList();
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














