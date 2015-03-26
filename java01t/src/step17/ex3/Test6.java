package step17.ex3;

import java.io.FileOutputStream;

// 실습 목표: 바이트 스트림 클래스를 사용하여 int, long 값을 출력하기
public class Test6 {

  public static void main(String[] args) throws Exception {
    int v1 = 1207430; //0x00126C86
    long v2 = 1345044002000L; // 0x000001392ADEB4D0
    // 파일에 출력될 데이터 : 00126C86000001392ADEB4D0 (총 12바이트)
    
    FileOutputStream out = new FileOutputStream("temp/test6.data");
    
    out.write(v1 >> 24);
    out.write(v1 >> 16);
    out.write(v1 >> 8);
    out.write(v1);
    
    out.write((int)(v2 >> 56));
    out.write((int)(v2 >> 48));
    out.write((int)(v2 >> 40));
    out.write((int)(v2 >> 32));
    out.write((int)(v2 >> 24));
    out.write((int)(v2 >> 16));
    out.write((int)(v2 >> 8));
    out.write((int)(v2));
    
    out.close();

  }

}









