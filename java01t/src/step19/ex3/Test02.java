package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 실습 목표: 커밋하기 
// => commit() 호출 => 데이터 입력 확인!
public class Test02 {

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
      
      int count = stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','101')");
      
      if (count == 1) {
        System.out.println("교실 정보를 추가하였습니다.");
      }
      
      // 임시 데이터베이스에 있는 결과를 본래 데이터베이스에 적용할 것을 요청한다.
      con.commit();
      
      //커넥션 객체에 대해 커밋을 수행하기 때문에,
      //같은 커넥션에 연결된 모든 Statement의 작업도 무조건 커밋된다.
      //=> 그래서 한 작업 당 한 개의 커넥션을 사용해야 한다.
      
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}












