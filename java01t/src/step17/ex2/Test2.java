package step17.ex2;

import java.io.File;

// File 클래스를 사용하여 파일을 다루기
// - 디렉토리 생성 및 파일 생성
public class Test2 {

  public static void main(String[] args) throws Exception {
    //디렉토리 만들기
    File file = new File("./temp");
    
    if (!file.exists()) {
      if (file.mkdir())
        System.out.println("디렉토리를 생성하였습니다.");
      else
        System.out.println("디렉토리 생성 실패!");
    }
    
    //파일 만들기
    File file2 = new File("./temp/test.txt");
    
    if (!file2.exists()) {
      if (file2.createNewFile())
        System.out.println("파일을 생성하였습니다.");
      else
        System.out.println("파일 생성 실패!");
    }

  }

}






















