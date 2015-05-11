package net.bitacademy.java67.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/* 변경사항
 * - 생성자에서 DB 정보를 받아서 커넥션을 준비한다.
 * - 하드 코딩된 DB 정보를 모두 제거한다. 대신 변수화시킨다. 
 */

public class DBConnectionPool {
  ArrayList<Connection> list = new ArrayList<Connection>();
  String url;
  String user;
  String password;
  
  public DBConnectionPool(String driver, String url, 
      String user, String password) {
    try {
      //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      // java.sql.Driver 구현체를 로딩한다.
      // - 위와 같이 DriverManager를 사용하여 직접 로딩하는 대신에,
      //   이렇게 간접적으로 로딩한다.
      // - 간접 로딩의 장점: 
      //   다양한 DBMS를 지원할 수 있다.
      Class.forName(driver);
      this.url = url;
      this.user = user;
      this.password = password;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public Connection getConnection() {
    try {
      if (list.size() > 0) {
        return list.remove(0);
      
      } else {
        return DriverManager.getConnection(url, user, password);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public void returnConnection(Connection con) {
    list.add(con); 
  }
  
  public void closeAll() {
    for (Connection con : list) {
      try {con.close();} catch (Exception e) {}
    }
  }
}



















