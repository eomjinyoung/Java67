package step16.ch02.ui;

import java.util.HashMap;

import step16.ch02.domain.User;

//UIObject 상속 받기
public class MemberDetail extends UIObject {
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    User user = (User) paramMap.get("user");
    System.out.printf("이름: %s\n", user.getName());
    System.out.printf("이메일: %s\n", user.getEmail());
    System.out.printf("전화: %s\n", user.getTel());
    System.out.printf("홈페이지: %s\n", user.getHomepage());
    System.out.printf("트위터: %s\n", user.getTwitter());
    System.out.println();
  }

}
