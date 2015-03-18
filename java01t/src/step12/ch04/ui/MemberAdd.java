package step12.ch04.ui;

import java.util.Scanner;

import step12.ch04.domain.User;

//회원 등록 화면을 다루는 클래스 : Boundary
public class MemberAdd {

  public User execute() {
    Scanner keyScan = new Scanner(System.in);
    
    //0) 사용자가 입력한 값을 저장할 User 인스턴스를 준비한다.
    User user = new User();
    
    //1) "이름: " 출력하고, 사용자로부터 이름을 입력 받는다.
    System.out.print("이름: ");
    user.setName(keyScan.nextLine());
    
    //2) "이메일: " 출력하고, 사용자로부터 이메일을 입력 받는다.
    System.out.print("이메일: ");
    user.setEmail(keyScan.nextLine());
    
    //3) "전화: " 출력하고, 사용자로부터 전화번호를 입력 받는다.
    System.out.print("전화: ");
    user.setTel(keyScan.nextLine());
    
    //4) "홈페이지: " 출력하고, 사용자로부터 홈페이지 URL을 입력 받는다.
    System.out.print("홈페이지: ");
    user.setHomepage(keyScan.nextLine());
    
    //5) "트위터: " 출력하고, 사용자로부터 트위터 아이디를 입력 받는다.
    System.out.print("트위터: ");
    user.setTwitter(keyScan.nextLine());
    
    //6) 저장 여부를 묻는다.
    System.out.print("저장하시겠습니까?(y/n) ");
    String response = keyScan.nextLine();
    
    //여기서 닫으면 같은 키보드에 연결되어 있는 App의 keyScan 객체를 사용할 수 없다.
    //keyScan.close(); //사용 후 자원 해제
    
    //7) 답변이 y이면, 안내 문구와 더불어 멤버 정보를 리턴한다.
    //8) 답변이 n이면, 안내 문구와 더불어 null을 리턴한다.
    if (response.equals("y"))
      return user;
    else 
      return null;
  }

}






