package step06.ex2;

//메서드를 분류한 후
//ex1.Test -> 계산을 테스트 하는 함수를 분류함.
public class Test {

  public static void main(String[] args) {
    //3 * 7 - 4 + 8 / 2 = ?
    int result = 0;
    result = Calculator.multiple(3, 7);
    result = Calculator.minus(result, 4);
    result = Calculator.plus(result, 8);
    result = Calculator.divide(result, 2);
    
    System.out.printf("결과 = %d\n", result);
  }

}
