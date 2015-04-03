package step19.ex2.ui;

import java.util.ArrayList;
import java.util.HashMap;

import step19.ex2.domain.User;

//UIObject 인터페이스 구현하기
public class MemberList implements UIObject {
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    ArrayList<User> users = (ArrayList<User>) paramMap.get("users");
    
    System.out.println("번호, 이름, 이메일, 전화");
    System.out.println("----------------------");

    for (User user : users) {
      System.out.printf("%d, %s, %s, %s\n", 
          user.getNo(), user.getName(), user.getEmail(), user.getTel());
    }
    
  }

}









