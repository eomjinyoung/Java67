package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/* 실습 목표: PreparedStatement 사용하기 
 * => Statement와 비교!
 * 1) 실행 속도
 *    S   : 실행할 때 마다 SQL문을 컴파일(DBMS에 전송하기 좋게 바이너리 형식화)하여 서버에 전송
 *    P(V): 미리 SQL문을 컴파일 해 두고, 값을 넣은 다음 전송. 반복하여 실행할 때 속도 빠름!
 * 2) 코드 읽기
 *    S   : INSERT 또는 UPDATE 할 때 SQL문과 값이 섞여 있다. SQL이 길 수록 읽기 힘들다.
 *    P(V): SQL문과 값이 분리되어 있다. 읽기 쉽다.
 * 3) 바이너리 데이터 입력
 *    S   : SQL문이 문자열이기 때문에 바이너리 값을 넣을 수 없다.
 *    P(V): SQL문과 값이 분리되어 있기 때문에 바이너리 값(이미지, 동영상 등)을 넣을 수 있다.
 *    
 */
public class T09_PreparedStatement {
  public static void main(String[] args) {
    //before();
    after();
  }
  public static void before() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      stmt = con.createStatement();
      
      int no = 15;
      String loc = "강릉";
      String room = "401";
      
      String sql = "UPDATE CLASSROOMS SET"
          + " LOC = '" + loc + "',"
          + " ROOM = '" + room + "'"
          + " WHERE CNO = " + no;
      
      int count = stmt.executeUpdate(sql);
      
      if (count == 1) {
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("변경 실패입니다!");
      }
          
    } catch (SQLException e) {
      e.printStackTrace(); 
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public static void after() {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      
      //SQL 문을 먼저 준비한다.
      stmt = con.prepareStatement(
          "UPDATE CLASSROOMS SET LOC = ?, ROOM = ? WHERE CNO = ?");
      
      int no = 15;
      String loc = "속초";
      String room = "402";
      
      //SQL 문 빈 자리(? => in parameter라고 부름)에 값 할당.
      //in parameter: 변수 명이 없다. 문자열, 숫자 상관없이 ?로 표시한다. 
      //setXXX(파라미터번호, 값)을 호출하여 값을 넣는다.
      //=> XXX: 타입
      //=> 파라미터 번호: 1부터
      //=> 값을 넣는 순서는 상관없다. 그러나 이해하기 좋게 순서대로 넣어라!
      
      stmt.setString(1, loc);
      stmt.setString(2, room);
      stmt.setInt(3, no);
      
      //값을 모두 할당한 다음에 executeUpdate()를 그냥 호출하면 된다.
      //주의! executeUpdate()에 SQL을 넣지 말라! 자주 실수하는 부분!
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("변경 실패입니다!");
      }
          
    } catch (SQLException e) {
      e.printStackTrace(); 
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  

}











