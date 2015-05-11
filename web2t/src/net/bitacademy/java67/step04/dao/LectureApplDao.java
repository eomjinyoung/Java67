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
import net.bitacademy.java67.step04.vo.LectureApplVo1;
import net.bitacademy.java67.step04.vo.LectureApplVo2;
import net.bitacademy.java67.step04.vo.LectureApplVo3;

public class LectureApplDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  public int insert(String lno, String sno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement("insert  into lec_appl  (lno, sno, ap_date, state) values (?, ?, now(), 1)");

      stmt.setString(1, lno);
      stmt.setString(2, sno);
     
      return stmt.executeUpdate();
      
    } catch (SQLException e) {
      return 0;

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int delete(String lno, String sno) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement("delete from lec_appl  where lno = ? and sno = ?");

      stmt.setString(1, lno);
      stmt.setString(2, sno);
     
      return stmt.executeUpdate();
      
    } catch (SQLException e) {
      return 0;

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public List<LectureApplVo1> lectureAppllist1() {
    ArrayList<LectureApplVo1> list = new ArrayList<LectureApplVo1>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();

      rs = stmt.executeQuery("select lno, title from lectures");

      LectureApplVo1 lecture1 = null;
      while (rs.next()) {
        lecture1 = new LectureApplVo1();
        lecture1.setLno(rs.getInt("lno"));
        lecture1.setTitle(rs.getString("title"));

        list.add(lecture1);
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

  public List<LectureApplVo2> lectureAppllist2(String lno) {
    ArrayList<LectureApplVo2> list = new ArrayList<LectureApplVo2>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();
      rs = stmt
          .executeQuery("select a.sno, b.name, date_format(a.ap_date,'%Y-%m-%d') as ap_date, if(a.state = 1, 'Yes', 'No') as state, a.lno "
              + "from lec_appl a left join students b on a.sno = b.sno left join lectures c on a.lno = c.lno "
              + "where a.lno = " + lno );

      LectureApplVo2 lecture2 = null;
      while (rs.next()) {
        lecture2 = new LectureApplVo2();
        lecture2.setSno(rs.getInt("sno"));
        lecture2.setName(rs.getString("name"));
        lecture2.setAp_date(rs.getDate("ap_date"));
        lecture2.setState(rs.getString("state"));

        list.add(lecture2);
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

  public List<LectureApplVo3> lectureAppllist3() {
    ArrayList<LectureApplVo3> list = new ArrayList<LectureApplVo3>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();

      rs = stmt.executeQuery("select sno, name from students");

      LectureApplVo3 lecture3 = null;
      while (rs.next()) {
        lecture3 = new LectureApplVo3();
        lecture3.setSno(rs.getInt("sno"));
        lecture3.setName(rs.getString("name"));

        list.add(lecture3);
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

  // public BoardVo select(int no) {
  // Connection con = null;
  // PreparedStatement stmt = null;
  // ResultSet rs = null;
  //
  // try {
  // con = dbPool.getConnection();
  // stmt = con.prepareStatement(
  // "SELECT bno,title,content,cre_date,views FROM board2 WHERE bno=?");
  // stmt.setInt(1, no);
  // rs = stmt.executeQuery();
  //
  // if (rs.next()) {
  // BoardVo board = new BoardVo();
  // board.setNo(rs.getInt("bno"));
  // board.setTitle(rs.getString("title"));
  // board.setContent(rs.getString("content"));
  // board.setCreateDate(rs.getDate("cre_date"));
  // board.setViews(rs.getInt("views"));
  // return board;
  //
  // } else {
  // return null;
  // }
  //
  // } catch (SQLException e) {
  // throw new DaoException(e);
  //
  // } finally {
  // try {rs.close();} catch (Exception e) {}
  // try {stmt.close();} catch (Exception e) {}
  // dbPool.returnConnection(con);
  // }
  // }

  // public int delete(int no) {
  // Connection con = null;
  // PreparedStatement stmt = null;
  //
  // try {
  // con = dbPool.getConnection();
  // stmt = con.prepareStatement(
  // "DELETE FROM board2 WHERE bno=?");
  // stmt.setInt(1, no);
  // return stmt.executeUpdate();
  //
  // }catch (SQLException e) {
  // throw new DaoException(e);
  //
  // } finally {
  // try {stmt.close();} catch (Exception e) {}
  // dbPool.returnConnection(con);
  // }
  // }

  // public int update(BoardVo board) {
  // Connection con = null;
  // PreparedStatement stmt = null;
  //
  // try {
  // con = dbPool.getConnection();
  // stmt = con.prepareStatement(
  // "UPDATE board2 SET title=?, content=?"
  // + " WHERE bno=?");
  // stmt.setString(1, board.getTitle());
  // stmt.setString(2, board.getContent());
  // stmt.setInt(3, board.getNo());
  //
  // return stmt.executeUpdate();
  //
  // }catch (SQLException e) {
  // throw new DaoException(e);
  //
  // } finally {
  // try {stmt.close();} catch (Exception e) {}
  // dbPool.returnConnection(con);
  // }
  //
  // }
  
  

}
