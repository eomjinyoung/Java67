package step19.ex2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

// FlyWeight 디자인 패턴 적용
// 1) 객체를 생성하는 데 시간이 오래 걸린다.
// 2) 객체 생성 개수에 제한이 있다. 
// => 생성한 객체를 공유하여 사용하는 기법 
// => "Pooling 기법"으로 알려져있다.

public class DBConnectionPool {
  ArrayList<Connection> list = new ArrayList<Connection>();
  
  public DBConnectionPool() {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public Connection getConnection() {
    try {
      if (list.size() > 0) {
        return list.remove(0);
      
      } else {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
            "java67", 
            "java67");
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



















