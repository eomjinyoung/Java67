package step16.ch01.ui;

import java.util.ArrayList;

import step16.ch01.domain.User;

//회원 목록 화면을 다루는 클래스 : Boundary
public class MemberList {

  public void execute(ArrayList<User> users) {
    int index = 0;
    // for (Object Item : 배열 또는 컬렉셕 객체)
    //=> 컬렉션 객체라 함은 Collection 인터페이스(규칙)에 따라 작성된 클래스
    //   예) ArrayList, HashSet, ...
    for (User user : users) {
      System.out.printf("%d, %s, %s, %s\n", 
          index++, user.getName(), user.getEmail(), user.getTel());
    }
    
  }

}
