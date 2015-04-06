package step20.ex1;

import java.net.Socket;

// Client : 먼저 요청하는 쪽
// Server : 요청 받는 쪽 
// Protocol: 주고 받는 데이터 형식 

public class EchoClient {
  public static void main(String[] args) throws Exception {
    //1. 서버 소켓과 연결을 시도한다.
    //=> 서버 소켓과 연결되면 통신을 담당할 소켓 객체를 리턴한다.
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버 소켓과 연결됨!");
    
    // 데이터를 보내고 받기 
    
    //서버 소켓과 연결 끊기
    socket.close();
  }
}










