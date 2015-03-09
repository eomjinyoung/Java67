package step04;

/*
 * 조건문: switch
 * 문법
 * switch(4바이트 정수값) {
 *   case 상수:
 *      명령들...
 *      break; 
 *   case 상수:
 *      명령들...
 *      break;
 *   default:
 *      명령들...
 * }
 * 
 * JDK7부터는 switch 조건에 문자열을 넣을 수 있다.
 * 
 * switch 조건: byte, short, int, char, Enum 타입 값, 문자열
 */
public class Test02 {

  public static void main(String[] args) {
    int level = 0;
    
    // 표준 사용 예 
    switch (level) {
    case 0:
      System.out.println("손님입니다.");
      break;
    case 1:
      System.out.println("일반 사용자입니다.");
      break;
    case 2:
      System.out.println("관리자입니다.");
      break;
    default:
      System.out.println("허용되지 않은 권한입니다");
    }

    System.out.println("-------------------");
    
    //break 사용 
    //break를 사용하지 않으면, break를 만날 때까지 또는 스위치 문을 나갈 때까지 
    //다음 문장을 계속 실행한다.
    level = 1;
    int bonusPoint = 0;
    switch (level) {
    case 3:
      System.out.println("최우수 사용자 포인트 적립");
      bonusPoint += 3000;
      //break;
    case 2:
      System.out.println("우수 사용자 포인트 적립");
      bonusPoint += 1000;
      //break;
    case 1:
      System.out.println("일반 사용자 포인트 적립");
      bonusPoint += 100;
      //break;
    default:
      System.out.println("손님은 포인트 적립 안함.");
    }
    
    System.out.println(bonusPoint);
    
    System.out.println("--------------------------");
    
    //스위치의 조건 
    byte b = 100;
    short s = 200;
    int i = 300;
    long l = 400;
    float f = 500f;
    double d = 600;
 
    switch (b) {}
    switch (s) {}
    switch (i) {}
    //switch (l) {} //오류!
    //switch (f) {} //오류!
    //switch (d) {} //오류!
    
    //문자 : 2byte 크기의 정수 값이기 때문에 가능하다.
    //case의 값: 반드시 상수이어야 한다. 중보되어서는 안된다.
    char c = '가';
    switch (c) {
    case '가':
      System.out.println("1." + c);
      break;
    case 0xAC01:
      System.out.println("2." + c);
      break;
    
    //case 0xAC01:  //case 값이 중복되어서는 안된다. 오류!
      
    case 0xAC00 + 2: //상수와 상수의 연산은 상수이다. 즉, 결과가 바뀌지 않는다.
      System.out.println("3." + c);
      break;
    
    //변수를 사용하면 기존의 case 값과 같아질 가능성이 있다. 그래서 불가!
    //변수와 상수의 연산은 변수이다. 변수의 값에 따라 결과가 바뀐다. 불가!
    //case c + 3: //오류!
    }
    
    switch ('가') {}
    
    //논리? 안된다. 
    //정수 값이 아니다. 정수 값이 아닌 것을 증명하라!
    //정수는 더하기 빼기가 가능하다. 
    //boolean bool = true + 0; <--- 문법 오류!
    boolean bool = true;
    //switch (bool) {}
    
    // JDK7부터 문자열 가능!
    //String str = "Hello";
    String str = "How old are you";
    switch (str) {
    case "Hello":
      System.out.println("반갑습니다");
      break;
    case "How old are you":
      System.out.println("청년이오!");
    }
    
  }

}

































