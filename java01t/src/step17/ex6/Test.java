package step17.ex6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 실습 목표: ObjectOutputStream/ObjectInputStream 사용하기
// => 인스턴스의 내용을 출력하기
//
// 1단계: DataOutputStream/DataInputStream을 사용하여 입출력하기
// => 인스턴스를 출력할 때 마다 각 변수의 값을 꺼내서 출력하게 되니
//    무척 번거롭다. => ex7 패키지에서 해결!
public class Test {
  static void writeScore() throws Exception {
    Score[] scores = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)};
    
    DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("temp/ex6.test.data")));
    
    out.writeInt(scores.length);
    
    for (Score score : scores) {
      out.writeUTF(score.getName());
      out.writeInt(score.getKor());
      out.writeInt(score.getEng());
      out.writeInt(score.getMath());
      // 데이터를 가지고 계산을 수행해서 나온 값을 출력에서 제외하라!
      // 데이터를 읽을 때 다시 계산을 수행하는 것이 데이터가 왜곡될 가능성을 줄이기 때문이다.
    }
    
    out.close();
  }
  
  static void readScore() throws Exception {
    DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/ex6.test.data")));
    
    int len = in.readInt();
    
    Score score = null;
    for (int i = 0; i < len; i++) {
      score = new Score(
          in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      System.out.println(score);
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
    writeScore();
    readScore();
    
  }

}










