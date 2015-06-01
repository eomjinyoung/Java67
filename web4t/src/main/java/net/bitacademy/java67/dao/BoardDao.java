package net.bitacademy.java67.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java67.domain.BoardVo;

/* 실습 내용: DAO를 인터페이스로 정의하기 */

public interface BoardDao {
  int insert(BoardVo board);
  
  List<BoardVo> selectList(Map<String,Object> paramMap);  
  
  int countAll(String word);
  
  BoardVo selectOne(int no);
  
  int delete(int no);
  
  int update(BoardVo board);

}











