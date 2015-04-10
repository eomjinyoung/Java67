package step21.ex5.stateful;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/* 실습 목표: Connectionful 방식으로 서버와 통신
 * => 한 번 서버와 연결하면 계속 계산을 요청할 수 있음.
 */

public class CalcClient {
  public static void main(String[] args) {
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    Scanner keyScan = new Scanner(System.in);
    
    try {
      socket = new Socket("localhost", 8888);
      System.out.println("서버와 연결되었음.");
      
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      String input = null;
      String[] tokens = null;
      int v1 = 0, v2 = 0;
      String op = null;
      
      do {
        System.out.print("> ");
        input = keyScan.nextLine();
        tokens = input.split(" ");
        
        if (tokens.length != 3) {
          if (tokens[0].equals("quit")) {
            op = "quit";
          } else {
            System.out.println("입력 예) 23 * 4(엔터)");
            continue;
          }
        } else {
          v1 = Integer.parseInt(tokens[0]);
          op = tokens[1];
          v2 = Integer.parseInt(tokens[2]);
        }

        out.writeInt(v1);
        out.writeUTF(op);
        out.writeInt(v2);
        
        System.out.println(in.readUTF());
        
      } while (!"quit".equals(op));
      
    } catch (Exception e) {
      System.out.println("서버 통신 오류!");
      e.printStackTrace();
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      try {keyScan.close();} catch (Exception e) {}
    }
  }
}











