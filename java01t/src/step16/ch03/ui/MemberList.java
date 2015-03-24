package step16.ch03.ui;

import java.util.ArrayList;
import java.util.HashMap;

import step16.ch03.domain.User;

//UIObject 인터페이스 구현하기
public class MemberList implements UIObject {
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    ArrayList<User> users = (ArrayList<User>) paramMap.get("users");
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









