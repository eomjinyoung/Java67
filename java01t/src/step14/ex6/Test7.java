package step14.ex6;

// 사용자 정의 예외 : 
// => 예외를 캐치할 때 다형적 변수(polymorphic variables)의 특징을 이용하기
//
public class Test7 {
  static class EmptyValueException extends Exception {}
  static class InvalidIndexException extends Exception {}

  static String[] names = new String[10];
  static int length;
  
  static void add(String name) {
    names[length++] = name;
  }
  
  static void remove(int index) 
      throws EmptyValueException, InvalidIndexException 
  {
    // 인덱스가 배열의 크기 범위 안에서 가리키지만, 값이 없는 방을 가리킨다.
    if (index >= length && index < names.length)
      throw new EmptyValueException(); // 빈방 오류
    
    // 인덱스가 배열의 크기를 벗어난다면,
    if (index >= names.length || index < 0) {
      throw new InvalidIndexException(); // 무효한 인덱스 오류
    }
    
    length--;
    for (int i = index; i < length; i++) {
      names[i] = names[i+1];
    }
  }
  
  static void print() {
    for (int i = 0; i < length; i++) {
      System.out.print(names[i] + ",");
    }
    System.out.println();
  }
  
  // 예외를 캐치할 때 다형적 변수 사용하기
  public static void main(String[] args) {
    add("홍길동");
    add("임꺽정");
    add("유관순");
    add("안중근");
    add("윤봉길");
    print();
    
    try {
      remove(2); 
      print();
      
      remove(3);
      print();
      
      //값이 들어있지 않은 인덱스 가리키기
      remove(3);
      
      //무효한 인덱스를 지정하는 경우
      //remove(-100);
      
    } catch (Exception e1) {
      // remove()에서 던지는 예외를 구분할 필요없다면, 
      // 굳이 각각의 예외를 따로 캐치할 필요는 없다.
      // 따라서 두 예외를 예외를 모두 받을 수 있는 상위 클래스의 파라미터를 선언한다.
      // => 다형적 변수의 특징을 활용한 것이다.
      System.out.println("빈방을 가리키고 있거나, 무효한 인덱스 이네요.");
    }

  }

}



















