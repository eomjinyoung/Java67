package net.bitacademy.java67.step04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java67.step03.DaoException;
import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.vo.TeacherVo;

public class TeacherDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public void insert(final TeacherVo teacher) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "insert into TRAINERS(name,photo,tel,email,addr,wage,pwd) "
          + "values(?,?,?,?,?,?,?)");

      stmt.setString(1, teacher.getName());
      stmt.setString(2, teacher.getPhoto());
      stmt.setString(3, teacher.getTel());
      stmt.setString(4, teacher.getEmail());
      stmt.setString(5, teacher.getAddr());
      stmt.setInt(6, teacher.getWage());
      stmt.setString(7, teacher.getPwd());
      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public List<TeacherVo> selectList() {
    ArrayList<TeacherVo> list = new ArrayList<TeacherVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "SELECT tno,name,photo,tel,email,addr,wage,pwd FROM trainers");

      TeacherVo teacher = null;
      while (rs.next()) {
        teacher = new TeacherVo();
        teacher.setTno(rs.getInt("tno"));
        teacher.setName(rs.getString("name"));
        teacher.setPhoto(rs.getString("photo"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setAddr(rs.getString("addr"));
        teacher.setWage(rs.getInt("wage"));
        
        list.add(teacher);
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
  
  public TeacherVo select(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT tno,name,photo,tel,email,addr,wage,pwd FROM trainers WHERE tno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      if (rs.next()) {
        TeacherVo teacher = new TeacherVo();
        teacher.setName(rs.getString("name"));
        teacher.setTno(rs.getInt("tno"));
        teacher.setPhoto(rs.getString("photo"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setAddr(rs.getString("addr"));
        teacher.setWage(rs.getInt("wage"));
        
        return teacher;
        
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

  
  public int delete(int tno) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
        con = dbPool.getConnection(); 
        stmt = con.prepareStatement(
            "DELETE FROM sub_trai WHERE tno=?");
        stmt.setInt(1, tno);
        stmt.executeUpdate();
        
      }catch (SQLException e) {
        throw new DaoException(e); 

      }
    
    try {
        con = dbPool.getConnection(); 
        stmt = con.prepareStatement(
            "DELETE FROM lec_trai WHERE tno=?");
        stmt.setInt(1, tno);
        stmt.executeUpdate();
        
      }catch (SQLException e) {
        throw new DaoException(e); 

      }
    
    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "DELETE FROM trainers WHERE tno=?");
      stmt.setInt(1, tno);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
    
  }
  
  public int update(TeacherVo teacher) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "update TRAINERS set name=?,photo=?,tel=?,email=?,"
			+ "addr=?,wage=?,pwd=? where tno=?");
      stmt.setString(1, teacher.getName());
      stmt.setString(2, teacher.getPhoto());
      stmt.setString(3, teacher.getTel());
      stmt.setString(4, teacher.getEmail());
      stmt.setString(5, teacher.getAddr());
      stmt.setInt(6, teacher.getWage());
      stmt.setString(7, teacher.getPwd());
      stmt.setInt(8, teacher.getTno());
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }

public List<TeacherVo> searchList(String colum, String value) {
	ArrayList<TeacherVo> list = new ArrayList<TeacherVo>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    System.out.println(":::::::::Called searchList");
    System.out.println("Colum : "+colum+"   value : "+value);
    try {
      con = dbPool.getConnection(); 
      con = dbPool.getConnection(); 
      String sqlString = "SELECT tno,name,photo,tel,email,addr,"
    		  + "wage,pwd FROM trainers where "+colum+" like "+"'%"+value+"%'";
      stmt = con.prepareStatement(sqlString
    		  );
      rs = stmt.executeQuery();
      System.out.println("executeQuery() 실행완료");
      TeacherVo teacher = null;
      while (rs.next()) {
        teacher = new TeacherVo();
        teacher.setTno(rs.getInt("tno"));
        teacher.setName(rs.getString("name"));
        teacher.setPhoto(rs.getString("photo"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setAddr(rs.getString("addr"));
        teacher.setWage(rs.getInt("wage"));
        
        System.out.println(teacher);
        list.add(teacher);
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











