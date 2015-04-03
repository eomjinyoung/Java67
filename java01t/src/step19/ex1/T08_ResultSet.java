package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 실습 목표: ResultSet 사용하기
 * => SELECT 문을 실행한 후 DBMS에 준비된 결과를 가져오기.
 * => 실행 순서
 *   1) 중간 생략...
 *   2) Statement 객체에 SELECT 실행을 요청한다.
 *   3) Statement 객체는 SELECT 문을 서버에 보낸다.
 *   4) DBMS는 SELECT를 실행한 후 그 결과를 임시 메모리에 둔다.
 *      SELECT 결과를 꺼낼 때 사용할 접근 정보를 리턴한다.
 *   5) Statement 결과에 접근할 때 사용할 접근 정보를 담은 ResultSet 객체를 리턴한다.
 *   6) ResultSet 객체에 하나의 레코드를 가져올 것을 요청한다.
 *   7) ResultSet 객체는 하나의 레코드를 DBMS에서 가져온다.
 *      만약, DBMS에서 가져올 레코드가 없다면 false를 리턴한다.
 *   8) ResultSet이 가져온 레코드에서 컬럼 값을 꺼낸다. 그리고 출력한다. 
 *   9) 6)번으로 간다.  
 *   
 * ResultSet 객체
 * => SELECT 결과에서 한 레코드를 가져오는 역할.
 * => 레코드에서 컬럼 값 꺼내기.
 *    getXXX(컬럼 번호)  => 예) getInt(1) 
 *                     => 1번 컬럼의 값을 꺼낸다. 컬럼 번호는 1부터 시작.
 *    getXXX(컬럼 이름)  => 예) getInt("CNO")
 * => 가능한 컬럼 번호를 사용하기 보다 컬럼 이름을 사용하라!
 *    SELECT 문이 바뀌면 컬럼 번호가 바뀐다. 그래서 SELECT 변경에 상관없이 
 *    메서드를 호출하려면 컬럼 이름을 사용하라!
 * => getXXX()에서 XXX? 컬럼의 타입이다.  
 */
public class T08_ResultSet {

  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      stmt = con.createStatement();
      
      // SELECT 문 실행하기
      // 리턴 값: DBMS에서 결과를 가져올 때 사용할 접근 정보
      // 착각하지 말 것: SELECT를 실행한 결과를 리턴한 것이 아니다.
      //              곧 SELECT한 결과를 ResultSet이 모두 갖고 있을 것이라 오해한다.
      //              => 아니다! 결과를 가져올 준비를 한 것이다.
      rs = stmt.executeQuery(
          "SELECT CNO,LOC,ROOM FROM CLASSROOMS");
      
      
      while (rs.next()) {   //접근 정보를 이용하여 결과 레코드를 하나 가져온다.
        System.out.printf("%d, %s, %s\n", 
          //rs.getInt(1), rs.getString(2), rs.getString(3));
          rs.getInt("CNO"), rs.getString("LOC"), rs.getString("ROOM"));
      }
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}











