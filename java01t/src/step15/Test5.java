package step15;

import java.util.HashMap;

// HashMap 사용법 
// => 데이터를 저장할 때 숫자 대신, 객체의 해시 값을 사용하여 저장한다.
// => key 로 사용할 클래스는 반드시 hashCode()와 equals()를 오버라이딩 해야 한다.
// => key와 value에 null을 허용한다.
// => 비동기 방식으로 동작
//    - 어떤 스레드가 값을 변경하고 있을 때, 다른 스레드는 그와 상관없이 그 값을 꺼낼 수 있다.
//    - 변경된 값이 꺼내진다는 보장을 못한다. 값의 정확성이 떨어진다. => 실행 속도 빠르다.
//
// HashTable
// => HashMap과 동일한 방식으로 데이터를 저장한다.
// => key와 value에 null을 허용하지 않는다.
// => 동기화를 지원
//    - 어떤 스레드가 값을 변경하고 있다면, 다른 스레드는 그 작업이 끝날 때 까지 기다려야 한다.
//    - 장점: 변경된 값이 꺼내진다는 보장을 한다.
//    - 단점: 어떤 스레드가 값을 꺼내는 동안 다른 스레드는 기다려야 하기 때문에 =>실행 속도 저하!


public class Test5 {

  static class Member {
    String id;
    String password;
    String name;
    String email;
    String tel;
    
    public Member(String id, String password, String name,
        String email, String tel) {
      this.id = id;
      this.password = password;
      this.name = name;
      this.email = email;
      this.tel = tel;
    }

    @Override
    public String toString() {
      return "Member [id=" + id + ", password=" + password + ", name=" + name
          + ", email=" + email + ", tel=" + tel + "]";
    }
  }
  
  public static void main(String[] args) {
    Member m1 = new Member("hong", "1111", "홍길동", "hong@test.com", "111");
    Member m2 = new Member("park", "1111", "박지성", "park@test.com", "222");
    Member m3 = new Member("kim", "1111", "김연아", "kim@test.com", "111");

    HashMap map = new HashMap();
    
    /* 값 저장하기 */
    map.put("hong", m1);
    map.put("park", m2);
    
    // key는 중복될 수 없다.
    map.put(new String("park"), m3); // 기존의 "park"으로 저장된 값을 대체한다.
    
    /* 값 꺼내기 */
    System.out.println( map.get("hong") );
    System.out.println( map.get("park") );
    
    /* 저장 원리
     * => key 객체에서 hashCode() 메서드를 호출하여 그 리턴 값을 인덱스로 사용한다.
     * => 상수 문자열 "park"으로 만든 스트링 객체는 new String("park")으로 만든
     *    스트링 객체와 비록 다른 인스턴스이지만 데이터가 같기 때문에 같은 해시 값을 리턴한다.
     *    물론, String 클래스의 hashCode()는 데이터 같을 경우 같은 해시 값을 리턴하도록
     *    프로그램 되어 있다.
     *    
     * 맵에 데이터를 저장할 때 Key로 사용할 수 있는 클래스는?      
     * => 같은 데이터에 대해 같은 해시 값을 리턴하는 클래스라면 가능하다.
     * => 또한 같은 데이터인 경우 equals()의 리턴 값이 true여야 한다.
     * => 한 마디로 hashCode()와 equals()를 오버라이딩 한 클래스.
     * => 보통 맵의 키로 사용하는 클래스는 String과 
     *    랩퍼 클래스(Byte, Short, Integer, Long, ...)이다.      
     */
    
    
    
  }

}




















