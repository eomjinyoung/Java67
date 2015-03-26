package step17.ex2;

import java.io.File;

// 실습 목표:
// - 디렉토리의 들어 있는 내용 알아내기
// - list() : 파일 및 디렉토리 이름 배열
// - listFiles() : 파일 및 디렉토리 정보를 담은 File 인스턴스 배열 

public class Test4 {

  public static void main(String[] args) {
    //현재 폴더(프로젝트 폴더)에 들어 있는 내용을 알아내기
    File file = new File(".");
    
    printSimpleInfo(file);
    printDetailInfo(file);
    printDetailInfo2(file);
  }

  private static void printSimpleInfo(File file) {
    System.out.println("단순 출력 ----------------------");
    String[] fileInfoList = file.list();
    
    for (String fileInfo : fileInfoList) {
      System.out.println(fileInfo);
    }
  }
  
  private static void printDetailInfo(File file) {
    System.out.println("\n상세 출력 ----------------------");
    String[] fileInfoList = file.list();
    
    File temp = null;
    for (String fileInfo : fileInfoList) {
      temp = new File(fileInfo);
      System.out.printf("%s%s%s%s %-20s %d\n", 
          temp.isDirectory() ? "d" : "-",
          temp.canRead() ? "r" : "-",
          temp.canWrite() ? "w" : "-",
          temp.canExecute() ? "x" : "-", 
          fileInfo,
          temp.length());
    }
  }
  
  private static void printDetailInfo2(File file) {
    System.out.println("\n상세 출력2 ----------------------");
    File[] fileInfoList = file.listFiles();
    
    for (File temp : fileInfoList) {
      System.out.printf("%s%s%s%s %-20s %d\n", 
          temp.isDirectory() ? "d" : "-",
          temp.canRead() ? "r" : "-",
          temp.canWrite() ? "w" : "-",
          temp.canExecute() ? "x" : "-", 
          temp.getName(),
          temp.length());
    }
  }

}















