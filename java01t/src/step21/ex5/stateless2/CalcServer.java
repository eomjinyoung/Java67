package step21.ex5.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

// 실습 목표: Connectionless 방식의 계산기 서버 만들기
// => QueryString을 받아서, 분석하여 처리한다.
public class CalcServer {
  
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");
    
    while (true) {
      service(ss.accept());
    }

  }
  
  static Map<String,String> getParameters(String queryString) {
    String[] tokens = null;
    String[] items = null;

    tokens = queryString.split("\\?"); 
    // tokens[0] : compute
    // tokens[1] : v1=20&op=+&v2=30
    
    Map<String,String> paramMap = new HashMap<String,String>();
    if (tokens[0].equals("compute")) {
      // &를 기준으로 key=value 형태로 자른다.
      tokens = tokens[1].split("&"); // 예) v1=20&op=+&v2=30
      // tokens[0] : v1=20
      // tokens[1] : op=+
      // tokens[2] : v2=30
      
      // "="을 기준으로 키와 값으로 자른다.
      items = tokens[0].split("="); //예) v1=20
      // items[0] : v1
      // items[1] : 20
      paramMap.put(items[0], items[1]);
      
      items = tokens[1].split("="); //예) op=+
      // items[0] : op
      // items[1] : +
      paramMap.put(items[0], items[1]);

      items = tokens[2].split("="); //예) v2=30
      // items[0] : v2
      // items[1] : 30
      paramMap.put(items[0], items[1]);
      
      return paramMap;
      
    } else {
      return null;
    }
  }
  
  static void service(Socket socket) {
    System.out.println("클라이언트가 연결되었음.");
    
    DataInputStream in = null;
    DataOutputStream out = null;
    String queryString = null;
    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      queryString = in.readUTF(); //예) compute?v1=20&op=+&v2=30
      System.out.println(queryString);
      
      Map<String,String> paramMap = getParameters(queryString);
      
      if (paramMap == null) {
        out.writeUTF("지원하지 않는 명령입니다.");
      
      } else {
        out.writeUTF(compute(
          Integer.parseInt(paramMap.get("v1")), 
          Integer.parseInt(paramMap.get("v2")),
          paramMap.get("op"))); 
      }
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















