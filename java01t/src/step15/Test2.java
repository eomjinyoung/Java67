package step15;

import java.util.HashSet;
import java.util.Iterator;

// Set : 데이터를 중복하여 저장하지 않는다. => 집합의 고유 특징
// HashSet => Set의 특징을 구현한 클래스
public class Test2 {

  public static void main(String[] args) {
    HashSet set = new HashSet();
    set.add("홍길동");
    set.add(100); // 100 -> new Integer(100) : boxing 
    set.add(90); 
    set.add(80);
    set.add("임꺽정");
    set.add(100); // 이미 앞에서 같은 값을 저장했기 때문에 다시 저장하지 않는다.
    set.add(100); // 이미 앞에서 같은 값을 저장했기 때문에 다시 저장하지 않는다.
    set.add(90); // 중복 저장 불가!
    
    // HashSet 객체에 보관된 데이터를 꺼내주는 객체 얻기
    Iterator iterator = set.iterator();

    Object value = null;
    while (iterator.hasNext()) { // Iterator에게 꺼낼 데이터가 있는지 물어본다.
      value = iterator.next(); // 꺼내달라고 요청한다.
      System.out.println(value);
    }
  }

}










