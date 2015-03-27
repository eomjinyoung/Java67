package step17.ex5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 실습 목표: 버퍼 기능과 원시 자료형 데이터 출력 기능을 동시 추가하기
// =>BufferedInputStream + DataOutputStream
// 
public class Test3 {

  public static void testWriting() throws Exception {
    DataOutputStream out = 
        new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("temp/ex5.test3.data")));
    
    out.writeUTF("홍길동");
    out.writeInt(20);
    out.writeBoolean(false);
    out.writeUTF("111-1111");
    
    out.close();
  }
  
  public static void testReading() throws Exception {
    DataInputStream in = 
        new DataInputStream(
            new BufferedInputStream(
                new FileInputStream("temp/ex5.test3.data")));
    
    String name = in.readUTF();
    int age = in.readInt();
    boolean gender = in.readBoolean();
    String tel = in.readUTF();
    
    System.out.printf("%s, %d, %b, %s\n", name, age, gender, tel);
    
    in.close();
  }

  public static void main(String[] args) throws Exception {
    testWriting();
    testReading();
    
  }

}














