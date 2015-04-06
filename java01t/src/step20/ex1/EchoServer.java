package step20.ex1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
    System.out.println("서버 소켓 준비 완료! 클라이언트 연결 기다림.");
    
    //2.클라이언트의 연결을 승인하라!
    //=> 클라이언트가 연결을 요청하면 대기열에 등록된다.
    //=> 대기열에서 첫 번째 클라이언트의 연결을 승인한다.
    
    // 대기열에 클라이언트 정보가 들어 올 때까지 기다린다.(blocking)
    // 대기열에서 클라이언트 정보를 꺼내는 순간, 클라이언트와의 통신을 담당할 객체를 리턴한다.
    Socket socket = ss.accept(); 
    System.out.println("클라이언트 연결 승인!");
    
    // 데이터 읽고 보내기
    //3. 데이터를 편히 읽고 쓰기 위해 입출력 스트림 객체 준비
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    // 처음에 클라이언트에서 데이터를 보내기 때문에, 서버에서는 먼저 읽어야 한다.
    String data = in.nextLine();
    
    // 클라이언트에게 데이터 보내기(응답한다).
    out.println(data + ":엄진영");
    
    //4. 데이터 통신을 마친 다음에 자원을 해제한다.
    in.close();
    out.close();
    
    // 클라이언트 소켓과 연결 끊기
    socket.close();
    
    // 서버 소켓의 자원 해제
    ss.close();
  }
}














