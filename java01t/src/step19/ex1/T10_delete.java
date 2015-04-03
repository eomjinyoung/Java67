package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/* 실습 목표: delete 문 실행! 
 */
public class T10_delete {
  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "java67", 
          "java67");
      
      stmt = con.prepareStatement(
          "DELETE FROM CLASSROOMS WHERE CNO = ?");
      
      int no = 14;
      
      stmt.setInt(1, no);
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        System.out.println("삭제하였습니다.");
      } else {
        System.out.println("삭제 실패입니다!");
      }
          
    } catch (SQLException e) {
      e.printStackTrace(); 
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  

}











