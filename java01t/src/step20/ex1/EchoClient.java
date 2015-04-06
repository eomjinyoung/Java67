package step20.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// Client : 먼저 요청하는 쪽
// Server : 요청 받는 쪽 
// Protocol: 주고 받는 데이터 형식 

public class EchoClient {
  public static void main(String[] args) throws Exception {
    //1. 서버 소켓과 연결을 시도한다.
    //=> 서버 소켓과 연결되면 통신을 담당할 소켓 객체를 리턴한다.
    Socket socket = new Socket("192.168.103.36", 8888);
    System.out.println("서버 소켓과 연결됨!");
    
    // 데이터를 보내고 받기
    //2. 데이터를 편히 읽고 쓰기 위해 입출력 스트림 객체 준비
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    //3. 데이터 보내기 => 데이터를 모두 보낼 때까지 리턴하지 않는다.(blocking)
    out.println("안녕하세요.^^");
    
    //4. 데이터 받기 => 줄 바꿈 데이터를 만날 때까지 리턴하지 않는다.(blocking)
    String message = in.nextLine();
    System.out.println("서버 => " + message);
    
    //5. 입출력이 끝났으면 닫아라!
    in.close();
    out.close();
    
    
    //서버 소켓과 연결 끊기
    socket.close();
  }
}










