package step22.ex1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

// 이미지 데이터를 Base64 형식으로 인코딩하기.
public class Test2 {

  public static void main(String[] args) throws Exception {
    Base64.Encoder base64Encoder = Base64.getEncoder();
    
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    BufferedInputStream imageSource = 
        new BufferedInputStream(new FileInputStream("./temp/pic02.jpg"));
    
    int b = -1;
    while((b = imageSource.read()) != -1) {
      out.write(b);
    }
    
    imageSource.close();
    out.close();
    
    String base64String = base64Encoder.encodeToString(out.toByteArray());
    System.out.println(base64String);
  }

}





