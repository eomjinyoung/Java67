package step16.ch02.ui;

import java.util.Scanner;

//회원 삭제 화면을 다루는 클래스 : Boundary
public class MemberDelete {

  public boolean confirm() {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("정말 삭제하시겠습니까?(y/n) ");
    String response = keyScan.nextLine();
    
    if (response.equals("y"))
      return true;
    else {
      System.out.println("삭제를 취소하였습니다.");
      return false;
    }
      
  }

  public void execute() {
    System.out.println("해당 회원을 삭제하였습니다.");
    System.out.println();
  }

}










