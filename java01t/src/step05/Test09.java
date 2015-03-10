package step05;

/* 
 * call by value vs call by reference
 * 1. call by value
 * - 메서드를 호출할 때 값을 넘기는 것을 말함.
 * - 이전 예제에서 만든 메서드이 이에 해당함.
 * - 즉, 자바 원시 타입의 값을 넘길 때.
 * 
 * 2. call by reference
 * - 메서드를 호출할 때 주소를 넘기를 것을 말함.
 */
public class Test09 {

  static void sum(int[] scores) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += scores[i];
    }
    scores[3] = sum;
  }
  
  static void average(int[] scores) {
    scores[4] = scores[3] / 3;
  }
  
  static void printScores(int[] scores) {
    System.out.printf("국어: %d, 영어: %d, 수학: %d\n", 
        scores[0], scores[1], scores[2]);
    System.out.printf("총정: %d, 평균: %d\n", scores[3], scores[4]);
  }
  
  public static void main(String[] args) {
    int[] scores = new int[]{100, 90, 80, 0, 0};
    
    sum(scores);
    average(scores);
    printScores(scores);

  }

}





