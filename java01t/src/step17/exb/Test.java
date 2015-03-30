package step17.exb;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// 실습 목표: serialVersionUID 변수 사용법!
// 개발자가 직접 직렬화 클래스의 버전을 지정한다.
// 
// 내용
// => Score1을 Score로 바꾼 후 출력한다.
public class Test {
  static void writeScore() throws Exception {
    Score[] scores = {
        //new Score("홍길동", 100, 100, 100),
        //new Score("임꺽정", 90, 90, 90),
        //new Score("유관순", 80, 80, 80)
        };
    
    ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("temp/exb.test.data")));
    
    out.writeInt(scores.length); // 총 성적 데이터의 수 출력!
    
    for (Score score : scores) {
      out.writeObject(score); // 각 학생의 성적 데이터 출력!
    }
    
    out.close();
  }
  
  public static void main(String[] args) throws Exception {
    writeScore(); // 국어, 영어, 수학 점수를 출력한다.
  }

}










