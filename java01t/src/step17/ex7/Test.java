package step17.ex7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 실습 목표: ObjectOutputStream/ObjectInputStream 사용하기
// => 인스턴스의 내용을 출력하기
//
// 2단계: ObjectOutputStream/ObjectInputStream을 사용하여 입출력하기
// => writeObject() 메서드가 있다.^^
// 
// 용어 정리!
// Serialization(직렬화, 바이트 배열화)
// Serialize: 인스턴스 값을 바이트 배열로 출력하라 : marshaling
// Deserialize : 바이트 배열의 값을 인스턴스로 생성하라 : unmarshaling
//
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










