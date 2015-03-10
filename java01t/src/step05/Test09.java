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

  static int[] makeScores(int kor, int eng, int math) {
    // 어떤 메서드에서 배열을 생성하든간에,
    // new 명령으로 만드는 메모리는 힙(heap)에 준비된다.
    // 힙에 존재하는 메모리는 메서드 호출이 끝나더라도 해제되지 않는다.
    // 메서드 호출이 끝났을 때 해제되는 메모리는 스택에 존재하는 메모리다. 
    int[] scores = new int[]{kor, eng, math, 0, 0};
    return scores;
  }
  
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
  }
  
  static void printSumAverage(int sum, int average) {
    System.out.printf("총정: %d, 평균: %d\n", sum, average);
  }
  
  public static void main(String[] args) {
    int[] scores = makeScores(100, 90, 80);
    sum(scores); // 값이 아니라 주소를 넘기는 것을 call by reference라고 한다.
    average(scores); // call by reference
    printScores(scores); // call by reference
    printSumAverage(scores[3], scores[4]); // call by value
  }

}





