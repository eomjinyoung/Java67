package step22.ex3;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcSkel {
  
  public int plus(int a, int b) throws Exception {
    Socket s = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      s = new Socket("192.168.103.67", 9898);
      in = new Scanner(s.getInputStream());
      out = new PrintStream(s.getOutputStream());
      
      out.println("plus," + a + "," + b);
      return Integer.parseInt(in.nextLine());
      
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {s.close();} catch (Exception e) {}
    }
  }
  
  public int minus(int a, int b) throws Exception {
    Socket s = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      s = new Socket("192.168.103.67", 9898);
      in = new Scanner(s.getInputStream());
      out = new PrintStream(s.getOutputStream());
      
      out.println("minus," + a + "," + b);
      return Integer.parseInt(in.nextLine());
      
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {s.close();} catch (Exception e) {}
    }
  }
  
}
