package step11.ex6;

//String 인스턴스?
//- 자바에서는 문자열을 String 클래스로 다룬다.
//- String 인스턴스는 문자열을 저장하기 위해 char 배열을 사용한다.
//- 인스턴스이니까 Heap에 저장된다는 것.
public class Test1 {

  public static void main(String[] args) {
    // Heap에 "홍길동" 유니코드를 저장한 char[]을 준비한다.
    String s1 = new String("홍길동");
    String s2 = new String("홍길동");
    
    //s1의 가리키는 인스턴스와 s2가 가리키는 인스턴스는 다르다.
    if (s1 == s2) {
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    //hashCode()?
    //- Object.hashCode() : 인스턴스 마다 고유의 해시 값을 리턴한다.
    //그런데, 왜 String.hashCode()는 같은 값을 리턴하는가?
    //- String 클래스는 같은 문자열을 갖는 경우 같은 해시 값을 리턴하게 오버라이딩 했다.
    //도대체 왜 이렇게 동작하도록 hashCode()를 오버라이딩 했을까?
    //- 맵 보관소에 라벨(키)로 사용하기 위해! 
    System.out.printf("%x\n", s1.hashCode());
    System.out.printf("%x\n", s2.hashCode());
    
    //equals()?
    //인스턴스가 다르더라도 같은 문자열을 갖는다면 true를 리턴하도록 오버라이딩 했다.
    if (s1.equals(s2)) {
      System.out.println("s1.equals(s2): true");
    } else {
      System.out.println("s1.equals(s2): false");
    }

  }

}











