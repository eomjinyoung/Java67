package step15;

// HashMap 사용법 
// => 데이터를 저장할 때 숫자 대신, 객체의 해시 값을 사용하여 저장한다.
// => key 로 사용할 클래스는 반드시 hashCode()와 equals()를 오버라이딩 해야 한다.
// => key와 value에 null을 허용한다.
// => 비동기 방식으로 동작
//    - 어떤 스레드가 값을 변경하고 있을 때, 다른 스레드는 그와 상관없이 그 값을 꺼낼 수 있다.
//    - 변경된 값이 꺼내진다는 보장을 못한다. 값의 정확성이 떨어진다.
//
// HashTable
// => HashMap과 동일한 방식으로 데이터를 저장한다.
// => key와 value에 null을 허용하지 않는다.
// => 동기화를 지원
//    - 어떤 스레드가 값을 변경하고 있다면, 다른 스레드는 그 작업이 끝날 때 까지 기다려야 한다.
//    - 장점: 변경된 값이 꺼내진다는 보장을 한다.
//    - 단점: 어떤 스레드가 값을 꺼내는 동안 다른 스레드는 기다려야 하기 때문에 =>실행 속도 저하!


public class Test5 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}







