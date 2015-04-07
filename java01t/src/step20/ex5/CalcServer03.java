package step20.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 실습 목표: 멀티태스킹 처리하기
// => Concurrent 프로그래밍
// => 특정 코드 블록을 동시에 실행하는 것!

public class CalcServer03 {
  
  // 동시에 실행해야 할 코드를 별도의 블록을 분리한다.
  // 1. Thread를 상속 받은 클래스를 정의한다.
  // 2. 작업에 필요한 재료는 생성자에서 받는다.
  // 3. run()을 오버라이딩하여 동시 실행 코드를 넣는다.
  static class MyWorker extends Thread {
    Socket socket;
    
    public MyWorker(Socket socket) {
      this.socket = socket;
    }
    
    // 동시 실행 코드 => Thread의 run() 메서드를 오버라이딩하여 넣는다.
    @Override
    public void run() {
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
        
      } catch (Exception e) {
        System.out.println("클라이언트 입출력 오류 발생!");
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
        System.out.println("클라이언트와의 연결을 끊었습니다.");
      }
    }
    
  }
  
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(9999);
    System.out.println("계산기 서버 실행!");
    
    while (true) {
      try {
        MyWorker 상담사 = new MyWorker(ss.accept());
        상담사.start(); // 직접 run() 호출하지 말 것.
        
      } catch (Exception e) {
        System.out.println("클라이언트 입출력 오류!");
      }
    }
    
    //try {ss.close();} catch (Exception e) {}

  }
  
}
















