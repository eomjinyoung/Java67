package step08.ex1;

//클래스 변수의 활용법을 알아보자!

public class Test {

  static void printScore(Score score) {
    System.out.printf("%d, %s, %d, %d, %d\n", 
        score.no, score.name, score.kor, score.eng, score.math);
  }
  
  public static void main(String[] args) {
    int count = 0;
    Score s1 = new Score(++count, "홍길동", 100, 100, 100);
    Score s2 = new Score(++count, "임꺽정", 90, 90, 90);
    Score s3 = new Score(++count, "안중근", 80, 80, 80);
    
    printScore(s1);
    printScore(s2);
    printScore(s3);

  }

}
