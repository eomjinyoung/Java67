package step11.ex6;

//immutable 테스트
// - substring(시작인덱스);
// - substring(시작인덱스, 끝인덱스); => 끝 인덱스의 문자는 포함하지 않는다.
// - replace(찾을문자열, 대체문자열); => 기존 문자열을 바꾸지 않는다.  
//
// StringBuffer : mutable 객체 => 값을 바꿀 수 있다.
// - replace(시작인덱스, 끝인덱스, 대체문자열); => 끝 인덱스의 문자는 포함하지 않는다.
// - equals() : 오버라이딩 되어 있지 않다. 따라서, 인스턴스가 같은지를 비교한다.
public class Test5 {
  public static void main(String[] args) {
    String s1 = "abcdefghijklmn";
    
    // 상수 문자열 객체에서 값을 뽑았다고 해서 상수 문자열 객체가 되는 것은 아니다.
    String s2 = s1.substring(5); // 5번부터 끝까지 문자열을 Heap에 복제한다.
    String s3 = s1.substring(5); // 5번부터 끝까지 문자열을 Heap에 복제한다.
    
    System.out.printf("%s, %s, %s\n", s1, s2, s3);
    if (s2 != s3) System.out.println("s2 != s3");
    
    String s4 = s1.substring(5, 10); // 10 바로 전까지 Heap에 복제한다.
    System.out.println(s4);
    
    // 잊지 말자! 상수 문자열은 String 인스턴스이다. 
    String s5 = "ABCDE12345abcde".substring(6);
    System.out.println(s5);
    
    //String 클래스로 만든 문자열은 절대 변경할 수 없다.
    String s6 = new String("ABC123abc");
    String s7 = s6.replace("123", "가나다"); // 기존의 값을 바꾸는 것이 아니다.
                               // 새로 String 인스턴스를 생성한다.
    System.out.printf("%s, %s\n", s6, s7);
    
    //기존 문자열을 바꾸고 싶다면, StringBuffer를 사용하라!
    //StringBuffer는 mutable이다. 
    StringBuffer buf = new StringBuffer("ABC123abc");
    buf.replace(3, 6, "가나다");
    System.out.println(buf);
    
    //StringBuffer 사용 시 유의 사항!
    //- equals()를 오버라이딩 하지 않았다.
    StringBuffer str1 = new StringBuffer("Hello");
    StringBuffer str2 = new StringBuffer("Hello");
    
    if (str1 != str2) System.out.println("str1 != str2");
    if (!str1.equals(str2)) System.out.println("str1.equals(str2): false");
  }
}
















