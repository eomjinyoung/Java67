package step21.ex5.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/* 실습 목표: Connectionless 방식으로 서버와 통신
 * => 서버에 데이터를 보낼 때 한 줄로 보내기
 * => 형식
 * => compute?v1=20&op=+&v2=40
 * => quit
 */

public class CalcClient {
  static Scanner keyScan = new Scanner(System.in);

  // 사용자가 입력한 계산 식을 웹 표준의 QueryString으로 변경한다.
  public static String toQueryString(String str) {
    String[] tokens = str.split(" ");
    
    if (tokens.length != 3) {
      if (tokens[0].equals("quit")) {
        return tokens[0];
      } else {
        return null;
      }
    } else {
      return "compute?v1=" + tokens[0] 
          + "&op=" + tokens[1]
          + "&v2=" + tokens[2];
    }
  }
  
  static String prompt() {
    // 사용자로부터 계산 식을 입력 받는다.
    System.out.print("> ");
    return keyScan.nextLine();
  }
  
  // 서버에 요청할 때마다 서버와 연결한다.
  // 요청/응답 작업이 끝난 후 즉시 서버와의 연결을 끊는다.
  static void requestCompute(String queryString) {
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    
    try {
      socket = new Socket("localhost", 8888);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      out.writeUTF(queryString);
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
    String queryString = null;
    do {
      queryString = toQueryString(prompt());
      
      if (queryString == null) {
        System.out.println("입력 예) 23 * 4(엔터)");
        continue;
      } else if (queryString.equals("quit")) {
        break;
      }
      
      requestCompute(queryString);
      
    } while (true);
    
    try {keyScan.close();} catch (Exception e) {}
  }
}











