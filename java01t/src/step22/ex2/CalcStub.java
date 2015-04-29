package step22.ex2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcStub {

  public static void main(String[] args) throws Exception {
    Calc calculator = new Calc();
    
    ServerSocket ss = new ServerSocket(9898);
    Socket s = null;
    Scanner in = null;
    PrintStream out = null;
    while (true) {
      try {
        System.out.println("연결을 기다리는 중...");
        s = ss.accept();
        in = new Scanner(s.getInputStream());
        out = new PrintStream(s.getOutputStream());
        
        String[] values = in.nextLine().split(",");
        int v1 = Integer.parseInt(values[1]);
        int v2 = Integer.parseInt(values[2]);
        
        switch (values[0]) {
        case "plus": out.println( calculator.plus(v1, v2) ); break;
        case "minus": out.println( calculator.minus(v1, v2) ); break;
        default:
          out.println("해당 연산자를 지원하지 않습니다.");
        }
        
      } catch (Exception e) {
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {s.close();} catch (Exception e) {}
      }
    }
    //ss.close();
  }

}






