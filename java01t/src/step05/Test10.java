package step05;

/*
 * 인스턴스 전달하기 
 */

public class Test10 {
  //사용자 정의 자료형
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
  }
  
  static Score makeScore(String name, int kor, int eng, int math) {
    Score score = new Score();
    score.name = name;
    score.kor = kor;
    score.eng = eng;
    score.math = math;
    score.sum = kor + eng + math;
    score.average = score.sum / 3f;
    
    return score;
  }
  
  static void printScore(Score score) {
    System.out.printf("이름: %s\n", score.name);
    System.out.printf("국어: %d\n", score.kor);
    System.out.printf("영어: %d\n", score.eng);
    System.out.printf("수학: %d\n", score.math);
    System.out.printf("총점: %d, 평균: %.1f\n", score.sum, score.average);
  }
  
  public static void main(String[] args) {
    Score score = makeScore("홍길동", 100, 90, 80);
    printScore(score);
    

  }

}





