package step17.ex3;

import java.io.FileReader;
import java.io.FileWriter;

// 실습 목표: character stream 클래스를 사용하여 입출력하기
// - character stream 클래스는 char 단위로 읽는다. 
// - 영어(ISO-8859-1)라면 규칙에 따라 1바이트 읽어서 2바이트 유니코드로 변환하여 리턴한다.
//   (분명히 2바이트를 리턴하지만, 0x0041처럼 앞 1바이트가 0이기 때문에 
//    toHexString()을 사용하여 문자열로 바꾸면 00은 버려진다. 그래서,
//    출력 화면에는 단지 41이 출력되는 것이다.)
// - 한국어(UTF-8)라면 3바이트 읽어서 2바이트 유니코드로 변환하여 리턴한다.
//   (UTF-8에서는 한글 '가' -> 0xEAB080이다. 이 코드를 2바이트 0xAC00으로 변환한다.)
// 
// - 곧 character stream 클래스는 그냥 데이터를 읽고 쓰는게 아니라,
//   중간에서 적절한 문자집합으로 변환하는 작업을 수행한다.
// - 그러니까, 그림 파일과 같은 바이너리 데이터를 character stream 클래스를 사용하여
//   읽고 쓰지 말라! 왜? 바이너리 데이터를 문자 데이터로 간주하여 중간에 변환할 것이기 때문이다.
// - 당연히 텍스트 파일은 가능은 character stream 클래스를 사용하여 읽고 써라. 
//   그래야 읽을 때 자바 유니코드로 바뀌고, 쓸 때 시스템 기본 문자 집합으로 바뀐다. 
public class Test5 {

  public static void main(String[] args) throws Exception {
    String str = "ABCabc012?!# $%&가각간";
    
    FileWriter out = new FileWriter("temp/test5.data");
    out.write(str);
    out.close();
    
    FileReader in = new FileReader("temp/test5.data");
    int c = 0;
    int count = 0;
    while ( (c = in.read()) != -1) {
      System.out.printf("%d: %s, %c\n", count, 
          Integer.toHexString(c), (char)c);
    }
    in.close();
  }

}





