package step21.ex5.stateful;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 실습 목표: Connectionful 방식의 계산기 서버 만들기
//
// Connectionful (Stateful)
// => 일단 클라이언트가 연결되면, 클라이언트에서 연결을 끊을 때 까지
// => 계속 요청을 처리해준다.
// => 특징
//    . 연결은 한 번만 이루어지기 때문에 연결하는데 시간을 낭비하지 않는다. => 속도 빠르다.
//    . 클라이언트가 계산을 요청하지 않아도 계속 연결을 유지해야 한다. => 자원 낭비.
//    . 기존 연결로 인해 다른 클라이언트와의 연결 개수에 제한을 받는다.
// => 예) FTP, SSH, Telnet
//
// Connectionless (Stateless)
// => 계산 요청을 할 때마다 연결하고, 계산을 수행하고, 응답하고, 열결을 끊는다.
// => 곧 계산을 수행할 때마다 매번 연결을 수행한다.
// => 특징
//    . 매번 계산을 요청할 때마다 연결을 해야 하기 때문에 속도가 지연된다.
//    . 요청을 처리한 후 즉시 연결을 끊기 때문에 더 많은 클라이언트 요청을 처리할 수 있다.
// => 예) HTTP
// 
public class CalcServer {
  
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    
    while (true) {
      service(ss.accept());
    }

  }
  
  static void service(Socket socket) {
    DataInputStream in = null;
    DataOutputStream out = null;
    int v1 = 0, v2 = 0;
    String op = null;
    
    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      do {
        v1 = in.readInt();
        op = in.readUTF();
        v2 = in.readInt();
        out.writeUTF(compute(v1, v2, op));

      } while (!op.equals("quit"));
    
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















