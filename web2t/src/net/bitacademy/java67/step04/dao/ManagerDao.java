package net.bitacademy.java67.step04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.DaoException;
import net.bitacademy.java67.step04.vo.ManagerVo;


public class ManagerDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  // public void destroy() {}

  public void insert(final ManagerVo manaer) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement("INSERT INTO managers (name,email,pwd,photo,tel) VALUES (?,?,?,?,?)");

      stmt.setString(1, manaer.getName());
      stmt.setString(2, manaer.getEmail());
      stmt.setString(3, manaer.getPassword());
      stmt.setString(4, manaer.getPhoto());
      stmt.setString(5, manaer.getTel());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
      dbPool.returnConnection(con);
    }
    }//다른 SQL 작업에서 사용할 수 있도록 반납한다. } }
   
   public ManagerVo select(int no) {
     Connection con = null; 
     PreparedStatement stmt = null; 
     ResultSet rs = null;
   
   try {
     con = dbPool.getConnection(); 
     stmt = con.prepareStatement(
   "SELECT mno,name,email,pwd,photo,tel FROM managers WHERE mno = ?");
     
   stmt.setInt(1, no);
   rs = stmt.executeQuery();
   
    if (rs.next()) { 
      ManagerVo manager = new ManagerVo();
      manager.setMno(rs.getInt("mno"));
      manager.setName(rs.getString("name"));
      manager.setEmail(rs.getString("email"));
      manager.setPassword(rs.getString("pwd"));
      manager.setPhoto(rs.getString("photo"));
      manager.setTel(rs.getString("tel"));
    return manager;
    
    } else { return null; }
    
    } catch (SQLException e) { throw new DaoException(e);
    
    } finally { try {rs.close();} catch (Exception e) {} try {stmt.close();}
    catch (Exception e) {} dbPool.returnConnection(con); } }
   


   public int delete(int no) {
     Connection con = null;
     PreparedStatement stmt = null;

     try {
       con = dbPool.getConnection(); 
       stmt = con.prepareStatement(
           "DELETE FROM managers WHERE mno=?");
       stmt.setInt(1, no);
       return stmt.executeUpdate();
       
     }catch (SQLException e) {
       throw new DaoException(e); 

     } finally {
       try {stmt.close();} catch (Exception e) {}
       dbPool.returnConnection(con);
     }
   }



  public int update(ManagerVo manager) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
      stmt = con
          .prepareStatement("UPDATE managers SET name = ?, email = ?, pwd = ? , photo=? , tel=?"
              + " WHERE mno = ?");
      stmt.setString(1, manager.getName());
      stmt.setString(2, manager.getEmail());
      stmt.setString(3, manager.getPassword());
      stmt.setString(4, manager.getPhoto());
      stmt.setString(5, manager.getTel());
      stmt.setInt(6, manager.getMno());
      

      return stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
      dbPool.returnConnection(con);
    }

  }


  public List<ManagerVo> selectList() {
    List<ManagerVo> list = new ArrayList<ManagerVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();

      rs = stmt.executeQuery("SELECT mno,name,email,tel FROM managers");
      ManagerVo board;
      while (rs.next()) {
        board = new ManagerVo();
        board.setMno(rs.getInt("mno"));
        board.setName(rs.getString("name"));
        board.setEmail(rs.getString("email")); 
        board.setTel(rs.getString("tel"));

        list.add(board);
      }

      return list;

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
      dbPool.returnConnection(con);
    }

  }
}