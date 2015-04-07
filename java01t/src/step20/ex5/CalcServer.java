package step20.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {

  public static void main(String[] args) throws Exception {
    /* 실행 순서
     * 1. 클라이언트의 연결이 들어오면 승인한다.
     * 2. 입출력 스트림을 준비한다.
     * 3. 클라이언트가 보낸 계산 식을 읽는다.
     * 4. 계산 식의 내용이 "quit"이라면, 
     *    클라이언트에게 "goodbye"를 보낸다.
     *    종료한다.
     * 5. 공백을 기준으로 값을 분리한다.
     * 6. 계산을 수행한 후 결과를 클라이언트로 보낸다.
     * 7. 3번으로 간다. 
     */
    
    ServerSocket ss = null;
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      ss = new ServerSocket(9999);
      socket = ss.accept();
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
      try {ss.close();} catch (Exception e) {}
    }

  }

}
