package net.bitacademy.java67.dao;

import java.util.HashMap;

import net.bitacademy.java67.DaoException;
import net.bitacademy.java67.domain.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public UserVo selectOne(String email, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      HashMap<String,String> paramMap = new HashMap<String,String>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      
      return sqlSession.selectOne(
          "net.bitacademy.java67.dao.UserDao.selectOne", paramMap);
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }
}











