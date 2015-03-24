package step16.ch03.ui;

import java.util.ArrayList;
import java.util.HashMap;

import step16.ch03.domain.User;

//UIObject 상속 받기
//=> UIObject의 execute() 메서드가 일반 메서드라면,
//   다음과 같이 서브 클래스에서 오버라이딩 하지 않아도 컴파일 할 때 문제되지 않는다.
//=> 그러나, 이것은 이 클래스를 사용하는 MemberControl과의 암묵적인 약속과는 다르다.
//   결국 이 클래스를 사용하는 MemberControl은 원하는 결과를 얻을 수 없을 것이다.
//
//UIObject의 추상 메서드 오버라이딩 하기 
//=> 오버라이딩 하지 않으면 컴파일 오류 발생 => 추상 메서드를 사용하는 이유!
public class MemberList extends UIObject {
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









