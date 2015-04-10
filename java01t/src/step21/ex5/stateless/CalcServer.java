package step21.ex5.stateless;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 실습 목표: Connectionless 방식의 계산기 서버 만들기
//
public class CalcServer {
  
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");
    
    while (true) {
      service(ss.accept());
    }

  }
  
  static void service(Socket socket) {
    System.out.println("클라이언트가 연결되었음.");
    
    DataInputStream in = null;
    DataOutputStream out = null;
    int v1 = 0, v2 = 0;
    String op = null;
    
    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      v1 = in.readInt();
      op = in.readUTF();
      v2 = in.readInt();
      out.writeUTF(compute(v1, v2, op));
    
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  static String compute(int v1, int v2, String op) {
    int result = 0;
    
    switch (op) {
    case "+": result = v1 + v2; break;
    case "-": result = v1 - v2; break;
    case "*": result = v1 * v2; break;
    case "/": result = v1 / v2; break;
    case "quit": return "goodbye";
    default: return "지원하지 않는 연산자입니다.";
    }
    
    return "계산 결과는 " + result + "입니다.";
  }

}















