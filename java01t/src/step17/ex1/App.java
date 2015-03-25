package step17.ex1;

import java.util.Scanner;

import step17.ex1.control.MemberControl;

/* 실습 목표: Fie I/O 기법 
 * => 프로그램을 종료하기 전에 ArrayList에 보관된 사용자 정보를 파일에 출력한다.
 * => 프로그래을 시작할 때 파일에 저장된 데이터를 읽어서 ArrayList에 보관한다.
 * 
 * 학습할 내용:
 * => File 클래스의 용도
 *    - OS의 파일 시스템을 다루는 역할
 *    - 파일을 생성, 삭제, 조회 등의 작업을 수행할 수 있다.
 * => FileReader 클래스의 사용법
 *    - 파일을 읽어서 char 데이터나 char[] 데이터를 출력한다.
 * => FileWriter 클래스의 사용법
 *    - 데이터를 파일로 출력할 때 사용하는 도구
 * 작업:
 * 1) MemberControl에 데이터 저장과 읽기를 수행하는 메서드를 추가한다.
 * 2) MemberDao가 직접 파일 입/출력을 담당한다. 관련 메서드 추가한다.
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
        memberControl.destroy();
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










