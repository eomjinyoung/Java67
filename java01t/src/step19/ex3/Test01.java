package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// commit과 rollback
// 1) commit
//   => 임시 데이터베이스에 저장한 작업 결과를 본래의 데이터베이스에 적용하라!
// 2) rollback
//   => 임시 데이터베이스에 저장한 작업 결과를 본래의 데이터베이스에 적용하지 말고 취소하라!
//
// 실습 목표: 커밋을 수동으로 맞춘 다음 insert 하기 
// => 입력이 되지 않을 것이다. : 커밋을 하지 않았기 때문이다.
//
// 커밋을 수동으로 맞추면 어떤 일이 일어나는가?
// => 데이터를 변경하는 모든 작업(insert,update,delete)은 임시 데이터베이스에 보관된다.
// => 개발자가 명시적으로 commit을 요청해야만 본래 데이터베이스에 실행 결과를 적용한다.
public class Test01 {

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
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}
