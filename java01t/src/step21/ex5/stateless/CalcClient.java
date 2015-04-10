package step21.ex5.stateless;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/* 실습 목표: Connectionless 방식으로 서버와 통신
 * => 요청할 때마다 서버와 연결한다.
 * => 특징
 *    . 실행 시간이 더 걸린다.
 *    . 계속 연결하지 않기 때문에 서버 메모리가 절약된다.
 */

public class CalcClient {
  static Scanner keyScan = new Scanner(System.in);

  static class Expression {
    String op;
    int v1;
    int v2;
    
    public Expression(String op, int v1, int v2) {
      this.op = op;
      this.v1 = v1;
      this.v2 = v2;
    }
    
    public static Expression valueOf(String str) {
      String[] tokens = str.split(" ");
      
      if (tokens.length != 3) {
        if (tokens[0].equals("quit")) {
          return new Expression("quit", 0, 0);
        } else {
          return null;
        }
      } else {
        return new Expression(
            tokens[1],
            Integer.parseInt(tokens[0]),
            Integer.parseInt(tokens[2]));
      }
    }
  }
  
  static String prompt() {
    // 사용자로부터 계산 식을 입력 받는다.
    System.out.print("> ");
    return keyScan.nextLine();
  }
  
  // 서버에 요청할 때마다 서버와 연결한다.
  // 요청/응답 작업이 끝난 후 즉시 서버와의 연결을 끊는다.
  static void requestCompute(Expression expr) {
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    
    try {
      socket = new Socket("localhost", 8888);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      out.writeInt(expr.v1);
      out.writeUTF(expr.op);
      out.writeInt(expr.v2);
      
      System.out.println(in.readUTF());
      
    } catch (Exception e) {
      System.out.println("서버 통신 오류!");
      e.printStackTrace();
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) {
    String input = null;
    Expression expr = null;

    do {
      input = prompt();
      expr = Expression.valueOf(input);
      
      if (expr == null) {
        System.out.println("입력 예) 23 * 4(엔터)");
        continue;
      }
      
      requestCompute(expr);
      
    } while (expr == null || !"quit".equals(expr.op));
    
    try {keyScan.close();} catch (Exception e) {}
  }
}











