package step09.exc;

public class C extends B {
  @Override
  public void m() {
    System.out.println("C.m().....");
  }
  
  public void test() {
    m(); // 자신의 m() 메서드 호출 
    super.m(); //=> 오버라이딩 하기 전에 메서드 호출
    //super.super.m(); // 문법 오류!
    
    x(); // 자신이 상속 받은 메서드 호출 => B.x()
    super.x(); // 오버라이딩 한 메서드가 아니기 때문에 그냥 상속 받은 메서드 호출.
    
    y(); // 자신이 상속 받은 메서드 호출 => A.y()
    super.y(); // 자신은 오버라이딩을 하지 않았다. 따라서 상속 받은 메서드 호출.
    
    //super 참조 변수
    //자신이 오버라이딩 한 메서드에 대해 사용할 수 있다.
    //자신이 오버라이딩 하지 않은 메서드에 대해 사용해봐야 무시된다.
    //붙이나 안 붙이나 똑 같다.
  }
}




