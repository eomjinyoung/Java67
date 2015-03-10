package step05;

/*
 * 프로그램 아규먼트를 이용하여 인스턴스 생성하기
 */

public class Test12 {
  //사용자 정의 자료형
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
  }
  
  static void printScore(Score score) {
    System.out.printf("이름: %s\n", score.name);
    System.out.printf("국어: %d\n", score.kor);
    System.out.printf("영어: %d\n", score.eng);
    System.out.printf("수학: %d\n", score.math);
    System.out.printf("총점: %d, 평균: %.1f\n", score.sum, score.average);
  }
  
  public static void main(String[] args) {
    Score score = new Score();
    score.name = args[0];
    score.kor = Integer.parseInt(args[1]);
    score.eng = Integer.parseInt(args[2]);
    score.math = Integer.parseInt(args[3]);
    score.sum = score.kor + score.eng + score.math;
    score.average = score.sum / 3f;

    printScore(score);
    

  }

}





