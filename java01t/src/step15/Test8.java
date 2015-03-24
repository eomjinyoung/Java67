package step15;

import java.util.ArrayList;

// 특정 타입의 객체만 저장하고 싶을 때?
// - 컬렉션 객체를 선언할 때 저장할 타입을 지정한다. => 제네릭(Generic)
public class Test8 {

  public static void main(String[] args) {
    //제네릭 사용 전
    //- 어떤 타입의 객체를 저장할지 지정하지 않으면, 다음과 같이 마음대로 저장할 수 있다.
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100); 
    list.add(90); 
    list.add(80);
    list.add("임꺽정");
    list.add(100);
    list.add(100);
    list.add(90);

    //제네릭 사용 후
    //- 특정 타입의 객체만 저장할 수 있도록 제한할 수 있다.
    //- 개발자가 다른 타입의 객체를 저장하는 실수를 컴파일 단계에서 방지한다.
    ArrayList<String> list2 = new ArrayList<String>();
    list2.add("홍길동");
    list2.add(new String("임꺽정"));
    
    // 이렇게 지정된 타입이 아닌 객체를 저장하면 컴파일 단계에서 오류가 발생한다.
    //list2.add(100); // 오류!! 왜? String을 저장하기로 해놓고 다른 타입을 저장하기 때문.
    
    /* 제네릭 사용
     * => 제네릭을 지원하는 클래스에 대해서만 사용할 수 있다.
     * => API 문서에서 클래스 이름 뒤에 <E> 또는 <T> 식으로 선언된 것.
     * => < > 안에 들어가는 알파벳 문자는 상관없다. 
     */
  }

}















