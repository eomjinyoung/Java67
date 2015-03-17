package step11.ex5;

// toString() 오버라이딩 
// - 원래 동작: "패키지명.클래스명@해시값" 문자열 리턴한다.
// - 우리가 원하는 형식의 문자열을 출력하도록 오버라이딩 하자!
public class Test {
  public static void main(String[] args) {
    Member m1 = new Member();
    m1.name = "홍길동";
    m1.id = "hong";
    m1.password = "1111";
    
    System.out.println(m1.toString());
    
    // println() 메서드는 m1의 값을 출력할 때 내부에서 toString()을 호출하여 
    // 그 리턴 값을 출력하기 때문에 위의 출력 결과와 같다.
    System.out.println(m1);

    Member m2 = new Member();
    m2.name = "홍길동";
    m2.id = "hong";
    m2.password = "1111";
    System.out.println(m2.toString());
    System.out.println(m2);
  }

}










