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
import net.bitacademy.java67.step04.vo.CrphotoVo;

// 커넥션 관리 기법:
// 2단계. DBConnectionPool 도입
// => SQL 작업을 수행할 때 마다 DBConnectionPool에서 커넥션을 빌린다.
// => 사용 후 반납한다.
public class ClassroomDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  //public void destroy() {}
  

  public List<ClassroomVo> selectList() {
    ArrayList<ClassroomVo> list = new ArrayList<ClassroomVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "SELECT CNO,LOC,ROOM,CONTENT FROM CLASSROOMS");

      ClassroomVo classroom = null;
      while (rs.next()) {
		 classroom = new ClassroomVo();
		 classroom.setCNO(rs.getInt("CNO"));
		 classroom.setLOC(rs.getString("LOC"));
		 classroom.setROOM(rs.getString("ROOM"));
		 classroom.setCONTENT(rs.getString("CONTENT"));
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

  public List<CrphotoVo> photoSelectList() {
	
	ArrayList<CrphotoVo> photoSel = new ArrayList<CrphotoVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.createStatement();

      rs = stmt.executeQuery(
          "SELECT CNO,PHOTO FROM CR_PHOTO");

      CrphotoVo photo = null;
      while (rs.next()) {
    	  photo = new CrphotoVo();
    	  photo.setCno(rs.getInt("CNO"));
    	  photo.setPhoto(rs.getString("PHOTO"));
		  photoSel.add(photo);
      }

      return photoSel;

    } catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int delete(int CNO) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "DELETE FROM CLASSROOMS WHERE CNO = ?");
      stmt.setInt(1, CNO);
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
	
  }

  public void insert(ClassroomVo classroomVo) {
	Connection con = null;
	PreparedStatement stmt = null;
	
	try {
		con = dbPool.getConnection(); 
		stmt = con.prepareStatement(
		"INSERT INTO CLASSROOMS (LOC, CONTENT, ROOM) VALUES (?, ?, ?)");
	
	stmt.setString(1, classroomVo.getLOC());
	stmt.setString(2, classroomVo.getCONTENT());
	stmt.setString(3, classroomVo.getROOM());

	stmt.executeUpdate();
	
	} catch (SQLException e) {
		throw new DaoException(e);
		
	} finally {
		try {stmt.close();} catch (Exception e) {}
		dbPool.returnConnection(con); 
	}
	
  }

  public ClassroomVo select(int CNO) {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		con = dbPool.getConnection(); 
		stmt = con.prepareStatement(
		"select LOC, CONTENT, ROOM from CLASSROOMS where CNO=?");
		stmt.setInt(1, CNO);
		rs = stmt.executeQuery();
		
      if (rs.next()) {
    	 ClassroomVo classroomVo = new ClassroomVo();
    	 classroomVo.setCNO(CNO);
    	 classroomVo.setLOC(rs.getString("LOC"));
    	 classroomVo.setROOM(rs.getString("ROOM"));
    	 classroomVo.setCONTENT(rs.getString("CONTENT"));
        return classroomVo;
         
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

  public int update(ClassroomVo classroomVo) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); 
      stmt = con.prepareStatement(
          "UPDATE CLASSROOMS SET LOC = ?, CONTENT = ?, ROOM = ?"
          + " WHERE CNO = ?");
      stmt.setString(1, classroomVo.getLOC());
      stmt.setString(2, classroomVo.getCONTENT());
      stmt.setString(3, classroomVo.getROOM());
      stmt.setInt(4, classroomVo.getCNO());
      
      return stmt.executeUpdate();
      
    }catch (SQLException e) {
      throw new DaoException(e); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
}











