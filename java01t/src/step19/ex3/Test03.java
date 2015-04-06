package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 실습 목표: 롤백하기 
// => rollback() 호출 => 임시 데이터베이스에 보관된 작업을 취소한다.
public class Test03 {

  public static void main(String[] args) {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      System.out.println("DBMS 접속 완료!");
      
      // 커밋을 수동으로 하게 설정한다.
      con.setAutoCommit(false);
      
      Statement stmt = con.createStatement();
      System.out.println("SQL 실행자 준비 완료!");
      
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','201')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','202')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','203')");
      
      // 임시 데이터베이스에 보관된 작업 결과를 취소한다.
      con.rollback();
      
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','301')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','302')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','303')");
      
      // 임시 데이터베이스에 보관된 작업 결과를 본래의 데이터베이스에 적용한다.
      con.commit();
      
      
      // 용어!
      // "트랜잭션(Transaction)"
      // => 여러 개의 작업을 묶어서 한 작업으로 다루고 싶을 때.
      // => 여러 개의 작업을 묶어 한 작업으로 만든 것.
      
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}












