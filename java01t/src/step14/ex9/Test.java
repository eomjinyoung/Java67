package step14.ex9;

//Stack 알고리즘 구현 및 테스트

public class Test {

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push("홍길동");
    stack.push("임꺽정");
    stack.push("유관순");
    stack.push("안중근");
    stack.push("윤봉길");
    
    System.out.println(stack.size());
    
    Object value = null;
    while ((value = stack.pop()) != null) {
      System.out.println(value);
    }

  }

}
