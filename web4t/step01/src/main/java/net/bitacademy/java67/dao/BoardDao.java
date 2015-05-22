package net.bitacademy.java67.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java67.DaoException;
import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.domain.BoardVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/* 실습 내용: 애노테이션 적용 */

@Component
public class BoardDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public void insert(final BoardVo board) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert("net.bitacademy.java67.dao.BoardDao.insert", board);
      // 첫 번째 파라미터 -> SQL ID : 네임스페이스이름.SQL아이디
      // 두 번째 파라미터 -> 데이터를 담고 있는 객체. 오직 한 개만 넘길 수 있다.
      // 만약 여러 개의 값을 전달하고 싶으면, Map이나 Value Object에 담아서 전달하라.
      
      // 서버에 입력 작업을 적용할 것을 요구한다.
      // 만약 commit을 요구하지 않으면, 임시 테이블에 저장된 작업 결과는 버려진다.
      sqlSession.commit();
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }
  
  public List<BoardVo> selectList(
      int startIndex, int pageSize, String word, String order) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    HashMap<String,Object> paramMap = new HashMap<String,Object>();
    paramMap.put("startIndex", startIndex);
    paramMap.put("pageSize", pageSize);
    paramMap.put("word", word);
    paramMap.put("order", order);
    
    try {
      return sqlSession.selectList(
          "net.bitacademy.java67.dao.BoardDao.selectList", paramMap);

    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }

  }
  
  public int countAll(String word) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
          "net.bitacademy.java67.dao.BoardDao.countAll", word);

    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }

  }
  
  public BoardVo select(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne(
          "net.bitacademy.java67.dao.BoardDao.selectOne", no);
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }

  
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.delete(
          "net.bitacademy.java67.dao.BoardDao.delete", no);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }
  
  public int update(BoardVo board) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.update(
          "net.bitacademy.java67.dao.BoardDao.update", board);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
    
  }
  

}











