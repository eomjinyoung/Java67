package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* 실습 목표: close() 사용
 * => 사용한 자원은 즉시 해제해야 다른 쪽에서 사용할 수 있다.
 */
public class T07_close {

  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      stmt = con.createStatement();
      int count = stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('대전','201')");
      if (count == 1) {
        System.out.println("교실 정보를 추가하였습니다.");
      }
      
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    
    } finally {
      //자원 해제는 정상적으로 작업한 후든 오류가 발생했든 반드시 수행해야 한다.
      //자원 해제 순서 : 생성된 역순으로 해제한다. Statement => Connection
      try {
        stmt.close(); //close()가 정상적으로 수행되지 않으면 예외 발생!
        //con.close(); //stmt.close()에서 예외가 발생하면 이 줄은 실행도 못해본다.
                       //그래서 아래와 같이 다른 try 블록에서 실행해야 한다.
      } catch (Exception e) {
        //자원 해제하다가 발생된 예외는 추가로 특별히 해야할 일이 없다. 그냥 무시!
      }
      
      try {
        con.close();
      } catch (Exception e) {}
      
      // 궁금? stmt.close()하고 con.close()를 같은 try 블록에 두면 안되나요?
      // 답변? stmt.close()에서 오류가 발생하면 con.close()를 실행하지 못한다.
      
      // 궁금? 만약 close()를 호출하지 않으면 어떻게 되나요?
      // 답변? 일정 시간 동안 DBMS 서버에 연결 정보가 남아 있다. 
      //      곧 연결된 것으로 DBMS 서버는 이해한다.
      //      보통 DBMS 서버는 시스템 성능을 고려하여 동시 연결 개수를 제한한다.
      //      연결 개수가 꽉차면 다음 연결 요청을 거절한다.
      //      클라이이언트가 서버에 연결하고 사용한 후 명확하게 연결을 해제하지 않으면,
      //      서버는 일정 시간 동안(timeout) 그 연결 정보를 유지할 것이다.
      //      이런 식으로 사용 후 연결을 닫지 않으면, 서버의 최대 연결 개수를 초과하게 되고,
      //      다음 연결에서 거절 당할 것이다. 
    }

  }

}











