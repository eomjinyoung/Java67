package step17.ex2;

// 실습 목표: 재귀호출 집중 분석
// 재귀 호출
// - 메서드 안에서 다시 자기를 호출하는 것.
// - 스택 메모리와 함께 고민하면 이해가 빠르다.
// - 자신를 호출한다고 생각하지 말고 또 다른 메서드를 호출한다고 생각하라!
// - 호출될 때 마다 스택 메모리가 증가한다.
//   => 스택 메모리가 부족하면 StackOverflowError 발생!
// - 수학 공식을 메서드로 만들 때 유용하다.
public class Test6 {

  // 1 + 2 + 3 + n
  static int sigma(int n) {
    if (n == 1)
      return 1;
    else
      return n + sigma(n - 1);
  }
  
  public static void main(String[] args) {
    System.out.println(sigma(10));

  }

}
