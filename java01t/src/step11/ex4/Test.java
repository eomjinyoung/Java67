package step11.ex4;

// 문자열의 비교와 equals()

public class Test {

  public static void main(String[] args) {
    String s1 = new String("홍길동");
    String s2 = new String("홍길동");
    
    if (s1 == s2) {
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    // 비교 결과는 true이다.
    // - String 클래스에서 Object로부터 상속받은 equals()를 오버라이딩 했기 때문이다.
    // - 즉, 인스턴스의 내용이 같은지 비교하게 변경하였다.
    if (s1.equals(s2)) {
      System.out.println("s1.equals(s2) : true");
    } else {
      System.out.println("s1.equals(s2) : false");
    }
    
    // String 클래스처럼 equals()를 오버라이딩 한 클래스가 있는가?
    // Byte, Short, Integer, Long, Float, Double, Boolean, Character
    Integer b1 = new Integer(10);
    Integer b2 = new Integer(10);
    
    if (b1 == b2) {
      System.out.println("b1 == b2");
    } else {
      System.out.println("b1 != b2");
    }
    
    if (b1.equals(b2)) {
      System.out.println("b1.equals(b2) : true");
    } else {
      System.out.println("b1.equals(b2) : false");
    }
    
    // Byte, Short, ... 클래스 => "Wrapper 클래스"
    // - 기본 자료형을 좀 더 다양하게 다룰 수 있도록 클래스로 만든 것.
    
    // 참고!
    // equals() 오버라이딩 했는지 여부를 아는 방법! => API 문서 보라!

  }

}









