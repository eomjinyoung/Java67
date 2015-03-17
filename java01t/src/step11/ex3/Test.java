package step11.ex3;

// 인스턴스가 달라도 그 인스턴스에 저장된 값이 같다면 
// equals()의 리턴 값이 true가 되게 하라!
public class Test {
  public static void main(String[] args) {
    Member m1 = new Member();
    m1.name = "홍길동";
    m1.id = "hong";
    m1.password = "1111";
    System.out.println(m1.toString());

    Member m2 = new Member();
    m2.name = "홍길동";
    m2.id = "hong";
    m2.password = "1111";
    System.out.println(m2.toString());
    
    if (m1 == m2) { // m1에 저장된 인스턴스 주소와 m2의 주소를 비교한다.
      System.out.println("m1 == m2");
    } else {
      System.out.println("m1 != m2");
    }
    
    // 오버라이딩한 equals()를 호출한다.
    // 즉, 내용이 같은지를 비교한다.
    if (m1.equals(m2)) { 
      System.out.println("m1.equals(m2) : true");
    } else {
      System.out.println("m1.equals(m2) : false");
    }
    
    
    
    //강조!
    // equals()는 재정의하지 않으면, 무조건 인스턴스가 같은지를 비교한다.
    // 만약 어떤 클래스의 equals()를 호출했는데,
    // 인스턴스가 다름에도 불구하고 내용이 같을 때 true를 리턴한다면,
    // 개발자가 그 클래스를 만들 때 equals()를 오버라이딩 했다는 뜻이다.
  }

}










