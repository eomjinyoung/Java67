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
import net.bitacademy.java67.step04.vo.StudentVo;

public class StudentDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public void insert(final StudentVo student) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "insert into students(name, photo, tel, email, pwd, addr, degree, work) values(?,?,?,?,?,?,?,?)");

      stmt.setString(1, student.getName());
      stmt.setString(2, student.getPhoto());
      stmt.setString(3, student.getTel());
      stmt.setString(4, student.getEmail());
      stmt.setString(5, student.getPwd());
      stmt.setString(6, student.getAddr());
      stmt.setInt(7, student.getDegree());
      stmt.setString(8, student.getWork());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public List<StudentVo> selectList() {
    ArrayList<StudentVo> list = new ArrayList<StudentVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "select sno, name from students");

      StudentVo student = null;
      while (rs.next()) {
        student = new StudentVo();
        student.setSno(rs.getInt("sno"));
        student.setName(rs.getString("name"));

        list.add(student);
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
  
  public StudentVo select(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT sno,name,photo,tel,email,pwd,addr,degree,work FROM students WHERE sno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      if (rs.next()) {
        StudentVo student = new StudentVo();
        student.setSno(rs.getInt("sno"));
        student.setName(rs.getString("name"));
        student.setPhoto(rs.getString("photo"));
        student.setTel(rs.getString("tel"));
        student.setEmail(rs.getString("email"));
        student.setPwd(rs.getString("pwd"));
        student.setAddr(rs.getString("addr"));
        student.setDegree(rs.getInt("degree"));
        student.setWork(rs.getString("work"));
        return student;
        
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
          "DELETE FROM students WHERE sno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int update(StudentVo student) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement(
          "update students set name=?, photo=?, tel=?, email=?, pwd=?, addr=?, degree=?, work=? where sno=?");
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getPhoto());
      stmt.setString(3, student.getTel());
      stmt.setString(4, student.getEmail());
      stmt.setString(5, student.getPwd());
      stmt.setString(6, student.getAddr());
      stmt.setInt(7, student.getDegree());
      stmt.setString(8, student.getWork());
      stmt.setInt(9, student.getSno());
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }

  public List<StudentVo> search(String name) {
    ArrayList<StudentVo> list = new ArrayList<StudentVo>();
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "select sno, name from students where name like ?");
      stmt.setString(1, name);
      rs = stmt.executeQuery();

      StudentVo student = null;
      while (rs.next()) {
        student = new StudentVo();
        student.setSno(rs.getInt("sno"));
        student.setName(rs.getString("name"));

        list.add(student);
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
