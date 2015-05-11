package net.bitacademy.java67.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

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



















