package step16.ch01;

import java.util.Scanner;

import step16.ch01.control.MemberControl;

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










