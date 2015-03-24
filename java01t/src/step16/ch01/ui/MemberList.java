package step16.ch01.ui;

import step16.ch01.domain.User;

//회원 목록 화면을 다루는 클래스 : Boundary
public class MemberList {

  public void execute(User[] users) {
    int index = 0;
    for (User user : users) {
      System.out.printf("%d, %s, %s, %s\n", 
          index++, user.getName(), user.getEmail(), user.getTel());
    }
    
  }

}
