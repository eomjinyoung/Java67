package step14.ex6;

// 사용자 정의 예외 : 개발자가 임의로 예외 만들기
// 
// 자바에서는 예외를 구분할 때, 예외 메시지로 구분하는 것이 아니라, 타입으로 구분한다.
// => 각각의 예외에 대해 별도의 예외 클래스를 정의한다.

class EmptyValueException extends Exception {}
class InvalidIndexException extends Exception {}

//엥? 아니 상속 받은 서브 클래스에 아무런 코딩을 하지 않네요?
// => 이 클래스는 단지 오류를 구분하기 위한 용도로 사용.
// => 특별히 Exception 클래스에 추가할 내용은 없다.
// => 클래스 이름으로 오류 상황을 구분할 수 있게 도와준다.

public class Test5 {
  static String[] names = new String[10];
  static int length;
  
  static void add(String name) {
    names[length++] = name;
  }
  
  // 사용자 정의 예외 도입 전
  // 메서드에서 발생되는 다양한 예외 상황을 호출자에게 전달하는 방법
  // => 오류 메시지의 규칙을 정하여, 오류를 전달한다.
  // => 호출자는 그 오류 메시지를 조사하여 처리하면 된다.
  static void remove(int index) throws Exception {
    // 인덱스가 배열의 크기 범위 안에서 가리키지만, 값이 없는 방을 가리킨다.
    if (index >= length && index < names.length)
      throw new Exception("400"); // 빈방 오류
    
    // 인덱스가 배열의 크기를 벗어난다면,
    if (index >= names.length || index < 0) {
      throw new Exception("401"); // 무효한 인덱스 오류
    }
    
    length--;
    for (int i = index; i < length; i++) {
      names[i] = names[i+1];
    }
  }
  
  // 사용자 정의 예외 도입 후
  // - 굳이 어떤 예외 상황인지 메시지를 남길 필요가 없다.
  // - 클래스 이름이 어떤 예외 상황인지 나타내기 때문이다.
  static void remove2(int index) 
      /*throws Exception*/ //이렇게 던지는 예외 타입의 상위 클래스를 지정해도 된다.
      throws EmptyValueException, InvalidIndexException 
         // 구체적으로 각각의 예외를 지정해도 된다. 
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
  
  // 사용자 정의 예외 도입 전
  public static void main01(String[] args) {
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
      //remove(3);
      
      //무효한 인덱스를 지정하는 경우
      remove(-100);
      
    } catch (Exception e) {
      //문제? remove() 메서드 호출할 때, 두 종류의 오류를 나눠서 처리하고 싶다!
      // 빈방은 간단히 안내 문구 출력하고 계속 실행하고 싶다.
      // 무효한 인덱스를 지정한 경우에는 실행을 멈추고 싶다.
      // => 오류 메시지의 규칙을 정한다. 그 규칙에 따라 구분하여 처리한다.
      if (e.getMessage().equals("400")) {
        System.out.println("인덱스가 빈 방을 가리키고 있습니다.");
      } else {
        return; //즉시 실행을 멈춘다.
      }
    }

  }
  
  // 사용자 정의 예외 도입 후
  public static void main(String[] args) {
    add("홍길동");
    add("임꺽정");
    add("유관순");
    add("안중근");
    add("윤봉길");
    print();
    
    try {
      remove2(2); 
      print();
      
      remove2(3);
      print();
      
      //값이 들어있지 않은 인덱스 가리키기
      remove2(3);
      
      //무효한 인덱스를 지정하는 경우
      //remove2(-100);
      
    } catch (EmptyValueException e1) {
      System.out.println("빈방을 가리키고 있네요.");
      
    } catch (InvalidIndexException e2) {
      System.out.println("무효한 인덱스입니다.");
    }

  }

}



















