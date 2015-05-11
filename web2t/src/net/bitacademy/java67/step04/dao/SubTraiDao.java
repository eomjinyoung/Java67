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
import net.bitacademy.java67.step04.vo.SubTraiVo;

public class SubTraiDao {
  DBConnectionPool dbPool;
              
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  
  public void deleteAll(final int tno) {
   Connection con = null;
   PreparedStatement stmt = null;
   
   try {
     con = dbPool.getConnection(); 
     stmt = con.prepareStatement( 
         "delete from sub_trai where tno=?");

     stmt.setInt(1, tno);
     

     stmt.executeUpdate();
   } catch (SQLException e) {
     throw new DaoException(e);
   } finally {
     try {stmt.close();} catch (Exception e) {}
     dbPool.returnConnection(con);
   }
   
  }
  public void insert(final SubTraiVo sub_trai) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "INSERT INTO  sub_trai(tno,sno) VALUES (?,?)");

      stmt.setInt(1, sub_trai.getTno());
      stmt.setInt(2, sub_trai.getSno());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public List selectList() {
    ArrayList plist = new ArrayList();
    ArrayList<SubTraiVo> list1 = new ArrayList<SubTraiVo>();
    ArrayList<SubTraiVo> list2 = new ArrayList<SubTraiVo>();
    ArrayList<SubTraiVo> list3 = new ArrayList<SubTraiVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "select t1.tno, t2.title, t2.sno from SUB_TRAI t1, SUBJECTS t2"
              + " where t1.sno=t2.sno");

      SubTraiVo sub_trai = null;
      while (rs.next()) {
        sub_trai = new SubTraiVo();
        sub_trai.setTno(rs.getInt("tno"));
        sub_trai.setTitle(rs.getString("title"));
        sub_trai.setSno(rs.getInt("sno"));

        list2.add(sub_trai);
      }
      rs = null;
      rs = stmt.executeQuery(
          "select tno, photo, name from TRAINERS");
      
      while (rs.next()) {
        sub_trai = new SubTraiVo();
        sub_trai.setTno(rs.getInt("tno"));
        sub_trai.setName(rs.getString("name"));
        sub_trai.setPhoto(rs.getString("photo"));

        list1.add(sub_trai);
      }
      plist.add(list1);
      plist.add(list2);
     
      return plist;

    } catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }

  }
  
  public List selectSubjects() {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT * FROM subjects");
      rs = stmt.executeQuery();

      ArrayList<SubTraiVo> list = new ArrayList<SubTraiVo>();
      while (rs.next()) {
        SubTraiVo sub_trai = new SubTraiVo();
        sub_trai.setSno(rs.getInt("sno"));
        sub_trai.setTitle(rs.getString("title"));
        list.add(sub_trai);
        
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

  

  

}











