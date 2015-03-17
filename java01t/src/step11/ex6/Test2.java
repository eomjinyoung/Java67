package step11.ex6;

// 상수 문자열과 String 인스턴스

public class Test2 {

  public static void main(String[] args) {
    //s1과 s2는 레퍼런스 변수인데 어떻게 "문자열"을 할당할 수 있는가?
    // - "홍길동"은 new String("홍길동")의 단축 명령이다.
    // - 그래서 실제 s1에 저장되는 것은 String 인스턴스의 주소이다.
    String s1 = "홍길동"; //new String("홍길동")의 단축 명령
                        //상수 풀에 만들어진다.
    String s2 = "홍길동"; //상수 풀에 이미 "홍길동"이라는 값을 갖는 String 인스턴스가 
                        // 있기 때문에, 새로 만들지 않고 기존 주소를 리턴한다.
    
    //그리고, 왜 s1과 s2가 같은가?
    // - 단축 명령으로 String 인스턴스를 만드는 경우, 
    //   상수 문자열처럼 다루기 위해, Heap이 아닌 Constants Pool영역에 인스턴스를 만든다.
    // - Constants Pool영역은 Method Area 영역에 각 클래스를 마다 존재한다.
    // - 즉, 상수 문자열 인스턴스는 Constants Pool에 만들어진다.
    // - 메모리 절약을 위해 상수 문자열로 만든 인스턴스는 중복되지 않는다.
    // - s2에 저장되는 인스턴스 주소는 s1에서 만든 String 인스턴스 이다.
    if (s1 == s2) {
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    //주의! 상수 문자열, 즉 단축 명령을 사용하지 않고 명시적으로 new 명령을 사용하여 
    //String 인스턴스를 만들 경우, 중복에 상관없이 무조건 Heap에 인스턴스를 만든다.
    
    //다른 예:
    String s3 = "가나다"; // 상수 풀에 없다. => 새로 만든다.
    String s4 = "가나나"; // 상수 풀에 없다. => 새로 만든다.
    
    if (s3 == s4) { // s3와 s4는 주소가 다르다.
      System.out.println("s3 == s4");
    } else {
      System.out.println("s3 != s4");
    }

    // 상수와 Heap 객체의 비교
    String s5 = "우헤헤"; // 상수 풀에 없다. => 새로 만든다.
    String s6 = new String("우헤헤"); // Heap에 새로 만든다.
    String s7 = new String("우헤헤"); // Heap에 새로 만든다.
    String s8 = "우헤헤"; // 상수 풀에 이미 있다. 기존 주소 리턴.
    String s9 = "우헤헤"; // 상수 풀에 이미 있다. 기존 주소 리턴.
    String s10 = new String("우헤헤"); // Heap에 새로 만든다.
    
    if (s5 != s6) System.out.println("s5 != s6");
    if (s5 != s7) System.out.println("s5 != s6");
    if (s5 == s8) System.out.println("s5 == s6");
    if (s5 == s9) System.out.println("s5 == s6");
    if (s5 != s10) System.out.println("s5 != s6");
    
    // 가비지 컬렉터와 문자열:
    // - 상수 문자열 인스턴스는 Method Area 영역에 존재한다.
    // - 가비지 컬렉터의 대상이 아니다.
    // - 가비지 컬렉터는 오로지 Heap 영역만 관리한다.
  }

}














