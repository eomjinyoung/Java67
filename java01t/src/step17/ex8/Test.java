package step17.ex8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 실습 목표: ObjectOutputStream/ObjectInputStream 사용하기
// => 인스턴스의 내용을 출력하기
//
// 3단계: writeObject() 할 때 NotSerializableException 예외가 발생하는 것을 해결하기
public class Test {
  static void writeScore() throws Exception {
    Score[] scores = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)};
    
    ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("temp/ex7.test.data")));
    
    out.writeInt(scores.length);
    
    for (Score score : scores) {
      // 일부로 치명적인 문제 만들기 => 총점과 평균을 왜곡하기
      // 실행 결과를 보면 총점과 평균이 이런 왜곡된 값으로 그대로 출력되었음을 알 수 있다.
      // => 그럼, 계산 데이터를 바이트 배열로 출력하지 않는 방법은? ex9을 보라!
      score.setTotal(0);
      score.setAverage(10f);
      
      out.writeObject(score);
    }
    
    out.close();
  }
  
  static void readScore() throws Exception {
    ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/ex7.test.data")));
    
    int len = in.readInt();
    
    Score score = null;
    for (int i = 0; i < len; i++) {
      score = (Score)in.readObject();
      System.out.println(score);
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
    // 출력할 때 오류 발생: NotSerializableException
    // => 왜? 자바는 보안 관계상 인스턴스의 데이터를 바이트 배열로 바꾸는 것을 허용하지 않는다.
    // => 그럼? 개발자가 해당 클래스에 대해 바이트 배열로 바꾸는 것을 허락한다고 설정해야 한다.
    // => 코드? ex8 패키지의 Score 클래스를 보라!
    writeScore();
    readScore();
    
  }

}










