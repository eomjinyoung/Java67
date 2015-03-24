package step16.ch03.ui;

import java.util.HashMap;
import java.util.Scanner;

//UIObject 인터페이스 구현하기
public class MemberDelete implements UIObject {
  @Override
  public void execute(HashMap<String, Object> paramMap) {
    String command = (String) paramMap.get("command");
    switch (command) {
    case "confirm":
      confirm(paramMap);
      break;
    case "deleteResult":
      deleteResult();
      break;
    }
  }

  //다음 메서드처럼 내부에서만 사용되는 메서드라면, private으로 접근을 제한해야 한다.
  //=> 메서드라고 모두 개방해서는 안된다.
  //=> 외부에서 호출해야 할 메서드만 개방하는 것이 소스의 유지보수에 좋다.
  private void confirm(HashMap<String, Object> paramMap) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("정말 삭제하시겠습니까?(y/n) ");
    String response = keyScan.nextLine();
    
    if (response.equals("y"))
      paramMap.put("response", true);
    else {
      System.out.println("삭제를 취소하였습니다.");
      paramMap.put("response", false);
    }
      
  }

  private void deleteResult() {
    System.out.println("해당 회원을 삭제하였습니다.");
    System.out.println();
  }

}










