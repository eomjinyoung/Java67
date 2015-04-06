package step20.ex2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 실습 목표: 무한 반복하기 
// 
// 대기열 개수 지정하기
// => 대기 가능한 클라이언트 수를 지정한다.
// => 대기 수를 넘는 클라이언트 접속은 거절한다.
//    => 클라이언트는 내부적으로 정한 타임아웃 동안 계속 서버와의 연결을 시도한다.
public class EchoServer {
  public static void main(String[] args) throws Exception {
    // 두 번째 파라미터 값이 대기열(backlog) 개수이다. 
    ServerSocket ss = new ServerSocket(8888, 3); //포트 번호 등록 
    System.out.println("서버 소켓 준비 완료!");
    
    while (true) {
      System.out.println("클라이언트 연결 기다림.");
      Socket socket = ss.accept(); 
      System.out.println("클라이언트 연결 승인!");
      
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());
      
      String data = in.nextLine();
      System.out.println(data); // 클라이언트가 보낸 데이터를 서버 콘솔 창으로 출력!
      
      out.println(data + ":엄진영"); // 클라이언트로 보내기!
      
      in.close();
      out.close();
      socket.close();
      System.out.println("클라이언트 연결 종료!");
    }
    //ss.close();
  }
}














