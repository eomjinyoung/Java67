package step14.ex6;

// 사용자 정의 예외 : 개발자가 임의로 예외 만들기
// 
// 자바에서는 예외를 구분할 때, 예외 메시지로 구분하는 것이 아니라, 타입으로 구분한다.
public class Test5 {
  static String[] names = new String[10];
  static int length;
  
  static void add(String name) {
    names[length++] = name;
  }
  
  // 사용자 예외 도입 전
  static void remove(int index) {
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
  
  public static void main(String[] args) {
    add("홍길동");
    add("임꺽정");
    add("유관순");
    add("안중근");
    add("윤봉길");
    print();
    
    remove(2); 
    print();
    
    remove(3);
    print();

  }

}



















