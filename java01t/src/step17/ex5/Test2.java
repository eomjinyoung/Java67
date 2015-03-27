package step17.ex5;

import java.io.FileInputStream;

// 실습 목표: 버퍼 기능을 수행하는 데이터 프로세싱 스트림 클래스(데코레이터) 사용하기
// =>BufferedInputStream
// 
// 내용: 20 ~ 30MB 크기의 파일을 읽는다.
// 1) 버퍼 기능을 붙이지 않고 읽어보고,
// 2) 버퍼 기능을 붙여서 읽어본다. 
// 두 작업 속도 차이를 알아본다. => BufferedInputStream의 역할을 이해한다.
//
// 데이터 읽기 = 데이터 찾기 시간(data seek time) + 데이터 전송 시간(data trasfer time)
// 예) 퀀텀 HDD 
//    데이터 찾기 시간: 0.0105초
//    데이터 전송 시간: 0.00000006초/바이트 
//    데이터를 전송하는 시간 보다 데이터를 찾는 시간이 매우 많이 걸린다.
//    그래서 데이터 읽기 속도를 높이려면, 데이터를 찾았을 때 많이 읽어야 한다.
//    보통 일정 크기의 바이터 배열(버퍼)을 만들어, 
//    read()를 호출할 때 왕창 버퍼로 읽어 들이는 방법을 사용한다.
// 아래 예제를 참고하라!
public class Test2 {

  public static void testWithoutBuffer() throws Exception {
    // 버퍼 사용 전
    // PDF는 바이너리 파일이다. 왜? 기본 텍스트 편집기(메모장, vi)로 변경할 수 없다.
    FileInputStream in = new FileInputStream("temp/jls8.pdf");
    int b = 0;
    long startTime = System.currentTimeMillis();
    while ((b = in.read()) != -1) {
      // 계속 읽는다.
    }
    long endTime = System.currentTimeMillis();
    System.out.printf("경과시간: %d 밀리초\n", endTime - startTime);
    in.close();
  }
  
  public static void testWithBuffer() throws Exception {
    // 버퍼 사용 후
    FileInputStream in = new FileInputStream("temp/jls8.pdf");
    byte[] buf = new byte[4096];
    int len = 0;
    long startTime = System.currentTimeMillis();
    while ((len = in.read(buf)) != -1) {
      // 계속 읽는다.
    }
    long endTime = System.currentTimeMillis();
    System.out.printf("경과시간: %d 밀리초\n", endTime - startTime);
    in.close();
  }

  public static void main(String[] args) throws Exception {
    System.out.print("버퍼 사용 후: ");
    testWithBuffer();

    System.out.print("버퍼 사용 전: ");
    testWithoutBuffer();
    
    
  }

}














