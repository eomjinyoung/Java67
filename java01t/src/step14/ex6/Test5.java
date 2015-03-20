package step14.ex6;

// 사용자 정의 예외 : 개발자가 임의로 예외 만들기
// 사용자 정의 예외 도입 전 실습
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
  
  static void print() {
    for (int i = 0; i < length; i++) {
      System.out.print(names[i] + ",");
    }
    System.out.println();
  }
  
  // 사용자 정의 예외 도입 전
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
  
}



















