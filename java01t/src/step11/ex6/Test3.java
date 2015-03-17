package step11.ex6;

// A 인스턴스의 name 변수에 저장된 상수 문자열의 주소와
// B 인스턴스의 name 변수에 저장된 상수 문자열의 주소가 같은지 비교해 보자!
public class Test3 {

  public static void main(String[] args) {
    A o1 = new A();
    B o2 = new B();
    
    if (o1.name == o2.name) {
      System.out.println("o1.name == o2.name");
    } else {
      System.out.println("o1.name != o2.name");
    }

  }

}
