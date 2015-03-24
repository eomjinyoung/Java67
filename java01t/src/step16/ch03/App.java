package step16.ch03;

import java.util.Scanner;

import step16.ch03.control.MemberControl;

/* 인터페이스의 활용
 * 
 * 인터페이스란?
 * - 호출자와 호출되는자 사이의 호출 규칙을 정의한 것.
 * - 메서드의 이름, 파라미터, 리턴 타입을 선언한다.
 * - 그러나 메서드를 구현하지는 않는다.
 *   => 인터페이스의 모든 메서드는 public abstract이다.
 *   => 만약 public abstract를 붙이지 않으면 컴파일 할 때 자동으로 붙인다.
 * - 인스턴스 변수를 선언할 수 없다.
 *   => 인터페이스의 모든 변수는 public static final이다.
 *   => 변수에 public static final을 붙이지 않으면 컴파일 할 때 자동으로 붙인다.
 * - 그러나 상수 변수는 선언할 수 있다.
 * 
 * 실습 목표
 * => MemberControl과 UI 클래스 관계를 살펴보면, 
 *    MemberControl이 일방적으로 UI 클래스를 사용한다는 알 수 있다.
 * => UIObject의 execute()는 MemberControl과 UI 클래스 사이의 호출 규칙임을 
 *    알 수 있다.
 * => 그럼에도 불구하고 UIObject는 추상 클래스로 선언하였다.
 * => 사실 추상 클래스의 목적은 서브 클래스에 공통되는 뭔가를 상속해주는 것인데,
 *    UIObject를 보면 서브 클래스를 위해 상속해주는 것이 아무것도 없다.
 * => 이런 경우 차라리 UIObject를 인터페이스로 정의하는 것이 바람직하다.
 * 
 * 자주하는 질문!
 * Q: 추상 클래스에서도 추상 메서드를 선언할 수 있고, 인터페이스에서도 추상 메서드를 선언합니다.
 *    그렇다면 둘 중에 아무거나 사용해도 되지 않나요?
 *
 * A: 짜장면도 배부르고, 김치찌게도 배부르다면 아무거나 먹어도 되지 않나요?
 * A: 기차를 타고 가도 되고, 버스를 타고 가도 된다. 아무거나 타면 되지 않느냐?
 * 
 * 결론: 두 문법의 용도가 다르다. 추상 클래스는 뭔가를 서브 클래스에게 상속해 줄 필요가 있을 때
 *     사용하는 문법. 추상 메서드는 단지 선택사항이다. 서브 클래스에서 오버라이딩 하도록 
 *     강제하는 문법일 뿐이다. 추상 클래스에 반드시 추상 메서드가 있어야 하는 것은 아니다.
 *     
 *     인터페이스는 원래 용도가 호출 규칙을 정의하는 것이다. 
 *     
 *     만약 한 클래스가 여러 개의 규칙을 따를 때 어떻게 할 것인가?
 *     => 추상 클래스의 경우 오직 한 개의 클래스만 상속 받을 수 있기 때문에,
 *        여러 개의 규칙을 준수하는 클래스를 만들 수 없다.
 *     => 인터페이스라면 한 클래스는 여러 개의 인터페이스를 함께 구현할 수 있다.
 *     
 *     그래서 호출 규칙은 인터페이스로 정의하라!
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










