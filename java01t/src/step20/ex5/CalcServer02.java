package step20.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 여러 클라이언트의 요청처리
// 단 동시 처리가 불가능하다.
// 연결된 순서대로 처리한다.

public class CalcServer02 {

  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(9999);
    System.out.println("계산기 서버 실행!");
    
    while (true) {
      try {
        service(ss.accept());
      } catch (Exception e) {
        System.out.println("클라이언트 입출력 오류!");
      }
    }
    
    //try {ss.close();} catch (Exception e) {}

  }
  
  static void service(final Socket socket) throws Exception {
    System.out.println("클라이언트와 연결되었습니다.");
    Scanner in = null;
    PrintStream out = null;
    
    try {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      String expr;
      String[] exprItems;
      
      int v1 = 0, v2= 0, result = 0;
      String oper;
      
      while (true) {
        expr = in.nextLine();
        if (expr.equals("quit")) {
          out.print("goodbye");
          break;
        }
        
        exprItems = expr.split(" ");
        
        if (exprItems.length != 3) {
          out.println("식이 올바르지 않습니다!");
          continue;
        }
        
        v1 = Integer.parseInt(exprItems[0]);
        v2 = Integer.parseInt(exprItems[2]);
        oper = exprItems[1];
        
        switch (oper) {
        case "+": result = v1 + v2; break;
        case "-": result = v1 - v2; break;
        case "*": result = v1 * v2; break;
        case "/": result = v1 / v2; break;
        default:
          out.println("지원하지 않는 연산자입니다.");
          continue;
        }
        out.println(result);
      }
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      System.out.println("클라이언트와의 연결을 끊었습니다.");
    }
  }

}
















