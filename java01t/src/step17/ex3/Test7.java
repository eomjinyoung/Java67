package step17.ex3;

import java.io.FileOutputStream;
import java.io.OutputStream;

// 실습 목표: 도우미 클래스를 사용하여 int, long을 출력하기
// => MyDataOutputStream 클래스는 내부에서 FileOutputStream 클래스를 사용하여
//    int, long 값을 출력한다. 
// => 이렇게 출력 중간에 개입하여 데이터를 가공하는 역할을 수행하는 클래스를
//    "Data Processing Stream Class" 라고 한다.
public class Test7 {
  static class MyDataOutputStream {
    OutputStream out;
    
    public MyDataOutputStream(OutputStream out) {
      this.out = out;
    }
    
    public void writeInt(int v) throws Exception {
      out.write(v >> 24);
      out.write(v >> 16);
      out.write(v >> 8);
      out.write(v);
    }
    
    public void writeLong(long v) throws Exception {
      out.write((int)(v >> 56));
      out.write((int)(v >> 48));
      out.write((int)(v >> 40));
      out.write((int)(v >> 32));
      out.write((int)(v >> 24));
      out.write((int)(v >> 16));
      out.write((int)(v >> 8));
      out.write((int)(v));
    }
    
    public void close() throws Exception {
      out.close();
    }
  }
  public static void main(String[] args) throws Exception {
    int v1 = 1207430; //0x00126C86
    long v2 = 1345044002000L; // 0x000001392ADEB4D0
    // 파일에 출력될 데이터 : 00126C86000001392ADEB4D0 (총 12바이트)
    
    FileOutputStream out = new FileOutputStream("temp/test6.data");
    MyDataOutputStream out2 = new MyDataOutputStream(out);

    out2.writeInt(v1);
    out2.writeLong(v2);
    
    out2.close();

  }

}









