package step17.ex2;

import java.io.File;

// 실습 목표: 현재 디렉토의 모든 파일 및 디렉토리 정보를 출력하기 
// - 하위 디렉토리 모두 포함.
public class Test5 {

  public static void main(String[] args) throws Exception {
    File file = new File(".");
    
    // 출력 결과
    // ./
    // ./src
    // ./src/SelectStudent.java
    // ...
    
    printFileInfo(file);
  }

  private static void printFileInfo(File file) {
    
  }

}









