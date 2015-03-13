package step08.ex1;

//클래스 변수의 활용법을 알아보자!
//학생의 카운트를 Score2에서 관리하기 때문에, 
// 이 클래스에서는 더이상 그 부분을 신경쓸 필요가 없다.
public class Test2 {

  static void printScore(Score2 score) {
    System.out.printf("%d, %s, %d, %d, %d\n", 
        score.no, score.name, score.kor, score.eng, score.math);
  }
  
  public static void main(String[] args) {
    Score2 s1 = new Score2("홍길동", 100, 100, 100);
    Score2 s2 = new Score2("임꺽정", 90, 90, 90);
    Score2 s3 = new Score2("안중근", 80, 80, 80);
    
    printScore(s1);
    printScore(s2);
    printScore(s3);

    //자기 클래스에 있는 클래스 변수가 아닌 경우는,
    // 반드시 클래스 이름을 명시해야 한다.
    System.out.println(Score2.count);
  }

}











