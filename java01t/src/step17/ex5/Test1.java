package step17.ex5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

// 실습 목표: data processing stream class 사용
// => DataOutputStream 클래스 사용법 익히기
//
// => java.io 패키지의 클래스들은 기능을 쉽게 확장할 수 있도록
//    Decorator 패턴으로 구현되어 있다.
// => data sink stream 클래스는 작업자 역할을 수행하고,
//    (예: FileOutputStream/FileInputStream, FileReader/FileWriter, ...)
//
//    data processing stream 클래스는 데코레이터 역할을 수행한다.
//    (예: DataOutputStream/DataInputStream, 
//         ObjectOutputStream/ObjectInputStream,
//        BufferedOutputStream/BufferedInputStream, ...)
// 실습을 통해 알아보자!
public class Test1 {

  public static void main(String[] args) throws Exception {
    int v1 = 1207430; //0x00126C86
    long v2 = 1345044002000L; // 0x000001392ADEB4D0
    // 파일에 출력될 데이터 : 00126C86000001392ADEB4D0 (총 12바이트)
    
    FileOutputStream out = new FileOutputStream("temp/ex5.test1.data");
    
    // "데코레이터 붙이기"
    // 기존의 FileOutputStream 객체에 기능을 덧 붙인다.
    // => int나 long을 바이트로 쪼개서 출력하는 기능!
    DataOutputStream out2 = new DataOutputStream(out);
    
    out2.writeInt(v1);
    out2.writeLong(v2);
    
    out2.close();
    out.close(); // DataOutputStream을 닫으면 자동으로 닫긴다. 
                 // 호출 안해도 됨.

  }

}









