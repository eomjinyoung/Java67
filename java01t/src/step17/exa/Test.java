package step17.exa;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// 실습 목표: SerialVersionUID 변수의 의미?
// 
// 직렬화(Serialization) = 클래스 정보 + 인스턴스 변수의 값 + (버전)
// => 클래스 정보 : 객체로 복원할 때 사용. 
// => 인스턴스 변수의 값 
// => 버전 : 클래스의 변경을 관리하기 위한 숫자 값 
//          개발자가 관리해야 한다. 자동으로 추가되는 것은 아니다.
//          직렬화할 때 사용한 클래스와 
//          복원할 때 사용할 클래스가 같은 클래스인지 검사할 때 사용한다.
//          예) .hwp 파일을 저장할 때도 HWP 파일 형식에 대한 버전 정보가 기록된다.
//              HWP 프로그램이 .hwp 파일을 읽을 때 먼저 해당 파일의 버전 번호를 검사하여
//              읽을 수 있는지 결정한다.
// 실습 내용:
// Score1 클래스를 사용하여 출력된 데이터를 Score2 클래스로 읽어 들일 수 있는 지 검사해 보자!
// 단, 실습할 때 Score1 클래스를 Score로 바꾼 후 출력하고,
// 읽어 들일 때는 Score2 클래스를 Score로 바꾼 후 실행한다.
public class Test {
  static void writeScore() throws Exception {
    Score[] scores = {
        //new Score("홍길동", 100, 100, 100),
        //new Score("임꺽정", 90, 90, 90),
        //new Score("유관순", 80, 80, 80)
        };
    
    ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("temp/exa.test.data")));
    
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










