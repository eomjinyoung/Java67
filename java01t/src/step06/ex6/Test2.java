package step06.ex6;

/* 
 * 인스턴스 변수를 사용하여, 계산 결과를 개별적으로 관리한다.
 */

public class Test2 {

  public static void main(String[] args) {
    //3 * 7 - 4 + 8 / 2 = ?
    //5 - 2 * 3 * 2 = ?
    // 결과를 개별적으로 관리하기 위해 인스턴스 생성한다.
    Calculator2 calc1 = new Calculator2();
    Calculator2 calc2 = new Calculator2();
    
    // 메서드를 호출할 때 마다 그 메서드가 사용할 인스턴스 주소를 알려준다.
    Calculator2.init(calc1, 3);
    Calculator2.init(calc2, 5);
    
    Calculator2.multiple(calc1, 7);
    Calculator2.minus(calc2, 2);
    
    Calculator2.minus(calc1, 4);
    Calculator2.multiple(calc2, 3);
    
    Calculator2.plus(calc1, 8);
    Calculator2.multiple(calc2, 2);
    
    Calculator2.divide(calc1, 2);
    
    System.out.printf("결과1 = %d\n", calc1.result);
    System.out.printf("결과2 = %d\n", calc2.result);
  }

}














