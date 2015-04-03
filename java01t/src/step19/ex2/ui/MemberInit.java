package step19.ex2.ui;

import java.util.HashMap;

//UIObject 인터페이스 구현하기
public class MemberInit implements UIObject{
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    System.out.println("회원 관리 시스템에 오신 걸 환영합니다.");
  }

}
