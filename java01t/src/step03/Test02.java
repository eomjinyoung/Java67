package step03;

// 연산자 우선 순위
// 괄호 ()
// *, / : 먼저 나온 순서대로 실행 
// +, - : 먼저 나온 순서대로 실행
public class Test02 {

  public static void main(String[] args) {
    int result = 1 + 3 * 2 + 7;
    System.out.println(result);
    
    int result2 = 1 + 3 * (2 + 7);
    System.out.println(result2);
  }

}
