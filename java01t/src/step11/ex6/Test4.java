package step11.ex6;

//인스턴스의 값을 가지고 강제적으로 상수 문자열 생성하기
// - String.intern()
public class Test4 {

  public static void main(String[] args) {
    //String s0 = "홍길동";
    String s1 = new String("홍길동");
    String s2 = new String("홍길동");
    String s3 = s1.intern(); // 인스턴스의 문자열을 가지고 상수 객체를 생성하라!
    String s4 = s2.intern(); // 이미 위에서 상수 객체를 만들었다. s3와 같다.
    String s5 = "홍길동"; //이미 위에서 상수 객체를 만들었다. s3와 같다.
    
    if (s1 != s2) System.out.println("s1 != s2");
    if (s1 != s3) System.out.println("s1 != s3");
    if (s3 == s4) System.out.println("s3 == s4");
    if (s3 == s5) System.out.println("s3 == s5");
    //if (s0 == s3) System.out.println("s0 == s3");
  }

}
