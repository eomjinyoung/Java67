package step11.ex2;

// hashCode() 테스트
public class Test {
  public static void main(String[] args) {
    // 같은 해시 값을 갖는 인스턴스에 대해 equals()의 결과는?
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
    
    System.out.printf("%x\n", m1.hashCode());
    System.out.printf("%x\n", m2.hashCode());
    
    //equals() 시험하자!
    if (m1 == m2) { // m1에 저장된 인스턴스 주소와 m2의 주소를 비교한다.
      System.out.println("m1 == m2");
    } else {
      System.out.println("m1 != m2");
    }
    
    //Object로부터 상속받은 equals()는 인스턴스를 비교할 때
    //주소가 같은지를 비교한다. hashCode() 값과 상관없다.
    //즉, 위의 == 연산자와 동일하다.
    if (m1.equals(m2)) { // 인스턴스가 같은지 비교
      System.out.println("m1.equals(m2) : true");
    } else {
      System.out.println("m1.equals(m2) : false");
    }
  }

}










