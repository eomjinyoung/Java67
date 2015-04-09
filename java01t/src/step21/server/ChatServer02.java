package step21.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// 실습 목표: 채팅 서버 만들기
// => 서버에 ChatAgent를 보관할 목록을 준비한다.
// => 클라이언트가 연결될 때 마다 대리인을 목록에 추가한다.
// => 클라이언트로부터 받는 메시지를 방송해 줄 메서드 준비한다. => broadcast()
// => broadcast()에서는 agent 목록에서 하나씩 꺼내 메시지를 보내게 한다. => response()
public class ChatServer02 {
  ArrayList<ChatAgent> agents = new ArrayList<ChatAgent>();
  int port;
  
  public ChatServer02(int port) {
    this.port = port;
  }
  
  class ChatAgent implements Runnable {
    Socket socket;
    
    public ChatAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      // 무슨 일을 할지는 아직 작성하지 않음.
    }

    // 클라이언트에게 메시지를 보낸다.
    public void response(String message) {
      
    }
  }
  
  // 클라이언트가 메시지를 보내면, ChatAgent가 받아서 이 메소드를 호출한다.
  // 여러 스레드 호출하면 메시지를 보내는 순서가 꼬인다. => critical section
  // 동기화 처리 필요 => mutex(뮤텍스) => 오직 한 스레드만이 진입 가능!
  synchronized public void broadcast(String message) {
    // 리스트에 보관된 ChatAgent를 꺼내서 메시지를 보내라고 명령한다.
    for (ChatAgent agent : agents) {
      agent.response(message);
    }
    
  }
  
  public void service() {
    ServerSocket ss = null;
    
    try {
      ss = new ServerSocket(port);
      
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
    ChatServer02 server = new ChatServer02(8888);
    server.service();

  }

}







