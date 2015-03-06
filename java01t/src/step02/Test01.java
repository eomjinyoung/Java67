package step02;

//표준 출력장치(모니터)로의 출력
//1) System.out
// - System 클래스에 들어 있는 out은 표준 출력 장치인 모니터(콘솔)를 가리킴.
//
//2) System.in
// - System 클래스에 들어 있는 in은 표준 입력 장치인 키보드를 가리킴.
//
//3) System.err
// - System 클래스에 들어 있는 err는 오류를 출력하는 장치(기본 모니터)를 가리킴.
public class Test01 {

  public static void main(String[] args) {
    //print() : 출력한 뒤에 줄 바꿈하지 않는다.
    System.out.print("하하하"); 
    System.out.print("호호호");
    
    //줄 바꿈하고 싶으면 줄 바꿈 명령을 출력하라!
    System.out.print("\n");
    System.out.print("헐...");
    
    //줄 바꿈 명령은 문자열 안에 포함될 수 있다.
    System.out.print("ABC\nDEF\n그렇군요...");
    
    //이렇게 줄 바꿈 명령처럼 문자열 사이에 넣는 특수 명령을 "Escape 문자"라고 한다.
    //-문자인데, 출력되지 않는 문자!
    //Escape 문자: \t(탭), \"(큰따옴표), \'(작은따옴표), \\(역슬래시), ...
    System.out.print("\n가나다\t라마바\t사아자");
    
    System.out.print("\n사람들은 \"행복하다\" 말한다.");
    
    System.out.print("\n이스케이프 문자는 역슬래시(\\) 다음에 명령이 온다.");
    
    System.out.print("\n우리의 작업 폴더는 c:\\bit 이다.");
    
    System.out.print("\n작은 따옴표는 ' 표시합니다.");
    
    char c = '\'';
    
    //println()
    //- 출력문 뒤에 줄 바꿈을 명령을 자동으로 붙인다.
    System.out.println("하하하");
    System.out.println("호호호");
  }

}















