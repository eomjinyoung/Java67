package step15;

import java.util.HashSet;
import java.util.Iterator;

// Address 클래스 변경
// - 같은 데이터를 갖는 경우, 같은 해시 값을 리턴하도록 변경한다.
// - 같은 데이터를 갖는 경우, equals()의 리턴 값이 true가 되도록 한다.

// HashSet에 같은 값을 갖는 인스턴스에 대해 중복 저장하지 않으려면,
// - hashCode()와 equals()를 오버라이딩 해야 한다.
// - 둘 중 하나만 해서는 안된다.
public class Test4 {

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

    // 인스턴스가 달라도 값이 같다면, 해시 값도 같다.
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((tel == null) ? 0 : tel.hashCode());
      return result;
    }

    // 인스턴스가 달라도 값이 같다면, true를 리턴한다.
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Address other = (Address) obj;
      if (email == null) {
        if (other.email != null)
          return false;
      } else if (!email.equals(other.email))
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      if (tel == null) {
        if (other.tel != null)
          return false;
      } else if (!tel.equals(other.tel))
        return false;
      return true;
    }
  }
  
  public static void main(String[] args) {
    Address a1 = new Address("홍길동", "111-1111", "hong@test.com");
    Address a2 = new Address("임꺽정", "111-2222", "leem@test.com");
    Address a3 = new Address("홍길동", "111-1111", "hong@test.com");

    String s1 = new String("임꺽정"); // s3와 해시 값이 같다.
    String s2 = new String("유관순");
    String s3 = new String("임꺽정"); // s1과 해시 값이 같다. 

    // a1과 a3는 인스턴스가 다르다. 그러나, 데이터가 같기 때문에 해시 값도 같다.
    System.out.println(a1.hashCode()); // a3와 같다.
    System.out.println(a2.hashCode());
    System.out.println(a3.hashCode()); // a1과 같다.
    
    HashSet set = new HashSet();
    set.add(a1);
    set.add(a2);
    set.add(a3); //인스턴스가 달라도 이미 같은 해시 값을 갖고 있는 a1이 있다.
                 //equals()의 결과도 true 이다. 따라서 중복 안됨.
    set.add(a2); //이미 같은 주소가 Set에 들어있다. 중복 안됨.
    set.add(a1); //이미 같은 주소가 Set에 들어있다. 중복 안됨.

    set.add(s1);
    set.add(s2);
    set.add(s3); // s1과 주소가 다르다. 즉 서로 다른 인스턴스이다. 그러나 해시 값이 같다.
                 // equals()의 결과도 true 이다. 따라서 중복 안됨.
    
    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    /* HashSet에 데이터 보관!
     * => 두 인스턴스의 hashCode() 리턴 값이 같고, equals()의 리턴 값이 true 이면,
     *    같은 데이터로 간주하여 중복 저장하지 않는다.
     */
  }

}








