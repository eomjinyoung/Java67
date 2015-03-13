package step09.ex3;

//Score 클래스에 캡슈화 문법 적용
//1) sum 변수에 직접 적용하지 못하게 한다.
//2) kor 변수의 값을 바꿀 때마다 자동으로 compute()가 호출되기 한다.

public class Test {

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score();
    
    s2.name = "임꺽정";
    
    //직접 접근할 수 없다.
    //s2.kor = 90;
    //s2.eng = 90;
    //s2.math = 90;
    //s2.compute();
    
    //어떻게 국,영,수 점수를 저장할 것인가? => 메서드를 호출하여 저장한다.
    s2.setKor(90);
    s2.setEng(90);
    s2.setMath(90);
    
    
    s1.print();
    s2.print();
    
    
    //문제상황1
    //가끔 이런 개발자도 있고, 이런 실수를 하는 경우도 있다.
    
    //문제 해결! 접근을 폐쇄했다.
    //s1.sum = 100; 
    //s1.print();
    
    //국,영,수,평균과 총점이 일치하지 않는다.
    // 이유? 총점을 개발자가 임의로 접근해서 바꿨기 때문이다.
    // 해결책?
    // - 개발자가 그런 실수를 하지 않기를 바란다.
    // - 강제적으로 접근하지 못하게 한다. => sum 변수를 외부에 접근하지 못하도록 막는다.
    //   캡슐화 문법을 적용한다. => Test2참조
    
    //문제상황2 아직 해결 안됨! => Score2와 Test2에서 해결함.
    //깜박 잊고 호출해야 할 메서드를 호출하지 못할 경우!
    //s2.kor = 50;
    //s2.compute(); // 점수가 바뀔 때 마다 총점과 평균을 다시 산출하기 위해 호출해야 한다.
    //문제 해결!
    s2.setKor(50);
    s2.print();
    
    // 총점을 알고 싶으면, getSum()을 호출한다.
    System.out.println("s1의 총점:" + s1.getSum());
  }

}












