package net.bitacademy.java67.service;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.dao.BoardLogDao;
import net.bitacademy.java67.domain.BoardLogVo;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* Service 객체
 * - Business Logic 수행
 * - Transaction 처리
 * - 서비스 클래스의 메서드 이름을 지을 때 가능한 업무 용어를 사용한다.
 */

@Service
public class BoardService {
  @Autowired
  BoardDao boardDao;
  
  @Autowired
  BoardLogDao boardLogDao;
  
  @Autowired
  PlatformTransactionManager txManager;
  
  @Transactional(
      propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public int add(BoardVo board, String ip) {
    int count = boardDao.insert(board); // txStatus 트랜잭션에 작업이 기록됨
    logDataAction(board, ip);
    return count;
  }

  @Transactional(
      propagation=Propagation.REQUIRES_NEW,
      rollbackFor=Exception.class)
  private void logDataAction(BoardVo board, String ip) {
    try {
      BoardLogVo boardLog = new BoardLogVo();
      boardLog.setIp(ip);
      boardLog.setActionType(BoardLogVo.ACTION_INSERT + "xxxx");
      boardLog.setBoardNo(board.getNo());
      boardLogDao.insert(boardLog);   // txStatus 트랜잭션에 작업이 기록됨
    } catch (Exception e) {
      System.out.println("로그 남기기 오류!");
    }
  }
  
  public List<BoardVo> list(
      int startIndex, int pageSize, String word, String order) {
    
    HashMap<String,Object> sqlParams = new HashMap<String,Object>();
    sqlParams.put("startIndex", startIndex);
    sqlParams.put("pageSize", pageSize);
    sqlParams.put("word", word);
    sqlParams.put("order", order);
    
    return boardDao.selectList(sqlParams);
  }
  
  public int size(String word) {
    return boardDao.countAll(word);
  }
  
  public BoardVo get(int no) {
    return boardDao.selectOne(no);
  }
  
  public int remove(int no, String ip) {
    int count = boardDao.delete(no);
    
    BoardLogVo boardLog = new BoardLogVo();
    boardLog.setIp(ip);
    boardLog.setActionType(BoardLogVo.ACTION_DELETE);
    boardLog.setBoardNo(no);
    boardLogDao.insert(boardLog);
    
    return count;
  }
  
  public int change(BoardVo board, String ip) {
    int count = boardDao.update(board);
    
    BoardLogVo boardLog = new BoardLogVo();
    boardLog.setIp(ip);
    boardLog.setActionType(BoardLogVo.ACTION_UPDATE + "1111");
    boardLog.setBoardNo(board.getNo());
    boardLogDao.insert(boardLog);
    
    return count;
  }
}









