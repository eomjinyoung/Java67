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
import net.bitacademy.java67.step04.vo.ClassroomVo;
import net.bitacademy.java67.step04.vo.LectureVo;
import net.bitacademy.java67.step04.vo.ManagerVo;

public class LectureDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  public void insert(final LectureVo lecture) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "insert into lectures(title,st_date,ed_date,hours,days,capa,intro,cnt,mno,cno)" + 
          " values(?,?,?,?,?,?,?,0,?,?)");//cnt 초기값 = 0

      stmt.setString(1, lecture.getTitle());
      stmt.setDate(2, lecture.getSt_date());
      stmt.setDate(3, lecture.getEd_date());
      stmt.setInt(4, lecture.getHours());
      stmt.setInt(5, lecture.getDays());
      stmt.setInt(6, lecture.getCapa());
      stmt.setString(7, lecture.getIntro());
      
      stmt.setNull(8, 0);
      if(lecture.getMno() != 0) stmt.setInt(8, lecture.getMno());

      stmt.setNull(9, 0);
      if(lecture.getCno() != 0) stmt.setInt(9, lecture.getCno());
      
      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public List<LectureVo> selectLectureList() {
    ArrayList<LectureVo> list = new ArrayList<LectureVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "select lno, title, capa, st_date, ed_date, days" +
          " from lectures");

      LectureVo lecture = null;
      while (rs.next()) {
        lecture = new LectureVo();
        lecture.setLno(rs.getInt("lno"));
        lecture.setTitle(rs.getString("title"));
        lecture.setCapa(rs.getInt("capa"));
        lecture.setSt_date(rs.getDate("st_date"));
        lecture.setEd_date(rs.getDate("ed_date"));
        lecture.setDays(rs.getInt("days"));

        list.add(lecture);
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
  

  public List<ManagerVo> selectManagerList() {
    ArrayList<ManagerVo> list = new ArrayList<ManagerVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "select mno, name, photo, tel, email, pwd" +
          " from managers");

      ManagerVo manager = null;
      while (rs.next()) {
        manager = new ManagerVo();
        manager.setMno(rs.getInt("mno"));
        manager.setName(rs.getString("name"));

        list.add(manager);
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

  public List<ClassroomVo> selectClassroomList() {
    ArrayList<ClassroomVo> list = new ArrayList<ClassroomVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "select cno, loc, room" +
          " from classrooms");

      ClassroomVo classroom = null;
      while (rs.next()) {
        classroom = new ClassroomVo();
        classroom.setCNO(rs.getInt("cno"));
        classroom.setLOC(rs.getString("loc"));
        classroom.setROOM(rs.getString("room"));

        
        list.add(classroom);
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
  
  
  public LectureVo selectLecture(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "SELECT t1.lno lno, t1.title title, t1.intro intro, t1.capa capa, " +
              //"date_format(t1.st_date,'%Y-%m-%d') AS stdate, " +
              "t1.st_date st_date, t1.ed_date ed_date, " +
              "t1.hours hours, t1.days days, t1.cnt cnt, t2.name mName, " + 
              "t1.mno mno, T1.cno cno, t3.loc loc, t3.room room" +
              " FROM LECTURES T1" +
              " LEFT OUTER JOIN MANAGERS T2 ON T1.MNO=T2.MNO" +
              " LEFT OUTER JOIN CLASSROOMS T3 ON T1.CNO=T3.CNO" +
              " WHERE T1.LNO=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      LectureVo lecture = null;
      if (rs.next()) {
        lecture = new LectureVo();
        lecture.setLno(rs.getInt("lno"));
        lecture.setTitle(rs.getString("title"));
        lecture.setIntro(rs.getString("intro"));
        lecture.setCapa(rs.getInt("capa"));
        lecture.setSt_date(rs.getDate("st_date"));
        lecture.setEd_date(rs.getDate("ed_date"));
        lecture.setHours(rs.getInt("hours"));
        lecture.setDays(rs.getInt("days"));
        lecture.setCnt(rs.getInt("cnt"));
        lecture.setMno(rs.getInt("mno"));
        lecture.setCno(rs.getInt("cno"));
//        lecture.setMno_name(rs.getString("mName"));
//        lecture.setCno_loc(rs.getString("loc"));
//        lecture.setCno_room(rs.getString("room"));
        
        return lecture;
        
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
          "DELETE FROM lectures WHERE lno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  
  public int update(LectureVo lecture) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "update lectures set title=?, st_date=?, ed_date=?, hours=?, days=?, " +
          "capa=?, intro=?, mno=?, cno=? where lno=?");
      stmt.setString(1, lecture.getTitle());
      stmt.setDate(2, lecture.getSt_date());
      stmt.setDate(3, lecture.getEd_date());
      stmt.setInt(4, lecture.getHours());
      stmt.setInt(5, lecture.getDays());
      stmt.setInt(6, lecture.getCapa());
      stmt.setString(7, lecture.getIntro());
      
      stmt.setNull(8, 0);
      if(lecture.getMno() != 0) stmt.setInt(8, lecture.getMno());

      stmt.setNull(9, 0);
      if(lecture.getCno() != 0) stmt.setInt(9, lecture.getCno());
      
      stmt.setInt(10, lecture.getLno());
      
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  

}











