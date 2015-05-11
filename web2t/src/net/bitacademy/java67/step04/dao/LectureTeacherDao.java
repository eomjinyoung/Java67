package net.bitacademy.java67.step04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.DaoException;
import net.bitacademy.java67.step04.vo.LectureTeacherVo;

public class LectureTeacherDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  public List<LectureTeacherVo> mainList(int no) {
    ArrayList<LectureTeacherVo> list = new ArrayList<LectureTeacherVo>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement("select T3.TNO, T1.LNO, T3.PHOTO, T1.TITLE, T3.NAME, T3.TEL, T3.EMAIL, date_format(T2.ST_DATE, '%Y-%m-%d') as SDATE, date_format(T2.EN_DATE, '%Y-%m-%d') as EDATE" +
          " FROM LECTURES T1 LEFT OUTER JOIN LEC_TRAI T2 ON T1.LNO = T2.LNO" +
          " LEFT OUTER JOIN TRAINERS T3 ON T2.TNO = T3.TNO WHERE T1.LNO = ?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      LectureTeacherVo lecTeachVo = null;

      while (rs.next()) {
        lecTeachVo = new LectureTeacherVo();
        lecTeachVo.setTno(rs.getInt("TNO"));
        lecTeachVo.setLno(rs.getInt("LNO"));
        lecTeachVo.setPhoto(rs.getString("PHOTO"));
        lecTeachVo.setTitle(rs.getString("TITLE"));
        lecTeachVo.setName(rs.getString("NAME"));
        lecTeachVo.setTel(rs.getString("TEL"));
        lecTeachVo.setEmail(rs.getString("EMAIL"));
        lecTeachVo.setSt_date(rs.getString("SDATE"));
        lecTeachVo.setEn_date(rs.getString("EDATE"));
        list.add(lecTeachVo);
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


  public List<LectureTeacherVo> leftList() {
    ArrayList<LectureTeacherVo> list = new ArrayList<LectureTeacherVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT TNO, NAME FROM TRAINERS ORDER BY TNO ASC");

      LectureTeacherVo lecTeachVo = null;

      while (rs.next()) {
        lecTeachVo = new LectureTeacherVo();
        lecTeachVo.setTno(rs.getInt("TNO"));
        lecTeachVo.setName(rs.getString("NAME"));
        list.add(lecTeachVo);
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


  public int add(LectureTeacherVo lecTeachVo) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "insert into lec_trai(LNO,TNO) values(?,?)");
      stmt.setInt(1, lecTeachVo.getLno());
      stmt.setInt(2, lecTeachVo.getTno());

      return stmt.executeUpdate();

    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }



  public int change(LectureTeacherVo lecTeachVo) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "UPDATE LEC_TRAI SET ST_DATE =?, EN_DATE=? WHERE LNO=? AND TNO=?");
      stmt.setString(1, lecTeachVo.getSt_date());
      stmt.setString(2, lecTeachVo.getEn_date());
      stmt.setInt(3, lecTeachVo.getLno());
      stmt.setInt(4, lecTeachVo.getTno());

      return stmt.executeUpdate();

    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }


  public int delete(int tno, int lno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "DELETE FROM LEC_TRAI WHERE lno=? AND tno=?");
      stmt.setInt(1, lno);
      stmt.setInt(2, tno);
      return stmt.executeUpdate();

    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

}
