package step16.ch02;

import java.util.Scanner;

import step16.ch02.control.MemberControl;

/* 상속 : 일반화(Generalization)
 * 1) Specialization(특수화)
 *    => 수퍼 클래스를 상속 받아서 좀 더 특별하게 만드는 것.
 *    => 인스턴스 변수와 메서드를 추가하면 더 특별한 클래스가 된다.
 *    
 * 2) Generalization(일반화)
 *    => 클래스들의 공통 메서드와 인스턴스 변수를 찾아서
 *       수퍼 클래스로 정의하고 그 수퍼 클래스를 상속 받는 것.
 * 
 * 실습 목표
 * => 기존의 UI 클래스들의 공통점을 찾아서 수퍼클래스로 정의하기.
 * => MemberControl이 UI 객체를 사용할 때 더 일관된 방법으로 호출할 수 있다.
 * => 작업:
 *    1) UIObject 클래스 생성
 *    2) 기존 UI 클래스들은 UIObject를 상속 받는다.
 *    3) MemberControl 변경
 * 
 * 추상 클래스
 * => 직접 사용할 일은 없고, 서브 클래스에게 공통으로 상속해 줄 메서드와 인스턴스 변수를 
 *    갖고 있는 클래스를 만들 때 사용하는 문법. 
 * => 서브 클래스에 뭔가를 상속해주는 용도.
 * => UIObject 클래스인 경우, 직접 이 클래스를 사용하기 보다는 
 *    MemberAdd나 MemberList와 같이 UI를 처리하는 클래스를 만들 때 상속받기 위한 용도.
 *    곧 UIObject 클래스를 추상 클래스로 선언하는 것이 적합하다.
 * 
 * 추상 메서드
 * => 어떤 메서드는 이름이나 파라미터, 리턴 타입을 통일시키기 위해 수퍼 클래스에서 정의는 하지만,
 *    실제적인 구현은 서브 클래스에서 해야 할 경우가 있다. 
 *    이런 경우 수퍼 클래스에서 메서드를 구현해봐야 의미없다. 
 *    서브 클래스에서 재정의할 것이기 때문이다.
 * => 또는 수퍼 클래스의 특정 메서드를 서브 클래스에서 반드시 재정의하도록 강제해야 할 때가 있다.
 * => 추상 메서드를 구현하지 않으면 서브 클래스는 추상 클래스가 되어야 한다.
 *    인스턴스를 생성하여 사용할 수 없다.
 */

public class App {

  public static void main(String[] args) {
    MemberControl memberControl = new MemberControl();

    //1) MemberControl에게 init() 메시지를 보낸다.
    memberControl.init();

    String command = null;
    Scanner keyScan = new Scanner(System.in);
    do {
      //2)사용자에게 프롬프트를 출력한다.
      System.out.print(">");
      
      //3)사용자로부터 명령어를 입력 받는다.
      command = keyScan.nextLine();
      String[] token = command.split(" ");
      
      switch (token[0]) {
      case "add":
        memberControl.add();
        break;
      case "list":
        memberControl.list();
        break;
      case "detail":
        memberControl.detail( Integer.parseInt( token[1] ) );
        break;
      case "delete":
        memberControl.delete(Integer.parseInt(token[1]));
        break;
      case "change":
        memberControl.change(Integer.parseInt(token[1]));
        break; 
      case "quit":
        System.out.println("안녕히 가십시오.");
        break;
      default:
        System.out.println("존재하지 않는 명령어입니다.");
      }
      
    //4)명령어에 따라 MemberControl을 실행한다.
    //5)만약 명령어가 "quit"이라면, 반복을 멈춘다.
    //2) 번으로 돌아간다.
    } while (!command.equals("quit"));
    
    keyScan.close();
  }

}










