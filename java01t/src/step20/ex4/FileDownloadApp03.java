package step20.ex4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//실습 목표: 파일 전송하기
//=> 소켓과 파일 사이에 버퍼 적용

public class FileDownloadApp03 {

  public static void main(String[] args) throws Exception {
    if (args.length == 2) {
      runClient(args[0], Integer.parseInt(args[1]));
      
    } else if (args.length == 1) {
      runServer(Integer.parseInt(args[0]));
      
    } else {
      System.out.println("프로그램 사용법:");
      System.out.println("클라이언트 실행 => ChatApp 서버주소 포트번호");
      System.out.println("서버 실행 => ChatApp 포트번호");
    }

  }
  
  public static void runClient(String serverAddr, int port) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("파일명?");
    String filePath = keyScan.nextLine();
    
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    BufferedInputStream fileIn = null;
    
    try {
      File file = new File(filePath);
      
      if (!file.exists()) {
        System.out.println("존재하지 않는 파일입니다.");
        return;
      }
      
      socket = new Socket(serverAddr, port);
      System.out.println("서버와 연결했습니다.");
      
      in = new DataInputStream(
            new BufferedInputStream(socket.getInputStream()));
      out = new DataOutputStream(
            new BufferedOutputStream(socket.getOutputStream()));
      
      //1. 서버에 파일명을 보낸다.
      //=> 중간에 버퍼가 있기 때문에, 출력 데이터는 일단 버퍼에 들어간다.
      //=> 버퍼가 꽉 찼을 때만 출력한다.
      out.writeUTF(file.getName()); 
      
      // 서버에 즉시 데이터를 보내고 싶으면 강제로 버퍼의 내용을 방출하라!
      out.flush();
      
      if (!in.readUTF().equals("ok")) {
        System.out.println("전송 오류!");
        return;
      }
      
      //2. 전송할 파일의 크기를 보낸다.
      out.writeLong(file.length());
      out.flush(); // 버퍼의 내용을 방출하라!
      if (!in.readUTF().equals("ok")) {
        System.out.println("전송 오류!");
        return;
      }
      
      //3. 파일 전송
      fileIn = new BufferedInputStream(new FileInputStream(file));
      
      byte[] buf = new byte[1024];
      int len = 0;
      
      while((len = fileIn.read(buf)) != -1) {
        out.write(buf, 0, len);
      }
      out.flush(); // 버퍼의 내용을 방출하라!
      
      if (!in.readUTF().equals("ok")) {
        System.out.println("전송 오류!");
        return;
      }
      System.out.println("파일 전송 완료!");
      
    } finally {
      try {fileIn.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      try {keyScan.close();} catch (Exception e) {}
    }
  }
  
  public static void runServer(int port) throws Exception {
    ServerSocket ss = null;  
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    BufferedOutputStream fileOut = null;

    try {
      System.out.println("서버 실행!");
      ss = new ServerSocket(port);
      socket = ss.accept(); 
      System.out.println("연결 완료!");
      
      in = new DataInputStream(
          new BufferedInputStream(socket.getInputStream()));
      out = new DataOutputStream(
          new BufferedOutputStream(socket.getOutputStream()));
      
      String fileName = in.readUTF();
      System.out.println("파일명: " + fileName);
      out.writeUTF("ok");
      out.flush(); // 버퍼의 내용을 방출하라!
      
      long fileSize = in.readLong();
      System.out.println("파일크기: " + fileSize);
      out.writeUTF("ok");
      out.flush(); // 버퍼의 내용을 방출하라!
      
      //1. 클라이언트가 보내는 파일을 저장할 출력 스트림 준비
      fileOut = new BufferedOutputStream(
              new FileOutputStream("temp/download/" + fileName));
      
      long readCount = 0;
      byte[] buf = new byte[1024];
      int len = 0;
      
      while ((len = in.read(buf)) != -1) {
        fileOut.write(buf, 0, len);
        
        readCount += len;
        if (readCount >= fileSize) 
          break;
      }
      out.writeUTF("ok");
      out.flush(); // 버퍼의 내용을 방출하라!
      
      System.out.println("파일 수신 완료!");
      
    } finally {
      try {fileOut.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      try {ss.close();} catch (Exception e) {}
    }
  }

}





