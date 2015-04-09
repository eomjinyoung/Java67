package step21.server;

import java.net.ServerSocket;
import java.net.Socket;

// 실습 목표: 채팅 서버 만들기
// => 클라이언트 요청을 받아서 별도의 스레드에 위임하기
public class ChatServer01 {
  int port;
  
  public ChatServer01(int port) {
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
  }
  
  public void service() {
    ServerSocket ss = null;
    
    try {
      ss = new ServerSocket(port);
      
      while(true) {
        /*
        Socket socket = ss.accept();
        ChatAgent agent = new ChatAgent(socket);
        Thread t = new Thread(agent);
        t.start();
        */
        new Thread(new ChatAgent(ss.accept())).start();
      }
      
    } catch (Exception e) {
      System.out.println("서버 오류 발생!");
      e.printStackTrace();
      
    } finally {
      try {ss.close();} catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) {
    ChatServer01 server = new ChatServer01(8888);
    server.service();

  }

}







