package net.bitacademy.java67.step07.ex1.before;

public class Test01 {

  public static void main(String[] args) {
    Calc calc = new Calc();
    System.out.println(calc.plus(10, 20));
    
    //기능을 확장하는 방법 1.
    //- 기존 클래스를 변경하라!
    //  => 기존 클래스의 소스가 없으면 변경 불가!
    //- 기존의 코드를 잘못 손대면 잘되던 기능도 오류 발생!
    //  => 위험도 증가!
    
    //추가한 기능 사용하기 
    System.out.println(calc.minus(10, 20));
    
    //기능을 확장하는 방법 2.
    //- 기존 클래스를 상속받는다.
    //- 기존 클래스의 소스가 없어도 된다.
    //- 단, 필요한 것만 선택적으로 상속할 수 없다.
    System.out.println("--------------------------");
    Calc2 calc2 = new Calc2();
    System.out.println(calc2.plus(10, 20));
    System.out.println(calc2.minus(10, 20));
    System.out.println(calc2.multiple(10, 20));
  }

}
