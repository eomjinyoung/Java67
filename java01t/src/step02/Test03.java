package step02;

// 키보드로부터 입력 받기
// System.in을 이용하여 처리
// 사용자가 입력한 값을 문자열로 쉽게 처리하기 위해
// Scanner라는 도구를 이용한다.
public class Test03 {

  public static void main(String[] args) {
    java.util.Scanner keyboardScan = new java.util.Scanner(System.in);
    
    //next() 한 토큰(token)의 문자열을 읽는다.
    //토큰? 공백이나 줄 바꿈으로 구분된 값을 의미한다. 
    String s = keyboardScan.next();
    System.out.println(s);
    
    //next()를 이용하여 두 개의 단어를 읽자!
    String s2 = keyboardScan.next();
    String s3 = keyboardScan.next();
    System.out.printf("%s, %s", s2, s3);
    
    keyboardScan.close(); // Scanner 사용을 끝낸 후 반드시 닫아 줄 것.
    // close() => Scanner가 사용한 하드웨어 자원을 해제하는 일을 한다.
    
  }

}










