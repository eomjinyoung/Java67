package net.bitacademy.java67.step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
  
  public void insert(final BoardVo board) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "INSERT INTO board2 (title,content,cre_date) VALUES (?,?,now())");

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
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
  
  public BoardVo select(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT bno,title,content,cre_date,views FROM board2 WHERE bno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      if (rs.next()) {
        BoardVo board = new BoardVo();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setCreateDate(rs.getDate("cre_date"));
        board.setViews(rs.getInt("views"));
        return board;
        
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
          "DELETE FROM board2 WHERE bno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(BoardVo board) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "UPDATE board2 SET title=?, content=?"
          + " WHERE bno=?");
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }
  

}











