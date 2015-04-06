package step20.ex3;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// 실습 목표: 키보드에서 입력 받은 문자열을 서버에 보내기

public class EchoClient {
  public static void main(String[] args) throws Exception {
    // 키보드 입력 스트림을 스캐너에 연결하기 
    // Scanner가 데코레이터는 아니지만 데코레이터 같이 역할을 수행한다.
    // 데코레이터는 같은 부모(예:InputStream, OutputStream)를 갖는다.
    Scanner keyScan = new Scanner(System.in);
    
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버 소켓과 연결됨!");
    
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    //키보드로부터 읽어들인 값을 
    String input = keyScan.nextLine();
    
    //서버에 보낸다.
    out.println(input);
    
    String message = in.nextLine();
    System.out.println("서버 => " + message);
    
    in.close();
    out.close();
    
    socket.close();
    keyScan.close();
    
  }
}










