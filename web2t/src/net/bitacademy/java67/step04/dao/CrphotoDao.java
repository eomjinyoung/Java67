package net.bitacademy.java67.step04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java67.step04.vo.CrphotoVo;
import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.DaoException;

public class CrphotoDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public void insert(String photo, int cno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "INSERT INTO cr_photo (photo,cno) VALUES (?,?)");

      stmt.setString(1, photo);
      stmt.setInt(2, cno);

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public CrphotoVo select(int cpno) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT cpno,photo,cno FROM cr_photo WHERE cpno=?");
      stmt.setInt(1, cpno);    
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        CrphotoVo crphoto = new CrphotoVo();
        crphoto.setCpno(rs.getInt("cpno"));
        crphoto.setPhoto(rs.getString("photo"));
        crphoto.setCno(rs.getInt("cno"));
        return crphoto;
        
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
  
  public List<CrphotoVo> selectList(int cno) {
    ArrayList<CrphotoVo> list = new ArrayList<CrphotoVo>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT cpno,photo,cno FROM cr_photo WHERE cno=?");
      stmt.setInt(1, cno);
      rs = stmt.executeQuery();

      CrphotoVo crphoto = null;
      while (rs.next()) {
        crphoto = new CrphotoVo();
        crphoto.setCpno(rs.getInt("cpno"));
        crphoto.setPhoto(rs.getString("photo"));
        crphoto.setCno(rs.getInt("cno"));

        list.add(crphoto);
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

  
  public int delete(int cpno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "DELETE FROM cr_photo WHERE cpno=?");
      stmt.setInt(1, cpno);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public CrphotoVo loc(int cno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT cno,loc,room FROM classrooms WHERE cno=?");
      stmt.setInt(1, cno);    
      ResultSet rs = stmt.executeQuery();
      
      if (rs.next()) {
        CrphotoVo crphoto = new CrphotoVo();
        crphoto.setCno(rs.getInt("cno"));
        crphoto.setLoc(rs.getString("loc"));
        crphoto.setRoom(rs.getString("room"));
        return crphoto;
        
      } else {
        return null;
      }
    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public CrphotoVo count(int cno) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT count(1) FROM cr_photo WHERE cno=?");
      stmt.setInt(1, cno);    
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        CrphotoVo crphoto = new CrphotoVo();
        crphoto.setCount(rs.getInt("count(1)"));
        return crphoto;
        
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
  

  

}











