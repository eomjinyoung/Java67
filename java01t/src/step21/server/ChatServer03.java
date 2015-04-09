package step21.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

// 실습 목표: 채팅 서버 만들기
// => ChatAgent의 run() 구현 : 메시지를 수신하면, ChatServer의 broardcast()를 호출.
// => ChatAgent의 response() 구현 : 클라이런트에게 메시지 전송.
// => ChatServer의 broadcast() 구현 : ChatAgent의 response() 호출 
//
public class ChatServer03 {
  ArrayList<ChatAgent> agents = new ArrayList<ChatAgent>();
  int port;
  
  public ChatServer03(int port) {
    this.port = port;
  }
  
  class ChatAgent implements Runnable {
    Socket socket;
    Scanner in = null;
    PrintStream out = null;
    
    public ChatAgent(Socket socket) throws Exception {
      this.socket = socket;
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
    }
    
    @Override
    public void run() {
      // 클라이언트에서 보내는 메시지를 받는다.
      // 서버에게 알린다. broadcast() 호출.
      String message = null;
      try {
        while (true) {
          message = in.nextLine();
          
          //서버의 broadcast() 호출
          // => 이너 클래스도 바깥 클래스 멤버이기 때문에, 
          //    바깥 클래스의 다른 멤버를 사용할 수 있다.
          broadcast(message);
          
          if (message.equals("quit"))
            break;
        }
      } catch (Exception e) {
        System.out.println("클라이언트 데이터 송수신 오류!");
        e.printStackTrace();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
        
        removeChatAgentFromList(this);
      }
    }

    // 클라이언트에게 메시지를 보낸다.
    public void response(String message) {
      try {
        out.println(message);
        
      } catch (Exception e) {
        System.out.println("클라이언트 데이터 송수신 오류!");
        e.printStackTrace();
        
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex) {}
        
        removeChatAgentFromList(this);
      }  
    }
  }
  
  // 클라이언트와 연결이 끊어지면, ChatAgent 목록에서 제거한다.
  public void removeChatAgentFromList(ChatAgent agent) {
    agents.remove(agent);
  }
  
  // 클라이언트가 메시지를 보내면, ChatAgent가 받아서 이 메소드를 호출한다.
  // 여러 스레드 호출하면 메시지를 보내는 순서가 꼬인다. => critical section
  // 동기화 처리 필요 => mutex(뮤텍스) => 오직 한 스레드만이 진입 가능!
  synchronized public void broadcast(String message) {
    // 리스트에 보관된 ChatAgent를 꺼내서 메시지를 보내라고 명령한다.
    for (int i = 0; i < agents.size(); i++) {
      agents.get(i).response(message);
    }
    
  }
  
  public void service() {
    ServerSocket ss = null;
    
    try {
      ss = new ServerSocket(port);
      System.out.println("서버 실행 중...");
      
      ChatAgent agent = null;
      
      while(true) {
        agent = new ChatAgent(ss.accept());
        agents.add(agent);
        new Thread(agent).start();
      }
      
    } catch (Exception e) {
      System.out.println("서버 오류 발생!");
      e.printStackTrace();
      
    } finally {
      try {ss.close();} catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) {
    ChatServer03 server = new ChatServer03(8888);
    server.service();

  }

}







