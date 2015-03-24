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
    memberInit.execute(null);
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
    
    HashMap<String,Object> box = new HashMap<String,Object>();
    box.put("users", users);

    // MemberList.bak01 소스
    // 안타깝게도 MemberList의 execute() 메서드를 오버라이딩 하지 않았다.
    // 그래서 다음은 UIObject에서 상속 받은 메서드를 호출하는 것이다.
    // 당연히 아무런 일도 하지 않을 것이다.
    //
    // 상속 받은 메서드를 반드시 오버라이딩 해야 하는데, 
    // MemberList처럼 개발자가 실수로 오버라이딩 하지 않는 경우가 있다.
    // 그래도 컴파일에는 문제가 없다. 단지 실행에서 원하는대로 동작이 안될 뿐....
    // 
    // MemberList.java 소스 
    // => 서브 클래스가 수퍼 클래스의 특정 메서드를 반드시 오버라이딩 하게끔 강제시키는 방법
    //    "추상 메서드"
    memberList.execute(box);
  }

  public void detail(int no) {
    User user = memberDao.select(no);

    HashMap<String,Object> box = new HashMap<String,Object>();
    box.put("user", user);
    memberDetail.execute(box);
  }

  public void delete(int no) {
    HashMap<String,Object> box = new HashMap<String,Object>();
    box.put("command", "confirm");
    memberDelete.execute(box); // confirm() 메서드를 호출할 것이다.
    
    boolean response = (Boolean)box.get("response");
    if (response == true) {
      memberDao.delete(no);
      box.put("command", "deleteResult");
      memberDelete.execute(box); // deleteResult() 메서드를 호출할 것이다.
    }
  }

  public void change(int no) {
    User user = memberDao.select(no);
    
    HashMap<String,Object> box = new HashMap<String,Object>();
    box.put("user", user);
    
    memberChange.execute(box);
    
    User changedUser = (User) box.get("changedUser");
    
    if (changedUser != null) {
      memberDao.update(no, changedUser);
    }
  }

}














