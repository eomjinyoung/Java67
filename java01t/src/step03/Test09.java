package step03;

/*
 * 배정 연산자 단축 표기법
 * x = x + y
 * => 단축키 x += y
 * - +=, -=, *=, /=, %=, >>=, ...
 */
public class Test09 {

  public static void main(String[] args) {
    int x = 20;
    x = x + 30;
    
    int y = 20;
    y += 30;
    System.out.printf("%d, %d\n", x, y);

  }

}
