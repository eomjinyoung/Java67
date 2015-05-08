package net.bitacademy.java67.step03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  /*
  public void insert(final User user) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); // DBConnectionPool에서 커넥션 객체를 빌린다.
      stmt = con.prepareStatement(
          "INSERT INTO USERS (NAME,EMAIL,TEL,HP,TWIT) VALUES (?,?,?,?,?)");

      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getTel());
      stmt.setString(4, user.getHomepage());
      stmt.setString(5, user.getTwitter());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con); //다른 SQL 작업에서 사용할 수 있도록 반납한다.
    }
  }
  */
  public List<BoardVo> selectList() {
    ArrayList<BoardVo> list = new ArrayList<BoardVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "SELECT bno,title,cre_date,views FROM board2");

      BoardVo board = null;
      while (rs.next()) {
        board = new BoardVo();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreateDate(rs.getDate("cre_date"));
        board.setViews(rs.getInt("views"));

        list.add(board);
      }

      return list;

    } catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }

  }
  /*
  public User select(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT uno,name,email,tel,hp,twit FROM users WHERE uno = ?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      if (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("uno"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setTel(rs.getString("tel"));
        user.setHomepage(rs.getString("hp"));
        user.setTwitter(rs.getString("twit")); 
        return user;
        
      } else {
        return null;
      }
      
    } catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int delete(int no) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "DELETE FROM USERS WHERE UNO = ?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int update(User user) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "UPDATE USERS SET NAME = ?, EMAIL = ?, TEL = ?, HP = ?, TWIT = ?"
          + " WHERE UNO = ?");
      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getTel());
      stmt.setString(4, user.getHomepage());
      stmt.setString(5, user.getTwitter());
      stmt.setInt(6, user.getNo());
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }
  */

}











