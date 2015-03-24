package step16.ch02.ui;

import java.util.HashMap;

//UIObjct 상속 받기
//=> 특별히 많은 일을 하지 않아도, 일관된 코딩을 위해 동일한 클래스를 상속 받게 한다.
public class MemberInit extends UIObject{
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    System.out.println("회원 관리 시스템에 오신 걸 환영합니다.");
  }

}
