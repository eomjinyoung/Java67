package step17.ex3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 실습 목표: 바이트 배열을 출력하고, 읽기

public class Test3 {

  public static void main(String[] args) throws Exception {
    // 바이트 배열 출력하기
    byte[] data = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66};
    FileOutputStream out = new FileOutputStream("temp/test3.data");
    out.write(data);
    out.close();
    
    // 바이트 배열 읽기
    FileInputStream in = new FileInputStream("temp/test3.data");
    byte[] buf = new byte[100];
    int len = 0;
    len = in.read(buf); //바이트 배열을 넘기면, 데이터를 읽어서 그 배열에 저장하고, 
                        //읽은 바이트의 개수를 리턴한다.
    in.close(); // 다 읽었으면 자원을 해제하라!
    
    for (int i = 0; i < len; i++) {
      System.out.println(Integer.toHexString(buf[i]));
    }
    
    
  }

}









