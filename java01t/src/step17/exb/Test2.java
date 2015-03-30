package step17.exb;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// 실습 목표: Score1 클래스의 값을 Score2로 읽기
// 
// 내용:
// => Score2 클래스를 Score로 바꾼 후 파일을 읽는다.
public class Test2 {
  static void readScore() throws Exception {
    ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/exb.test.data")));
    
    int len = in.readInt(); // 출력한 성적 데이터의 수를 읽기!
    
    Score score = null;
    for (int i = 0; i < len; i++) { // 성적 데이터의 수 만큼 반복
      score = (Score)in.readObject(); // 각 학생의 성적 데이터를 읽기!
      score.compute(); // 총점 과 평균을 계산 
      System.out.println(score); // 간단히 화면에 출력 
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
    readScore(); // Score1으로 출력할 데이터를 Score2로 읽기
    
    // 오류 발생
    //Exception in thread "main" java.io.InvalidClassException: 
    // step17.exa.Score; local class incompatible: 
    // stream classdesc serialVersionUID = 1898126714259917305, 
    // local class serialVersionUID = 3717696502220984781

    // 오류 발생 이유?
    // exa.test.data 파일에 기록된 클래스의 버전과
    // 복원할 때 사용할 클래스의 버전이 다르다.
    // 
    // 내가 Score 클래스에 버전을 부여한적이 없는데? 
    // Score 클래스의 버전을 명시하지 않으면, 
    // 컴파일러가 자동으로 그 클래스의 버전을 임의의 값으로 지정한다.
  }

}










