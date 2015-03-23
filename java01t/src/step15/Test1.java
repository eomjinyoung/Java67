package step15;

import java.util.ArrayList;

// Collection API
// - 데이터 목록을 다루는 클래스
// - List : 인덱스 기반으로 데이터를 저장하고 꺼낸다. 데이터 중복 허용.
// - Set  : 인덱스 기반으로 데이터를 저장하고 꺼낸다. 데이터 중복 불가.
// - Map  : 해시코드를 기반으로 데이터를 저장하고 꺼낸다.
//
// List 방식으로 데이터를 목록을 다루는 클래스 실습
// => ArrayList : 단순히 데이터 목록을 관리할 때 사용. 속도가 빠르다.
public class Test1 {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100); // 100 -> new Integer(100) : boxing 
    list.add(90); 
    list.add(80);
    list.add("임꺽정");
    list.add(100);
    list.add(100);
    list.add(90);

    for (Object value : list) {
      System.out.println(value);
    }
    
    System.out.println(list);
    
    list.remove(3);
    System.out.println(list);
    
    // remove()에 값을 주면, 그 값을 갖는 객체를 찾아서 지운다.
    // 단, 첫 번째로 일치하는 객체만 지운다.
    list.remove("임꺽정");
    System.out.println(list);
    
    // 위와 같다. 
    list.remove(new Integer(100));
    System.out.println(list);
    
    // insert 수행 
    list.add(2, 70);
    System.out.println(list);
  }

}















