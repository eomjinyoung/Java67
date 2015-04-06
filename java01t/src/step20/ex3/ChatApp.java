package step20.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatApp {

  public static void main(String[] args) throws Exception {
    if (args.length == 2) {
      runClient(args[0], Integer.parseInt(args[1]));
      
    } else if (args.length == 1) {
      runServer(Integer.parseInt(args[0]));
      
    } else {
      System.out.println("프로그램 사용법:");
      System.out.println("클라이언트 실행 => ChatApp 서버주소 포트번호");
      System.out.println("서버 실행 => ChatApp 포트번호");
    }

  }
  
  public static void runClient(String serverAddr, int port) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    
    // 챗 클라이언트를 실행하면 첫 번째로 별명을 입력 받는다.
    // 이 별명은 서버에 보낼 메시지에 붙일 것이다.
    System.out.print("별명?");
    String alias = keyScan.nextLine();
    
    Socket socket = new Socket(serverAddr, port);
    System.out.println("상대와 연결되었습니다.");
    
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    String input = null;
    String message = null;
        
    while (true) {
      input = keyScan.nextLine();
      out.println(alias + ":" + input);
      
      message = in.nextLine();
      System.out.println(message);
      
      if (input.equals("goodbye"))
        break;
    }
    
    in.close();
    out.close();
    
    socket.close();
    keyScan.close();
    
  }
  
  public static void runServer(int port) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("별명?");
    String alias = keyScan.nextLine();
    
    ServerSocket ss = new ServerSocket(port);
    Socket socket = ss.accept(); 
    System.out.println("연결 완료!");

    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    String input = null;
    String message = null;
        
    while (true) {
      message = in.nextLine();
      System.out.println(message);

      input = keyScan.nextLine();
      out.println(alias + ":" + input);
      
      if (message.equals("goodbye"))
        break;
    }
    
    in.close();
    out.close();
    
    socket.close();
    ss.close();
    
    keyScan.close();
  }

}





