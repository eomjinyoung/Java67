package step17.ex3;

import java.io.File;
import java.io.FileInputStream;

// 실습 목표: 바이트 단위로 읽기
// - FileInputStream의 사용
public class Test2 {

  public static void main(String[] args) throws Exception {
    //File file = new File("temp/test.txt");
    //FileInputStream in = new FileInputStream(file);
    
    //다음과 같이 파일의 경로를 문자열로 생성자에 줘도 된다.
    FileInputStream in = new FileInputStream("temp/test.txt");
    
    int i = in.read();
    System.out.println(Integer.toHexString(i));
    
    i = in.read();
    System.out.println(Integer.toHexString(i));
    
    i = in.read();
    System.out.println(Integer.toHexString(i));
    
    i = in.read();
    System.out.println(Integer.toHexString(i));
    
    i = in.read(); // 더이상 읽을 수 없으면 -1을 리턴한다.
    System.out.println(i);
    
    //항상 입출력 완료 후 자원을 해제해야 한다.
    in.close();
  }

}















