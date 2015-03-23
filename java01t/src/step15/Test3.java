package step15;

import java.util.HashSet;
import java.util.Iterator;

// HashSet 객체의 데이터 관리 방식 
// => 사용자 정의 객체를 Set에 보관할 경우!

public class Test3 {

  // 복합 자료형 정의 
  static class Address {
    String name;
    String tel;
    String email;
    
    public Address(String name, String tel, String email) {
      this.name = name;
      this.tel = tel;
      this.email = email;
    }

    @Override
    public String toString() {
      return "Address [name=" + name + ", tel=" + tel + ", email=" + email
          + "]";
    }
  }
  
  public static void main(String[] args) {
    Address a1 = new Address("홍길동", "111-1111", "hong@test.com");
    Address a2 = new Address("임꺽정", "111-2222", "leem@test.com");
    Address a3 = new Address("홍길동", "111-1111", "hong@test.com");

    System.out.println(a1.hashCode());
    System.out.println(a2.hashCode());
    System.out.println(a3.hashCode());
    
    HashSet set = new HashSet();
    set.add(a1);
    set.add(a2);
    set.add(a3);
    set.add(a2); //이미 같은 주소가 Set에 들어있다. 중복 불가! => 저장 안됨.
    set.add(a1); //이미 같은 주소가 Set에 들어있다. 중복 불가! => 저장 안됨.
    
    // HashSet 객체에서 값을 직접 꺼낼 수 없다. => 꺼내주는 자의 도움을 받아야 한다.
    Iterator iterator = set.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    String s1 = new String("임꺽정");
    String s2 = new String("유관순");
    String s3 = new String("임꺽정");
    
    // s1과 s3가 주소가 다름(인스턴스가 다름)을 확인하자. 
    if (s1 != s3) 
      System.out.println("s1 != s3"); 
    
    set.add(s1);
    set.add(s2);
    set.add(s3); // 주소가 다름에도 불구하고, 저장안됨. 이유는?
    
    // Iterator는 사용 후 되감을 수는 없다. 따라서, 출력하려면 다시 얻어야 한다.
    iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    //s1과 s3는 서로 다른 인스턴스이다. 그러나 값이 같다. 그래서 중복 저장 안된다?
    //=> 데이터가 같다고 중복 안된 것은 아니다. 
    //=> 해시 값이 같기 때문에 중복 저장 안된 것이다.
    //=> String 클래스는 hashCode() 메서드를 오버라이딩(재정의)하였다.
    //   같은 데이터인 경우 같은 해시 값을 리턴하도록 변경하였기 때문이다.
    //
    //추론: 만약, Address 클래스도 같은 데이터에 대해 같은 해시 값을 리턴하도록 만든다면,
    //     중복 저장되는 일이 없겠네요? YES!!!!!  ==> Test4에서 확인하라!
  }

}








