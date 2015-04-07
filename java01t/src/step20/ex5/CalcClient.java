package step20.ex5;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {

  public static void main(String[] args) throws Exception{
    /* 실행 순서
     * 0. 키보드 스캐너 준비
     * 1. 서버에 연결
     * 2. 입출력 스트림 준비 (Scanner, PrintStream)
     * 3. 사용자로부터 계산 식을 입력 받는다.
     * 4. 서버에 전송한다.
     * 5. 서버의 응답결과를 출력한다.
     * 6. 만약 입력 받은 값이 "quit"이라면 종료한다.
     * 7. 3번으로 간다.
     */
     Scanner scan = new Scanner(System.in);
     Socket socket = null;
     Scanner in = null;
     PrintStream out = null;
     
     try {
       socket = new Socket("localhost", 9999);
       in = new Scanner(socket.getInputStream());
       out = new PrintStream(socket.getOutputStream());
       
       String input;
       String result;
       
       while (true) {
         
         System.out.print("계산식 입력 : ");
         input = scan.nextLine();
         
         out.println(input);
         result = in.nextLine();
         
         System.out.print("결과 : ");
         System.out.println(result);
         System.out.println();
         
         if(input.equals("quit")) 
           break;
       }
       
     } finally {
       try {scan.close();} catch (Exception e) {}
       try {in.close();} catch (Exception e) {}
       try {out.close();} catch (Exception e) {}
       try {socket.close();} catch (Exception e) {}
     }
  }

}
