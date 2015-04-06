package step20.ex1;

import java.net.ServerSocket;
import java.net.Socket;

// 서버 소켓: 요청을 받는 기능
// 포트 번호: 데이터를 주고 받는 소켓을 구분하기 위해 붙이는 고유 번호
// => 기존에 자주 사용하는 포트 번호
//    FTP : 21
//    Telnet : 23
//    POP3 (이메일): 110
//    IMAP4 (이메일): 143
//    HTTP (웹): 80
//    HTTP 프록시: 8080
// => 가능한 기존에 널리 사용하는 포트 번호는 사용하지 말 것.
//    특히 1000 이하의 포트 번호는 사용하지 말 것.
//    1000 이상이라도 8080처럼 널리 사용되는 포트 번호는 사용하지 말 것.
//
public class EchoServer {
  public static void main(String[] args) throws Exception {
    //1.서버 소켓 생성 
    ServerSocket ss = new ServerSocket(8888); //포트 번호 등록 
    
    //2.클라이언트의 연결을 승인하라!
    //=> 클라이언트가 연결을 요청하면 대기열에 등록된다.
    //=> 대기열에서 첫 번째 클라이언트의 연결을 승인한다.
    
    // 대기열에 클라이언트 정보가 들어 올 때까지 기다린다.(blocking)
    // 대기열에서 클라이언트 정보를 꺼내는 순간, 클라이언트와의 통신을 담당할 객체를 리턴한다.
    Socket socket = ss.accept(); 
    
    
    // 데이터 읽고 보내기
    
    
    // 클라이언트 소켓과 연결 끊기
    socket.close();
    
    // 서버 소켓의 자원 해제
    ss.close();
  }
}














